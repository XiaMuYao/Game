package com.ydws.game.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import com.ydws.game.R
import com.ydws.game.adapter.VoteAdapter
import com.ydws.game.adapter.gameinfoAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.gameInfoBean
import com.ydws.game.bean.youxitoutiaoBean
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.SPreference
import kotlinx.android.synthetic.main.activity_vote_detail.*
import org.jetbrains.anko.toast

class VoteDetailActivity : BaseAbstractActivity() {
    var toupiaoid: String = ""
    private var userid: String by SPreference("userid", "")

    override fun getContentLayoutID(): Int {
        return R.layout.activity_vote_detail
    }

    override fun initViews() {
        toupiaoid = intent.getStringExtra("toupiaoid")
        findViewById<View>(R.id.include).findViewById<View>(R.id.back).setOnClickListener { finish() }
        val viewById = findViewById<View>(R.id.include).findViewById<TextView>(R.id.tv_title_bar)
        viewById.text = "游戏详情"
    }

    companion object {
        fun start(context: Context, toupiaoid: String) {
            val starter = Intent(context, VoteDetailActivity::class.java)
            starter.putExtra("toupiaoid", toupiaoid)
            context.startActivity(starter)
        }
    }

    override fun initData() {
        getData()

        ID.text = "ID."+userid
        toupiao.setOnClickListener {


            RetrofitManager.service
                    .selectVoteByIdNumber(toupiaoid, userid)
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any?>() {
                        override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                            toast(t.message)
                            getData()

                        }

                        override fun onCodeError(code: Int, msg: String) {
                            toast(msg)
                        }
                    })


        }
    }

    private fun getData() {
        RetrofitManager.service
                .selectVoteById(toupiaoid)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<gameInfoBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<gameInfoBean.DataBean>, data: gameInfoBean.DataBean) {
                        toast(t.message)
                        var list: List<String> = arrayListOf(data.gameIntroduce, data.gameFeatures, data.gameRules)

                        val layoutManager = LinearLayoutManager(this@VoteDetailActivity)
                        val voteAdapter = gameinfoAdapter(R.layout.item_game)
                        xianshiwenzi.adapter = voteAdapter
                        xianshiwenzi.layoutManager = layoutManager
                        voteAdapter.setNewData(list)

                        textView3.text = data.gameName
                        jiezhishijian.text = "有效投票截止时间:${data.endTime}"
                        leijipiaoshu.text = "累计票数:${data.numNumberVote}"

                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }
                })
    }
}
