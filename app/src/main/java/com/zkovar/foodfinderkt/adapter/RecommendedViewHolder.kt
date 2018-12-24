package com.inducesmile.Eceats.adapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.zkovar.foodfinderkt.R


class RecommendedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var RecommendTitle: TextView
    var Recommend: TextView
    var RecommendCover: ImageView

    init {

        RecommendTitle = itemView.findViewById(R.id.play_list_name) as TextView
        Recommend = itemView.findViewById(R.id.number_of_tracks) as TextView
        RecommendCover = itemView.findViewById(R.id.play_list_cover) as ImageView
    }
}
