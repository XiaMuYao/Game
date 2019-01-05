package com.ydws.game.api

import com.ydws.game.bean.FindCountriesBean
import com.ydws.game.net.base.BaseResponse
import io.reactivex.Observable


import com.ydws.game.body.PropBody
import retrofit2.http.*

/***
 * Created by mo on 2019/1/5
 * 冷风如刀，以大地为砧板，视众生为鱼肉。
 * 万里飞雪，将穹苍作烘炉，熔万物为白银。
 **/
interface SecondApiService {
    /**
     * 充值时返回金币数量
     */
    @GET("agent/findBalance")
    fun findBalance(@Query("userId") userId: String,
              @Query("sessionId") sessionId: String,
              @Query("language") language: String): Observable<BaseResponse<String>>

    @POST("/prop/addBuyBack")
    fun  addBuyBack(@QueryMap map:Map<String,Any>): Observable<BaseResponse<Any>>

    @GET("/agent/findCountries")
    fun findCountries(): Observable<BaseResponse<List<FindCountriesBean.DataBean>>>
}