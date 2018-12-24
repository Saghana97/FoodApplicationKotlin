package com.inducesmile.Eceats

import android.content.Intent
import android.widget.Toast
import android.content.BroadcastReceiver
import android.content.Context
import android.support.design.widget.Snackbar
import com.inducesmile.Eceats.Activity.HomeActivity


class GpsLocationReceiver : BroadcastReceiver() {
    var mSnackbar:Snackbar?=null
     override fun onReceive(context: Context, intent: Intent) {

                 if (intent.action!!.matches("android.location.PROVIDERS_CHANGED".toRegex())) {
//                     mSnackbar =Snackbar.make(findViewById(R.id.main_container_wrapper),"Location has been changed",Snackbar.LENGTH_LONG)
                     Toast.makeText(context, "LOCATION HAS BEEN SET ON OR OFF",
                             Toast.LENGTH_SHORT).show()
//                     mSnackbar?.duration =Snackbar.LENGTH_LONG
//                     mSnackbar?.show()
                     val pushIntent = Intent(context, HomeActivity::class.java)
                     context.startService(pushIntent)
                 }

    }
}


