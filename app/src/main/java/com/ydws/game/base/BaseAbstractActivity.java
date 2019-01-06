package com.ydws.game.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.ydws.game.R;


public abstract class BaseAbstractActivity extends AppCompatActivity implements IBaseActivity {


    protected KProgressHUD mProgressHUD;


    protected final String TAG = this.getClass().getSimpleName();

    /**
     * Activity 初始化时调用，用于设置全局数据
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutID());
        initViews();

    }

    /**
     * Activity 可见时调用
     */
    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    /**
     * Activity 获取焦点时调用
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Activity 失去焦点时调用，持久化数据的最后一次可靠的机会
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Activity 不可见时调用
     */
    @Override
    protected void onStop() {
        super.onStop();
        showHud(false);
    }

    /**
     * 和 onCreate 对应，activity 被摧毁时调用，如 finish
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    /**
     * onStop 之前调用
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    public final void showHud(boolean b) {
        b = false;
        if (mProgressHUD == null) {
            mProgressHUD = ProgressUtils.loading(this);
        }
        if (mProgressHUD.isShowing() && !b) {
            mProgressHUD.dismiss();
        } else if (!mProgressHUD.isShowing() && b) {
            mProgressHUD.show();
        }
    }

    @Override
    public final void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
