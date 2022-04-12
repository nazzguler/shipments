package com.oscar.posadas.shipments.di

import com.oscar.posadas.shipments.ShipmentsApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DriverListActivityModule::class
    ]
)
interface AppComponent {
    fun inject(application: ShipmentsApplication)
}