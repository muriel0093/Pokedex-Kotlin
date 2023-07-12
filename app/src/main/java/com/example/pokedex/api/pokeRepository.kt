package com.example.pokedex.api

import android.util.Log
import com.example.pokedex.api.Model.PokemonApiResult
import com.example.pokedex.api.Model.PokemonsApiResult
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object pokeRepository {

    private val service: PokemonService
    // https://pokeapi.co/api/v2/pokemon/?limit=151
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
       val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemon(number: Int): PokemonApiResult? {
        val call = service.getPokemons(number)

        return call.execute().body()
    }
}