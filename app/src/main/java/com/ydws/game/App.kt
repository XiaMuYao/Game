package com.ydws.game

import android.app.Application
import android.content.Context
import com.blankj.utilcode.util.Utils

import kotlin.properties.Delegates

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/11/13
 * 描    述：
 * 修订历史：
 * ================================================
 */
class App : Application() {

    companion object {
        var instance: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Utils.init(this)


    }



}