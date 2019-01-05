package com.ydws.game.activity

import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity

class ShopActivity : BaseAbstractActivity() {
    private var titleTv: TextView? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_shop
    }

    override fun initViews() {
        titleTv = findViewById(R.id.tv_title_bar)
    }

    override fun initData() {
        titleTv!!.text = "道具商城"
    }
}
