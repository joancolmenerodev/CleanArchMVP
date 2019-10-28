package com.joancolmenerodev.base.networking

class HeadersInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response = with(chain.request().newBuilder()) {
        addHeader(com.joancolmenerodev.feature.base.networking.HeadersInterceptor.Companion.HEADER_KEY, com.joancolmenerodev.feature.base.networking.HeadersInterceptor.Companion.API_KEY)
        chain.proceed(this.build())
    }

    companion object {
        const val HEADER_KEY = "X-CMC_PRO_API_KEY"
        const val API_KEY = "badb6455-0340-4bfb-9f60-80f51ae8bc0d"
    }
}