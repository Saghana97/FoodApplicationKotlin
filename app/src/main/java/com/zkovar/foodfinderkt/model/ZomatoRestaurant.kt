package com.zkovar.foodfinderkt.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class ZomatoRestaurant : Parcelable {

    @SerializedName("restaurant")
    var restaurant: Restaurant

    constructor(restaurant: Restaurant) {
        this.restaurant = restaurant
    }

    protected constructor(`in`: Parcel) {
        restaurant = `in`.readParcelable(Restaurant::class.java.classLoader)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(restaurant, flags)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ZomatoRestaurant> = object : Parcelable.Creator<ZomatoRestaurant> {
            override fun createFromParcel(`in`: Parcel): ZomatoRestaurant {
                return ZomatoRestaurant(`in`)
            }

            override fun newArray(size: Int): Array<ZomatoRestaurant?> {
                return arrayOfNulls(size)
            }
        }
    }
}
