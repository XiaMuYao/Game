package com.ydws.game.activity

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.jiabidaojuBean
import com.ydws.game.fragment.DaiLiCaoZuoGoldRecordFragment
import com.ydws.game.fragment.DaiLiCaoZuoPropRecoveryFragment
import com.ydws.game.fragment.GoldRecordFragment
import com.ydws.game.fragment.PropRecoveryFragment
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_record_merchant.*
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast

/**
 * 代理操作
 */
class DaiLiCaoZuoActivity : BaseAbstractActivity(), View.OnClickListener {
    companion object {
        var index: Int = 1
    }

    private var radioGroup: RadioGroup? = null
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_record_merchant
    }

    override fun initViews() {
        index = 1
        radioGroup = findViewById(R.id.radio)
        findViewById<View>(R.id.rb_gold_zanzhu).setOnClickListener(this)
        findViewById<View>(R.id.rb_record).setOnClickListener(this)
        ID.text = "ID:${userid}"
        val tv = findViewById<TextView>(R.id.tv_title_bar)
        tv.text = "道具回收"
        findViewById<View>(R.id.back).setOnClickListener { finish() }
    }

    override fun initData() {

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        if (index == 1) {
            transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoGoldRecordFragment())
            transaction.commit()
        } else if (index == 2) {
            transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoPropRecoveryFragment())
            transaction.commit()
        }


        RetrofitManager.service
                .addSponderGet(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<jiabidaojuBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<jiabidaojuBean.DataBean>, data: jiabidaojuBean.DataBean) {
                        textView10.text="贊助服務獲得金幣總量:${data.daoBishangGet}"
                        textView7.text="道具回收服務獲得金幣總量:${data.goldBishangGet}"
                        textView8.text="合計:${data.num}"
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })

    }

    override fun onClick(view: View) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when (view.id) {
            R.id.rb_gold_zanzhu -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_record_one)
                transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoGoldRecordFragment())
                DaiLiCaoZuoActivity.index = 1
            }
            R.id.rb_record -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_record_two)
                transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoPropRecoveryFragment())
                DaiLiCaoZuoActivity.index = 2

            }
        }
        transaction.commit()
    }
}
