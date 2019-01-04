package com.ydws.game.activity;

import android.widget.TextView;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;
/**
 * 我的推广
 */
public class GenerlizeThreeActivity extends BaseAbstractActivity {
    private TextView titleTv;
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_generalize_three;
    }

    @Override
    public void initViews() {
        titleTv = findViewById(R.id.tv_title_bar);
    }

    @Override
    public void initData() {
        titleTv.setText("我的推廣");
    }
}
