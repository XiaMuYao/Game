package com.ydws.game.net.base

import com.google.gson.JsonParseException
import com.ydws.game.net.LL
import org.json.JSONException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException


/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/8/3
 * 描    述：异常处理类
 * 修订历史：
 * ================================================
 */
class BaseExceptionHandle {

    companion object {
        var errorCode = ErrorStatus.Error_Exception
        var errorMsg = "请求失败，请稍后重试"

        fun handleException(e: Throwable): String {
            e.printStackTrace()
            when (e) {
                is SocketTimeoutException, is ConnectException, is UnknownHostException -> {
                    LL.e("网络连接异常: " + e.message)
                    errorMsg = "网络连接异常"
                    errorCode = ErrorStatus.NETWORK_ERROR
                }
                is JsonParseException, is JSONException, is ParseException -> {
                    LL.e("数据解析异常: " + e.message)
                    errorMsg = "数据解析异常"
                    errorCode = ErrorStatus.API_ERROR
                }
                is IllegalArgumentException -> {
                    errorMsg = "参数错误"
                    errorCode = ErrorStatus.INVALID_PARAMETER
                }
                else -> {
                    errorMsg = "未知错误，可能抛锚了吧~"
                    errorCode = ErrorStatus.Error_Exception
                }
            }
            return errorMsg
        }

    }


}
