package com.assessment.data.network

import retrofit2.http.GET


interface AnnouncesApi {

    @GET("/listings.json")
    suspend fun getListAnnounces(): AnnouncesResponse

}