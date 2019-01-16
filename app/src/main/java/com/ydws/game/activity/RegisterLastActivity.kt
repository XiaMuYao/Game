package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ydws.game.MainActivity
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.LoginBean
import com.ydws.game.bean.UserRegisterBean
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import kotlinx.android.synthetic.main.activity_register_last.*
import kotlinx.android.synthetic.main.view_title_bar.view.*
import org.jetbrains.anko.toast
import java.util.*
import com.ydws.game.R
import android.content.ClipData
import android.content.ClipboardManager


class RegisterLastActivity : BaseAbstractActivity() {

    private var tuijian: String? = null
    private var account: String? = null
    private var tpassword: String? = null
    var one = 1

    override fun getContentLayoutID(): Int {
        return R.layout.activity_register_last
    }

    override fun initViews() {

        titledd.tv_title_bar.text = "修改密码"

        next.setOnClickListener {

            RetrofitManager.service
                    .register(account!!,
                            tpassword!!,
                            tuijian!!,
                            guanjianzi.text.toString().trim(),
                            miyao.text.toString().trim()
                    )
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any>() {
                        override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                            toast("注册成功")
                            LoginActivity.start(this@RegisterLastActivity)
                            finish()
                        }

                        override fun onCodeError(code: Int, msg: String) {
                        }

                    })
        }

        fuzhi.setOnClickListener {
            val clip = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clip.text = miyao.text
            toast("复制成功")
        }

        huoqumibao.setOnClickListener {
            if (guanjianzi.text.isEmpty()) {
                toast("关键字为空")
            } else {
                if (one == 1) {
                    miyao.text = UUID.randomUUID().toString().substring(0, 20)
                    one = 2
                } else if (one==2) {
                    toast("只能获取一次")
                }
            }
        }
    }


    override fun initData() {
        tuijian = intent.getStringExtra("ed_tuijian")
        account = intent.getStringExtra("ed_account")
        tpassword = intent.getStringExtra("ed_tpassword")

    }

    companion object {
        fun start(context: Context,
                  ed_tuijian: String,
                  ed_account: String,
                  ed_tpassword: String) {
            val starter = Intent(context, RegisterLastActivity::class.java)
            starter.putExtra("ed_tuijian", ed_tuijian)
            starter.putExtra("ed_account", ed_account)
            starter.putExtra("ed_tpassword", ed_tpassword)
            context.startActivity(starter)
        }
    }


}
