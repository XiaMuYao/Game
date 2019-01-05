package com.ydws.game.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.ydws.game.R
import com.ydws.game.adapter.GameRecordAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.GameListBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_game_record.*
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.toast

import java.util.ArrayList

/**
 * 游戏记录
 */
class GameRecordActivity : BaseAbstractActivity() {
    private var gameRecordAdapter: GameRecordAdapter? = null
    private var gameRecordRv: RecyclerView? = null
    private var userid: String by SPreference("userid", "")
    var page: Int = 1;
    override fun getContentLayoutID(): Int {
        return R.layout.activity_game_record
    }

    override fun initViews() {
        gameRecordRv = findViewById(R.id.rv_game_record)

        xiayiye.setOnClickListener {

            page++
            getdataPage(page)
        }
    }

    override fun initData() {

        gameRecordAdapter = GameRecordAdapter(R.layout.item_game_record)
        val datas = ArrayList<GameListBean.DataBean>()

        gameRecordAdapter!!.setNewData(datas)
        gameRecordRv!!.adapter = gameRecordAdapter
        gameRecordRv!!.layoutManager = LinearLayoutManager(this)

        getdataPage(page)


    }

    private fun getdataPage(page: Int) {
        RetrofitManager.service
                .selectGoldCoinRecord(userid,
                        page.toString())
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<List<GameListBean.DataBean>>() {
                    override fun onSuccees(t: BaseResponse<List<GameListBean.DataBean>>, data: List<GameListBean.DataBean>) {
                        gameRecordAdapter!!.setNewData(data)
                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }
}
