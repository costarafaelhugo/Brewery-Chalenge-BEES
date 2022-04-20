package com.hugorafaelcosta.brewerybees.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hugorafaelcosta.brewerybees.R
import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import kotlinx.android.synthetic.main.breweries_card_top_ten.view.*

class BreweryAdapter : RecyclerView.Adapter<BreweryAdapter.BreweryViewHolder>() {

    private var items: List<BreweryModel> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreweryAdapter.BreweryViewHolder {

        return BreweryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.breweries_card_top_ten, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BreweryAdapter.BreweryViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(brewerys: List<BreweryModel>) {
        this.items = brewerys
        notifyDataSetChanged()
    }


    class BreweryViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: BreweryModel) = with(itemView) {

            val brewaryImage = itemView.background_photo
            val breweryName = itemView.brewery_name
            val breweryRate = itemView.brewery_rate
            val breweryType = itemView.brewery_type_text

            item.let {
                Glide.with(itemView.context).load(it.photos).into(brewaryImage)
                breweryName.text = it.name
                breweryRate.text = it.sizeEvaluations.toString()
                breweryType.text = it.breweryType
            }
        }
    }
}