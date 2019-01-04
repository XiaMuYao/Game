package com.ydws.game.net.base


/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/8/3
 * 描    述：基础返回类型
 * 修订历史：
 * ================================================
 */
open class BaseResponse<T>(
    val code: Int,
    val message: String,
    val success: String,
    val data: T
)

