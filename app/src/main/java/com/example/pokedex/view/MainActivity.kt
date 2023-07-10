package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.api.pokeRepository
import com.example.pokedex.domain.Pokemon
import com.example.pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Charmander = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png",
            4,
            listOf(
                PokemonType("FIre")
            ),
            "Charmander"
        )

        val pokemons = listOf(Charmander, Charmander, Charmander)
        recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)

        Thread(Runnable {
            loadPokemons()

        }).start()


    }

    private fun loadPokemons(
    ) {
        val pokemonsApiResult = pokeRepository.listPokemons()

        pokemonsApiResult?.results?.let {
            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = pokeadapter(it)
        }
    }
}