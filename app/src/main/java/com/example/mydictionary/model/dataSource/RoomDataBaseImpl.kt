package com.example.mydictionary.model.dataSource

import com.example.mydictionary.model.data.DataModel

class RoomDataBaseImpl : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO()
    }
}
