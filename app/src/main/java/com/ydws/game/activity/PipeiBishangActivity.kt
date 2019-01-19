package com.ydws.game.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.GoldTradingBean
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pipei_bishang.*
import kotlinx.android.synthetic.main.view_title_bar.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * 匹配币商
 */
class PipeiBishangActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null
    private var userid: String by SPreference("userid", "")
    private var userName: String by SPreference("userName", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_pipei_bishang
    }

    override fun initViews() {
        view_title.back.onClick { finish() }
        titleTv = findViewById(R.id.tv_title_bar)
        titleTv!!.text = "赞助"
        ID.text = "ID:$userid"
        findViewById<View>(R.id.iv_pipei_daili).setOnClickListener(this)
        findViewById<View>(R.id.back).setOnClickListener(this)

    }

    @SuppressLint("CheckResult")
    override fun initData() {
        SecondRetrofitManager.service
                .findBalance(userid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {

                    override fun onSuccees(t: BaseResponse<String>, data: String) {
                        tv_daoju_count_show.text = data
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        if (code==205){
                            finish()
                        }
                    }
                })


    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_pipei_daili -> {
                if (tv_gold_count_show.text.toString().isBlank()) {
                    "請輸入贊助金幣數量".toast()
                    return
                }
                if (tv_gold_count_show.text.toString().toInt() < 1000) {
                    "贊助金不能低於1000".toast()
                    return
                }
                if (tv_jiaoyi_pwd_show.text.toString().isBlank()) {
                    "請輸入交易密碼".toast()
                    return
                }

                SecondRetrofitManager.service
                        .addGoldTrading(userid, tv_gold_count_show.text.toString(), tv_jiaoyi_pwd_show.text.toString())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(object : BaseObserver<GoldTradingBean>() {

                            override fun onSuccees(t: BaseResponse<GoldTradingBean>, data: GoldTradingBean) {
                                val intent = Intent(this@PipeiBishangActivity, GoldApplyActivity::class.java)
                                intent.putExtra("data", data)
                                intent.putExtra("title", "匹配信息")
                                startActivity(intent)
                            }

                            override fun onCodeError(code: Int, msg: String) {
                                if (code == 205) {
                                    finish()
                                }
                            }
                        })
            }
            R.id.back -> finish()
        }
    }
}
