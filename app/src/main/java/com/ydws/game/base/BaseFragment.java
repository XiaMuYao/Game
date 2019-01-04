package com.ydws.game.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by lyy on 2018/10/23.
 * Fragment Base
 */

public abstract class BaseFragment extends Fragment {

    protected Context mActivity;
    protected View mRootView;
    // 播放器播放音频
    protected MediaPlayer mPlayer;

    protected abstract int initLayoutId();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initLayoutId();
        mRootView = inflater.inflate(initLayoutId(), container, false);
        initView();
        initData();
        return mRootView;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



}
