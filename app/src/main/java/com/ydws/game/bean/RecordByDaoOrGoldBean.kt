package com.ydws.game.bean

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import com.ydws.game.activity.GoldSearchActivity
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import io.reactivex.android.schedulers.AndroidSchedulers

class RecordByDaoOrGoldBean(var type: Int = 1, private val context: Context, var id: Int = 0, var idStr: String = "", var userId: Int = 0, var lastChangeTime: String? = null, var tradingStatus: Int = 0, var propsNumber: Any? = null, var buyOrSell: Int = 0, var goldNumber: Int = 0) {
    var buyOrSellStr: String = ""
    var goldNumberStr: String = "0"
    var statusStr: String = "已完成"
    var isShowDetail: Boolean = false

    init {
        statusStr = if (tradingStatus == 1) "進行中" else "已完成"
        goldNumberStr = goldNumber.toString()
        if (buyOrSell == 1) {
            buyOrSellStr = "赞助"
        } else {
            buyOrSellStr = "回购"
        }
        isShowDetail = buyOrSell == 2 && type != 1
    }

    fun lookup() {
        val intent = Intent(context, GoldSearchActivity::class.java)
        intent.putExtra("id", id)
        context.startActivity(intent)
    }

    fun report() {
        //查看详情


//        AlertDialog.Builder(context)
//                .setMessage("確認舉報？")
//                .setPositiveButton("確認") { _, _ ->
//                    SecondRetrofitManager.service
//                            .report(userId.toString(), id.toString())
//                            .compose(SchedulerUtils.ioToMain())
//                            .subscribe(object : BaseObserver<Any?>() {
//                                override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
//                                    "举报成功".toast()
//                                }
//
//                                override fun onCodeError(code: Int, msg: String) {
//                                }
//
//                            })
//                }.setNegativeButton("取消") { _, _ -> }
//                .create().show()

    }
}
