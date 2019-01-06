package com.ydws.game.activity

import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_show_image.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class ShowImageDetailActivity : BaseAbstractActivity() {

    private var userid: String by SPreference("userid", "")
    override fun getContentLayoutID(): Int {
        return R.layout.activity_show_image
    }

    override fun initViews() {
        findViewById<View>(R.id.back).onClick { finish() }
        findViewById<TextView>(R.id.tv_title_bar).text = "凭证"
        ID.text = "ID:${userid}"
        Glide.with(this@ShowImageDetailActivity).load(intent.getStringExtra("url")).into(image)
    }

    override fun initData() {
    }

}