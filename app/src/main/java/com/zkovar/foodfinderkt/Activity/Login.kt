package com.inducesmile.Eceats.Activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.ui.location.LocationActivity


class Login : AppCompatActivity() {
    lateinit var sharedpreferences: SharedPreferences
//    lateinit var name: EditText
//    lateinit var email: EditText

    val Name = "nameKey"
    val Email = "emailKey"




    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val name = findViewById<View>(R.id.logpass) as EditText
        val  email = findViewById<View>(R.id.logname) as EditText

        val notify=intent.getStringExtra("message")
        if(notify!=null){
        Toast.makeText(this,""+notify,Toast.LENGTH_LONG).show()}




        sharedpreferences = getSharedPreferences(
                Register.mypreference,
                Context.MODE_PRIVATE
        )

        logbtn.setOnClickListener {
                         Log.d("pev","nxt")
             Log.d("pev", ""+email.getText().toString())
             Log.d("pev",name.getText().toString())

             Log.d("spev",sharedpreferences.getString(Name, ""))
             Log.d("spev",sharedpreferences.getString(Email, ""))
            if((name.getText().toString().length==0) && (email.getText().toString().length==0)){
                Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show()
            }

            if (sharedpreferences.contains(Name)) {
                if (name.getText().toString() == sharedpreferences.getString(Name, ""))
                    if (sharedpreferences.contains(Email)) {
                        if(email.getText().toString() == sharedpreferences.getString(Email, "")) {
                            val intent = Intent(baseContext,HomeActivity::class.java)
                            startActivity(intent)

                        }
                    }

            }


        }


        logreg.setOnClickListener {
            val intent = Intent(baseContext, Register::class.java)
            startActivity(intent)
        }





//        if (sharedpreferences.contains(Name)) {
//            name.setText(sharedpreferences.getString(Name, ""))
//        }
//        if (sharedpreferences.contains(Email)) {
//            email.setText(sharedpreferences.getString(Email, ""))
//        }

    }
}
