package com.ydws.game.activity

import android.content.Intent
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_generalize.*

/**
 * 推廣簡介
 */
class GeneralizeActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_generalize
    }

    override fun initViews() {
        ID.text = userid
        titleTv = findViewById(R.id.tv_title_bar)
        findViewById<View>(R.id.btn_next).setOnClickListener(this)

    }

    override fun initData() {
        titleTv!!.text = "我的推廣"
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_next -> startActivity(Intent(this, GeneralizeTwoActivity::class.java))
        }
    }
}
