package com.inducesmile.Eceats.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.inducesmile.Eceats.adapter.RecommendedAdapter
import com.inducesmile.Eceats.entities.RecommendedObject
import com.zkovar.foodfinderkt.R

import java.util.ArrayList


class RecommendedFragment : Fragment() {

    val testData: List<RecommendedObject>
        get() {
            val reslist = ArrayList<RecommendedObject>()
            reslist.add(RecommendedObject("MEXICAN", "Codingbytes", ""))
            reslist.add(RecommendedObject("CHINESE", "Codingbytes", ""))
            reslist.add(RecommendedObject("SUSHI", "Codingbytes", ""))


            return reslist
        }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_recommended, container, false)

        val playlisRecyclerView = view.findViewById(R.id.your_play_list) as RecyclerView
        val gridLayout = GridLayoutManager(activity, 2)
        playlisRecyclerView.layoutManager = gridLayout
        playlisRecyclerView.setHasFixedSize(true)

        val mAdapter = RecommendedAdapter(activity, testData)
        playlisRecyclerView.adapter = mAdapter

        return view
    }
}
