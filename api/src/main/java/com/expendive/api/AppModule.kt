package com.expendive.api

import android.app.Application
import android.content.Context
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Abdul Sami on 12/15/2017.
 */

class AppModule(private val application: Application) {
    @Provides @Singleton
    fun provideContext(): Context = application
}