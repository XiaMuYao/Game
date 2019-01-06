package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ydws.game.MainActivity
import com.ydws.game.R
import com.ydws.game.R.id.ed_password
import com.ydws.game.R.id.next_btn
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.LoginBean
import com.ydws.game.bean.UserRegisterBean
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_register_last.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.util.*

class RegisterLastActivity : BaseAbstractActivity() {

    private var tuijian: String? = null
    private var account: String? = null
    private var tpassword: String? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_register_last
    }

    override fun initViews() {

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
                            LoginActivity.start(this@RegisterLastActivity)
                            finish()
                        }

                        override fun onCodeError(code: Int, msg: String) {
                        }

                    })
        }

        huoqumibao.setOnClickListener {
            if (guanjianzi.text.isEmpty()) {
                toast("关键字为空")
            } else {
                miyao.text = UUID.randomUUID().toString().substring(0, 20)
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
