package com.inducesmile.Eceats.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast


import com.inducesmile.Eceats.fragment.LibraryFragment
import com.zkovar.foodfinderkt.Activity.Page
import com.zkovar.foodfinderkt.Activity.Support
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.fragment.Display
import com.zkovar.foodfinderkt.ui.location.LocationActivity
import kotlinx.android.synthetic.main.fragment_allres.*

class HomeActivity : AppCompatActivity() {

    private var fragmentManager: FragmentManager? = null
    private var fragment: Fragment? = null
    lateinit var sharedpreferences: SharedPreferences

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        Log.d("ggg","kkkk")

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        Log.d("ggg","kkkk1")
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()
        Log.d("ggg","kkkk2")
        fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragment = LibraryFragment()
        fragmentTransaction.replace(R.id.main_container_wrapper, fragment)
        fragmentTransaction.commit()

//        Log.d("ggg","kkkk3")
//        val camBt = findViewById<ImageButton>(R.id.search1)
//        camBt.setOnClickListener{
//            val intentLoadNewActivity = Intent(baseContext, LocationActivity::class.java)
//            startActivity(intentLoadNewActivity)
//        }
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        val header = navigationView.inflateHeaderView(R.layout.nav_header_home)
//        val profileName = header.findViewById(R.id.profile_name) as TextView
//        profileName.text = "ECEats"

        Log.d("ggg","kkkk4")

        sharedpreferences = getSharedPreferences(
                Register.mypreference,
                Context.MODE_PRIVATE
        )

        navigationView.setNavigationItemSelectedListener { item ->
            val id = item.itemId

            if (id == R.id.nav_res) {
                val intent = Intent(baseContext, HomeActivity::class.java)
                startActivity(intent)

            } else if (id == R.id.nav_orders) {
                val intent = Intent(baseContext, LocationActivity::class.java)
               startActivity(intent)

            } else if (id == R.id.nav_wallet) {
                val intent = Intent(baseContext, Display::class.java)
                startActivity(intent)

            } else if (id == R.id.nav_support) {
                val intent = Intent(baseContext, Support::class.java)
                startActivity(intent)

            } else if (id == R.id.nav_about) {
                Toast.makeText(this,"This is a food application receiving information from zomato api", Toast.LENGTH_SHORT).show()

            }
            else if(id==R.id.nav_logout){
                val editor=sharedpreferences.edit()
                editor.clear()
                editor.commit()
                val intent = Intent(baseContext, Login::class.java)
                startActivity(intent)

            }

            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.main_container_wrapper, fragment)
            transaction.commit()



            val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
            assert(drawer != null)
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.music, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)

    }

    companion object {

        private val TAG = HomeActivity::class.java.simpleName
    }

}
