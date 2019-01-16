package com.ydws.game.adapter

import android.app.Dialog
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydws.game.R
import com.ydws.game.bean.GameListBean

class GameRecordAdapter(layoutResId: Int) : BaseQuickAdapter<GameListBean.DataBean, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: GameListBean.DataBean) {
        helper.let {
            var name = if (item.userName == null) "" else item.gameName

            it.setText(R.id.duizhanyonghu,name)
                    .setText(R.id.tv_gold_record_id,item.duijuTime)
                    .setText(R.id.tv_gold_record_count,item.gameName)

//            it.setText(R.id.tv_gold_record_id, "ID:${item.duijuTime}")
//                    .setText(R.id.shijian, name)
//                    .setText(R.id.tv_gold_record_count, name)
//                    .setText(R.id.tv_gold_record_count, name)
//
            if (item.status == 1) {
                it.setText(R.id.shengli, "胜 +${item.gameLiushui}")
            } else {
                it.setText(R.id.shengli, "胜 -${item.gameLiushui}")

            }
//            if (item.status == 2) {
//                it.setText(R.id.tv_gold_record_status, "失败")
//            }
        }

    }


}
