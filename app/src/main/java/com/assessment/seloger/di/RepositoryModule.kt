package com.assessment.seloger.di

import com.assessment.data.AnnounceRepositoryImpl
import com.assessment.domain.AnnounceRepository
import com.assessment.domain.usecases.GetListAnnouncesUseCase
import org.koin.dsl.module.module

val repositoryModule = module {
    factory<AnnounceRepository> { AnnounceRepositoryImpl(get()) }
    factory { GetListAnnouncesUseCase(get()) }
}