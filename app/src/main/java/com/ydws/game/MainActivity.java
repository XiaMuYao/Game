package com.ydws.game;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.ydws.game.activity.EverydayTaskActivity;
import com.ydws.game.activity.GameRecordActivity;
import com.ydws.game.activity.GeneralizeActivity;
import com.ydws.game.activity.MerChantActivity;
import com.ydws.game.activity.PersonalActivity;
import com.ydws.game.activity.SeniorAgentActivity;
import com.ydws.game.activity.ShopActivity;
import com.ydws.game.activity.SponsorActivity;
import com.ydws.game.activity.VoteActivity;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.bean.LoginBean;
import com.ydws.game.bean.PersonalMessageBean;
import com.ydws.game.utils.SharedPreferencesUtils;
import com.ydws.game.utils.constants.Common;
import com.ydws.game.utils.constants.CommonURL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseAbstractActivity implements View.OnClickListener {
    private ImageView main_background;

    private TextView ID_TextView;

    private TextView jinbi,yinbi,daoju;

    private String use_Id;
    private String photo;
    private ImageView head_portrait_ImageView;

    private ImageView problem_ImageView;
    private ImageView userIcon;
    private Context context;
    @Override
    public int getContentLayoutID() {
        return R.layout.activity_main;
    }


    @Override
    public void initViews() {
        context = this;
        main_background = findViewById(R.id.main_background);

        jinbi = findViewById(R.id.jinbi);
        yinbi = findViewById(R.id.yinbi);
        daoju = findViewById(R.id.daoju);

        ID_TextView = findViewById(R.id.ID_TextView);
        userIcon = findViewById(R.id.card_head_portrait);

        head_portrait_ImageView = findViewById(R.id.head_portrait_ImageView);
        problem_ImageView = findViewById(R.id.problem_ImageView);
        Glide.with(getApplicationContext()).load(R.mipmap.hall_page_background).into(main_background);


        problem_ImageView.setOnClickListener(this);
        userIcon.setOnClickListener(this);
        findViewById(R.id.store_ImageView).setOnClickListener(this);
        findViewById(R.id.generalize_ImageView).setOnClickListener(this);
        findViewById(R.id.sponsor_ImageView).setOnClickListener(this);
        findViewById(R.id.everyday_task_ImageView).setOnClickListener(this);
        findViewById(R.id.premier_reseller_ImageView).setOnClickListener(this);
        findViewById(R.id.inquire_ImageView).setOnClickListener(this);
        findViewById(R.id.i_want_to_vote_ImageButton).setOnClickListener(this);
        findViewById(R.id.game_iapn_ImageView).setOnClickListener(this);
        use_Id = (String) SharedPreferencesUtils.getParam(getApplicationContext(), Common.ID, "");
        photo = (String) SharedPreferencesUtils.getParam(getApplicationContext(), Common.PHOTO, "");
        Glide.with(getApplicationContext()).load(photo).into(head_portrait_ImageView);
        ID_TextView.setText(use_Id);
    }


    @Override
    public void initData() {
        String id = (String) SharedPreferencesUtils.getParam(getApplicationContext(), Common.ID, "");

        String url = CommonURL.URL + "/game/findEntityById?language=" + 0 + "&id=" + id + "&sessionId=" + Common.sessionId;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {
                        Log.d(TAG, e.getMessage());
                        ToastUtils.showShort("无法连接服务器...");
                    }

                    @Override
                    public void onResponse(String response) {
                        LogUtils.d(TAG, response);
                        PersonalMessageBean personalMessageBean = new Gson().fromJson(response, PersonalMessageBean.class);
                        if (personalMessageBean.getCode().equals(Common.SUCCESS)) {
                            Glide.with(context).load(R.mipmap.hall_page_background).into(userIcon);
                            jinbi.setText(personalMessageBean.getData().getJinbi()+"");
                            yinbi.setText(personalMessageBean.getData().getYinbi()+"");
                            daoju.setText(personalMessageBean.getData().getPropsNumber()+"");
                            ID_TextView.setText(personalMessageBean.getData().getId()+"");
                        } else {
                            showMessage(personalMessageBean.getMessage());
                        }


                    }
                });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.problem_ImageView:
                //todo 问号点击显示 

                break;

            case R.id.store_ImageView:
                startActivity(new Intent(this, ShopActivity.class));

                break;
            case R.id.card_head_portrait:
                startActivity(new Intent(this, PersonalActivity.class));
                break;

            case R.id.generalize_ImageView:
                startActivity(new Intent(this, GeneralizeActivity.class));
                break;

            case R.id.sponsor_ImageView:
                startActivity(new Intent(this, SponsorActivity.class));
                break;

            case R.id.everyday_task_ImageView:
                startActivity(new Intent(this, EverydayTaskActivity.class));

                break;

            case R.id.premier_reseller_ImageView:
                startActivity(new Intent(this, SeniorAgentActivity.class));
                break;
            case R.id.inquire_ImageView:
                startActivity(new Intent(this, GameRecordActivity.class));
                break;
            case R.id.game_iapn_ImageView:
                startActivity(new Intent(this, MerChantActivity.class));
                break;
            case R.id.i_want_to_vote_ImageButton:
                startActivity(new Intent(this, VoteActivity.class));
                break;
        }
    }

}
