package com.ydws.game.activity

import android.content.Intent
import android.view.Gravity
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.SelectWantSponsorBean
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SPreference
import com.ydws.game.utils.TestPopupWindow
import com.ydws.game.utils.TestPopuptwoWindow
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sponsor.*
import kotlinx.android.synthetic.main.view_title_bar.view.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 * 赞助首页
 */
class SponsorActivity : BaseAbstractActivity(), View.OnClickListener {
    private var titleTv: TextView? = null
    private var userid: String by SPreference("userid", "")
    private var selecy: Int by SPreference("selecy", 1)

    override fun getContentLayoutID(): Int {
        return R.layout.activity_sponsor
    }

    override fun initViews() {
        titleTv = findViewById(R.id.tv_title_bar)
        titllle.back.onClick { finish() }

        findViewById<View>(R.id.iv_gold_zanzhu).setOnClickListener(this)
        findViewById<View>(R.id.iv_daoju_huishou).setOnClickListener(this)
        findViewById<View>(R.id.iv_dali_shenqing).setOnClickListener(this)
        findViewById<View>(R.id.record).setOnClickListener(this)
        findViewById<View>(R.id.ddddddddddddddddddd).setOnClickListener(this)
        ID.text = "ID."+userid
        selecy = 1
    }

    override fun onResume() {
        selecy = 1
        super.onResume()
    }

    override fun initData() {
        titleTv!!.text = "綜合服務"
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_gold_zanzhu -> startActivity(Intent(this, PipeiBishangActivity::class.java))
            R.id.iv_daoju_huishou -> startActivity(Intent(this, PropActivity::class.java))
            R.id.iv_dali_shenqing -> gameSelectWantSponsor()
            R.id.record -> startActivity(Intent(this, MerchantRecordActivity::class.java))
            R.id.ddddddddddddddddddd -> {
                var mWindow = TestPopuptwoWindow(this);
                mWindow.showAtLocation(ddddddddddddddddddd, Gravity.CENTER,0,0)
            }
        }
    }

    //startActivity(Intent(this, AgentActivity::class.java))
    private fun gameSelectWantSponsor() {
        SecondRetrofitManager.service.gameSelectWantSponsor(userid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<SelectWantSponsorBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<SelectWantSponsorBean.DataBean>, data: SelectWantSponsorBean.DataBean) {
                        handleBecomeStatus(data)
                    }

                    override fun onCodeError(code: Int, msg: String) {
//                        activityPropBinding.buyValueVisibility = View.GONE

                    }

                })
    }

    private fun handleBecomeStatus(data: SelectWantSponsorBean.DataBean) {
        when {
            data.becomeStatus in arrayOf(0, 2, 3) -> {
//                startActivity(Intent(this, AgentActivity::class.java))
                AgentActivity.start(this, data)
            }
            data.becomeStatus == 1 -> showMessage("您已是服務代理")
            data.becomeStatus == 4 -> AgentSureActivity.start(this, data)
        }
    }

    companion object {


        fun start() {

        }
    }
}
