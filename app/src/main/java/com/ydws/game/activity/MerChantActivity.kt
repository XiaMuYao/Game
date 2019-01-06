package com.ydws.game.activity

import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.text.Editable
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.squareup.okhttp.Request
import com.ydws.game.MainActivity
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.LoginBean
import com.ydws.game.bean.bishangBean
import com.ydws.game.bean.erweimaBean
import com.ydws.game.fragment.GoldShutFragment
import com.ydws.game.fragment.GoldSupportFragment
import com.ydws.game.fragment.RecordFragment
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import com.ydws.game.utils.SharedPreferencesUtils
import com.ydws.game.utils.constants.Common
import com.ydws.game.utils.constants.CommonURL
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback
import kotlinx.android.synthetic.main.activity_generalize_three.*
import kotlinx.android.synthetic.main.activity_mer_chant.*
import org.jetbrains.anko.toast

/**
 * 币商管理
 */
class MerChantActivity : BaseAbstractActivity(), View.OnClickListener {
    private var radioGroup: RadioGroup? = null
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_mer_chant
    }

    override fun initViews() {
        radioGroup = findViewById(R.id.radio)
        findViewById<View>(R.id.rb_gold_zanzhu).setOnClickListener(this)
        findViewById<View>(R.id.rb_record).setOnClickListener(this)
        findViewById<View>(R.id.rb_shut).setOnClickListener(this)
        findViewById<View>(R.id.iv_agent).setOnClickListener(this)
        findViewById<View>(R.id.title).findViewById<View>(R.id.back).setOnClickListener { finish() }
        val viewById = findViewById<View>(R.id.title).findViewById<TextView>(R.id.tv_title_bar)
        viewById.text = "服务代理"

    }
    override fun initData() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_mer_chant, GoldSupportFragment())
        transaction.commit()




        RetrofitManager.service
                .selectSponsorInformation(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<bishangBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<bishangBean.DataBean>, data: bishangBean.DataBean) {

                        /*这里没完事*/
                        show_name.text = SpannableStringBuilder(data.payee)
                        show_sex.text = SpannableStringBuilder(data.phone)
                        show_age.text = SpannableStringBuilder(data.bankName)
                        show_tel.text = SpannableStringBuilder(data.bankName)
                        show_nicheng.text = SpannableStringBuilder(data.zhifubao)
                        et_wechat.text = SpannableStringBuilder(data.wechat)

                        Glide.with(this@MerChantActivity)
                                .load(data.photo)
                                .into(iv_user_icon)

                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })


    }

    override fun onClick(view: View) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when (view.id) {
            R.id.rb_gold_zanzhu -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_one)
                transaction.replace(R.id.frame_mer_chant, GoldSupportFragment())
            }
            R.id.rb_record -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_two)
                transaction.replace(R.id.frame_mer_chant, RecordFragment())
            }
            R.id.rb_shut -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_three)
                transaction.replace(R.id.frame_mer_chant, GoldShutFragment())
            }

            R.id.iv_agent -> startActivity(Intent(this, DaiLiCaoZuoActivity::class.java))
        }
        transaction.commit()
    }


}
