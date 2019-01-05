package com.ydws.game.fragment

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ydws.game.App
import com.ydws.game.R
import com.ydws.game.base.BaseFragment
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
    }

    override fun initData() {

    }
}
