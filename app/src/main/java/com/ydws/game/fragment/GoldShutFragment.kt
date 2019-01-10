package com.ydws.game.fragment

import android.os.Build.VERSION_CODES.M
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.view.View
import com.ydws.game.App
import com.ydws.game.R
import com.ydws.game.base.BaseFragment
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.fragment_gold_shutt.*
import kotlinx.android.synthetic.main.fragment_gold_shutt.view.*
import org.jetbrains.anko.support.v4.toast

/**
 * 金币注销
 */
class GoldShutFragment : BaseFragment() {
    private var userid: String by SPreference("userid", "")
    var bili = 0
    override fun initLayoutId(): Int {
        return R.layout.fragment_gold_shutt
    }

    override fun initView(mRootView: View) {
        mRootView.rddight.setOnClickListener {

            var a = Integer.parseInt(count.text.toString().trim())


            RetrofitManager.service
                    .updatePingtaibuy(address.text.toString().trim(),
                            a, userid)
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any?>() {
                        override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                            toast(t.message)
                        }


                        override fun onCodeError(code: Int, msg: String) {
                            toast(msg)
                        }
                    })

        }


        mRootView.count.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0.toString().isNotEmpty()) {
                    trade_number.text = SpannableStringBuilder((
                            (p0.toString().toBigDecimal().divide(bili.toBigDecimal())).toString()))
                } else {
                    trade_number.text.clear()
                }
            }

        })

    }

    override fun initData() {
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
