package com.example.pokedex.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.api.pokeRepository
import com.example.pokedex.domain.Pokemon

class PokemonsViewModel: ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()
    init{
            Thread(Runnable {
                loadPokemons()
            }).start()
    }

    private fun loadPokemons(
    ) {
        val pokemonsApiResult = pokeRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons.postValue(it.map { PokemonResult ->
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
            })
        }
    }
}