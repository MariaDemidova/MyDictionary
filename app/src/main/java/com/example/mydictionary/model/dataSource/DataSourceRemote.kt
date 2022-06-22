package com.example.mydictionary.model.dataSource

import com.example.mydictionary.model.data.DataModel

class DataSourceRemote(private val remoteProvider: RetrofitImpl = RetrofitImpl()) :
    DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}