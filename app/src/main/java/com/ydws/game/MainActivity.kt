package com.ydws.game


import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.squareup.okhttp.Request
import com.ydws.game.activity.EverydayTaskActivity
import com.ydws.game.activity.GameRecordActivity
import com.ydws.game.activity.GeneralizeActivity
import com.ydws.game.activity.MerChantActivity
import com.ydws.game.activity.PersonalActivity
import com.ydws.game.activity.SeniorAgentActivity
import com.ydws.game.activity.ShopActivity
import com.ydws.game.activity.SponsorActivity
import com.ydws.game.activity.VoteActivity
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.LoginBean
import com.ydws.game.bean.PersonalMessageBean
import com.ydws.game.utils.SPreference
import com.ydws.game.utils.SharedPreferencesUtils
import com.ydws.game.utils.StringUtli
import com.ydws.game.utils.constants.Common
import com.ydws.game.utils.constants.CommonURL
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback

import java.util.ArrayList

class MainActivity : BaseAbstractActivity(), View.OnClickListener {
    private var main_background: ImageView? = null
    private var userid: String by SPreference("userid", "")
    private var ID_TextView: TextView? = null

    private var jinbi: TextView? = null
    private var yinbi: TextView? = null
    private var daoju: TextView? = null

    private var use_Id: String? = null
    private var photo: String? = null
    private var head_portrait_ImageView: ImageView? = null

    private var problem_ImageView: ImageView? = null
    private var userIcon: ImageView? = null
    private var context: Context? = null
    override fun getContentLayoutID(): Int {
        return R.layout.activity_main
    }


    override fun initViews() {
        context = this
        main_background = findViewById(R.id.main_background)

        jinbi = findViewById(R.id.jinbi)
        yinbi = findViewById(R.id.yinbi)
        daoju = findViewById(R.id.daoju)

        ID_TextView = findViewById(R.id.ID_TextView)
        userIcon = findViewById(R.id.card_head_portrait)

        head_portrait_ImageView = findViewById(R.id.head_portrait_ImageView)
        problem_ImageView = findViewById(R.id.problem_ImageView)
        Glide.with(applicationContext).load(R.mipmap.hall_page_background).into(main_background!!)


        problem_ImageView!!.setOnClickListener(this)
        userIcon!!.setOnClickListener(this)
        findViewById<View>(R.id.store_ImageView).setOnClickListener(this)
        findViewById<View>(R.id.generalize_ImageView).setOnClickListener(this)
        findViewById<View>(R.id.sponsor_ImageView).setOnClickListener(this)
        findViewById<View>(R.id.everyday_task_ImageView).setOnClickListener(this)
        findViewById<View>(R.id.premier_reseller_ImageView).setOnClickListener(this)
        findViewById<View>(R.id.inquire_ImageView).setOnClickListener(this)
        findViewById<View>(R.id.i_want_to_vote_ImageButton).setOnClickListener(this)
        findViewById<View>(R.id.game_iapn_ImageView).setOnClickListener(this)
        use_Id = SharedPreferencesUtils.getParam(applicationContext, Common.ID, "") as String
        photo = SharedPreferencesUtils.getParam(applicationContext, Common.PHOTO, "") as String
        Glide.with(applicationContext).load(photo).into(head_portrait_ImageView!!)
        ID_TextView!!.text = use_Id
    }


    override fun initData() {

        val url = CommonURL.URL + "/game/findEntityById?language=" + 0 + "&id=" + userid + "&sessionId=" + StringUtli.getBlueTooth()
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        Log.d(TAG, e.message)
                        ToastUtils.showShort("无法连接服务器...")
                    }

                    override fun onResponse(response: String) {
                        LogUtils.d(TAG, response)
                        val personalMessageBean = Gson().fromJson(response, PersonalMessageBean::class.java)
                        if (personalMessageBean.code == Common.SUCCESS) {
                            Glide.with(this@MainActivity).load(R.mipmap.hall_page_background).into(userIcon!!)
                            jinbi!!.text = personalMessageBean.data.jinbi.toString() + ""
                            yinbi!!.text = personalMessageBean.data.yinbi.toString() + ""
                            daoju!!.text = personalMessageBean.data.propsNumber.toString() + ""
                            ID_TextView!!.text = personalMessageBean.data.id.toString() + ""
                        } else {
                            showMessage(personalMessageBean.message)
                        }


                    }
                })


    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.problem_ImageView -> {
            }

            R.id.store_ImageView -> startActivity(Intent(this, ShopActivity::class.java))
            R.id.card_head_portrait -> startActivity(Intent(this, PersonalActivity::class.java))

            R.id.generalize_ImageView -> startActivity(Intent(this, GeneralizeActivity::class.java))

            R.id.sponsor_ImageView -> startActivity(Intent(this, SponsorActivity::class.java))

            R.id.everyday_task_ImageView -> startActivity(Intent(this, EverydayTaskActivity::class.java))

            R.id.premier_reseller_ImageView -> startActivity(Intent(this, SeniorAgentActivity::class.java))
            R.id.inquire_ImageView -> startActivity(Intent(this, GameRecordActivity::class.java))
            R.id.game_iapn_ImageView -> startActivity(Intent(this, MerChantActivity::class.java))
            R.id.i_want_to_vote_ImageButton -> startActivity(Intent(this, VoteActivity::class.java))
        }//todo 问号点击显示
    }

}
