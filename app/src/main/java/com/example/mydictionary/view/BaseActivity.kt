package com.example.mydictionary.view


import androidx.appcompat.app.AppCompatActivity
import com.example.mydictionary.model.data.AppState
import com.example.mydictionary.viewModel.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity(){

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}