package com.ydws.game.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.ydws.game.R
import com.ydws.game.bean.GameListBean
import com.ydws.game.bean.jiaoyijiluBean

class JiaoYiRecordAdapter(layoutResId: Int) : BaseQuickAdapter<jiaoyijiluBean.DataBean, BaseViewHolder>(layoutResId) {

    override fun convert(helper: BaseViewHolder, item: jiaoyijiluBean.DataBean) {
        helper.let {

            if (item.type == 1) {
                it.setText(R.id.tv_gold_record_id, "兌換")
            }
            if (item.type == 2) {
                it.setText(R.id.tv_gold_record_id, "註銷")

            }


            var text = ""
            if (item.status == 1) {
                text = "审核中"
            }
            if (item.status == 2) {
                text = "审核成功"
            }
            if (item.status == 3) {
                text = "审核失败"
            }
            it.setText(R.id.shengli, text)

            it.setText(R.id.duizhanyonghu, item.createTime)
                    .setText(R.id.tv_gold_record_count, item.goldNumber)


        }

    }


}
