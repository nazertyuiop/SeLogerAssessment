package com.assessment.seloger.di

import com.assessment.seloger.BuildConfig
import com.assessment.data.network.AnnouncesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {

    single { createOkHttpClient() }
    single { createRetrofitService(get()) }

}

fun createOkHttpClient(): Retrofit {

    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    val okhttp = OkHttpClient.Builder()
    okhttp.addInterceptor(httpLoggingInterceptor)

    return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp.build())
        .build()
}

fun createRetrofitService(retrofit: Retrofit): AnnouncesApi {
    return retrofit.create(AnnouncesApi::class.java)
}