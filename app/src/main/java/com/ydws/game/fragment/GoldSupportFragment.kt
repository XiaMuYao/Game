package com.ydws.game.fragment

import android.text.SpannableStringBuilder
import android.view.View
import com.ydws.game.R
import com.ydws.game.base.BaseFragment
import com.ydws.game.bean.usdtBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.fragment_gold_shutt.*
import kotlinx.android.synthetic.main.fragment_gold_support.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * 金币赞助
 */
class GoldSupportFragment : BaseFragment() {
    private var userid: String by SPreference("userid", "")

    private var USDTid: String by SPreference("USDTid", "")
    private var USDTaddress: String by SPreference("USDTaddress", "")

    override fun initLayoutId(): Int {
        return R.layout.fragment_gold_support
    }

    override fun initView(mRootView: View) {


        mRootView.rigddasdqwht.setOnClickListener {

            var a = Integer.parseInt(count.text.toString().trim())

            RetrofitManager.service
                    .insertPingtaibuy(a, trade_number.text.toString().trim(),
                            userid)
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any?>() {
                        override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {


                        }


                        override fun onCodeError(code: Int, msg: String) {
                            toast(msg)
                        }
                    })
        }


    }


    override fun initData() {


        RetrofitManager.service
                .selectPlatformAddress()
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<usdtBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<usdtBean.DataBean>, data: usdtBean.DataBean) {
                        USDTid = data.id.toString()
                        USDTaddress = data.address
                        address.text = SpannableStringBuilder(data.address)
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }
}
