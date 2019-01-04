package com.ydws.game.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * Created by 任飞宇
 * on 2018/10/15.
 */

public class WelcomeActivity extends BaseAbstractActivity {

    private ImageView welcome_ImageView;
    private CountDownTimer mTimer;
    private int recLen = 3;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initViews() {
        welcome_ImageView = findViewById(R.id.welcome_ImageView);
        Glide.with(this).load(R.mipmap.welcome_page).into(welcome_ImageView);
    }

    @Override
    public void initData() {
        if (mTimer == null) {
            mTimer = new CountDownTimer((long) (recLen * 1000), 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    if (!WelcomeActivity.this.isFinishing()) {
                        final int remainTime = (int) (millisUntilFinished / 1000L);
                    }
                }

                @Override
                public void onFinish() {
                    intent();
                }
            };
            mTimer.start();
        }
    }

    private void intent() {
        startActivity(new Intent(getApplicationContext(), BootPageActivity.class));
        finish();
    }
}
