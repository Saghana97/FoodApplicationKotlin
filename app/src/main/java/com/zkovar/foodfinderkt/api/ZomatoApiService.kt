package com.zkovar.foodfinderkt.api

import com.zkovar.foodfinderkt.model.ZomatoCityResponse
import com.zkovar.foodfinderkt.model.ZomatoRestaurant
import com.zkovar.foodfinderkt.model.ZomatoRestaurantResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ZomatoApiService {

    @GET("api/v2.1/search")
    fun getRestaurants(@Query("city_id") id: Int,
                       @Header("user_key") key: String): Observable<ZomatoRestaurantResponse>

    @GET("api/v2.1/cities")
    fun getCities(@Query("q") cityName: String,
                  @Query("count") count: Int,
                  @Header("user_key") key: String): Observable<ZomatoCityResponse>

    @GET("api/v2.1/")
    fun getRestaurantDetails(@Query("restaurant_id") id: Int,
                             @Header("user_key") key: String): Observable<ZomatoRestaurant>

    companion object {

        fun create(): ZomatoApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ZomatoApiClient.BASE_URL)
                    .build()
            return retrofit.create(ZomatoApiService::class.java)
        }

    }

}
