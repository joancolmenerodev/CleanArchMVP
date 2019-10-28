package com.joancolmenerodev.base.di

import com.joancolmenerodev.data.BuildConfig
import com.joancolmenerodev.base.networking.HeadersInterceptor

val retrofitModule = Kodein.Module("retrofitModule") {

    bind<OkHttpClient>() with singleton {
        OkHttpClient()
            .newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
            })
            .addInterceptor(HeadersInterceptor)
            .build()
    }
    bind<Retrofit>() with singleton {
        Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com/")
            .client(instance())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    bind<AuthenticationApi>() with singleton {
        instance<Retrofit>().create(AuthenticationApi::class.java)
    }

}