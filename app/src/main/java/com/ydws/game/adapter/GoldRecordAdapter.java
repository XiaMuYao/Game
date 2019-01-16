package com.ydws.game.adapter;

import android.graphics.Color;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ydws.game.R;
import com.ydws.game.bean.RecordByDaoOrGoldBean;

import java.util.UUID;

public class GoldRecordAdapter extends BaseQuickAdapter<RecordByDaoOrGoldBean, BaseViewHolder> {
    public GoldRecordAdapter(int layoutResId) {
        super(layoutResId);
    }


    @Override
    protected void convert(BaseViewHolder helper, RecordByDaoOrGoldBean item) {
        helper.addOnClickListener(R.id.iv_right_gold);

        helper.setText(R.id.tv_gold_record_id, "赞助");
        helper.setText(R.id.tv_gold_record_count, item.getGoldNumber()+"");

        String starte = "";
        if (item.getTradingStatus() == 1) {
            starte = "进行中";
            helper.setTextColor(R.id.tv_gold_record_status,Color.BLACK);
        } else if (item.getTradingStatus() == 2) {
            starte = "已完成";
            helper.setTextColor(R.id.tv_gold_record_status,Color.RED);

        }
        helper.setText(R.id.tv_gold_record_status, starte);
        helper.setText(R.id.shijian, item.getLastChangeTime());
    }
}
