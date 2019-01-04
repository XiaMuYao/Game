package com.ydws.game.activity;

import android.widget.TextView;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

public class ShopActivity extends BaseAbstractActivity {
    private TextView titleTv;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_shop;
    }

    @Override
    public void initViews() {
        titleTv = findViewById(R.id.tv_title_bar);
    }

    @Override
    public void initData() {
        titleTv.setText("道具商城");
    }
}
