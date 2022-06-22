package com.example.mydictionary.di

import com.example.mydictionary.model.data.DataModel
import com.example.mydictionary.model.dataSource.RetrofitImpl
import com.example.mydictionary.model.dataSource.RoomDataBaseImpl
import com.example.mydictionary.model.repository.BaseRepo
import com.example.mydictionary.model.repository.RepoImpl
import com.example.mydictionary.viewModel.MainInteractor
import com.example.mydictionary.viewModel.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<BaseRepo<List<DataModel>>>(named(NAME_REMOTE)) { RepoImpl(RetrofitImpl()) }
    single<BaseRepo<List<DataModel>>>(named(NAME_LOCAL)) { RepoImpl(RoomDataBaseImpl()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
