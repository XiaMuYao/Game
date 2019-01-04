package com.ydws.game.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ydws.game.R;
import com.ydws.game.bean.GoldRecordBean;

public class GoldRecordAdapter extends BaseQuickAdapter<GoldRecordBean, BaseViewHolder> {
    public GoldRecordAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, GoldRecordBean item) {
        helper.addOnClickListener(R.id.iv_right_gold);
    }
}
