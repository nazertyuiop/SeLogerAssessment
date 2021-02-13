package com.assessment.seloger.di

import com.assessment.data.AnnounceRepositoryImpl
import org.koin.dsl.module.module

val repositoryModule = module {
    single { AnnounceRepositoryImpl(get()) }
}