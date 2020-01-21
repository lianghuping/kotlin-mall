package com.ljp.baselibrary.data.net

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitFactory {

    companion object {
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit
    private val interceptor:Interceptor

    init {
        interceptor = Interceptor{
            chain ->
            val request = chain.request().newBuilder()
                .addHeader("Content-type","application/json")
                .addHeader("charset","utf-8")
                .build()
            chain.proceed(request)
        }


        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("http://10.0.2.2:8080/Kotlin_war/")
            .client(initClient())
            .build()
    }


    private fun initClient(): OkHttpClient {

        return OkHttpClient().newBuilder()
            .addInterceptor(logInterceptor())
            .addInterceptor(interceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun logInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}