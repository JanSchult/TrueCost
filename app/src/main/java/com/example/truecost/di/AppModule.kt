package com.example.truecost.di

import com.example.truecost.data.local.LifeCostDatabase
import com.example.truecost.data.remote.LifeCostRepository
import com.example.truecost.util.TrueCostCalculator
import com.example.truecost.viewmodel.TrueCostViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf

import org.koin.dsl.module

val appModule = module {

    // UseCase
    single {
        TrueCostCalculator()
    }
    single {
        LifeCostDatabase.getDatabase(androidContext())
    }
    single {
        get<LifeCostDatabase>().lifecostdao()
    }
single < LifeCostRepository>{ LifeCostRepository(get()) }
    // ViewModel
    viewModelOf(::TrueCostViewModel)

}