package com.example.mydictionary.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.mydictionary.model.data.AppState
import com.example.mydictionary.model.dataSource.DataSourceLocal
import com.example.mydictionary.model.dataSource.DataSourceRemote
import com.example.mydictionary.model.repository.RepoImpl

import io.reactivex.observers.DisposableObserver

class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepoImpl(DataSourceRemote()),
        RepoImpl(DataSourceLocal())
    )

) : BaseViewModel<AppState>() {
    private var appState: AppState? = null

    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }
                .subscribeWith(getObserver())
        )
        Log.d("zopa", word)
        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}