package com.assessment.seloger

import android.app.Application
import com.assessment.seloger.di.applicationInjectionsModules
import org.koin.android.ext.android.startKoin

class SeLogerApplication : Application() {

    companion object {
        lateinit var instance: SeLogerApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin(this, applicationInjectionsModules)
    }

}