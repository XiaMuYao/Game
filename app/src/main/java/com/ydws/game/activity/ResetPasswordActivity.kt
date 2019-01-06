package com.ydws.game.activity

import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity

class ResetPasswordActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_reset
    }

    override fun initViews() {
        titleTv = findViewById(R.id.tv_title_bar)
    }

    override fun initData() {
        titleTv!!.text = "修改交易密码"

    }

    override fun onClick(view: View) {

    }
}
