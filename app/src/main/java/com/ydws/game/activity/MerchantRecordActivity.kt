package com.ydws.game.activity

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.fragment.GoldRecordFragment
import com.ydws.game.fragment.PropRecoveryFragment
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_record_merchant.*

/**
 * 记录查询
 */
class MerchantRecordActivity : BaseAbstractActivity(), View.OnClickListener {
    private var radioGroup: RadioGroup? = null
    private var userid: String by SPreference("userid", "")
    private var selecy: Int by SPreference("selecy", 1)

    override fun getContentLayoutID(): Int {
        return R.layout.activity_record_merchant
    }

    override fun initViews() {
        textView10.visibility  =View.GONE
        textView7.visibility  =View.GONE
        textView8.visibility  =View.GONE
        radioGroup = findViewById(R.id.radio)
        findViewById<View>(R.id.rb_gold_zanzhu).setOnClickListener(this)
        findViewById<View>(R.id.rb_record).setOnClickListener(this)
        ID.text = "ID:${userid}"
        val tv = findViewById<TextView>(R.id.tv_title_bar)
        tv.text = "記錄查詢"
        findViewById<View>(R.id.back).setOnClickListener { finish() }
    }


    override fun initData() {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_mer_chant, GoldRecordFragment())
        transaction.commit()

        if (selecy == 1) {
            radioGroup!!.setBackgroundResource(R.mipmap.zanzhuxinxitou)
            transaction.replace(R.id.frame_mer_chant, GoldRecordFragment())
        } else if (selecy == 2) {
            transaction.replace(R.id.frame_mer_chant, PropRecoveryFragment())
        }
    }

    override fun onClick(view: View) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        when (view.id) {
            R.id.rb_gold_zanzhu -> {
                radioGroup!!.setBackgroundResource(R.mipmap.zanzhuxinxitou)
                transaction.replace(R.id.frame_mer_chant, GoldRecordFragment())
                selecy = 1
            }
            R.id.rb_record -> {
                radioGroup!!.setBackgroundResource(R.mipmap.zanzhuxinxitoutwo)
                transaction.replace(R.id.frame_mer_chant, PropRecoveryFragment())
                selecy = 2
            }
        }
        transaction.commit()
    }
}
