package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.SelectWantSponsorBean
import com.ydws.game.databinding.ActivityAgentBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 代理申请
 */
class AgentActivity : BaseAbstractActivity(), View.OnClickListener {

    private lateinit var activityAgentBinding: ActivityAgentBinding
    private val viewModel: SelectWantSponsorBean.DataBean by lazy { intent.getParcelableExtra(argBecomeStatus) as SelectWantSponsorBean.DataBean }
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_agent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityAgentBinding = DataBindingUtil.setContentView(this, R.layout.activity_agent)
        activityAgentBinding.viewModel = viewModel
        activityAgentBinding.idStr = "ID.$userid"
        activityAgentBinding.title.findViewById<TextView>(R.id.tv_title_bar).text = getString(com.ydws.game.R.string.fuwudailishenqing)
        activityAgentBinding.ivSubmit.setOnClickListener {
            if (viewModel.becomeStatus == 3) {
                showMessage("正在通過一級審核，請等待")
            } else if (viewModel.becomeStatus in arrayOf(0, 2)) {
                if(viewModel.city.isNullOrBlank() ||
                        viewModel.payee.isNullOrBlank() ||
                        viewModel.phone.isNullOrBlank() ||
                        viewModel.bankName.isNullOrBlank() ||
                        viewModel.cardNumber.isNullOrBlank() ||
                        viewModel.zhifubao.isNullOrBlank() ||
                        viewModel.wechat.isNullOrBlank()){
                    showMessage("請完善資料")
                    return@setOnClickListener
                }
                gameAddWantSponsor()
            }
        }
    }

    //    city	是	string	国家/详细地址
//    shoukuanName	是	string	收款人姓名
//    bankName	是	string	开户行
//    cardNumber	是	string	借记卡号
//    zhifubaoNumber	是	string	支付宝号
//    wechat	是	string	微信号
//    userId	是	int	用户id
//    phone	是	string	手机号
//    language	是	int	语言language
//    sessionId
    private fun gameAddWantSponsor() {

        val params = mapOf("city" to (viewModel.city?:""),
                "shoukuanName" to (viewModel.payee?:""),
                "bankName" to (viewModel.bankName?:""),
                "cardNumber" to (viewModel.cardNumber?:""),
                "zhifubaoNumber" to (viewModel.zhifubao?:""),
                "wechat" to (viewModel.wechat?:""),
                "userId" to (userid?:"")
                )

        SecondRetrofitManager.service.gameAddWantSponsor(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any?>() {
                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
//                        handleBecomeStatus(data)
                        showMessage("代理已申請")
                    }

                    override fun onCodeError(code: Int, msg: String) {
//                        activityPropBinding.buyValueVisibility = View.GONE

                    }

                })
    }

    override fun initViews() {
        findViewById<View>(R.id.iv_submit).setOnClickListener(this)
    }

    override fun initData() {

    }

    override fun onClick(view: View) {
//        when (view.id) {
//            R.id.iv_submit -> startActivity(Intent(this, AgentSureActivity::class.java))
//        }
    }

    companion object {
        private const val argBecomeStatus = "argBecomeStatus"
        fun start(context: Context, becomeStatus: SelectWantSponsorBean.DataBean) {
            context.startActivity(Intent(context, AgentActivity::class.java).putExtra(argBecomeStatus, becomeStatus))
        }
    }
}
