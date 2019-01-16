package com.ydws.game.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View

import com.chad.library.adapter.base.BaseQuickAdapter
import com.ydws.game.App
import com.ydws.game.BR
import com.ydws.game.R
import com.ydws.game.activity.GoldSearchActivity
import com.ydws.game.adapter.GoldRecordAdapter
import com.ydws.game.base.BaseFragment
import com.ydws.game.base.QuickAdapter
import com.ydws.game.bean.GameSelectGoldRecordBean
import com.ydws.game.bean.RecordByDaoOrGoldBean
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import android.widget.Toast
import com.ydws.game.activity.jinbizanzhuinfoActivity
import java.sql.Array
import java.util.*


/**
 * 金币赞助
 */
class GoldRecordFragment : BaseFragment() {
    var dataaa: List<RecordByDaoOrGoldBean> = ArrayList()
    override fun initView(mRootView: View?) {
        goldRv = mRootView?.findViewById(R.id.rv_record)
    }

    private var goldRv: RecyclerView? = null
    private var recordAdapter: GoldRecordAdapter? = null
    private var userid: String by SPreference("userid", "")

    private var number = 0
    override fun initLayoutId(): Int {
        return R.layout.fragment_gold_record
    }


    override fun initData() {
        recordAdapter = GoldRecordAdapter(R.layout.item_jinbizanzhu)
//        val datas = ArrayList<RecordByDaoOrGoldBean>()
//        datas.add(RecordByDaoOrGoldBean())
//        datas.add(RecordByDaoOrGoldBean())
//        datas.add(RecordByDaoOrGoldBean())
//        recordAdapter!!.setNewData(datas)
        goldRv!!.adapter = recordAdapter
        goldRv!!.layoutManager = LinearLayoutManager(context)

//        recordAdapter!!.onItemChildClickListener = this
        fetchData()

        recordAdapter?.setOnItemClickListener { adapter, view, position ->
            jinbizanzhuinfoActivity.start(context!!, dataaa[position].id.toString())
        }
        recordAdapter?.setOnItemChildClickListener { adapter, view, position ->
            jinbizanzhuinfoActivity.start(context!!, dataaa[position].id.toString())
        }
    }

    private fun fetchData() {
        SecondRetrofitManager.service.propRecordByDaoOrGold(userid, 2).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<List<GameSelectGoldRecordBean.DataBean>>() {
                    override fun onSuccees(t: BaseResponse<List<GameSelectGoldRecordBean.DataBean>>, data: List<GameSelectGoldRecordBean.DataBean>) {
                        val result = data.map {
                            RecordByDaoOrGoldBean(
                                    type = 1,
                                    context = context!!,
                                    id = it.id,
                                    idStr = it.id.toString(),
                                    userId = it.userId,
                                    lastChangeTime = it.lastChangeTime,
                                    tradingStatus = it.tradingStatus,
                                    propsNumber = it.propsNumber,
                                    buyOrSell = it.buyOrSell,
                                    goldNumber = it.goldNumber
                            )
                        }
                        dataaa = result

                        recordAdapter?.setNewData(result)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }


}
