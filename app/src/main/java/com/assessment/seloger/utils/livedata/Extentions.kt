package com.assessment.seloger.utils.livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

fun Exception.isNetworkRelated(): Boolean = this is ConnectException ||
        this is UnknownHostException ||
        this is SocketTimeoutException ||
        this is TimeoutException


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}