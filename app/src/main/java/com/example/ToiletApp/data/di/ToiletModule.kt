package com.example.ToiletApp.data.di

import com.example.ToiletApp.data.repository.ToiletRepository
import com.example.ToiletApp.data.repository.ToiletRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ToiletModule {

    @Singleton
    @Binds
    abstract fun bindToiletRepository(
        toiletRepositoryImpl: ToiletRepositoryImpl
    ): ToiletRepository
}