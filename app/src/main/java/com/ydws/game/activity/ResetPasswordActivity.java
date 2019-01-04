package com.ydws.game.activity;

import android.view.View;
import android.widget.TextView;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

public class ResetPasswordActivity extends BaseAbstractActivity implements View.OnClickListener {
    private TextView titleTv;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_reset;
    }

    @Override
    public void initViews() {
        titleTv = findViewById(R.id.tv_title_bar);
    }

    @Override
    public void initData() {
        titleTv.setText("修改交易密码");

    }

    @Override
    public void onClick(View view) {

    }
}
