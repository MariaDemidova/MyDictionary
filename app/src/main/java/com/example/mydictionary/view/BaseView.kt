package com.example.mydictionary.view

import com.example.mydictionary.model.data.AppState


interface BaseView {
    fun renderData(appState: AppState)
}