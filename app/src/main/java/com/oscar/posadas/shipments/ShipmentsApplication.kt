package com.oscar.posadas.shipments

import android.app.Application
import com.oscar.posadas.shipments.di.AppModule
import com.oscar.posadas.shipments.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ShipmentsApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
            .inject(this)
    }
}