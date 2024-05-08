package com.example.ToiletApp.data.di

import com.example.ToiletApp.data.data_resource.ToiletDataResource
import com.example.ToiletApp.data.data_resource.ToiletDataResourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataResourceModule {

    @Singleton
    @Binds
    abstract fun bindToiletDataResource(
        toiletDataResourceImpl: ToiletDataResourceImpl
    ): ToiletDataResource

}