package com.ydws.game.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.chad.library.adapter.base.BaseQuickAdapter
import com.ydws.game.R
import com.ydws.game.adapter.VoteAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.VoteBean
import com.ydws.game.bean.youxitoutiaoBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import org.jetbrains.anko.toast

import java.util.ArrayList

/**
 * 投票
 */
class VoteActivity : BaseAbstractActivity(), BaseQuickAdapter.OnItemClickListener {
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        VoteDetailActivity.start(this@VoteActivity, list[position].id.toString())
    }

    private var voteRv: RecyclerView? = null
    private var voteAdapter: VoteAdapter? = null
    private var list: List<youxitoutiaoBean.DataBean> = ArrayList<youxitoutiaoBean.DataBean>()
    override fun getContentLayoutID(): Int {
        return R.layout.activity_vote
    }

    override fun initViews() {
        voteRv = findViewById(R.id.rv_vote)

        findViewById<View>(R.id.title).findViewById<View>(R.id.back).setOnClickListener { finish() }
        val viewById = findViewById<View>(R.id.title).findViewById<TextView>(R.id.tv_title_bar)
        viewById.text = "投票"
    }

    override fun initData() {
        voteAdapter = VoteAdapter(R.layout.item_vote)

        voteRv!!.adapter = voteAdapter
        voteRv!!.layoutManager = LinearLayoutManager(this)

        voteAdapter!!.onItemClickListener = this
        RetrofitManager.service
                .selectVote()
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<List<youxitoutiaoBean.DataBean>>() {
                    override fun onSuccees(t: BaseResponse<List<youxitoutiaoBean.DataBean>>, data: List<youxitoutiaoBean.DataBean>) {
                        toast(t.message)
                        list = data
                        voteAdapter!!.setNewData(data)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }

}
