package com.example.mydictionary.viewModel


interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
