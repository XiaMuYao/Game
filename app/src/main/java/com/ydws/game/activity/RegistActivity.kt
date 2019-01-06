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
import org.jetbrains.anko.toast

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
            if (ed_tpassword.text.isNullOrBlank()
                    || ed_tuijian.text.isNullOrBlank()
                    || ed_account.text.isNullOrBlank()
                    || ed_password.text.isNullOrBlank()) {
                toast("有字段未填写")
            } else {
                if (ed_password.text.equals(ed_tpassword.text)) {
                    RegisterLastActivity.start(this,
                            ed_tuijian.text.toString().trim(),
                            ed_account.text.toString().trim(),
                            ed_password.text.toString().trim())
                } else {
                    toast("两次密码不相同")
                }
            }

        }
    }
}
