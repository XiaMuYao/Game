package com.ydws.game.fragment

import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.view.View
import com.ydws.game.R
import com.ydws.game.base.BaseFragment
import com.ydws.game.bean.usdtBean
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.fragment_gold_support.*
import kotlinx.android.synthetic.main.fragment_gold_support.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * 金币赞助
 */
class GoldSupportFragment : BaseFragment() {
    private var userid: String by SPreference("userid", "")

    private var USDTid: String by SPreference("USDTid", "")
    private var USDTaddress: String by SPreference("USDTaddress", "")
    var bili = 0
    override fun initLayoutId(): Int {
        return R.layout.fragment_gold_support
    }

    override fun initView(mRootView: View) {


        mRootView.rigddasdqwht.setOnClickListener {

            if (ddddddd.text.isNullOrBlank() || trade_number.text.isNullOrBlank()) {
                toast("有字段为空")

            } else {
                var a = Integer.parseInt(ddddddd.text.toString().trim())

                RetrofitManager.service
                        .insertPingtaibuy(a, trade_number.text.toString().trim(),
                                userid)
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any?>() {
                            override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                toast(t.message)
                            }


                            override fun onCodeError(code: Int, msg: String) {
                            }
                        })

            }

        }

        mRootView.ddddddd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().isNotEmpty()) {
                    yueheshuliang.text = SpannableStringBuilder((
                            (p0.toString().toBigDecimal().divide(bili.toBigDecimal())).toString()))
                } else {
                    yueheshuliang.text.clear()
                }
            }

        })
    }


    override fun initData() {


        RetrofitManager.service
                .selectPlatformAddress()
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<usdtBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<usdtBean.DataBean>, data: usdtBean.DataBean) {
                        USDTid = data.id.toString()
                        USDTaddress = data.address
                        addressdddd.text = SpannableStringBuilder(data.address)
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })

        RetrofitManager.service
                .getBili()
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<Int>() {
                    override fun onSuccees(t: BaseResponse<Int>, data: Int) {
                        bili = data
                        LL.d("bili=$bili")
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })

    }
}
