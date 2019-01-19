package com.ydws.game.activity

import android.content.Intent
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.tuiguangBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_generalize_two.*
import org.jetbrains.anko.toast


class GeneralizeTwoActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_generalize_two
    }

    override fun initViews() {
        ID.text = "ID."+userid
        titleTv = findViewById(R.id.tv_title_bar)
        findViewById<TextView>(R.id.ID).text ="ID.$userid"

        findViewById<View>(R.id.iv_next).setOnClickListener(this)
        findViewById<View>(R.id.back).setOnClickListener { finish() }
        lingqujiangli.setOnClickListener {

            RetrofitManager.service
                    .receiveGoldCoin(userid)
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any>() {
                        override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                            "领取成功".toast()
                        }


                        override fun onCodeError(code: Int, msg: String) {
                            toast(msg)
                        }
                    })


        }
    }

    override fun initData() {
        titleTv!!.text  = "我的推廣"

        RetrofitManager.service
                .findAgentGeneralInformation(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<tuiguangBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<tuiguangBean.DataBean>, data: tuiguangBean.DataBean) {
                        tv_zhitui_count.text = "直推玩家數：${data.zongZhituiPlayerNumber}"
                        tv_qudao_count.text = "渠道玩家數：${data.zongQudaoPlayerNumber}"
                        tv_zhitui_yeji.text = "直推玩家業績：${data.zongZhituiPlayerYeji}"
                        tv_qudao_yeji.text = "渠道玩家業績：${data.zongQudaoPlayerYeji}"
                        tv_gold_yeji.text = "本週金幣獎勵：${data.weekGold}"
                        tv_gold_leiji.text = "累計領取獎勵：${data.leijiGold}"
                        tv_gold_unable.text = "未領取金幣獎勵：${data.weiLingGold}"
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_next -> startActivity(Intent(this, GenerlizeThreeActivity::class.java))
        }
    }
}
