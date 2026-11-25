package com.example.lab2.repository

import com.example.lab2.model.Character
import com.example.lab2.model.HorizontalList
import com.example.lab2.model.MyListable
import com.example.lab2.model.Planet

class AppRepositoryImpl : AppRepository {
    override fun getItems(): List<MyListable> {
        val tatooine = Planet("Tatooine", "Arid", 1)
        val naboo = Planet("Naboo", "Temperate", 2)
        val coruscant = Planet("Coruscant", "Temperate", 3)
        val kamino = Planet("Kamino", "Ocean", 4)
        val geonosis = Planet("Geonosis", "Arid", 5)

        return listOf(
            HorizontalList(listOf(tatooine, naboo, coruscant, kamino, geonosis), 200),
            Character("Luke Skywalker", "Human", tatooine, 101),
            Character("Darth Vader", "Human", tatooine, 102),
            Character("Obi-Wan Kenobi", "Human", null, 103),
            Character("Yoda", "Unknown", null, 104),
            Planet("Hoth", "Frozen", 6),
            Character("Padmé Amidala", "Human", naboo, 105),
            Character("Boba Fett", "Human", kamino, 106),
            Planet("Endor", "Forest", 7),
        )
    }
}
