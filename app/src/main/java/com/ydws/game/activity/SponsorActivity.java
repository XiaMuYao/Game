package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 赞助首页
 */
public class SponsorActivity extends BaseAbstractActivity implements View.OnClickListener {
    private TextView titleTv;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_sponsor;
    }

    @Override
    public void initViews() {
        titleTv = findViewById(R.id.tv_title_bar);

        findViewById(R.id.iv_gold_zanzhu).setOnClickListener(this);
        findViewById(R.id.iv_daoju_huishou).setOnClickListener(this);
        findViewById(R.id.iv_dali_shenqing).setOnClickListener(this);
        findViewById(R.id.record).setOnClickListener(this);
    }

    @Override
    public void initData() {
        titleTv.setText("赞助");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_gold_zanzhu:
                startActivity(new Intent(this, PipeiBishangActivity.class));
                break;
            case R.id.iv_daoju_huishou:
                startActivity(new Intent(this, PropActivity.class));
                break;
            case R.id.iv_dali_shenqing:
                startActivity(new Intent(this, AgentActivity.class));
                break;
            case R.id.record:
                startActivity(new Intent(this, MerchantRecordActivity.class));
                break;
        }
    }
}
