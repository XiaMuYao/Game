package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 匹配币商
 */
public class PipeiBishangActivity extends BaseAbstractActivity implements View.OnClickListener {
    private TextView titleTv;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_pipei_bishang;
    }

    @Override
    public void initViews() {
        titleTv = findViewById(R.id.tv_title_bar);
    }

    @Override
    public void initData() {
        titleTv.setText("赞助");
        findViewById(R.id.iv_pipei_daili).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_pipei_daili:
                startActivity(new Intent(this, GoldApplyActivity.class));
                break;
        }
    }
}
