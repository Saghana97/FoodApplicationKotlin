package com.inducesmile.Eceats.adapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.inducesmile.Eceats.fragment.AllResFragment
import com.inducesmile.Eceats.fragment.RecommendedFragment

class CustomFragmentPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> return AllResFragment()
            1 -> return RecommendedFragment()
            2 -> return AllResFragment()
            3 -> return AllResFragment()
        }/*case 1:
                return new PlaylistFragment();
            case 2:
                return new AlbumFragment();
            case 3:
                return new ArtistFragment();*/
        return null
    }

    override fun getCount(): Int {
        return FRAGMENT_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "ALL RESTAURANTS"
            1 -> return "RECOMMENDED"
        }
        return null
    }

    companion object {

        private val TAG = CustomFragmentPageAdapter::class.java.getSimpleName()

        private val FRAGMENT_COUNT = 4
    }
}
