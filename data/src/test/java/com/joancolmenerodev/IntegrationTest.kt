package com.joancolmenerodev

import com.joancolmenerodev.base.networking.HeadersInterceptor
import com.joancolmenerodev.data.BuildConfig
import com.joancolmenerodev.service.CryptoCurrencyService
import com.joancolmenerodev.service.CryptoRetrofitApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

abstract class IntegrationTest {

    lateinit var mockServer: MockWebServer
    private lateinit var apiService: CryptoCurrencyService
    lateinit var cryptoRetrofitApi : CryptoRetrofitApi

    @Before
    open fun setUp() {
        this.configureMockServer()
        generateFakeApiService()

    }

    @After
    open fun tearDown() {
        this.stopMockServer()
    }

    open fun configureMockServer() {
        mockServer = MockWebServer()
        mockServer.start()
    }

    open fun stopMockServer() {
        mockServer.shutdown()
    }

    open fun mockHttpResponse(fileName: String, responseCode: Int) = mockServer.enqueue(
        MockResponse()
            .setResponseCode(responseCode)
            .setBody(getJson(fileName))
    )


    private fun getJson(filename: String): String {
        val uri = this.javaClass.classLoader.getResource("json/${filename}")
        val file = File(uri.path)
        return String(file.readBytes())
    }

    private fun generateFakeApiService() {
        //Perhaps this is a good idea to create a FakeRetrofitModule
        apiService = Retrofit.Builder()
            .baseUrl(mockServer.url("/"))
            .client(generateOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoCurrencyService::class.java)

        cryptoRetrofitApi = CryptoRetrofitApi(apiService)
    }

    private fun generateOkHttpClient() = OkHttpClient()
        .newBuilder()
        .addInterceptor(HeadersInterceptor())
        .addInterceptor(HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE
        })
        .build()
}
