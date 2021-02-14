package com.assessment.data.network

import com.google.gson.annotations.SerializedName


data class AnnouncesResponse(
    @SerializedName("items") val items: List<AnnounceItemJson>?,
    @SerializedName("totalCount") val totalCount: Int?
)


data class AnnounceItemJson(

    @SerializedName("bedrooms") val bedrooms: Int?,
    @SerializedName("city") val city: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("area") val area: Int?,
    @SerializedName("url") val url: String?,
    @SerializedName("price") val price: Int?,
    @SerializedName("professional") val professional: String?,
    @SerializedName("propertyType") val propertyType: String?,
    @SerializedName("rooms") val rooms: Int?
)


