package com.example.navapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _text = MutableStateFlow("Settings Screen")
    val textUi: StateFlow<String> = _text.asStateFlow()

    fun changeText() {
        _text.value = "The text has been changed via the ViewModel!"
    }
}
