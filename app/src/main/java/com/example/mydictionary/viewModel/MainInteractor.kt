package com.example.mydictionary.viewModel

import com.example.mydictionary.di.NAME_LOCAL
import com.example.mydictionary.di.NAME_REMOTE
import com.example.mydictionary.model.data.AppState
import com.example.mydictionary.model.data.DataModel
import com.example.mydictionary.model.repository.BaseRepo
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: BaseRepo<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: BaseRepo<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}