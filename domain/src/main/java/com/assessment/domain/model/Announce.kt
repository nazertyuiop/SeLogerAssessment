package com.assessment.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Announce(
    val nbrBedrooms: Int,
    val city: String,
    val id: Int,
    val area: Int,
    val image: String?,
    val price: Int,
    val professional: String,
    val propertyType: String,
    val nbrRooms: Int
) : Parcelable


fun Announce.getGeneralInfo(): String = "$nbrRooms p . $nbrBedrooms ch . $area m "