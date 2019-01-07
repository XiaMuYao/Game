package com.ydws.game.activity

import android.content.Intent
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.jiaoyijiluBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

/**
 * 高级代理简介
 */
class SeniorAgentActivity : BaseAbstractActivity(), View.OnClickListener {
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_senior_agent
    }

    override fun initViews() {
        findViewById<View>(R.id.iv_agent_senior).setOnClickListener(this)
        val viewById = findViewById<View>(R.id.title).findViewById<TextView>(R.id.tv_title_bar)
        viewById.text = "高级代理"
    }

    override fun initData() {

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_agent_senior -> {

                RetrofitManager.service
                        .gotoAgentBefor(userid)
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any?>() {
                            override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                toast("成功成为高级代理")
                                SeniorAgentTwoActivity.start(this@SeniorAgentActivity)
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })
            }
        }
    }
}
