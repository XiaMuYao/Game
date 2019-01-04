package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 推廣簡介
 */
public class GeneralizeActivity extends BaseAbstractActivity implements View.OnClickListener {
    private TextView titleTv;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_generalize;
    }

    @Override
    public void initViews() {
        titleTv = findViewById(R.id.tv_title_bar);
        findViewById(R.id.btn_next).setOnClickListener(this);

    }

    @Override
    public void initData() {
        titleTv.setText("我的推廣");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(this, GeneralizeTwoActivity.class));
                break;
        }
    }
}
