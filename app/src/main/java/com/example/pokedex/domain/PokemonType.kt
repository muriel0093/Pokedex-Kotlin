package com.example.pokedex.domain

import java.util.Locale

data class PokemonType(
    val name: String,
){
    val formattedType = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}