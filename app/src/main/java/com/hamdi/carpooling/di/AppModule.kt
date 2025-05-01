package com.hamdi.carpooling.di

import com.hamdi.carpooling.dataBase.remote.UserRepository
import com.hamdi.carpooling.dataBase.remote.UserRepositoryImpl
import com.hamdi.carpooling.dataBase.roomDB.RoomUserRepository
import com.hamdi.carpooling.features.auth.signin.data.AuthRepositoryImpl
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import com.hamdi.carpooling.features.home.data.HomeRepositoryImpl
import com.hamdi.carpooling.features.home.domain.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        impl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindRoomUserRepository(
        impl: UserRepositoryImpl
    ): RoomUserRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository
}
