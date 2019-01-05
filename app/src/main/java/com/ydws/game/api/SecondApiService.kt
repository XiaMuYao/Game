package com.ydws.game.api

import com.ydws.game.net.base.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface SecondApiService {
    /**
     * 充值时返回金币数量
     */
    @GET("agent/findBalance")
    fun findBalance(@Query("userId") userId: String,
              @Query("sessionId") sessionId: String,
              @Query("language") language: String): Observable<BaseResponse<String>>
}