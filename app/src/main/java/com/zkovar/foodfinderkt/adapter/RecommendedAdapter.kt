package com.inducesmile.Eceats.adapter


import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.inducesmile.Eceats.entities.RecommendedObject
import com.zkovar.foodfinderkt.R

class RecommendedAdapter(private val context: FragmentActivity?, private val Recommended: List<RecommendedObject>) : RecyclerView.Adapter<RecommendedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recommended_layout, parent, false)
        return RecommendedViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecommendedViewHolder, position: Int) {
        val RecommendedObject = Recommended[position]
        holder.RecommendTitle.text = RecommendedObject.RecommendedTitle
        holder.Recommend.text = RecommendedObject.Recommend

    }

    override fun getItemCount(): Int {
        return Recommended.size
    }

    companion object {

        private val TAG = RecommendedAdapter::class.java.getSimpleName()
    }
}
