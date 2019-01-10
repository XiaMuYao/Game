package com.ydws.game.activity

import android.content.Intent
import android.view.View
import android.widget.TextView
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.DetailsOfPropRepurchaseBean
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_gold_search.*
import org.jetbrains.anko.sdk27.coroutines.onClick

/**
 *
 */
class GoldSearchActivity : BaseAbstractActivity() {
    private var userid: String by SPreference("userid", "")
    override fun getContentLayoutID(): Int {
        return R.layout.activity_gold_search
    }
    private var pageData: DetailsOfPropRepurchaseBean? = null

    override fun initViews() {
        findViewById<View>(R.id.back).onClick { finish() }
        findViewById<TextView>(R.id.tv_title_bar).text = "服务代理"
        iv_submit.onClick { finish() }
        report.onClick {
            SecondRetrofitManager.service
                    .report(userid,intent.getIntExtra("id",1).toString())
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(object : BaseObserver<Any?>(){
                        override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                            "举报成功".toast()
                            finish()
                        }

                        override fun onCodeError(code: Int, msg: String) {
                        }

                    })
        }
        SecondRetrofitManager.service
                .detailsOfPropRepurchase(userid,intent.getIntExtra("id",1).toString())
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<DetailsOfPropRepurchaseBean>(){
                    override fun onSuccees(t: BaseResponse<DetailsOfPropRepurchaseBean>, data: DetailsOfPropRepurchaseBean) {
                        pageData = data
                        ID.text = "ID:${userid}"
                        phone.text = data.phone
                        zanzhufangshi.text = data.payTypeName
                        goumaishijian.text = data.createTime
                        zhuangtai.text = if(data.tradingStatus==1)"进行中" else "已完成"
                        zanzhushuliang.text = data.propsNumber.toString()

                    }

                    override fun onCodeError(code: Int, msg: String) {

                    }

                })
        chakanpingzheng.onClick {
            pageData?.let {
                val intent = Intent(this@GoldSearchActivity,ShowImageDetailActivity::class.java)
                intent.putExtra("url", it.zhuanzhangPhoto)
                startActivity(intent)
            }

        }
    }

    override fun initData() {

    }
}
