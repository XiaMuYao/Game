package com.ydws.game.api

import com.ydws.game.bean.LoginBean
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



}