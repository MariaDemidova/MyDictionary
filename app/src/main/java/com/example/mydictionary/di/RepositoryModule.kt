package com.example.mydictionary.di

import com.example.mydictionary.model.data.DataModel
import com.example.mydictionary.model.dataSource.DataSource
import com.example.mydictionary.model.dataSource.RetrofitImpl
import com.example.mydictionary.model.dataSource.RoomDataBaseImpl
import com.example.mydictionary.model.repository.BaseRepo
import com.example.mydictionary.model.repository.RepoImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): BaseRepo<List<DataModel>> =
        RepoImpl(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): BaseRepo<List<DataModel>> =
        RepoImpl(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImpl()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomDataBaseImpl()
}
