package com.example.mydictionary.model.repository

interface BaseRepo<T> {
    suspend fun getData(word: String): T
}