package com.inducesmile.Eceats.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.content.SharedPreferences
import android.widget.Toast
import android.content.Context
import android.view.Window
import android.view.WindowManager
import com.zkovar.foodfinderkt.R


class Register : AppCompatActivity() {

    lateinit var sharedpreferences: SharedPreferences
    lateinit var name: EditText
    lateinit var email: EditText
    lateinit var password:EditText
     var count=0


    override fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        name = findViewById<View>(R.id.regpass) as EditText
        email = findViewById<View>(R.id.regemail) as EditText

        password = findViewById<View>(R.id.regpass) as EditText


        sharedpreferences = getSharedPreferences(
                mypreference,
                Context.MODE_PRIVATE
        )


//        if (sharedpreferences.contains(Name)) {
//            name.setText(sharedpreferences.getString(Name, ""))
//        }
//        if (sharedpreferences.contains(Email)) {
//            email.setText(sharedpreferences.getString(Email, ""))
//
//        }

    }

    fun Save(view: View) {
        val n = name.text.toString()
        val e = email.text.toString()

        val emailvalidate = name.text.toString()
        val email = emailvalidate.trim()

        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        if (email.matches(emailPattern.toRegex())) {
            Toast.makeText(applicationContext, "valid email address", Toast.LENGTH_SHORT).show()
            count++
        } else {
            Toast.makeText(applicationContext, "Invalid email address", Toast.LENGTH_SHORT).show()
        }
        val pass= password.text.toString()
        if(pass.length<6){
            Toast.makeText(applicationContext,"Enter valid password",Toast.LENGTH_SHORT).show()
        }

        val editor = sharedpreferences.edit()
        if((n.length==0) && (e.length==0)){
            Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show()
        }else{
        editor.putString(Name, n)
        editor.putString(Email, e)
        editor.commit()

        val intent = Intent(baseContext, Login::class.java)
        intent.putExtra("message", "Registered");
        startActivity(intent)
    }}

//    fun clear(view: View) {
//        name = findViewById<View>(R.id.etName) as EditText
//        email = findViewById<View>(R.id.etEmail) as EditText
//        name.setText("")
//        email.setText("")
//
//    }
//
//    fun Get(view: View) {
//        name = findViewById<View>(R.id.etName) as EditText
//        email = findViewById<View>(R.id.etEmail) as EditText
//        sharedpreferences = getSharedPreferences(
//            mypreference,
//            Context.MODE_PRIVATE
//        )
//
//        if (sharedpreferences.contains(Name)) {
//            name.setText(sharedpreferences.getString(Name, ""))
//        }
//        if (sharedpreferences.contains(Email)) {
//            email.setText(sharedpreferences.getString(Email, ""))
//
//        }
//    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }

    companion object {
        val mypreference = "mypref"
        val Name = "nameKey"
        val Email = "emailKey"
    }




}
