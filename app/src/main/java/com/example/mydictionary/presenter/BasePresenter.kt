package com.example.mydictionary.presenter

import com.example.mydictionary.model.data.AppState
import com.example.mydictionary.view.BaseView


interface BasePresenter<T: AppState, V: BaseView> {
    fun attachView(view: V)
    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}