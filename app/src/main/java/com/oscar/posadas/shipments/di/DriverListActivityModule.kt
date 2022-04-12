package com.oscar.posadas.shipments.di

import com.oscar.posadas.shipments.view.DriverListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DriverListActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeDriverListActivityInjector(): DriverListActivity
}