package com.ydws.game.activity;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ydws.game.MainActivity;
import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 任飞宇
 * on 2018/11/20.
 */

public class BootPageActivity extends BaseAbstractActivity implements OnBannerListener {
    private Banner mBanner;
    private GlideImageLoader glideImageLoader;
    private List imagePath;
    private CountDownTimer mTimer;
    private int recLen = 3;


    @Override
    public int getContentLayoutID() {
        return R.layout.activity_boot_page;
    }

    @Override
    public void initViews() {
        mBanner = findViewById(R.id.boot_page_banner);

    }

    @Override
    public void initData() {

        imagePath = new ArrayList<>();

        imagePath.add(R.mipmap.boot_page_1);
        imagePath.add(R.mipmap.boot_page_2);
        imagePath.add(R.mipmap.boot_page_3);

        glideImageLoader = new GlideImageLoader();
        mBanner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        mBanner.setImageLoader(glideImageLoader);
        mBanner.setBannerAnimation(Transformer.ZoomOutSlide);
        mBanner.setDelayTime(recLen * 1000);
        mBanner.isAutoPlay(true);
        mBanner.setIndicatorGravity(BannerConfig.CENTER);

        mBanner.setImages(imagePath).setOnBannerListener(this).start();

        if (mTimer == null) {
            mTimer = new CountDownTimer((long) (recLen * imagePath.size() * 1000), 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    if (!BootPageActivity.this.isFinishing()) {
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

    @Override
    public void OnBannerClick(int position) {
        intent();
    }

    private void intent() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }


}
