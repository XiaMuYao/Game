package com.ydws.game.fragment

import android.support.v7.widget.LinearLayoutManager
import android.text.SpannableStringBuilder
import android.view.View

import com.ydws.game.R
import com.ydws.game.adapter.GameRecordAdapter
import com.ydws.game.adapter.JiaoYiRecordAdapter
import com.ydws.game.base.BaseFragment
import com.ydws.game.bean.GameListBean
import com.ydws.game.bean.jiaoyijiluBean
import com.ydws.game.bean.usdtBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.banner.*
import kotlinx.android.synthetic.main.fragment_gold_shutt.*
import kotlinx.android.synthetic.main.fragment_record.*
import kotlinx.android.synthetic.main.fragment_record.view.*
import org.jetbrains.anko.support.v4.toast
import java.util.ArrayList

/**
 * 记录查询
 */
class RecordFragment : BaseFragment() {
    private var jiaoypter: JiaoYiRecordAdapter? = null
    private var userid: String by SPreference("userid", "")


    override fun initLayoutId(): Int {
        return R.layout.fragment_record
    }

    override fun initView(mRootView: View) {

        jiaoypter = JiaoYiRecordAdapter(R.layout.item_jiaoyi_record)


        mRootView.jilu.adapter = jiaoypter
        mRootView.jilu.layoutManager = LinearLayoutManager(context)


    }

    override fun initData() {




        RetrofitManager.service
                .selectGoldTradingRecord(userid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<List<jiaoyijiluBean.DataBean>>() {
                    override fun onSuccees(t: BaseResponse<List<jiaoyijiluBean.DataBean>>, data: List<jiaoyijiluBean.DataBean>) {
                        jiaoypter?.setNewData(data)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })





    }
}
