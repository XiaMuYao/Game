package com.ydws.game.api

import com.yalantis.ucrop.UCropActivity
import com.ydws.game.bean.FindCountriesBean
import com.ydws.game.bean.PayTypeBean
import com.ydws.game.bean.GoldTradingBean
import com.ydws.game.bean.PropAboutMoney
import com.ydws.game.bean.SelectBuyBackBean
import com.ydws.game.bean.*
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import io.reactivex.Observable


import okhttp3.MultipartBody
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
    fun addGoldTrading(@Query("userId") userId: String, @Query("jinbi") jinbi: String, @Query("tradingPassword") tradingPassword: String): Observable<BaseResponse<GoldTradingBean>>

    @POST("prop/addBuyBack")
    fun addBuyBack(@QueryMap map: Map<String, String>): Observable<BaseResponse<Any?>>

    @GET(" agent/findCountries")
    fun findCountries(): Observable<BaseResponse<List<FindCountriesBean.DataBean>>>

    @GET("prop/selectBuyBack")
    fun selectBuyBack(@Query("id") id: String): Observable<BaseResponse<SelectBuyBackBean.DataBean>>

    @GET("prop/aboutMoney")
    fun propAboutMoney(@Query("countries") countries: String, @Query("goldNumber") number: String): Observable<BaseResponse<PropAboutMoney.DataBean>>

    @GET("game/selectEverydayTask")
    fun gameSelectEverydayTask(@Query("userId") userId: String): Observable<BaseResponse<GameSelectEverydayTaskBean.DataBean>>

    @POST("game/receivegold")
    fun gameReceivegold(@Query("userId") userId: String): Observable<BaseResponse<Any>>

    @GET("prop/recordByDaoOrGold")
    fun propRecordByDaoOrGold(@Query("userId") userId: String, @Query("daoOrGold") daoOrGold: Int): Observable<BaseResponse<List<GameSelectGoldRecordBean.DataBean>>>

    @GET("agent/getPayType")
    fun getPayType(): Observable<BaseResponse<List<PayTypeBean>>>

    @Multipart
    @POST("fileupload/picture")
    fun uploadPicture(@Part inputStream: MultipartBody.Part): Observable<BaseResponse<String>>

    @POST("agent/goldCommit")
    fun goldCommit(@QueryMap map: Map<String, String>): Observable<BaseResponse<Any>>


    @GET("game/selectWantSponsor")
    fun gameSelectWantSponsor(@Query("id") userId: String): Observable<BaseResponse<SelectWantSponsorBean.DataBean>>

    @POST("game/addWantSponsor")
    fun gameAddWantSponsor(@QueryMap map: Map<String, String>): Observable<BaseResponse<Any?>>

    @POST("game/upAgentTransactionNumber")
    fun gameUpAgentTransactionNumber(@Query("tradingNumber") tradingNumber: String, @Query("userId") userId: String): Observable<BaseResponse<Any?>>

    @GET("game/selectPlatformAddress")
    fun  gameSelectPlatformAddress():Observable<BaseResponse<GameSelectPlatformAddressBean.DataBean>>

    @POST("game/upTraPasswordModify")
    fun gameUpTraPasswordModify(@QueryMap map: Map<String, String>): Observable<BaseResponse<Any?>>

    @GET("prop/detailsOfPropRepurchase")
    fun detailsOfPropRepurchase(@Query("userId")userId:String,@Query("dingdanId")dingdanId:String): Observable<BaseResponse<DetailsOfPropRepurchaseBean>>

    @POST("prop/report")
    fun report(@Query("userId")userId:String,@Query("id")id:String): Observable<BaseResponse<Any?>>

    @GET("agent/getRecord")
    fun getRecord(@Query("userId")userId:String): Observable<BaseResponse<List<DaiLiCaoZuoJinBiBean>>>

    @GET("agent/getDetails")
    fun getDetails(@Query("userId")userId:String,@Query("id")id:String): Observable<BaseResponse<DaiLiCaoZuoGoldDetailBean>>

    @POST("prop/biJuBaoUser")
    fun biJuBaoUser(@Query("userId")userId:String,@Query("id")id:String): Observable<BaseResponse<Any?>>

    @POST("agent/DeterminingTransactions")
    fun DeterminingTransactions(@Query("userId")userId:String,@Query("jiluId")jiluId:String,@Query("bishangId")bishangId:String,@Query("jinbishu")jinbishu:String):Observable<BaseResponse<Any?>>

    @GET("prop/sponsorId")
    fun sponsorId(@Query("bishangId")bishangId:String): Observable<BaseResponse<List<DaiLiCaoZuoDaojuBean>>>

    @GET("prop/userBuyBack")
    fun userBuyBack(@Query("userId")userId:String,@Query("id")id:String):Observable<BaseResponse<DaiLiCaoZuoDaoSearchBean>>

    @POST("prop/sponsorConfirm")
    fun sponsorConfirm(@Query("userId")userId:String,@Query("zhuanzhangPhoto")zhuanzhangPhoto:String,@Query("payType")payType:String,@Query("id")id:String):Observable<BaseResponse<Any?>>

    @GET("game/selectEntityById")
    fun gameSelectEntityById(@Query("id") userId: String):Observable<BaseResponse<SelectEntityById.DataBean>>

    @POST("game/updateGathering")
    fun gameUpdateGathering(@QueryMap map: Map<String, String>): Observable<BaseResponse<Any?>>


    @GET("game/judgeQuestion")
    fun gameJudgeQuestion(@Query("userId")userId:String,@Query("question")question:String,@Query("answer")answer:String) : Observable<BaseResponse<Any?>>

    @POST("game/updatePassword")
    fun gameUpdatePassword(@QueryMap map: Map<String, String>): Observable<BaseResponse<Any?>>

    @GET("game/selectPortrait")
    fun selectPortrait(): Observable<BaseResponse<List<selectPortraitBean>>>

    @POST("game/updPhoto")
    fun updPhoto(@Query("id")id:String,@Query("photo")photo:String): Observable<BaseResponse<Any?>>


    @POST("game/updateTradingPassword")
    fun  gameUpdateTradingPassword(@Query("id")id:String,@Query("tradingPassword")tradingPassword:String,@Query("tradingPassword2")tradingPassword2:String): Observable<BaseResponse<Any?>>
}