package com.learn.images_compose.di

import android.content.Context
import com.learn.images_compose.App
import com.learn.images_compose.Repository.ImagesRepository
import com.learn.images_compose.util.Util.BASE_URL
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.learn.images_compose.API.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@dagger.Module
@InstallIn(SingletonComponent::class)
object Module {



    @Singleton
    @Provides
    fun injectRe(api: Retrofit) = ImagesRepository(api)

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext application : Context): App{
        return application as App
    }

    @Singleton
    @Provides
    fun injectRetrofit(): Retrofit{
        return retrofit2.Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build().create(Retrofit::class.java)
    }

}