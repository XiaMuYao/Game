package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import com.ydws.game.utils.TextChangedListener
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.toast

class ResetPwdActivity : BaseAbstractActivity() {
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_reset_pwd
    }

    override fun initViews() {
        TextChangedListener.StringWatcher(zaicimima)
        TextChangedListener.StringWatcher(xinmima)
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, ResetPwdActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun initData() {
        reset_btn.setOnClickListener {

            if (xinmima.text.toString().length > 8 || xinmima.text.toString().length < 5) {
                toast("密码为5-8位")
                return@setOnClickListener
            }
            if (zaicimima.text.toString().length > 8 || zaicimima.text.toString().length < 5) {
                toast("密码为5-8位")
                return@setOnClickListener
            }
            if (xinmima.text.toString().equals(zaicimima.text.toString())) {
                RetrofitManager.service
                        .changePassword(userid,
                                xinmima.text.toString().trim())
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any?>() {
                            override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                LoginActivity.start(this@ResetPwdActivity)
                                finish()
                                toast(t.message)
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })


            } else {
                toast("两次输入密码不相同")
            }
        }
    }
}
