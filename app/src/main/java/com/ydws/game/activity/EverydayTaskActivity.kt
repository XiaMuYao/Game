package com.ydws.game.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.GameSelectEverydayTaskBean
import com.ydws.game.databinding.ActivityEverydayTaskBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EverydayTaskActivity : BaseAbstractActivity() {
    private lateinit var activityEverydayTaskBinding: ActivityEverydayTaskBinding
    private var userid: String by SPreference("userid", "")


    override fun getContentLayoutID(): Int {
        return R.layout.activity_everyday_task
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityEverydayTaskBinding = DataBindingUtil.setContentView(this,R.layout.activity_everyday_task)
        activityEverydayTaskBinding.tipsVisibility = View.GONE
        activityEverydayTaskBinding.addTask.setOnClickListener {
            receiveGold()
        }

        activityEverydayTaskBinding.idStr  = "ID.$userid"

        activityEverydayTaskBinding.title.findViewById<TextView>(R.id.tv_title_bar).text = "每日任務"
        activityEverydayTaskBinding.title.findViewById<View>(R.id.back).setOnClickListener { finish() }
        fetchData()
    }
    private fun fetchData(){
        SecondRetrofitManager.service.gameSelectEverydayTask(userid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<GameSelectEverydayTaskBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<GameSelectEverydayTaskBean.DataBean>, data: GameSelectEverydayTaskBean.DataBean) {
                        activityEverydayTaskBinding.completeGame = data.completeGame.toString()
                        activityEverydayTaskBinding.unfinishedGame = data.unfinishedGame.toString()
                        activityEverydayTaskBinding.weekGames =data.weekGames.toString()
                        activityEverydayTaskBinding.weilingquJiangli = data.weilingquJiangli.toString()
                        activityEverydayTaskBinding.tipsVisibility = if(data.unfinishedGame == 0) View.VISIBLE else View.GONE
                        }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }

    override fun initViews() {

    }

    override fun initData() {

    }

    private fun receiveGold(){
        SecondRetrofitManager.service.gameReceivegold(userid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any>() {
                    override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                        "獎勵已領取".toast()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }
}
