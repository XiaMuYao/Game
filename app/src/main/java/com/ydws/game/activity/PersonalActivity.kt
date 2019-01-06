package com.ydws.game.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

import com.ydws.game.R
import com.ydws.game.adapter.PersonalAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.PersonalBean
import com.ydws.game.bean.SelectEntityById
import com.ydws.game.databinding.ActivityPersonalBinding
import com.ydws.game.databinding.LayoutYanZhengMiBaoBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import java.util.ArrayList

/**
 * 个人页
 */
class PersonalActivity : BaseAbstractActivity(), View.OnClickListener {

    private var personalRv: RecyclerView? = null
    private var personalAdapter: PersonalAdapter? = null
    private var datas: MutableList<PersonalBean>? = null

    private lateinit var activityPersonalBinding: ActivityPersonalBinding

    private var personalInfo: SelectEntityById.DataBean? = null

    private var userid: String by SPreference("userid", "")


    override fun getContentLayoutID(): Int {
        return R.layout.activity_personal
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPersonalBinding = DataBindingUtil.setContentView(this, R.layout.activity_personal)
        activityPersonalBinding.title.findViewById<TextView>(R.id.tv_title_bar).text = "我的信息"
        activityPersonalBinding.title.findViewById<View>(R.id.back).setOnClickListener { finish() }
        fetchData()
        activityPersonalBinding.changePayment.setOnClickListener {
            tryChangePayment()
        }
    }

    private fun fetchData() {
        SecondRetrofitManager.service.gameSelectEntityById(userid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<SelectEntityById.DataBean>() {
                    override fun onSuccees(t: BaseResponse<SelectEntityById.DataBean>, data: SelectEntityById.DataBean) {
                        personalInfo = data
                        activityPersonalBinding.sexStr = if (personalInfo?.sex == 1) "男" else "女"
                        activityPersonalBinding.viewModel = personalInfo
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }

    override fun initViews() {
        personalRv = findViewById(R.id.rv_personal)
    }

    override fun initData() {
        findViewById<View>(R.id.iv_reset_password).setOnClickListener(this)
        findViewById<View>(R.id.iv_jiaoyi_mima).setOnClickListener(this)


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        personalAdapter = PersonalAdapter(R.layout.item_personal)
        datas = ArrayList()
        val imgs = ArrayList<Int>()
        imgs.add(R.mipmap.icon_one)
        imgs.add(R.mipmap.icon_two)
        imgs.add(R.mipmap.icon_three)
        imgs.add(R.mipmap.icon_four)
        imgs.add(R.mipmap.icon_three)
        imgs.add(R.mipmap.icon_one)
        imgs.add(R.mipmap.icon_two)
        imgs.add(R.mipmap.icon_three)
        imgs.add(R.mipmap.icon_four)
        imgs.add(R.mipmap.icon_three)
        for (i in imgs.indices) {
            val personalBean = PersonalBean()
            personalBean.imgId = imgs[i]
            datas!!.add(personalBean)
        }
        personalAdapter!!.setNewData(datas)
        personalRv!!.adapter = personalAdapter
        personalRv!!.layoutManager = layoutManager
    }

    private fun tryChangePayment() {
        if (personalInfo == null) {
            showMessage("信息獲取中，請稍後")
            return
        }

        if (personalInfo?.tradingWord != 0) {
            showQuestionAndAnswer()
        } else {
            changePayment()
        }
    }

    private fun showQuestionAndAnswer() {
        val binding = LayoutYanZhengMiBaoBinding.inflate(LayoutInflater.from(this))
        val builder = AlertDialog.Builder(this);
        builder.setView(binding.root)
        builder.setPositiveButton("驗證") { _, _ ->
            if (binding.question.isNullOrBlank()) {
                showMessage("關鍵字不能為空")
                return@setPositiveButton
            }
            if (binding.answer.isNullOrBlank()) {
                showMessage("密鑰不能為空")
                return@setPositiveButton
            }

            confirmMiBao(binding.question!!, binding.answer!!)
        }
        builder.setNegativeButton("取消") { _, _ ->

        }

        builder.create().show()
    }


    private fun confirmMiBao(question: String, answer: String) {
        SecondRetrofitManager.service.gameJudgeQuestion(userid, question, answer).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any?>() {
                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                        changePayment()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }


    private fun changePayment() {

//        id	是	int	用户id
//                wechat	否	string	微信号（随意修改，不能重复）
//        zhifubao	否	string	支付宝账号（随意修改，不能重复）
//        cardNumber	是	string	银行卡号 （第一次必修添加上，必须一直有，不能重复）
//        bankName	是	string	开户行名 （第一次必修添加上，必须一直有，可重复）
//        stutas

        if (personalInfo?.usdtbalance == 1) {
            if(personalInfo?.bankName.isNullOrBlank() || personalInfo?.cardNumber.isNullOrBlank()){
                showMessage("銀行卡信息不能為空")
                return
            }
        }
        val params = mapOf(
                "id" to userid,
                "wechat" to (personalInfo?.wechat?:""),
                "zhifubao" to (personalInfo?.zhifubao?:""),
                "bankName" to (personalInfo?.bankName?:""),
                "stutas" to (personalInfo?.usdtbalance.toString())

        )
        SecondRetrofitManager.service.gameUpdateGathering(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any?>() {
                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                        changePayment()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_reset_password -> startActivity(Intent(this, ResetPasswordActivity::class.java))
            R.id.iv_jiaoyi_mima -> startActivity(Intent(this, SetPasswordActivity::class.java))
        }
    }
}
