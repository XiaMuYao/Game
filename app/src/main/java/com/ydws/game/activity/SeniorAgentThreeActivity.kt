package com.ydws.game.activity

import android.text.SpannableStringBuilder
import android.widget.Toast
import cc.ibooker.zcountdownviewlib.CountDownView
import com.ydws.game.MainActivity
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.gaojidailituiguangBean
import com.ydws.game.bean.jiaquanBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_senior_agent_three.*
import org.jetbrains.anko.toast

/**
 * 高代3
 */
class SeniorAgentThreeActivity : BaseAbstractActivity() {
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_senior_agent_three
    }

    override fun initViews() {
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

        add_task.setOnClickListener {

            RetrofitManager.service
                    .openWeighting(userid)
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any>() {
                        override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                            toast(t.message)
                        }

                        override fun onCodeError(code: Int, msg: String) {
                            toast(msg)
                        }
                    })
        }
    }

    override fun initData() {
        RetrofitManager.service
                .findWeighting(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<jiaquanBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<jiaquanBean.DataBean>, data: jiaquanBean.DataBean) {
                        countdownView.setCountTime(data.timestamp.toLong() / 1000)
                                .startCountDown()
                        jiaquandengji.text = data.level.toString()
                        var text = ""
                        if (data.yesNo == 0) {
                            text = "未完成"
                        } else if (data.yesNo == 1) {
                            text = "正在进行"
                        } else if (data.yesNo == 2) {
                            text = "已经完成"
                        }
                        dangqianjiaquzhuangtai.text = text
                        dangqianrenwudengji.text = data.taskLevel.toString()
                        chengfajibie.text = data.chengfaLevel.toString()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }


}
