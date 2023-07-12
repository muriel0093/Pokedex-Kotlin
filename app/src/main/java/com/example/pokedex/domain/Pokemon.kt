package com.example.pokedex.domain

import java.util.Locale

data class Pokemon(
    val number: Int,
    val type: List<PokemonType>,
    val name: String,
   // val url: String,
){
    val formattedName = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }

    val formatterNumber = number.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formatterNumber.png"
}

