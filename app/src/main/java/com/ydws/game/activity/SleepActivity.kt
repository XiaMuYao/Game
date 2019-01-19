package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import cc.ibooker.zcountdownviewlib.CountDownView
import com.ydws.game.R
import com.ydws.game.adapter.gameinfoAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.gameInfoBean
import com.ydws.game.bean.xiuxishijian
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_sleep.*
import kotlinx.android.synthetic.main.view_title_bar.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import java.util.HashMap

class SleepActivity : BaseAbstractActivity() {

    private var userid: String by SPreference("userid", "")
    var a = 0

    override fun getContentLayoutID(): Int {
        return R.layout.activity_sleep
    }

    override fun initViews() {
        view_title.back.onClick { finish() }
        view_title.tv_title_bar.text = "休息/恢復"
        ID.text = "ID." + userid
        huifu.setOnClickListener {

            if (a == 1) {
                RetrofitManager.service
                        .applyForRest(userid)
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any?>() {
                            override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                toast(t.message)
                                finish()
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })
            } else if (a == 2) {
                RetrofitManager.service
                        .recoveryService(userid)
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any?>() {
                            override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                toast(t.message)
                                finish()
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })
            }
        }
    }

    override fun initData() {
        RetrofitManager.service
                .findBiStatus(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<xiuxishijian.DataBean>() {
                    override fun onSuccees(t: BaseResponse<xiuxishijian.DataBean>, data: xiuxishijian.DataBean) {
                        var text = ""
                        when (data.biStatus) {
                            1 -> {
                                text = "開放中..."
                                huifu.visibility = View.VISIBLE
                                huifu.setBackgroundResource(R.mipmap.zanting)
                                countdownView.visibility = View.GONE
                                a = 1
                            }
                            2 -> {
                                text = "休息中/可恢復..."
                                huifu.visibility = View.VISIBLE
                                huifu.setBackgroundResource(R.mipmap.huifu)
                                a = 2
                            }
                            3 -> {
                                text = "休息中/可恢復..."
                                huifu.visibility = View.VISIBLE
                                huifu.setBackgroundResource(R.mipmap.huifu)
                                a = 2
                            }
                            4 -> {
                                text = "已经被拉黑..."
                                countdownView.visibility = View.GONE
                                huifu.visibility = View.GONE
                                data.haoTimes = 0
                            }
                        }
                        wenzixiugai.text = text
                        val yanse = "#FFFFFF"
                        val beijing = "#005D3C2D"
                        val textsize = 15F
                        countdownView // 设置倒计时时间戳
                                .setHourTvBackgroundColorHex(beijing)
                                .setMinuteTvBackgroundColorHex(beijing)
                                .setSecondTvBackgroundColorHex(beijing)


                                .setHourTvTextColorHex(yanse)
                                .setHourTvGravity(CountDownView.CountDownViewGravity.GRAVITY_CENTER)
                                .setHourTvTextSize(textsize)


                                .setHourColonTvSize(18, 0)
                                .setHourColonTvTextColorHex(yanse)
                                .setHourColonTvGravity(CountDownView.CountDownViewGravity.GRAVITY_CENTER)
                                .setHourColonTvTextSize(textsize)

                                .setMinuteTvTextColorHex(yanse)
                                .setMinuteTvTextSize(textsize)

                                .setMinuteColonTvSize(18, 0)
                                .setMinuteColonTvTextColorHex(yanse)
                                .setMinuteColonTvTextSize(textsize)


                                .setSecondTvTextColorHex(yanse)
                                .setSecondTvTextSize(textsize)
                                .setCountTime(data.haoTimes / 1000)
                                .startCountDown()

                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SleepActivity::class.java)
            context.startActivity(starter)
        }
    }
}
