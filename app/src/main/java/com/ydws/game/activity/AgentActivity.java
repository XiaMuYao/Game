package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 代理申请
 */
public class AgentActivity extends BaseAbstractActivity implements View.OnClickListener {
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_agent;
    }

    @Override
    public void initViews() {
        findViewById(R.id.iv_submit).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_submit:
                startActivity(new Intent(this, AgentSureActivity.class));
                break;
        }
    }
}
