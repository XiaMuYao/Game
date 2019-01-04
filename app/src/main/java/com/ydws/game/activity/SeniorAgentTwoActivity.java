package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 高代2
 */
public class SeniorAgentTwoActivity extends BaseAbstractActivity implements View.OnClickListener {
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_senior_agent_two;
    }

    @Override
    public void initViews() {
        findViewById(R.id.immediately_extension).setOnClickListener(this);
        findViewById(R.id.add_task).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_task:
                startActivity(new Intent(this, GenerlizeThreeActivity.class));
                break;
            case R.id.immediately_extension:
                startActivity(new Intent(this, GenerlizeThreeActivity.class));
                break;
        }
    }
}
