package com.ydws.game.adapter

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydws.game.R
import com.ydws.game.bean.VoteBean
import com.ydws.game.bean.youxitoutiaoBean

class VoteAdapter(layoutResId: Int) : BaseQuickAdapter<youxitoutiaoBean.DataBean, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: youxitoutiaoBean.DataBean) {
//        helper.addOnClickListener(R.id.iv_vote_detail)

        helper.let {

            it.setText(R.id.tv_vote_title, item.gameName)
                    .setText(R.id.goumaipiaoshu, item.numNumberVote.toString())
            Glide.with(mContext)
                    .load(item.gamePhoto)
                    .into(it.getView(R.id.iv_vote_bg)
                            as ImageView)
        }
    }


}
