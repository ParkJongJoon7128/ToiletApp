package com.example.testproject.data.di

import com.example.testproject.data.data_resource.ToiletDataResource
import com.example.testproject.data.data_resource.ToiletDataResourceImpl
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