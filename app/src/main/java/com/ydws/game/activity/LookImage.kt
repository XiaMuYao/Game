package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import com.bumptech.glide.Glide
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import kotlinx.android.synthetic.main.activity_guide.*
import kotlinx.android.synthetic.main.activity_look_image.*
import kotlinx.android.synthetic.main.view_title_bar.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class LookImage : BaseAbstractActivity() {
    var url = ""
    override fun getContentLayoutID(): Int {
        return R.layout.activity_look_image
    }

    override fun initViews() {
        url = intent.getStringExtra("url")
        titlddde.tv_title_bar.text="查看凭证"
        titlddde.back.onClick { finish() }
    }

    override fun initData() {
        Glide.with(this@LookImage)
                .load(url)
                .into(pingzheng)
    }

    companion object {
        fun start(context: Context, url: String) {
            val starter = Intent(context, LookImage::class.java)
            starter.putExtra("url", url)
            context.startActivity(starter)
        }
    }

}
