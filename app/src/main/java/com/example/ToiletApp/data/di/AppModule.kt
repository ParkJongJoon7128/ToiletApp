package com.example.ToiletApp.data.di

import com.example.ToiletApp.data.api.ToiletService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Base URL
    private const val baseUrl = "https://openapi.gg.go.kr/"

    // Api Key
    private const val apiKey = "172e4fdad76d4b6aa8f34ad805d9dfb3"

    // OkhttpClient
    @Singleton
    @Provides
    fun provideOkhttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    // Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val parser = TikXml.Builder().exceptionOnUnreadXml(false).build()

        return Retrofit.Builder()
            .addConverterFactory(TikXmlConverterFactory.create(parser))
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .build()
    }

    // Toilet Api Service
    @Singleton
    @Provides
    fun provideToiletService(retrofit: Retrofit): ToiletService {
        return retrofit.create(ToiletService::class.java)
    }
}