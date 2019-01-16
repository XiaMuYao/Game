package com.ydws.game.activity

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.GameListBean
import com.ydws.game.bean.buyingPropsBean
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_shop.*
import org.jetbrains.anko.toast
import java.nio.file.WatchEvent

class ShopActivity : BaseAbstractActivity() {
    private var titleTv: TextView? = null
    private var userid: String by SPreference("userid", "")
    private var beishu: Int = 1;
    override fun getContentLayoutID(): Int {
        return R.layout.activity_shop
    }

    override fun initViews() {
        tv_daoju_count_show.isEnabled = false
        titleTv = findViewById(R.id.tv_title_bar)
        ID.text = "ID."+userid
        findViewById<View>(R.id.title).findViewById<View>(R.id.back).setOnClickListener { finish() }

        tv_daoju_count_show.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                LL.d(s.toString())
                if (!s.toString().isEmpty())
                    tv_gold_count_show.text = (beishu * Integer.parseInt(s.toString())).toString()
            }

        })
        match.setOnClickListener {
            RetrofitManager.service
                    .buyProps(userid, tv_daoju_count_show.text.toString().trim())
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any>() {
                        override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                            "购买成功".toast()
                            finish()
                        }


                        override fun onCodeError(code: Int, msg: String) {
                            toast(msg)
                        }
                    })

        }
    }

    override fun initData() {
        titleTv!!.text = "道具商城"

        RetrofitManager.service
                .buyingProps(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<buyingPropsBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<buyingPropsBean.DataBean>, data: buyingPropsBean.DataBean) {
                        tv_gold_count_get.text = data.jinbi.toString()
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })


        RetrofitManager.service
                .findPropsMoney(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<String>() {
                    override fun onSuccees(t: BaseResponse<String>, data: String) {
                        beishu = Integer.parseInt(data)
                        tv_daoju_count_show.isEnabled = true

                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })


    }
}
