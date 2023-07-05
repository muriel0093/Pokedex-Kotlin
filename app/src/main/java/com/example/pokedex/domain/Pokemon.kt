package com.example.pokedex.domain

data class Pokemon(
    val imageUrl: String,
    val number: Int,
    val type: List<PokemonType>,
    val name: String,
){
    val formatterNumber = number.toString().padStart(3, '0')

}

