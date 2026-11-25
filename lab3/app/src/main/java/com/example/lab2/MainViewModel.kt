package com.example.lab2

import androidx.lifecycle.ViewModel
import com.example.lab2.model.MyListable
import com.example.lab2.repository.AppRepository
import com.example.lab2.repository.AppRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val repository: AppRepository = AppRepositoryImpl()

    private val _text = MutableStateFlow("Profile")
    val textUi: StateFlow<String> = _text.asStateFlow()
    
    private val _items = MutableStateFlow<List<MyListable>>(emptyList())
    val items: StateFlow<List<MyListable>> = _items.asStateFlow()
    
    init {
        loadItems()
    }

    private fun loadItems() {
        _items.value = repository.getItems()
    }

    fun changeText() {
        _text.value = "The text has been changed via the ViewModel!"
    }
}
