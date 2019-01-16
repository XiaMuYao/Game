package com.ydws.game.activity

import android.Manifest
import android.Manifest.permission.READ_PHONE_STATE
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.longsh.optionframelibrary.OptionCenterDialog
import com.squareup.okhttp.Request
import com.ydws.game.MainActivity
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.LoginBean
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import com.ydws.game.utils.SharedPreferencesUtils
import com.ydws.game.utils.constants.Common
import com.ydws.game.utils.constants.CommonURL
import com.zhy.http.okhttp.OkHttpUtils
import com.zhy.http.okhttp.callback.StringCallback

import java.util.ArrayList

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by 任飞宇
 * on 2018/11/20.
 */

class LoginActivity : BaseAbstractActivity(), View.OnClickListener {

    private var background_ImageView: ImageView? = null
    private var set_TextView: TextView? = null
    private var login_account_edit_text: EditText? = null
    private var login_password_edit_text: EditText? = null
    private var sign_in_button: Button? = null

    private var userid: String by SPreference("userid", "")
    private var userName: String by SPreference("userName", "")

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, LoginActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun getContentLayoutID(): Int {
        return R.layout.activity_login
    }

    override fun initViews() {
        ActivityCompat.requestPermissions(this@LoginActivity, arrayOf(Manifest.permission.READ_CALENDAR,
                Manifest.permission.WRITE_CALENDAR,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_PHONE_STATE), 1)
        background_ImageView = findViewById(R.id.background_ImageView)
        set_TextView = findViewById(R.id.set_TextView)
        login_account_edit_text = findViewById(R.id.login_account_edit_text)
        login_password_edit_text = findViewById(R.id.login_password_edit_text)
        sign_in_button = findViewById(R.id.sign_in_button)
        login_account_edit_text?.text = SpannableStringBuilder(userName)
        set_TextView!!.setOnClickListener(this)
        sign_in_button!!.setOnClickListener(this)
        findViewById<View>(R.id.tv_forget_pwd).setOnClickListener(this)
        findViewById<View>(R.id.regist_tv).setOnClickListener(this)
    }

    override fun initData() {
        Glide.with(this).load(R.mipmap.hall_page_background).into(background_ImageView!!)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.set_TextView -> {
                //todo 设置修改文字语言
                val list = ArrayList<String>()
                list.add("中文繁体")
                list.add("English")
                val optionCenterDialog = OptionCenterDialog()
                optionCenterDialog.show(this@LoginActivity, list)
                optionCenterDialog.setItemClickListener { parent, view, position, id ->
                    LogUtils.d(position)
                    when (position) {
                        0 -> {

                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                            finish()
                        }
                        1 -> {

                            startActivity(Intent(applicationContext, LoginEnActivity::class.java))
                            finish()
                        }
                    }
                    optionCenterDialog.dismiss()
                }
            }
            R.id.sign_in_button -> {
                RetrofitManager.service
                        .login(login_account_edit_text!!.text.toString().trim { it <= ' ' }, login_password_edit_text!!.text.toString().trim { it <= ' ' })
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<LoginBean.DataBean>() {
                            override fun onSuccees(t: BaseResponse<LoginBean.DataBean>, data: LoginBean.DataBean) {
                                userName = data.userName
                                userid = data.id.toString()

                                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                                startActivity(intent)
                                finish()
                            }

                            override fun onCodeError(code: Int, msg: String) {
                            }

                        })
            }
            R.id.tv_forget_pwd -> startActivity(Intent(this, ForgetPwdActivity::class.java))

            R.id.regist_tv -> startActivity(Intent(this, RegistActivity::class.java))
            else -> {
            }
        }//                LogUtils.d("点击了...");
        //                final String login_account = login_account_edit_text.getText().toString();
        //                final String login_password = login_password_edit_text.getText().toString();
        //                if (login_password.trim().equals("")) {
        //                    Toast.makeText(this, "Please input your username！", Toast.LENGTH_SHORT).show();
        //                    return;
        //                }
        //                if (login_password.trim().equals("")) {
        //                    Toast.makeText(this, "Please input your password！", Toast.LENGTH_SHORT).show();
        //                    return;
        //                }
        //                    requestData(login_account, login_password);
        //                Intent intent = new Intent(this, MainActivity.class);
        //                startActivity(intent);
        //                finish();
    }

    private fun requestData(login_account: String, login_password: String) {
        val url = CommonURL.URL + "/game/login?userName=" + login_account + "&password=" + login_password + "&language=" + 0 + "&sessionId=" + Common.sessionId
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(object : StringCallback() {
                    override fun onError(request: Request, e: Exception) {
                        Log.d(TAG, e.message)
                        ToastUtils.showShort("无法连接服务器...")
                    }

                    override fun onResponse(response: String) {
                        LogUtils.d(TAG, response)
                        val loginBean = Gson().fromJson(response, LoginBean::class.java)
                        if (loginBean.code == Common.SUCCESS) {
                            SharedPreferencesUtils.setParam(applicationContext, Common.STATE, Common.LOGIN_IN)
                            SharedPreferencesUtils.setParam(applicationContext, Common.ID, loginBean.data.id.toString() + "")
                            SharedPreferencesUtils.setParam(applicationContext, Common.ACCOUT, login_account)
                            SharedPreferencesUtils.setParam(applicationContext, Common.PASSWORD, login_password)
                            SharedPreferencesUtils.setParam(applicationContext, Common.PHOTO, loginBean.data.photo)
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            showMessage(loginBean.message)
                        }


                    }
                })


    }
}
