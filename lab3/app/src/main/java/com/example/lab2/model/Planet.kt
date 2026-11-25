package com.example.lab2.model

data class Planet(
    val name: String,
    val climate: String,
    override val id: Int
): MyListable
