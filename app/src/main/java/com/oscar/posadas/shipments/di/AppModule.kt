package com.oscar.posadas.shipments.di

import android.content.Context
import com.oscar.posadas.shipments.repository.LocalRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideLocalRepository(): LocalRepository {
        return LocalRepository(context)
    }
}