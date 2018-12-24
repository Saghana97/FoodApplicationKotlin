package com.zkovar.foodfinderkt.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class ZomatoRestaurantResponse protected constructor(`in`: Parcel) : Parcelable {

    @SerializedName("restaurants")
    var restaurants: List<ZomatoRestaurant>? = null

    init {
        restaurants = `in`.createTypedArrayList(ZomatoRestaurant.CREATOR)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList(restaurants)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ZomatoRestaurantResponse> = object : Parcelable.Creator<ZomatoRestaurantResponse> {
            override fun createFromParcel(`in`: Parcel): ZomatoRestaurantResponse {
                return ZomatoRestaurantResponse(`in`)
            }

            override fun newArray(size: Int): Array<ZomatoRestaurantResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}
