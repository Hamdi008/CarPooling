package com.hamdi.carpooling.di

import android.content.Context
import android.content.SharedPreferences
import com.hamdi.carpooling.dataBase.remote.UserApi
import com.hamdi.carpooling.features.auth.logout.data.remote.LogoutApi
import com.hamdi.carpooling.features.auth.signin.data.AuthInterceptor
import com.hamdi.carpooling.features.auth.signin.data.remote.AuthApi
import com.hamdi.carpooling.features.auth.signup.data.remote.RegisterApi
import com.hamdi.carpooling.features.welcome.data.remote.WelcomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(sharedPreferences: SharedPreferences): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(sharedPreferences))
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .baseUrl("http://192.168.254.190:9000/") // 🛠 Replace with your base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideWelcomeApi(retrofit: Retrofit): WelcomeApi {
        return retrofit.create(WelcomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRegisterApi(retrofit: Retrofit): RegisterApi {
        return retrofit.create(RegisterApi::class.java)
    }

    @Provides
    @Singleton
    fun provideLogoutApi(retrofit: Retrofit): LogoutApi {
        return retrofit.create(LogoutApi::class.java)
    }
}