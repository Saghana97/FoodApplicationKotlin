package com.inducesmile.Eceats.adapter


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.inducesmile.Eceats.entities.AllResObject
import com.zkovar.foodfinderkt.R


class AllResViewHolder : RecyclerView.ViewHolder {

    var ResTitle: TextView
    var Res: TextView
    var ResImage: ImageView

    constructor(itemView: View, ResTitle: TextView, Res: TextView, ResImage: ImageView) : super(itemView) {
        this.ResTitle = ResTitle
        this.Res = Res
        this.ResImage = ResImage
    }

    constructor(itemView: View) : super(itemView) {

        ResTitle = itemView.findViewById(R.id.song_title) as TextView
        Res  = itemView.findViewById(R.id.song_author) as TextView
        ResImage = itemView.findViewById(R.id.song_cover) as ImageView
    }
}
