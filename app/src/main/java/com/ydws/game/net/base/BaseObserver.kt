package com.ydws.game.net.base

import android.annotation.SuppressLint
import android.widget.Toast
import com.ydws.game.App
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/8/3
 * 描    述：
 * 修订历史：
 * ================================================
 */
abstract class BaseObserver<T> : Observer<BaseResponse<T>> {


    /**
     * 开始订阅
     * 这一层就是开启不同的等待页面
     */
    override fun onSubscribe(d: Disposable) {
        //请求开始 --- 开启dialog
    }

    /**
     * 收到数据 处理
     * 这一层结合 code以及数据额处理 如果没有数据 和数据错误的展示
     */
    @SuppressLint("ShowToast")
    override fun onNext(t: BaseResponse<T>) {
        if (t.code == ErrorStatus.SUCCESS) {
            onSuccees(t, t.data)
        } else {
            onCodeError(t.code, t.message)
            Toast.makeText(App.instance,t.message,Toast.LENGTH_SHORT)
        }
    }

    /**
     * 收到错误
     */
    override fun onError(e: Throwable) {
        BaseExceptionHandle.handleException(e)
    }

    /**
     * 发送结束
     */
    override fun onComplete() {
        //请求完成 --- 结束dialog
    }

    /**
     * 全部正常
     */
    protected abstract fun onSuccees(t: BaseResponse<T>, data: T)

    /**
     * 请求成功 也返回了数据
     */
    protected abstract fun onCodeError(code: Int, msg: String)

//    /**
//     * 重试的逻辑
//     */
//    protected abstract fun onReLoad()


}