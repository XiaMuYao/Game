package com.ydws.game.adapter

import android.databinding.adapters.TextViewBindingAdapter.setText
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydws.game.R
import com.ydws.game.bean.VoteBean
import com.ydws.game.bean.youxitoutiaoBean

class gameinfoAdapter(layoutResId: Int) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: String) {


        helper.let {
            if (helper.position % 2 == 0) {

                helper.getView<TextView>(R.id.item_title).visibility = View.VISIBLE
                helper.getView<TextView>(R.id.neirong).visibility = View.GONE

                it.setText(R.id.item_title, item)
            } else {

                helper.getView<TextView>(R.id.item_title).visibility = View.GONE
                helper.getView<TextView>(R.id.neirong).visibility = View.VISIBLE

                it.setText(R.id.neirong, item)
            }


        }

    }


}
