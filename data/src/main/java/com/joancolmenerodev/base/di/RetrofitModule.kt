package com.joancolmenerodev.base.di

import com.joancolmenerodev.base.networking.HeadersInterceptor
import com.joancolmenerodev.data.BuildConfig
import com.joancolmenerodev.service.CryptoCurrencyService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitModule = Kodein.Module("retrofitModule") {

    bind<OkHttpClient>() with singleton {
        OkHttpClient()
            .newBuilder()
            .addInterceptor(HeadersInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            })
            .build()
    }
    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .client(instance())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    bind<CryptoCurrencyService>() with singleton {
        instance<Retrofit>().create(CryptoCurrencyService::class.java)
    }

}