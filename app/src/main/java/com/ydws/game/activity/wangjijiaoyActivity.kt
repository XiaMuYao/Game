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
import kotlinx.android.synthetic.main.view_title_bar.view.*
import kotlinx.android.synthetic.main.wangjimima.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class wangjijiaoyActivity : BaseAbstractActivity() {

    private var userid: String by SPreference("userid", "")


    override fun getContentLayoutID(): Int {
        return R.layout.wangjimima
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, wangjijiaoyActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun initViews() {
        ID.text = "ID." + userid
        view_title.tv_title_bar.text = "交易密码重置"
        view_title.back.onClick { finish() }
        submit.setOnClickListener {
            if (!editText3.text.toString().equals(editText4.text.toString())) {
                toast("两次输入密码不相同")
                return@setOnClickListener
            }
            if (editText3.text.toString().length > 8 || editText3.text.length < 5) {
                toast("交易密码长度不正确 5-8")
            }
            if (editText4.text.toString().length > 8 || editText4.text.length < 5) {
                toast("交易密码长度不正确 5-8")
            }
            if (tv_gold_count_show.text.isNullOrBlank() ||
                    tv_jiaoyi_pwd_show.text.isNullOrBlank() ||
                    editText3.text.isNullOrBlank() ||
                    editText4.text.isNullOrBlank()) {
                toast("请补全参数")
            } else {
                submit.onClick {
                    RetrofitManager.service
                            .updateUserTraWJ(userid, tv_gold_count_show.text.toString(),
                                    tv_jiaoyi_pwd_show.text.toString(),
                                    editText3.text.toString(),
                                    editText4.text.toString())
                            .compose(SchedulerUtils.ioToMain())
                            .subscribe(object : BaseObserver<Any?>() {
                                override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                    toast(t.message)
                                    finish()
                                }

                                override fun onCodeError(code: Int, msg: String) {
                                    toast(msg)
                                }
                            })
                }
            }
        }
    }

    override fun initData() {
        TextChangedListener.StringWatcher(editText3)
        TextChangedListener.StringWatcher(editText4)
    }

}
