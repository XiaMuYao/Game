package com.ydws.game.activity

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.utils.TextChangedListener
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
        TextChangedListener.StringWatcher(ed_account)
        TextChangedListener.StringWatcher(ed_password)
        TextChangedListener.StringWatcher(ed_tpassword)
    }

    override fun initData() {
        next_btn.setOnClickListener {
            if (ed_tpassword.text.isNullOrBlank()
                    || ed_tuijian.text.isNullOrBlank()
                    || ed_account.text.isNullOrBlank()
                    || ed_password.text.isNullOrBlank()

            ) {
                toast("有字段未填寫！")
                return@setOnClickListener
            } else {
                if (
                        ed_password.text.toString().length > 12 || ed_password.text.toString().length < 8 ||
                        ed_tpassword.text.toString().length > 12 || ed_tpassword.text.toString().length < 8||
                        ed_account.text.toString().length > 20 || ed_account.text.toString().length <8
                ) {
                    toast("賬號或者密碼長度有誤！")
                    return@setOnClickListener
                }
                if (!ed_password.text.equals(ed_tpassword.text)) {
                    RegisterLastActivity.start(this,
                            ed_tuijian.text.toString().trim(),
                            ed_account.text.toString().trim(),
                            ed_password.text.toString().trim())
                } else {
                    toast("兩次密碼不相同！")
                }
            }

        }
    }
}
