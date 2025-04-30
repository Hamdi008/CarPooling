package com.hamdi.carpooling.di

import android.util.Log
import com.hamdi.carpooling.dataBase.remote.UserApi
import com.hamdi.carpooling.features.home.data.remote.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        Log.d("HEL:","provide Retrofit")

        return Retrofit.Builder()
            .baseUrl("http://192.168.254.190:9000/") // 🛠 Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideHomeApi(retrofit: Retrofit): HomeApi {
        Log.d("HEL:","provide HomeApi")
        return retrofit.create(HomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi {
        Log.d("HEL:","provide UserApi")
        return retrofit.create(UserApi::class.java)
    }
}