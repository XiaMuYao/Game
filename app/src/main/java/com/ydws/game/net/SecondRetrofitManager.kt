package com.ydws.game.net


import com.ydws.game.api.ApiService
import com.ydws.game.api.SecondApiService
import com.ydws.game.utils.StringUtli
import com.ydws.game.utils.constants.CommonURL
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object SecondRetrofitManager {

    private var client: OkHttpClient? = null
    private var retrofit: Retrofit? = null


    val service: SecondApiService by lazy { getRetrofit()!!.create(SecondApiService::class.java) }


    /**
     * 设置公共参数
     * .addQueryParameter("language", "0")
     */
    private fun addQueryParameterInterceptor(): Interceptor {
        return Interceptor { chain ->
            val originalRequest = chain.request()
            val request: Request
            val modifiedUrl = originalRequest.url().newBuilder()
                    .addQueryParameter("language", "0")
                    .addQueryParameter("sessionId", StringUtli.getBlueTooth())
                    .build()
            request = originalRequest.newBuilder().url(modifiedUrl).build()
            chain.proceed(request)
        }
    }


    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            synchronized(SecondRetrofitManager::class.java) {
                if (retrofit == null) {
                    //添加一个log拦截器,打印所有的log
                    val httpLoggingInterceptor = HttpLoggingInterceptor()
                    //可以设置请求过滤的水平,body,basic,headers
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


                    client = OkHttpClient.Builder()
                            .addInterceptor(addQueryParameterInterceptor())  //参数添加
                            .addInterceptor(httpLoggingInterceptor) //日志,所有的请求响应度看到
                            .connectTimeout(60L, TimeUnit.SECONDS)
                            .readTimeout(60L, TimeUnit.SECONDS)
                            .writeTimeout(60L, TimeUnit.SECONDS)
                            .build()

                    // 获取retrofit的实例
                    retrofit = Retrofit.Builder()
                            .baseUrl(CommonURL.URL)
                            .client(client!!)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
            }
        }
        return retrofit
    }
}
