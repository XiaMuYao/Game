package com.ydws.game.activity

import android.view.View
import android.widget.TextView
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.body.GoldTradingBean
import kotlinx.android.synthetic.main.activity_gold_apply.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class GoldApplyActivity : BaseAbstractActivity() {

    var data: GoldTradingBean? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_gold_apply
    }

    override fun initViews() {
        data = intent.getSerializableExtra("data") as GoldTradingBean?
        findViewById<View>(R.id.back).onClick { finish() }
        findViewById<TextView>(R.id.tv_title_bar).text = "金幣贊助"
        ll_status.onClick {

        }
        ID.text = data?.id.toString()
        guojiahediqu.text = data?.city


    }

    override fun initData() {

    }
}
