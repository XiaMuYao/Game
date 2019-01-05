package com.ydws.game.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import com.chad.library.adapter.base.BaseQuickAdapter
import com.ydws.game.BR
import com.ydws.game.R
import com.ydws.game.activity.RepoSearchActivity
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

import java.util.ArrayList

/**
 * 道具回收
 */
class PropRecoveryFragment : BaseFragment(), BaseQuickAdapter.OnItemChildClickListener {
    private var goldRv: RecyclerView? = null
    private var recordAdapter: GoldRecordAdapter? = null
    private var userid: String by SPreference("userid", "")

    private var adapter = QuickAdapter<RecordByDaoOrGoldBean>(BR.viewModel,R.layout.item_gold_record)



    override fun initLayoutId(): Int {
        return R.layout.fragment_gold_record
    }

    override fun initView(mRootView: View?) {
        goldRv = mRootView?.findViewById(R.id.rv_record)
    }

    override fun initData() {
        recordAdapter = GoldRecordAdapter(R.layout.item_gold_record)
        val datas = ArrayList<RecordByDaoOrGoldBean>()
        //        datas.add(new RecordByDaoOrGoldBean());
        //        datas.add(new RecordByDaoOrGoldBean());
        //        datas.add(new RecordByDaoOrGoldBean());
        recordAdapter!!.setNewData(datas)
//        goldRv!!.adapter = recordAdapter
        goldRv!!.adapter = adapter
        goldRv!!.layoutManager = LinearLayoutManager(context)


        recordAdapter!!.onItemChildClickListener = this
        fetchData()
    }
    private fun fetchData(){
        SecondRetrofitManager.service.propRecordByDaoOrGold(userid,2).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<List<GameSelectGoldRecordBean.DataBean>>() {
                    override fun onSuccees(t: BaseResponse<List<GameSelectGoldRecordBean.DataBean>>, data: List<GameSelectGoldRecordBean.DataBean>) {
                        val result =  data.map {
                            RecordByDaoOrGoldBean(
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



                        adapter.addAll(result)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }
    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        when (view.id) {
            R.id.iv_right_gold -> startActivity(Intent(mActivity, RepoSearchActivity::class.java))
        }
    }
}
