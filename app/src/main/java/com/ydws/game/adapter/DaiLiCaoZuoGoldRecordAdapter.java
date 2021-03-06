package com.ydws.game.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ydws.game.R;
import com.ydws.game.bean.RecordByDaoOrGoldBean;

public class DaiLiCaoZuoGoldRecordAdapter extends BaseQuickAdapter<RecordByDaoOrGoldBean, BaseViewHolder> {
    public DaiLiCaoZuoGoldRecordAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, RecordByDaoOrGoldBean item) {
        helper.addOnClickListener(R.id.iv_right_gold);
    }
}
