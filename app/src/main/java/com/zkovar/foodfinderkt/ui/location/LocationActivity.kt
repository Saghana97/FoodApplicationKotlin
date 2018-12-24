package com.zkovar.foodfinderkt.ui.location

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import com.zkovar.foodfinderkt.Activity.Page
import com.zkovar.foodfinderkt.BuildConfig
import com.zkovar.foodfinderkt.R
import com.zkovar.foodfinderkt.api.ZomatoApiService
import com.zkovar.foodfinderkt.model.ZomatoCityResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_location.*

class LocationActivity : AppCompatActivity() {

    private val zomatoApiService by lazy {
        ZomatoApiService.create()
    }

    private var disposable: Disposable? = null

    private var adapter = LocationAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        getCitiesButton.setOnClickListener { getEligibleCities() }

        citySuggestions.layoutManager = LinearLayoutManager(this)
        citySuggestions.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        citySuggestions.adapter = adapter
    }

    private fun getEligibleCities() {
        val city = cityName.text.toString()
        if (city.isEmpty()) {
            Snackbar.make(cityName, R.string.invalid_city_entry, Snackbar.LENGTH_SHORT).show()
            return
        }

        progressBar.visibility = View.VISIBLE

        disposable = zomatoApiService.getCities(city, NUM_CITIES,"9f94420d5a5473fefba551a2e39b8959")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleSuccess, this::handleError)
    }

    private fun handleSuccess(response: ZomatoCityResponse) {
        adapter.setData(response)
        progressBar.visibility = View.GONE
    }

    private fun handleError(throwable: Throwable) {
        Snackbar.make(root, R.string.location_api_failure_message, Snackbar.LENGTH_SHORT).show()
        progressBar.visibility = View.GONE
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {

            android.R.id.home -> {
                val intent = Intent(baseContext, Page::class.java)
                startActivity(intent)
//                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val NUM_CITIES = 20
    }

}
