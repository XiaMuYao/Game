package com.ydws.game.activity

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.GameSelectPlatformAddressBean
import com.ydws.game.bean.SelectWantSponsorBean
import com.ydws.game.databinding.ActivityAgentSureBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 代理确认
 */
class AgentSureActivity : BaseAbstractActivity(), View.OnClickListener {

    private lateinit var activityAgentSureBinding: ActivityAgentSureBinding

    private val viewModel: SelectWantSponsorBean.DataBean by lazy { intent.getParcelableExtra(argBecomeStatus) as SelectWantSponsorBean.DataBean }

    private var userid: String by SPreference("userid", "")


    override fun getContentLayoutID(): Int {
//        mapOf<Int, String>(R.mipmap.icon_one to "1")

        return R.layout.activity_agent_sure
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAgentSureBinding = DataBindingUtil.setContentView(this, R.layout.activity_agent_sure)
        activityAgentSureBinding.editable = viewModel.tradingNumber == null
        activityAgentSureBinding.tradeNumber = viewModel.tradingNumber


        activityAgentSureBinding.title.findViewById<TextView>(R.id.tv_title_bar).text = "服務代理"
        activityAgentSureBinding.title.findViewById<View>(R.id.back).setOnClickListener { finish() }

        activityAgentSureBinding.copy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText(null, activityAgentSureBinding.usdtAddress)
            clipboard.primaryClip = clipData
            showMessage("地址已複製")
        }

        activityAgentSureBinding.right.setOnClickListener {
            if (viewModel.tradingNumber != null) {
                showMessage("正在審核，請稍等")
            } else {
                submitForm()
            }
        }

        fetchAddress()
    }

    private fun submitForm() {
        SecondRetrofitManager.service.gameUpAgentTransactionNumber(
                activityAgentSureBinding.tradeNumber ?: "",
                userid

        ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any?>() {
                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                        showMessage("申請已提交")
                        activityAgentSureBinding.editable = false
                        viewModel.tradingNumber = activityAgentSureBinding.tradeNumber
//                        handleBecomeStatus(data)
                    }

                    override fun onCodeError(code: Int, msg: String) {
//                        activityPropBinding.buyValueVisibility = View.GONE

                    }

                })
    }

    private fun fetchAddress() {
        showMessage("獲取USDT地址中")
        SecondRetrofitManager.service.gameSelectPlatformAddress().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<GameSelectPlatformAddressBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<GameSelectPlatformAddressBean.DataBean>, data: GameSelectPlatformAddressBean.DataBean) {
                        activityAgentSureBinding.usdtAddress = data.address
                    }

                    override fun onCodeError(code: Int, msg: String) {
//                        activityPropBinding.buyValueVisibility = View.GONE

                    }

                })


    }

    override fun initViews() {
        findViewById<View>(R.id.right).setOnClickListener(this)
    }

    override fun initData() {}

    override fun onClick(view: View) {
//        when (view.id) {
//            R.id.right -> startActivity(Intent(this, MerChantActivity::class.java))
//        }
    }

    companion object {
        private const val argBecomeStatus = "argBecomeStatus"
        fun start(context: Context, becomeStatus: SelectWantSponsorBean.DataBean) {
            context.startActivity(Intent(context, AgentSureActivity::class.java).putExtra(argBecomeStatus, becomeStatus))
        }
    }
}
