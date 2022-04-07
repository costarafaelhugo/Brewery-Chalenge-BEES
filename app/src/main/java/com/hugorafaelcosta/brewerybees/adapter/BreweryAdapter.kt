package com.hugorafaelcosta.brewerybees.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hugorafaelcosta.brewerybees.R
import com.hugorafaelcosta.brewerybees.database.models.BreweryModel
import kotlinx.android.synthetic.main.breweries_card_top_ten.view.*

class BreweryAdapter(
    private val items: List<BreweryModel?>
) : RecyclerView.Adapter<BreweryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.breweries_card_top_ten, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item = items[position]
        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: BreweryModel?) = with(itemView) {
            val brewaryImage = itemView.background_photo
            val breweryName = itemView.brewery_name
            val breweryRate = itemView.brewery_rate
            val breweryType = itemView.brewery_type_text

            item?.let {
                Glide.with(itemView.context).load(it.photos).into(brewaryImage)

                breweryName.text = item.name
                breweryRate.text = item.sizeEvaluations.toString()
                breweryType.text = item.breweryType
            }
        }
    }
}

//
//override fun getItemCount(): Int {
//    return items.size
//}
//
//fun setDataSet(brewerys: List<BreweryModel>) {
//    this.items = brewerys
//}
//
//
//class BreweryViewHolder constructor(
//    itemView: View
//) : ViewHolder(itemView) {
//
//    fun bindView(item: BreweryModel?) = with(itemView) {
//
//        val brewaryImage = itemView.background_photo
//        val breweryName = itemView.brewery_name
//        val breweryRate = itemView.brewery_rate
//        val breweryType = itemView.brewery_type_text
//
//        fun bind(brewery: BreweryModel) {
//            item?.let {
//
//                Glide.with(itemView.context).load(it.photos).into(brewaryImage)
//                breweryName.text = "${breweryName}"
//                breweryRate.text = "${breweryRate}"
//                breweryType.text = "${breweryType}"
//            }
//        }
//    }
//}
//}

//        return BreweryViewHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.breweries_card_top_ten, parent, false)
//        )
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        when (holder) {
//            is BreweryViewHolder -> {
//                holder.bindView(items[position])
//            }
//        }
//}
