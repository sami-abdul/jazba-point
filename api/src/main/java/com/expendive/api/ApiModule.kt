package com.expendive.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Abdul Sami on 12/15/2017.
 */

@Module
class ApiModule {
    @Provides @Singleton @Named
    fun provideBaseUrl(): String = "http://api.themoviedb.org/"

    @Provides @Singleton
    fun provideApi(retrofit: Retrofit): DbApi {
        return retrofit.create(DbApi::class.java)
    }
}


