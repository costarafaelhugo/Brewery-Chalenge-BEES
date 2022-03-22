package com.hugorafaelcosta.brewerybees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hugorafaelcosta.brewerybees.R
import com.hugorafaelcosta.brewerybees.database.models.Brewery
import kotlinx.android.synthetic.main.breweries_card_top_ten.view.*

class BreweryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var items : List<Brewery> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return BreweryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.breweries_card_top_ten, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is BreweryViewHolder->{
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
       return items.size
    }

    fun setDataSet(brewerys: List<Brewery>){
         this.items = brewerys
    }


    class BreweryViewHolder constructor(
        itemView : View
    ): RecyclerView.ViewHolder(itemView){

        private val breweryName =  itemView.brewery_name
        private val breweryRate =  itemView.brewery_rate
        private val breweryType =  itemView.brewery_type_text

        fun bind(brewery: Brewery){
            breweryName.text = brewery.name
            breweryRate.text = brewery.size_evaluations.toString()
            breweryType.text = brewery.type
        }
    }
}