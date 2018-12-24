package com.zkovar.foodfinderkt.ui.location

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zkovar.foodfinderkt.Activity.Page
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.model.ZomatoCityResponse
import com.zkovar.foodfinderkt.ui.restaurant.RestaurantListActivity

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var data: ZomatoCityResponse? = null

    fun setData(data: ZomatoCityResponse) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.city_card, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.locationSuggestions?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val city = data!!.locationSuggestions[position]
        holder.setCityName(city.name)
        holder.cityName.setOnClickListener {
            val intent = Intent(it.context, Page::class.java)
//            intent.putExtra(RestaurantListActivity.CITY_NAME_KEY, city)
            it.context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cityName: TextView = itemView.findViewById(R.id.cityName)

        fun setCityName(name: String) {
            cityName.text = name
        }

    }

}
