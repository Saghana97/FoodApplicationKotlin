package com.zkovar.foodfinderkt.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.funtrip.funtrip.db.DatabaseHandler
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.model.Tasks
import kotlinx.android.synthetic.main.activity_page.*

class Page : AppCompatActivity() {

    var dbHandler: DatabaseHandler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page)

        initOperations()

    }


    private fun initOperations() {

        dbHandler = DatabaseHandler(this)

        label_rest_rating.setOnClickListener({
            var success: Boolean = false
Log.d("llll","1")
            val tasks: Tasks = Tasks()
            tasks.name = "Olive garden"
            tasks.status = "Y"
            success = dbHandler?.addTask(tasks) as Boolean


            if (success)
                finish()
        })

        label_rest_rating2.setOnClickListener({
            var success: Boolean = false
            Log.d("llll","2")
            val tasks: Tasks = Tasks()
            tasks.name = "French Door"
            tasks.status = "Y"
            success = dbHandler?.addTask(tasks) as Boolean


            if (success)
                finish()
        })

        label_rest_rating3.setOnClickListener({
            var success: Boolean = false
            Log.d("llll","3")
            val tasks: Tasks = Tasks()
            tasks.name = "Ocean cafe"
            tasks.status = "Y"
            success = dbHandler?.addTask(tasks) as Boolean


            if (success)
                finish()
        })

        label_rest_rating4.setOnClickListener({
            var success: Boolean = false
            Log.d("llll","4")
            val tasks: Tasks = Tasks()
            tasks.name = "Park In"
            tasks.status = "Y"
            success = dbHandler?.addTask(tasks) as Boolean


            if (success)
                finish()
        })

        label_rest_rating5.setOnClickListener({
            var success: Boolean = false
            Log.d("llll","5")
            val tasks: Tasks = Tasks()
            tasks.name = "Border Cafe"
            tasks.status = "Y"
            success = dbHandler?.addTask(tasks) as Boolean


            if (success)
                finish()
        })
    }


}