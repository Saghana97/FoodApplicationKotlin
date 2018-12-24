package com.inducesmile.Eceats.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.ui.location.LocationActivity


class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 3000
    lateinit var sharedpreferences: SharedPreferences

    val Name = "nameKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val actionBar = supportActionBar
        actionBar?.hide()

        sharedpreferences = getSharedPreferences(
                Register.mypreference,
                Context.MODE_PRIVATE
        )

        Handler().postDelayed({
            val text=sharedpreferences.getString(Name, "")
            if(text.length!=0){
                Log.d("ggg","hhhh")
                val intent = Intent(baseContext, HomeActivity::class.java)
                startActivity(intent)

            }else{
                Log.d("ggg","iiii")
                val intent = Intent(baseContext, Login::class.java)
                startActivity(intent)
            }
            this@SplashActivity.finish()
        }, SPLASH_DISPLAY_LENGTH.toLong())




    }

    companion object {

        private val TAG = SplashActivity::class.java.getSimpleName()
    }
}
