package com.ydws.game.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.fragment.GoldShutFragment;
import com.ydws.game.fragment.GoldSupportFragment;
import com.ydws.game.fragment.RecordFragment;

/**
 * 币商管理
 */
public class MerChantActivity extends BaseAbstractActivity implements View.OnClickListener {
    private RadioGroup radioGroup;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_mer_chant;
    }

    @Override
    public void initViews() {
        radioGroup = findViewById(R.id.radio);
        findViewById(R.id.rb_gold_zanzhu).setOnClickListener(this);
        findViewById(R.id.rb_record).setOnClickListener(this);
        findViewById(R.id.rb_shut).setOnClickListener(this);
        findViewById(R.id.iv_agent).setOnClickListener(this);

    }

    @Override
    public void initData() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_mer_chant, new GoldSupportFragment());
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.rb_gold_zanzhu:
                radioGroup.setBackgroundResource(R.mipmap.title_one);
                transaction.replace(R.id.frame_mer_chant, new GoldSupportFragment());
                break;
            case R.id.rb_record:
                radioGroup.setBackgroundResource(R.mipmap.title_two);
                transaction.replace(R.id.frame_mer_chant, new RecordFragment());
                break;
            case R.id.rb_shut:
                radioGroup.setBackgroundResource(R.mipmap.title_three);
                transaction.replace(R.id.frame_mer_chant, new GoldShutFragment());
                break;

            case R.id.iv_agent:
                startActivity(new Intent(this, MerchantRecordActivity.class));
                break;
        }
        transaction.commit();
    }


}
