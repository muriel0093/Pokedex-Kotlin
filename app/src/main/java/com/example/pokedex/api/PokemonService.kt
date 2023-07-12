package com.example.pokedex.api

import com.example.pokedex.api.Model.PokemonApiResult
import com.example.pokedex.api.Model.PokemonsApiResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemons(@Path("number") number: Int?): Call<PokemonApiResult>
}