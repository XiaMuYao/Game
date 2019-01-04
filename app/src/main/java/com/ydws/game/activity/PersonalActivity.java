package com.ydws.game.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ydws.game.R;
import com.ydws.game.adapter.PersonalAdapter;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.bean.PersonalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 个人页
 */
public class PersonalActivity extends BaseAbstractActivity implements View.OnClickListener {
    private RecyclerView personalRv;
    private PersonalAdapter personalAdapter;
    private List<PersonalBean> datas;

    @Override
    public int getContentLayoutID() {
        return R.layout.activity_personal;
    }

    @Override
    public void initViews() {
        personalRv = findViewById(R.id.rv_personal);
    }

    @Override
    public void initData() {
        findViewById(R.id.iv_reset_password).setOnClickListener(this);
        findViewById(R.id.iv_jiaoyi_mima).setOnClickListener(this);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        personalAdapter = new PersonalAdapter(R.layout.item_personal);
        datas = new ArrayList<>();
        List<Integer> imgs = new ArrayList<>();
        imgs.add(R.mipmap.icon_one);
        imgs.add(R.mipmap.icon_two);
        imgs.add(R.mipmap.icon_three);
        imgs.add(R.mipmap.icon_four);
        imgs.add(R.mipmap.icon_three);
        imgs.add(R.mipmap.icon_one);
        imgs.add(R.mipmap.icon_two);
        imgs.add(R.mipmap.icon_three);
        imgs.add(R.mipmap.icon_four);
        imgs.add(R.mipmap.icon_three);
        for (int i = 0; i < imgs.size(); i++) {
            PersonalBean personalBean = new PersonalBean();
            personalBean.setImgId(imgs.get(i));
            datas.add(personalBean);
        }
        personalAdapter.setNewData(datas);
        personalRv.setAdapter(personalAdapter);
        personalRv.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_reset_password:
                startActivity(new Intent(this,ResetPasswordActivity.class));
                break;
            case R.id.iv_jiaoyi_mima:
                startActivity(new Intent(this,SetPasswordActivity.class));
                break;
        }
    }
}
