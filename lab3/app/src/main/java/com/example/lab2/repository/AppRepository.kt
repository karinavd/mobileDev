package com.example.lab2.repository

import com.example.lab2.model.MyListable

interface AppRepository {
    fun getItems(): List<MyListable>
}
