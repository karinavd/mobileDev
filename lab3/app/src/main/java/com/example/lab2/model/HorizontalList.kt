package com.example.lab2.model

data class HorizontalList(
    val planets: List<Planet>,
    override val id: Int
): MyListable
