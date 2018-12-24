package com.zkovar.foodfinderkt.model

import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

/**
 * https://developers.zomato.com/documentation#!/location/locations
 */
class ZomatoCity constructor(`in`: Parcel) : Parcelable {

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("country_id")
    var countryId: Int = 0

    @SerializedName("country_name")
    var countryName: String = ""

    @SerializedName("country_flag_url")
    var countryFlagUrl: String = ""

    @SerializedName("should_experiment_with")
    var shouldExperimentWith: Int = 0

    @SerializedName("discovery_enabled")
    var discoveryEnabled: Int = 0

    @SerializedName("is_state")
    var isState: Int = 0

    @SerializedName("state_id")
    var stateId: Int = 0

    @SerializedName("state_name")
    var stateName: String = ""

    @SerializedName("state_code")
    var stateCode: String = ""

    init {
        id = `in`.readInt()
        name = `in`.readString()
        countryId = `in`.readInt()
        countryName = `in`.readString()
        countryFlagUrl = `in`.readString()
        shouldExperimentWith = `in`.readInt()
        discoveryEnabled = `in`.readInt()
        isState = `in`.readInt()
        stateId = `in`.readInt()
        stateName = `in`.readString()
        stateCode = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(countryId)
        parcel.writeString(countryName)
        parcel.writeString(countryFlagUrl)
        parcel.writeInt(shouldExperimentWith)
        parcel.writeInt(discoveryEnabled)
        parcel.writeInt(isState)
        parcel.writeInt(stateId)
        parcel.writeString(stateName)
        parcel.writeString(stateCode)
    }

    companion object {

        val CREATOR: Parcelable.Creator<ZomatoCity> = object : Parcelable.Creator<ZomatoCity> {
            override fun createFromParcel(`in`: Parcel): ZomatoCity {
                return ZomatoCity(`in`)
            }

            override fun newArray(size: Int): Array<ZomatoCity?> {
                return arrayOfNulls(size)
            }
        }
    }
}
