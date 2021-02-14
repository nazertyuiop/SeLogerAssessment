package com.assessment.seloger.di

import com.assessment.seloger.ui.home.HomeViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module {
    viewModel { HomeViewModel(get()) }
}

val applicationInjectionsModules = listOf(
    applicationModule,
    dataModule,
    repositoryModule
)