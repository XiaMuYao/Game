package com.ydws.game.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.databinding.ActivityPropBinding

/**
 * 道具回收
 */
class PropActivity : BaseAbstractActivity(), View.OnClickListener {
    private lateinit var activityPropBinding: ActivityPropBinding;
    override fun getContentLayoutID(): Int {
        return R.layout.activity_prop
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPropBinding = DataBindingUtil.setContentView(this,R.layout.activity_prop)

    }
    override fun initViews() {
        findViewById<View>(R.id.submit).setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.submit -> {
            }
        }
    }
}
