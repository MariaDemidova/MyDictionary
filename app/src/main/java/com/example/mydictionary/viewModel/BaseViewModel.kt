package com.example.mydictionary.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydictionary.model.data.AppState
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
    val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {
    open fun getData(word: String, isOnline: Boolean): LiveData<T> = liveDataForViewToObserve


}