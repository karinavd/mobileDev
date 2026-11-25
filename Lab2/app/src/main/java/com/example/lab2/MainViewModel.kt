package com.example.lab2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _text = MutableStateFlow("Profile")
    val textUi: StateFlow<String> = _text.asStateFlow()

    fun changeText() {
        _text.value = "The text has been changed via the ViewModel!"
    }
}
