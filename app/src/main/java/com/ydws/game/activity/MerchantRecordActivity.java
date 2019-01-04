package com.ydws.game.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.fragment.GoldRecordFragment;
import com.ydws.game.fragment.PropRecoveryFragment;

/**
 * 记录查询
 */
public class MerchantRecordActivity extends BaseAbstractActivity implements View.OnClickListener {
    private RadioGroup radioGroup;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_record_merchant;
    }

    @Override
    public void initViews() {
        radioGroup = findViewById(R.id.radio);
        findViewById(R.id.rb_gold_zanzhu).setOnClickListener(this);
        findViewById(R.id.rb_record).setOnClickListener(this);
    }

    @Override
    public void initData() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_mer_chant, new GoldRecordFragment());
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.rb_gold_zanzhu:
                radioGroup.setBackgroundResource(R.mipmap.title_record_one);
                transaction.replace(R.id.frame_mer_chant, new GoldRecordFragment());
                break;
            case R.id.rb_record:
                radioGroup.setBackgroundResource(R.mipmap.title_record_two);
                transaction.replace(R.id.frame_mer_chant, new PropRecoveryFragment());
                break;
        }
        transaction.commit();
    }
}
