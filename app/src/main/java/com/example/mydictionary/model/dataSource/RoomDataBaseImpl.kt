package com.example.mydictionary.model.dataSource

import com.example.mydictionary.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImpl : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO()
    }
}
