package com.zkovar.foodfinderkt.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

/**
 * Created by zkovar on 4/2/18.
 */
class ZomatoCityResponse protected constructor(`in`: Parcel) : Parcelable {

    @SerializedName("location_suggestions")
    var locationSuggestions: List<ZomatoCity> = ArrayList()

    @SerializedName("status")
    var status: String? = null

    @SerializedName("has_more")
    var hasMore: Int = 0

    @SerializedName("has_total")
    var hasTotal: Int = 0

    init {
        locationSuggestions = `in`.createTypedArrayList(ZomatoCity.CREATOR)
        status = `in`.readString()
        hasMore = `in`.readInt()
        hasTotal = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeTypedList(locationSuggestions)
        dest.writeString(status)
        dest.writeInt(hasMore)
        dest.writeInt(hasTotal)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ZomatoCityResponse> = object : Parcelable.Creator<ZomatoCityResponse> {
            override fun createFromParcel(`in`: Parcel): ZomatoCityResponse {
                return ZomatoCityResponse(`in`)
            }

            override fun newArray(size: Int): Array<ZomatoCityResponse?> {
                return arrayOfNulls(size)
            }
        }
    }
}
