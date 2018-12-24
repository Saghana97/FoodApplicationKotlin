package com.inducesmile.Eceats.fragment


import android.content.Context
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.zkovar.foodfinderkt.Activity.Page
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.ui.location.LocationActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_allres.*
import android.R.id.button1
import android.R.id.button1






class AllResFragment : Fragment() {

//    val testData: List<AllResObject>
//        get() {
//            val recentfood = ArrayList<AllResObject>()
//            recentfood.add(AllResObject("Burger", "CodingByte", ""))
//            recentfood.add(AllResObject("Pizza", "CodingByte", ""))
//            recentfood.add(AllResObject("Dosa", "CodingByte", ""))
//            return recentfood

//        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater.inflate(R.layout.fragment_allres, container, false)

//        activity?.title ?:  "All Restaurants"

//        val camBt = getView()!!.findViewById(R.id.search1) as ImageButton
//        camBt.setOnClickListener{
//            val intentLoadNewActivity = Intent(context, LocationActivity::class.java)
//            startActivity(intentLoadNewActivity)
//        }


//        val camBt:ImageButton = getView()!!.findViewById(R.id.search1)
//        camBt.setOnClickListener{
//            val intentLoadNewActivity = Intent(activity, LocationActivity::class.java)
//            startActivity(intentLoadNewActivity)
//        }


        return view
    }
    //        val songRecyclerView = view.findViewById(R.id.song_list) as RecyclerView
//        val linearLayoutManager = LinearLayoutManager(activity)
//        songRecyclerView.layoutManager = linearLayoutManager
//        songRecyclerView.setHasFixedSize(true)
//
//        val mAdapter = AllResAdapter(activity, testData)
//        songRecyclerView.adapter = mAdapter

}
