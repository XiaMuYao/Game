package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 忘记密码
 */
public class ForgetPwdActivity extends BaseAbstractActivity implements View.OnClickListener {
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_forget_pwd;
    }

    @Override
    public void initViews() {
        findViewById(R.id.next_btn).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.next_btn:
                startActivity(new Intent(this,ResetPwdActivity.class));
                break;
        }
    }
}
