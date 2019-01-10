package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.ydws.game.R
import com.ydws.game.adapter.gameinfoAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.gameInfoBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_sleep.*
import org.jetbrains.anko.toast

class SleepActivity : BaseAbstractActivity() {

    private var userid: String by SPreference("userid", "")
var a = 0

    override fun getContentLayoutID(): Int {
        return R.layout.activity_sleep
    }

    override fun initViews() {

        ID.text = "ID." + userid
        huifu.setOnClickListener {

            if (a==1) {
                RetrofitManager.service
                        .applyForRest(userid)
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any>() {
                            override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                                toast(t.message)
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })
            } else if (a==2){
                RetrofitManager.service
                        .recoveryService(userid)
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
    }

    override fun initData() {
        RetrofitManager.service
                .findBiStatus(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<Int>() {
                    override fun onSuccees(t: BaseResponse<Int>, data: Int) {
                        var text = ""
                        a = data.toInt()

                        when (data) {
                            1 -> {
                                text = "开放中..."
                                huifu.visibility = View.VISIBLE
                                huifu.setBackgroundResource(R.mipmap.zanting)
                            }
                            2 -> {
                                text = "休息中..."
                                huifu.visibility = View.VISIBLE
                                huifu.setBackgroundResource(R.mipmap.huifu)

                            }
                            3 -> text = "黑名单..."
                        }
                        wenzixiugai.text = text

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
