package com.ydws.game.api

import com.ydws.game.bean.GameListBean
import com.ydws.game.bean.LoginBean
import com.ydws.game.bean.UserRegisterBean
import io.reactivex.Observable
import com.ydws.game.net.base.BaseResponse
import retrofit2.http.*

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
    @GET("/agent/getProblem")
    fun getProblem(@Query("userName") userName: String): Observable<BaseResponse<LoginBean.DataBean>>


    /**
     * 获取游戏记录
     */
    @GET("game/selectGoldCoinRecord")
    fun selectGoldCoinRecord(@Query("userId") userId: String,
                       @Query("number") number: String
    ): Observable<BaseResponse<List<GameListBean.DataBean>>>
}