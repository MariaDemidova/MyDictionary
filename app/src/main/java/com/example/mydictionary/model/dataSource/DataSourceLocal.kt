package com.example.mydictionary.model.dataSource

import com.example.mydictionary.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal(private val remoteProvider: RoomDataBaseImpl = RoomDataBaseImpl()) :
    DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}