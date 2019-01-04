package com.ydws.game.net.base


/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/8/3
 * 描    述：
 * 修订历史：
 * ================================================
 */
object ErrorStatus {
    /**
     * 操作成功
     */
    const val SUCCESS = 200
    /**
     * 未登录（身份过期）
     */
    const val UNLOGGED = 1

    /**
     * 操作无效（取消）
     */
    const val INVALID_OPERATION = 2

    /**
     * 参数无效（错误）
     */
    const val INVALID_PARAMETER = 3
    /**
     * 查询结果为空
     */
    const val QUERY_RESULT_IS_EMPTY = 4

    /**
     * 操作权限不足
     */
    const val INSUFFICIENT_OPERATION_PRIVILEGES = 5

    /**
     * 非法操作
     */
    const val ILLEGAL_OPERATION = 6
    /**
     * 警告
     */
    const val WARNING = 7
    /**
     * 出错异常
     */
    const val Error_Exception = 8
    /**
     * 补货成功
     */
    const val REPLENISHMENT_SUCCESS = 9
    /**
     * 登录成功
     */
    const val Login_Successfully = 10

    /**
     * 已邀请
     */
    const val ALREADY_INVITED = 11

    /**
     * 接口错误
     */
    const val API_ERROR = 1010
    /**
     * 网路连接异常
     */
    const val NETWORK_ERROR = 5157

}