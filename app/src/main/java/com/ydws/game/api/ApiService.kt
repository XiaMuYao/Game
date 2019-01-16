package com.ydws.game.api

import com.ydws.game.bean.*
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
    @GET("game/foundPassword")
    fun foundPassword(@Query("userName") userName: String,
                      @Query("mibaoQuestion") mibaoQuestion: String,
                      @Query("mibaoAnswer") mibaoAnswer: String
    ): Observable<BaseResponse<String>>

    /**
     * 验证秘钥成功后 重置密码页面 确定按钮
     */
    @POST("game/changePassword")
    fun changePassword(@Query("userId") userId: String,
                       @Query("password") password: String
    ): Observable<BaseResponse<Any?>>

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


    /**
     * USDT钱包地址
     */
    @GET("game/selectGoldTradingRecord")
    fun selectGoldTradingRecord(@Query("userId") userId: String):
            Observable<BaseResponse<List<jiaoyijiluBean.DataBean>>>


    /**
     * USDT钱包地址
     */
    @POST("weight/gotoAgentBefor")
    fun gotoAgentBefor(@Query("userId") userId: String):
            Observable<BaseResponse<Any?>>


    /**
     * 高级代理的推广详情
     */
    @GET("agent/findHighGenerationDetails")
    fun findHighGenerationDetails(@Query("userId") userId: String):
            Observable<BaseResponse<gaojidailituiguangBean.DataBean>>


    /**
     * 查询用户的加权信息
     */
    @GET("weight/findWeighting")
    fun findWeighting(@Query("userId") userId: String):
            Observable<BaseResponse<jiaquanBean.DataBean>>

    /**
     * 主动开启加权任务
     */
    @POST("weight/openWeighting")
    fun openWeighting(@Query("userId") userId: String):
            Observable<BaseResponse<Any?>>

    /**
     * 游戏列表
     */
    @GET("game/selectVote")
    fun selectVote():
            Observable<BaseResponse<List<youxitoutiaoBean.DataBean>>>


    /**
     * 游戏投票详情
     */
    @GET("game/selectVoteById")
    fun selectVoteById(@Query("id") id: String):
            Observable<BaseResponse<gameInfoBean.DataBean>>

    /**
     * 游戏投票详情
     */
    @POST("game/selectVoteByIdNumber")
    fun selectVoteByIdNumber(@Query("id") id: String,
                             @Query("userId") userId: String
    ): Observable<BaseResponse<Any?>>


    /**
     * 游戏投票详情
     */
    @POST("game/updateUserEntity")
    fun updateUserEntity(@Query("id") id: String,
                         @Query("payee") payee: String,
                         @Query("photo") photo: String,
                         @Query("sex") sex: Int,
                         @Query("phone") phone: String,
                         @Query("niName") niName: String,
                         @Query("city") city: String
    ): Observable<BaseResponse<Any?>>


    /**
     * 币商休息页查币商状态
     */
    @GET("agent/findBiStatus")
    fun findBiStatus(@Query("userId") id: String
    ): Observable<BaseResponse<xiuxishijian.DataBean>>


    /**
     * 暂停
     */
    @POST("agent/applyForRest")
    fun applyForRest(@Query("userId") id: String
    ): Observable<BaseResponse<Any?>>


    /**
     * 恢复
     */
    @POST("agent/recoveryService")
    fun recoveryService(@Query("userId") id: String
    ): Observable<BaseResponse<Any?>>


    /**
     * USDT比例
     */
    @GET("agent/getBili")
    fun getBili(): Observable<BaseResponse<Int>>


    /**
     * getPayType获得支付方式
     */
    @GET("agent/getPayType")
    fun getPayType(): Observable<BaseResponse<zhifufangshi.DataBean>>


    /**
     * 记录查询→赞助记录→记录详情按钮
     */
    @GET("agent/findGold")
    fun findGold(@Query("userId") id: String,
                 @Query("tradingId") TradingId: String): Observable<BaseResponse<jinbizanshuxiangqingBean.DataBean>>


    /**
     * 记录查询→赞助记录→记录详情按钮
     */
    @POST("game/updateUserTraWJ")
    fun updateUserTraWJ(@Query("userId") id: String,
                        @Query("question") question: String,
                        @Query("answer") answer: String,
                        @Query("tradingPassword") tradingPassword: String,
                        @Query("tradingPasswordXin") tradingPasswordXin: String
    ): Observable<BaseResponse<Any?>>



    /**
     * 记录查询→赞助记录→记录详情按钮
     */
    @GET("prop/addSponderGet")
    fun addSponderGet(@Query("id") id: String): Observable<BaseResponse<jiabidaojuBean.DataBean>>

}