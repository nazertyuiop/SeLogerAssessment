package com.assessment.domain.model

import java.io.Serializable

data class Announce (val nbrBedrooms : Int,
                     val city : String,
                     val id : Int,
                     val area : Int,
                     val image : String?,
                     val price : Int,
                     val professional : String,
                     val propertyType : String,
                     val nbrRooms : Int) : Serializable