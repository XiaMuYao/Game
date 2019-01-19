package com.ydws.game.bean

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.widget.EditText
import com.ydws.game.activity.DaiLiCaoZuoDaoSearchActivity
import com.ydws.game.activity.DaiLiCaoZuoGoldSearchActivity
import com.ydws.game.activity.GoldSearchActivity
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import io.reactivex.android.schedulers.AndroidSchedulers

class DaiLiCaoZuoRecordByDaoBean(var type: Int = 1, private val context: Context, var id: Int = 0, var idStr: String = "", var userId: Int = 0, var lastChangeTime: String? = null, var tradingStatus: Int = 0, var propsNumber: String? = null, var buyOrSell: Int = 0, var goldNumber: Int = 0) {
    var buyOrSellStr: String = ""
    var goldNumberStr: String = "0"
    var statusStr: String = "已完成"
    var isShowDetail: Boolean = false
    var userIdStr: String = ""

    init {
        statusStr = if (tradingStatus == 1) "進行中" else "已完成"
        goldNumberStr = goldNumber.toString()
        if (buyOrSell == 1) {
            buyOrSellStr = "赞助"
        } else {
            buyOrSellStr = "回购"
        }
        isShowDetail = buyOrSell == 2 && type != 1
        userIdStr = userId.toString()
    }

    fun lookup() {
        val intent = Intent(context, DaiLiCaoZuoDaoSearchActivity::class.java)
        intent.putExtra("id", id.toString())
        intent.putExtra("title", "道具回收")

        context.startActivity(intent)
    }

    fun report() {
        val et = EditText(context)
        AlertDialog.Builder(context).setTitle("请输入消息")
                .setView(et)
                .setPositiveButton("确定") { dialogInterface, i ->

                    SecondRetrofitManager.service
                            .report(userId.toString(), id.toString(), et.toString().trim())
                            .compose(SchedulerUtils.ioToMain())
                            .subscribe(object : BaseObserver<Any?>() {
                                override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                    "举报成功".toast()
                                }

                                override fun onCodeError(code: Int, msg: String) {
                                }

                            })
                }.setNegativeButton("取消", null).show()


    }
}
