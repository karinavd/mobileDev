package com.example.lab2.model

data class Character(
    val name: String,
    val species: String,
    val planet: Planet?,
    override val id: Int
): MyListable
