package com.zkovar.foodfinderkt.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class Restaurant : Parcelable {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("location")
    var location: ZomatoLocation? = null

    @SerializedName("cuisines")
    var cuisines: String? = null

    @SerializedName("average_cost_for_two")
    var averageCost: Double = 0.toDouble()

    @SerializedName("price_range")
    var priceRange: Int = 0

    @SerializedName("currency")
    var currency: String? = null

    @SerializedName("photos_url")
    var photosUrl: String? = null

    @SerializedName("menu_url")
    var menuUrl: String? = null

    @SerializedName("featured_image")
    var featuredImageUrl: String? = null

    constructor() {

    }

    protected constructor(`in`: Parcel) {
        id = `in`.readInt()
        name = `in`.readString()
        url = `in`.readString()
        cuisines = `in`.readString()
        averageCost = `in`.readDouble()
        priceRange = `in`.readInt()
        currency = `in`.readString()
        photosUrl = `in`.readString()
        menuUrl = `in`.readString()
        featuredImageUrl = `in`.readString()
        location = `in`.readParcelable(ZomatoLocation::class.java.classLoader)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(url)
        parcel.writeString(cuisines)
        parcel.writeDouble(averageCost)
        parcel.writeInt(priceRange)
        parcel.writeString(currency)
        parcel.writeString(photosUrl)
        parcel.writeString(menuUrl)
        parcel.writeString(featuredImageUrl)
        parcel.writeParcelable(location, flags)
    }

    companion object {

        val CREATOR: Parcelable.Creator<Restaurant> = object : Parcelable.Creator<Restaurant> {
            override fun createFromParcel(`in`: Parcel): Restaurant {
                return Restaurant(`in`)
            }

            override fun newArray(size: Int): Array<Restaurant?> {
                return arrayOfNulls(size)
            }
        }
    }
}
