package com.ydws.game.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.longsh.optionframelibrary.OptionCenterDialog;
import com.squareup.okhttp.Request;
import com.ydws.game.MainActivity;
import com.ydws.game.R;
import com.ydws.game.base.BaseAbstractActivity;
import com.ydws.game.bean.LoginBean;
import com.ydws.game.utils.SharedPreferencesUtils;
import com.ydws.game.utils.constants.Common;
import com.ydws.game.utils.constants.CommonURL;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;

/**
 * Created by 任飞宇
 * on 2018/12/11.
 */

public class LoginEnActivity extends BaseAbstractActivity implements View.OnClickListener {

    private ImageView background_ImageView;
    private TextView set_TextView;
    private EditText login_account_edit_text;
    private EditText login_password_edit_text;
    private Button sign_in_button;

    private int language = 0;


    @Override
    public int getContentLayoutID() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews() {
        background_ImageView = findViewById(R.id.background_ImageView);
        set_TextView = findViewById(R.id.set_TextView);
        login_account_edit_text = findViewById(R.id.login_account_edit_text);
        login_password_edit_text = findViewById(R.id.login_password_edit_text);
        sign_in_button = findViewById(R.id.sign_in_button);

        set_TextView.setOnClickListener(this);
        sign_in_button.setOnClickListener(this);

    }

    @Override
    public void initData() {
        Glide.with(this).load(R.mipmap.hall_page_background).into(background_ImageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_TextView:
                //todo 设置修改文字语言
                final ArrayList<String> list = new ArrayList<>();
                list.add("中文繁体");
                list.add("English");
                final OptionCenterDialog optionCenterDialog = new OptionCenterDialog();
                optionCenterDialog.show(LoginEnActivity.this, list);
                optionCenterDialog.setItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        LogUtils.d(position);
                        switch (position) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);

                                break;
                            case 1:
                                Intent intentEn = new Intent(getApplicationContext(), LoginEnActivity.class);
                                startActivity(intentEn);
                                break;
                            default:
                        }
                        optionCenterDialog.dismiss();
                    }
                });


                break;
            case R.id.sign_in_button:
                final String login_account = login_account_edit_text.getText().toString();
                final String login_password = login_password_edit_text.getText().toString();
                if (login_password.trim().equals("")) {
                    Toast.makeText(this, "请您输入用户名！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (login_password.trim().equals("")) {
                    Toast.makeText(this, "请您输入密码！", Toast.LENGTH_SHORT).show();
                    return;
                }
                requestData(login_account, login_password);


                break;
            default:

        }
    }

    private void requestData(final String login_account, final String login_password) {
        String url = CommonURL.URL + "/game/login?userName=" + login_account + "&password=" + login_password + "&language=" + language;
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
                        LoginBean loginBean = new Gson().fromJson(response, LoginBean.class);
                        if (loginBean.getCode().equals(Common.SUCCESS)) {
                            SharedPreferencesUtils.setParam(getApplicationContext(), Common.STATE, Common.LOGIN_IN);
                            SharedPreferencesUtils.setParam(getApplicationContext(), Common.ID, loginBean.getData().getId() + "");
                            SharedPreferencesUtils.setParam(getApplicationContext(), Common.ACCOUT, login_account);
                            SharedPreferencesUtils.setParam(getApplicationContext(), Common.PASSWORD, login_password);
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            showMessage(loginBean.getMessage());
                        }


                    }
                });


    }
}

