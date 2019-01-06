package com.ydws.game.activity

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.fragment.DaiLiCaoZuoGoldRecordFragment
import com.ydws.game.fragment.DaiLiCaoZuoPropRecoveryFragment
import com.ydws.game.fragment.GoldRecordFragment
import com.ydws.game.fragment.PropRecoveryFragment
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_record_merchant.*

/**
 * 代理操作
 */
class DaiLiCaoZuoActivity : BaseAbstractActivity(), View.OnClickListener {
    private var radioGroup: RadioGroup? = null
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_record_merchant
    }

    override fun initViews() {
        radioGroup = findViewById(R.id.radio)
        findViewById<View>(R.id.rb_gold_zanzhu).setOnClickListener(this)
        findViewById<View>(R.id.rb_record).setOnClickListener(this)
        ID.text = "ID:${userid}"
        val tv = findViewById<TextView>(R.id.tv_title_bar)
        tv.text = "服务代理"
        findViewById<View>(R.id.back).setOnClickListener { finish() }
    }

    override fun initData() {

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoGoldRecordFragment())
        transaction.commit()
    }

    override fun onClick(view: View) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when (view.id) {
            R.id.rb_gold_zanzhu -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_record_one)
                transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoGoldRecordFragment())
            }
            R.id.rb_record -> {
                radioGroup!!.setBackgroundResource(R.mipmap.title_record_two)
                transaction.replace(R.id.frame_mer_chant, DaiLiCaoZuoPropRecoveryFragment())
            }
        }
        transaction.commit()
    }
}