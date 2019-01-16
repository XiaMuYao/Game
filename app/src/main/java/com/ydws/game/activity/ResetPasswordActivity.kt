package com.ydws.game.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.databinding.ActivityResetBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SPreference
import com.ydws.game.utils.TextChangedListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_reset.*
import org.jetbrains.anko.toast

class ResetPasswordActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null
    private var userid: String by SPreference("userid", "")

    private lateinit var activityResetBinding: ActivityResetBinding

    override fun getContentLayoutID(): Int {
        return R.layout.activity_reset
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityResetBinding = DataBindingUtil.setContentView(this, R.layout.activity_reset)
        activityResetBinding.idStr = "ID.$userid"

        activityResetBinding.viewTitle.findViewById<TextView>(R.id.tv_title_bar).text = "修改交易密碼"
        activityResetBinding.viewTitle.findViewById<View>(R.id.back).setOnClickListener { finish() }
        activityResetBinding.submit.setOnClickListener {
            resetPassword()
        }
        wangjijiaoyimima.setOnClickListener {
            wangjijiaoyActivity.start(this@ResetPasswordActivity)
        }

    }

    override fun initViews() {
        titleTv = findViewById(R.id.tv_title_bar)

        TextChangedListener.StringWatcher(tv_gold_count_show)
        TextChangedListener.StringWatcher(tv_jiaoyi_pwd_show)
        TextChangedListener.StringWatcher(editText3)

    }

    override fun initData() {
        titleTv!!.text = "修改交易密码"

    }

    private fun resetPassword() {
        if (activityResetBinding.oldPassword.isNullOrBlank()) {
            showMessage("請輸入原交易碼")
            return
        }

        if (activityResetBinding.newPassword.isNullOrBlank()) {
            showMessage("請輸入新交易碼")
            return
        }

        if (activityResetBinding.newPassword != activityResetBinding.newPasswordRepeat) {
            showMessage("兩次交易碼不一致")
            return
        }
        if (tv_gold_count_show.text.toString().length > 8 || tv_gold_count_show.text.toString().length < 5) {
            toast("密码不符合规则")
        }
        if (tv_jiaoyi_pwd_show.text.toString().length > 8 || tv_jiaoyi_pwd_show.text.toString().length < 5) {
            toast("密码不符合规则")
        }
        if (editText3.text.toString().length > 8 || editText3.text.toString().length < 5) {
            toast("密码不符合规则")
        }



//        id	是	integer	用户id
//                tradingPassword	是	string	交易密码
//                tradingPasswordXin	是	string	新交易密码
//                tradingPasswordXin2	是	string	再次输入新交易密码
//                language	是	int	语言，0汉语，其他英文
//        sessionId
        val params = mapOf(
                "tradingPassword" to activityResetBinding.oldPassword!!,
                "tradingPasswordXin" to activityResetBinding.newPassword!!,
                "tradingPasswordXin2" to activityResetBinding.newPasswordRepeat!!,
                "id" to userid
        )

        SecondRetrofitManager.service.gameUpTraPasswordModify(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any?>() {
                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                        showMessage("修改成功")
                        finish()
                    }

                    override fun onCodeError(code: Int, msg: String) {
//                        activityPropBinding.buyValueVisibility = View.GONE

                    }

                })

    }

    override fun onClick(view: View) {

    }
}
