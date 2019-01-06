package com.ydws.game.adapter

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydws.game.R
import com.ydws.game.bean.VoteBean
import com.ydws.game.bean.youxitoutiaoBean

class gameinfoAdapter(layoutResId: Int) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: String) {


        helper.let {
            it.setText(R.id.item_title, item)
                    .setText(R.id.neirong, item)
        }
    }


}
