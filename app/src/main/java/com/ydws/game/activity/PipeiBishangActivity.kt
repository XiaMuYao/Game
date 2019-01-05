package com.ydws.game.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.TextView
import com.ydws.game.MainActivity

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SharedPreferencesUtils
import com.ydws.game.utils.constants.Common
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pipei_bishang.*

/**
 * 匹配币商
 */
class PipeiBishangActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_pipei_bishang
    }

    override fun initViews() {
        titleTv = findViewById(R.id.tv_title_bar)
        titleTv!!.text = "赞助"
        findViewById<View>(R.id.iv_pipei_daili).setOnClickListener(this)
        findViewById<View>(R.id.back).setOnClickListener(this)
    }

    @SuppressLint("CheckResult")
    override fun initData() {
        val userId = SharedPreferencesUtils.getParam(applicationContext, Common.ID, "") as String
        SecondRetrofitManager.service
                .findBalance(userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { it->
                    tv_daoju_count_show.text = it.data
                }


    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_pipei_daili -> startActivity(Intent(this, GoldApplyActivity::class.java))
            R.id.back -> finish()
        }
    }
}
