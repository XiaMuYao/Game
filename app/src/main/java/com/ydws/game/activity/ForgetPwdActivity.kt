package com.ydws.game.activity

import android.content.Intent
import android.view.View

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import kotlinx.android.synthetic.main.activity_register_last.*
import org.jetbrains.anko.toast

/**
 * 忘记密码
 */
class ForgetPwdActivity : BaseAbstractActivity(), View.OnClickListener {
    private var userid: String by SPreference("userid", "")
    override fun getContentLayoutID(): Int {
        return R.layout.activity_forget_pwd
    }

    override fun initViews() {
        next_btn.setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun onClick(view: View) {
        when (view.id) {


            R.id.next_btn -> {
                RetrofitManager.service
                        .foundPassword(zhanghaohhhh.text.toString().trim(),
                                mibaowenti.text.toString().trim(),
                                mibaodaan.text.toString().trim())
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<String>() {
                            override fun onSuccees(t: BaseResponse<String>, data: String) {
                                toast(t.message)
                                userid = data.toString()
                                ResetPwdActivity.start(this@ForgetPwdActivity)
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })
            }
        }
    }
}
