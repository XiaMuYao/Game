package com.ydws.game.activity;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 代理确认
 */
public class AgentSureActivity extends BaseAbstractActivity implements View.OnClickListener {
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_agent_sure;
    }

    @Override
    public void initViews() {
        findViewById(R.id.right).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.right:
                startActivity(new Intent(this, MerChantActivity.class));
                break;
        }
    }
}
