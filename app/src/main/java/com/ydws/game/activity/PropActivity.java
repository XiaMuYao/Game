package com.ydws.game.activity;

import android.content.Intent;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;

/**
 * 道具回收
 */
public class PropActivity extends BaseAbstractActivity implements View.OnClickListener {
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_prop;
    }

    @Override
    public void initViews() {
findViewById(R.id.submit).setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit:
                break;
        }
    }
}
