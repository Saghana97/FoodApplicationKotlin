package com.inducesmile.Eceats.adapter

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.inducesmile.Eceats.entities.AllResObject
import com.zkovar.foodfinderkt.R

class AllResAdapter(private val context: FragmentActivity?, private val AllRes: List<AllResObject>) : RecyclerView.Adapter<AllResViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllResViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.allres_layout, parent, false)
        return AllResViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllResViewHolder, position: Int) {
        val AllResObject = AllRes[position]
        holder.ResTitle.text = AllResObject.restaurantTitle
        holder.Res.text = AllResObject.restaurantitem
    }

    override fun getItemCount(): Int {
        return AllRes.size
    }

}
