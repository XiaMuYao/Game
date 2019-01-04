package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 高级代理简介
 */
public class SeniorAgentActivity extends BaseAbstractActivity implements View.OnClickListener {
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_senior_agent;
    }

    @Override
    public void initViews() {
        findViewById(R.id.iv_agent_senior).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_agent_senior:
                startActivity(new Intent(this, SeniorAgentTwoActivity.class));
                break;
        }
    }
}
