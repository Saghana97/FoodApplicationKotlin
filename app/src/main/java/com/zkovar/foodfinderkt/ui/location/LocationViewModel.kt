package com.zkovar.foodfinderkt.ui.location

import android.app.Activity
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity

class LocationViewModel : ViewModel() {

    val cityName: MutableLiveData<String> = MutableLiveData()

    companion object {
        fun create(activity: FragmentActivity): LocationViewModel {
            return ViewModelProviders.of(activity).get(LocationViewModel::class.java);
        }
    }

}