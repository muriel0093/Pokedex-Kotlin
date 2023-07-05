package com.example.pokedex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon

class pokeadapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<pokeadapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        //inflate é igual a dar vida ao xml, inflar o xml para que possa ser visivel

        return ViewHolder(view) //retorna a classe ViewHolder criada logo embaixo passando a nossa view como parametro
    }

    override fun getItemCount() =
        items.size // Por ser uma linha unica somente com um retorno posso simplesmente passar como se fosse
    //uma arrow function em javascript, usando somente uma unica linha

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) { //funcao onBindViewHolder sempre q o viewholder aparecer na tela ele mostra a posição do item e qual é o item da lista
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) =
            with(itemView) {// with aponta o this para o contexto dado dentro dos parenteses, fora do with o this aponta para
                //o viewHolder  e dentro do with o this aponta para a view
                val ivPokemon = findViewById<ImageView>(R.id.ivPokemon)
                val tvNumber = findViewById<TextView>(R.id.tvNumber)
                val tvName = findViewById<TextView>(R.id.tvName)
                val tvType1 = findViewById<TextView>(R.id.tvType1)
                val tvType2 = findViewById<TextView>(R.id.tvType2)

                // TODO: Load image with Glade

                tvName.text = item.name
                tvNumber.text = "Nº ${item.formatterNumber}"
                tvType1.text = item.type[0].name

                if(item.type.size > 1){
                    tvType2.visibility= View.VISIBLE
                    tvType2.text = item.type[1].name
                }else{
                    tvType2.visibility= View.GONE
                }

            }
    }

}