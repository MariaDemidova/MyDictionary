package com.example.mydictionary.model.repository

import com.example.mydictionary.model.data.DataModel
import com.example.mydictionary.model.dataSource.DataSource
import io.reactivex.Observable

class RepoImpl(private val dataSource: DataSource<List<DataModel>>): BaseRepo<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}