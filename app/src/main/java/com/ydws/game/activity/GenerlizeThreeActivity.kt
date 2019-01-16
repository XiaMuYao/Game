package com.ydws.game.activity

import android.content.ClipboardManager
import android.content.Context
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.erweimaBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_generalize_three.*
import kotlinx.android.synthetic.main.activity_register_last.*
import org.jetbrains.anko.toast

/**
 * 我的推广
 */
class GenerlizeThreeActivity : BaseAbstractActivity() {
    private var userid: String by SPreference("userid", "")
    private var titleTv: TextView? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_generalize_three
    }

    override fun initViews() {
        titleTv = findViewById(R.id.tv_title_bar)
        findViewById<View>(R.id.include).findViewById<View>(R.id.back).setOnClickListener { finish() }
        findViewById<TextView>(R.id.ID).text = "ID.$userid"
        textView5.text = "推薦人ID:$userid"

        fuzhilianjie.setOnClickListener {
            val clip = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clip.text = textView5.text.toString() + "\n" + xiazaidizhi.text.toString()
            toast("复制成功")

        }
    }

    override fun initData() {
        titleTv!!.text = "我的推廣"

        ID.text = "ID." + userid
        RetrofitManager.service
                .showPropaganda(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<erweimaBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<erweimaBean.DataBean>, data: erweimaBean.DataBean) {

                        Glide.with(this@GenerlizeThreeActivity)
                                .load(data.tuiguangErweima)
                                .into(erweima)
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })


    }
}
