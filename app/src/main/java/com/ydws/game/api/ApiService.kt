package com.ydws.game.api

import com.ydws.game.bean.*
import io.reactivex.Observable
import com.ydws.game.net.base.BaseResponse
import retrofit2.http.*
import java.math.BigDecimal

interface ApiService {

    /**
     * 登录
     */
    @GET("game/login")
    fun login(@Query("userName") userName: String,
              @Query("password") password: String): Observable<BaseResponse<LoginBean.DataBean>>

    /**
     * 注册
     */
    @POST("game/register")
    fun register(@Query("userName") userName: String,
                 @Query("password") password: String,
                 @Query("refereesId") refereesId: String,
                 @Query("question") question: String,
                 @Query("answer") answer: String
    ): Observable<BaseResponse<Any>>


    /**
     * 找回密码 下一步按钮
     */
    @POST("game/foundPassword")
    fun foundPassword(@Query("userName") userName: String,
                      @Query("mibaoQuestion") mibaoQuestion: String,
                      @Query("mibaoAnswer") mibaoAnswer: String
    ): Observable<BaseResponse<Any>>

    /**
     * 验证秘钥成功后 重置密码页面 确定按钮
     */
    @GET("game/changePassword")
    fun changePassword(@Query("userId") userId: String,
                       @Query("password") password: String
    ): Observable<BaseResponse<Any>>

    /**
     * 获取密钥
     */
    @GET("agent/getProblem")
    fun getProblem(@Query("userName") userName: String): Observable<BaseResponse<LoginBean.DataBean>>


    /**
     * 获取游戏记录
     */
    @GET("game/selectGoldCoinRecord")
    fun selectGoldCoinRecord(@Query("userId") userId: String,
                             @Query("number") number: String
    ): Observable<BaseResponse<List<GameListBean.DataBean>>>

    /**
     * 获取游戏记录
     */
    @GET("prop/buyingProps")
    fun buyingProps(@Query("id") userId: String
    ): Observable<BaseResponse<buyingPropsBean.DataBean>>


    /**
     * 获取金币道具数量
     */
    @GET("prop/findPropsMoney")
    fun findPropsMoney(@Query("id") userId: String
    ): Observable<BaseResponse<String>>


    /**
     * 获取金币道具数量
     */
    @POST("prop/buyProps")
    fun buyProps(@Query("id") userId: String,
                 @Query("money") money: String,
                 @Query("number") number: String
    ): Observable<BaseResponse<Any>>


    /**
     * 查看推广详情
     */
    @POST("game/findAgentGeneralInformation")
    fun findAgentGeneralInformation(@Query("userId") userId: String):
            Observable<BaseResponse<tuiguangBean.DataBean>>


    /**
     * 推广页领取业绩奖励
     */
    @POST("receive/receiveGoldCoin")
    fun receiveGoldCoin(@Query("userId") userId: String):
            Observable<BaseResponse<Any>>

    /**
     * 推广页二维码
     */
    @GET("agent/showPropaganda")
    fun showPropaganda(@Query("id") userId: String):
            Observable<BaseResponse<erweimaBean.DataBean>>

    /**
     * 点击服务代理获得币商信息
     */
    @GET("game/selectSponsorInformation")
    fun selectSponsorInformation(@Query("id") userId: String):
            Observable<BaseResponse<bishangBean.DataBean>>

    /**
     * 币商向平台赞助金币 确认按钮
     */
    @POST("game/insertPingtaibuy")
    fun insertPingtaibuy(@Query("goldNumber") goldNumber: Int,
                         @Query("tradingNumber") tradingNumber: String,
                         @Query("userId") userId: String
    ):
            Observable<BaseResponse<Any?>>

    /**
     * 币商向平台赞助金币 确认按钮
     */
    @POST("game/updatePingtaibuy")
    fun updatePingtaibuy(@Query("USDTAddress") Address: String,
                         @Query("goldNumber") goldNumber: Int,
                         @Query("userId") userId: String
    ):
            Observable<BaseResponse<Any?>>



    /**
     * USDT钱包地址
     */
    @GET("game/selectPlatformAddress")
    fun selectPlatformAddress():
            Observable<BaseResponse<usdtBean.DataBean>>
}