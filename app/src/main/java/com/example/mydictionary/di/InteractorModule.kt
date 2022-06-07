package com.example.mydictionary.di

import com.example.mydictionary.model.data.DataModel
import com.example.mydictionary.model.repository.BaseRepo
import com.example.mydictionary.viewModel.MainInteractor
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: BaseRepo<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: BaseRepo<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
