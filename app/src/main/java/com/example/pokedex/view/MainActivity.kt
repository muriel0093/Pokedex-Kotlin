package com.example.pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.api.pokeRepository
import com.example.pokedex.domain.Pokemon
import com.example.pokedex.view.viewModel.PokemonViewModelFactory
import com.example.pokedex.view.viewModel.PokemonsViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvPokemon)

        viewModel.pokemons.observe(this, Observer{
                loadRecycleView(it)
            })
    }

    /*private fun loadPokemons(
    ) {
        val pokemonsApiResult = pokeRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons = it.map { PokemonResult ->
                val number =
                    PokemonResult.url
                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", "").toInt()
                val pokemonApiResult = pokeRepository.getPokemon(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.types.map { type ->
                            type.type
                        },
                        pokemonApiResult.name,
                    )
                }
            }
            recyclerView.post {
                loadRecycleView()
            }
        }
    } */

    private fun loadRecycleView(pokemons: List<Pokemon?>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = pokeadapter(pokemons)
    }
}