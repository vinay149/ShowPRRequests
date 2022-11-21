package com.example.showprrequests.showPrRequest.di

import android.content.Context
import com.example.showprrequests.ShowPrApplication
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class AuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
            requestBuilder.addHeader("Authorization", "Bearer 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")
        return chain.proceed(requestBuilder.build())
    }
}

@Module
class AppModule {

    @Provides
    fun getApplicationContext():ShowPrApplication{
        return ShowPrApplication.instance
    }

    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient):Retrofit{
       return Retrofit
           .Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .client(okHttpClient)
           .baseUrl("https://api.github.com")
           .build()
    }

    @Provides
    fun provideOkHttp():OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .readTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS).build()
    }

}