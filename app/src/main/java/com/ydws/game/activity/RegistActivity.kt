package com.ydws.game.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import com.ydws.game.MainActivity

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.UserRegisterBean
import com.ydws.game.net.RetrofitManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_regist.*

/**
 * 注册
 */
class RegistActivity : BaseAbstractActivity() {


    override fun getContentLayoutID(): Int {
        return R.layout.activity_regist
    }

    override fun initViews() {

    }

    override fun initData() {
        next_btn.setOnClickListener {

            RegisterLastActivity.start(this,
                    ed_tuijian.text.toString().trim(),
                    ed_account.text.toString().trim(),
                    ed_password.text.toString().trim()
            )
        }
    }
}
