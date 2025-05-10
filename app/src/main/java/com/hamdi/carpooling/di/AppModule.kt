package com.hamdi.carpooling.di

import com.hamdi.carpooling.dataBase.remote.UserRepository
import com.hamdi.carpooling.dataBase.remote.UserRepositoryImpl
import com.hamdi.carpooling.dataBase.roomDB.RoomUserRepository
import com.hamdi.carpooling.features.auth.logout.data.LogoutRepositoryImpl
import com.hamdi.carpooling.features.auth.logout.domain.LogoutRepository
import com.hamdi.carpooling.features.auth.pin.data.PinRepositoryImpl
import com.hamdi.carpooling.features.auth.pin.domain.PinRepository
import com.hamdi.carpooling.features.auth.signin.data.AuthRepositoryImpl
import com.hamdi.carpooling.features.auth.signin.domain.AuthRepository
import com.hamdi.carpooling.features.auth.signup.data.RegisterRepositoryImpl
import com.hamdi.carpooling.features.auth.signup.domain.RegisterRepository
import com.hamdi.carpooling.features.welcome.data.WelcomeRepositoryImpl
import com.hamdi.carpooling.features.welcome.domain.WelcomeRepository
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
    abstract fun bindWelcomeRepository(
        impl: WelcomeRepositoryImpl
    ): WelcomeRepository

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

    @Binds
    @Singleton
    abstract fun bindRegisterRepository(
        impl: RegisterRepositoryImpl
    ): RegisterRepository

    @Binds
    @Singleton
    abstract fun bindLogoutRepository(
        impl: LogoutRepositoryImpl
    ): LogoutRepository

    @Binds
    @Singleton
    abstract fun bindPinRepository(
        impl: PinRepositoryImpl
    ): PinRepository
}
