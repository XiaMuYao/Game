package com.ydws.game.api

import com.ydws.game.bean.FindCountriesBean
import com.ydws.game.body.GoldTradingBean
import com.ydws.game.bean.PropAboutMoney
import com.ydws.game.bean.SelectBuyBack
import com.ydws.game.body.GoldTradingBody
import com.ydws.game.net.base.BaseResponse
import io.reactivex.Observable


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
    fun findBalance(@Query("userId") userId: String): Observable<BaseResponse<String>>

    @GET("agent/addGoldTrading")
    fun addGoldTrading(@Query("userId") userId: String,@Query("jinbi") jinbi: String,@Query("tradingPassword") tradingPassword: String): Observable<BaseResponse<GoldTradingBean>>

    @POST("/prop/addBuyBack")
    fun  addBuyBack(@QueryMap map:Map<String,Any>): Observable<BaseResponse<Any>>

    @GET(" agent/findCountries")
    fun findCountries(): Observable<BaseResponse<List<FindCountriesBean.DataBean>>>

    @GET("prop/selectBuyBack")
    fun  selectBuyBack(@Query("id")id:String):Observable<BaseResponse<SelectBuyBack.DataBean>>

    @GET("prop/aboutMoney")
    fun propAboutMoney(@Query("countries")countries:String,@Query("goldNumber")number:String):Observable<BaseResponse<PropAboutMoney.DataBean>>

    @GET("/prop/selectBuyBack")
    fun propSelectBuyBack(@QueryMap map: Map<String, Any>)
}