package com.example.mydictionary.model.dataSource

interface DataSource<T> {
    suspend fun getData(word: String): T
}