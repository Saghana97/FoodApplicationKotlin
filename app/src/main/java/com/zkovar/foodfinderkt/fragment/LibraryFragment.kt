package com.inducesmile.Eceats.fragment


import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.inducesmile.Eceats.adapter.CustomFragmentPageAdapter
import com.zkovar.foodfinderkt.R


class LibraryFragment : Fragment() {

    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_library, container, false)

        tabLayout = view.findViewById(R.id.tabs) as TabLayout
        viewPager = view.findViewById(R.id.view_pager) as ViewPager

        viewPager!!.adapter = CustomFragmentPageAdapter(childFragmentManager)
        tabLayout!!.setupWithViewPager(viewPager)

        return view
    }

    companion object {

        private val TAG = LibraryFragment::class.java.getSimpleName()
    }
}
