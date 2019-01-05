package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.view.View

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity

/**
 * 高代2
 */
class SeniorAgentTwoActivity : BaseAbstractActivity(), View.OnClickListener {
    override fun getContentLayoutID(): Int {
        return R.layout.activity_senior_agent_two
    }

    override fun initViews() {
        findViewById<View>(R.id.immediately_extension).setOnClickListener(this)
        findViewById<View>(R.id.add_task).setOnClickListener(this)
    }

    companion object {
        fun start(context: Context){
            val starter = Intent(context,SeniorAgentTwoActivity::class.java)
            context.startActivity(starter)
        }
    }
    override fun initData() {

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.add_task -> startActivity(Intent(this, GenerlizeThreeActivity::class.java))
            R.id.immediately_extension -> startActivity(Intent(this, GenerlizeThreeActivity::class.java))
        }
    }
}
