package com.zkovar.foodfinderkt.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class ZomatoLocation : Parcelable {

    @SerializedName("address")
    var address: String? = null

    @SerializedName("locality")
    var locality: String? = null

    @SerializedName("zipcode")
    var zipCode: String? = null

    @SerializedName("latitude")
    var latitude: String? = null

    @SerializedName("longitude")
    var longitude: String? = null

    constructor() {

    }

    protected constructor(`in`: Parcel) {
        address = `in`.readString()
        locality = `in`.readString()
        zipCode = `in`.readString()
        latitude = `in`.readString()
        longitude = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(address)
        dest.writeString(locality)
        dest.writeString(zipCode)
        dest.writeString(latitude)
        dest.writeString(longitude)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ZomatoLocation> = object : Parcelable.Creator<ZomatoLocation> {
            override fun createFromParcel(`in`: Parcel): ZomatoLocation {
                return ZomatoLocation(`in`)
            }

            override fun newArray(size: Int): Array<ZomatoLocation?> {
                return arrayOfNulls(size)
            }
        }
    }
}
