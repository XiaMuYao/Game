package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.text.SpannableStringBuilder
import android.view.View

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.gaojidailituiguangBean
import com.ydws.game.bean.jiaquanBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_senior_agent_two.*
import org.jetbrains.anko.toast

/**
 * 高代2
 */
class SeniorAgentTwoActivity : BaseAbstractActivity(), View.OnClickListener {
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_senior_agent_two
    }

    override fun initViews() {
        findViewById<View>(R.id.immediately_extension).setOnClickListener(this)
        findViewById<View>(R.id.add_task).setOnClickListener(this)
    }

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, SeniorAgentTwoActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun initData() {
        RetrofitManager.service
                .findHighGenerationDetails(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<gaojidailituiguangBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<gaojidailituiguangBean.DataBean>, data: gaojidailituiguangBean.DataBean) {
                        jiaquandengji.text = SpannableStringBuilder(data.level.toString())
                        yisunshijiaquan.text = SpannableStringBuilder(data.loseJinbi.toString())
                        jiaquanshangxian.text = SpannableStringBuilder(data.jiaquanMax.toString())
                        benzhoujiaquan.text = SpannableStringBuilder(data.leijiJiangli.toString())
                        leijilingqu.text = SpannableStringBuilder(data.weekLeijiJiangli.toString())
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.add_task -> startActivity(Intent(this, SeniorAgentThreeActivity::class.java))
            R.id.immediately_extension -> startActivity(Intent(this, GenerlizeThreeActivity::class.java))
        }
    }
}
