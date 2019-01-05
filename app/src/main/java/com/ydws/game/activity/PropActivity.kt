package com.ydws.game.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.Countries
import com.ydws.game.bean.FindCountriesBean
import com.ydws.game.bean.PropAboutMoney
import com.ydws.game.bean.SelectBuyBackBean
import com.ydws.game.body.PropBody
import com.ydws.game.databinding.ActivityPropBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.toast
import com.ydws.game.utils.SPreference
import com.ydws.game.widget.chooser.OnChooseListener
import com.ydws.game.widget.chooser.SimpleChooserDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * 道具回收
 */
class PropActivity : BaseAbstractActivity(), View.OnClickListener {
    private lateinit var activityPropBinding: ActivityPropBinding
    private val countries = arrayListOf<Countries>()
    private var currentCountry: Countries? = null

    private val propBody = PropBody()
    private var userid: String by SPreference("userid", "")


    override fun getContentLayoutID(): Int {
        return R.layout.activity_prop
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPropBinding = DataBindingUtil.setContentView(this, R.layout.activity_prop)
        activityPropBinding.buyValueVisibility = View.GONE
        propBody.userId.set(userid)
        setupView()
    }

    private fun setupView() {
        activityPropBinding.viewModel = propBody
        activityPropBinding.llReplace.setOnClickListener {
            if (propBody.propsNumber.get().isNullOrBlank()) {
                showMessage("請輸入道具回收數量")
                return@setOnClickListener
            }
            if (countries.isNotEmpty()) {
                SimpleChooserDialog.showParcelables(supportFragmentManager, countries, OnChooseListener { dialog, content ->
                    dialog.dismiss()
                    currentCountry = content as Countries
                    aboutMoney()
                })
            }
        }
        activityPropBinding.submit.setOnClickListener { addBuyBack() }
    }

    override fun initViews() {


    }

    override fun initData() {
        SecondRetrofitManager.service.findCountries()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<List<FindCountriesBean.DataBean>>() {
                    override fun onSuccees(t: BaseResponse<List<FindCountriesBean.DataBean>>, data: List<FindCountriesBean.DataBean>) {

                        val result = data.map {
                            Countries(
                                    id = it.id,
                                    countries = it.countries,
                                    bili = it.bili
                            )
                        }

                        countries.clear()
                        countries.addAll(result)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
        SecondRetrofitManager.service.selectBuyBack(userid).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<SelectBuyBackBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<SelectBuyBackBean.DataBean>, data: SelectBuyBackBean.DataBean) {
                        propBody.bankname.set(data.bankName)
                        propBody.cardNumber.set(data.cardNumber)
                        propBody.city.set(data.city)
                        propBody.phone.set(data.phone)
                        propBody.payee.set(data.payee)
                        propBody.wechat.set(data.wechat)
                        propBody.zhifubaoId.set(data.zhifubao)

                    }

                    override fun onCodeError(code: Int, msg: String) {

                    }

                })


    }

    private fun aboutMoney() {
        showHud(true)
        SecondRetrofitManager.service.propAboutMoney(currentCountry?.countries
                ?: "", propBody.propsNumber.get() ?: "1").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<PropAboutMoney.DataBean>() {
                    override fun onSuccees(t: BaseResponse<PropAboutMoney.DataBean>, data: PropAboutMoney.DataBean) {
                        showHud(false)
                        activityPropBinding.buyValueVisibility = View.VISIBLE
                        propBody.buyValue.set(data.a.toString())
                        propBody.fiatStr.set(data.divide2.toString())
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        showHud(false)
                        activityPropBinding.buyValueVisibility = View.GONE

                    }

                })
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.submit -> addBuyBack()
        }
    }

    //    userId	是	Integer	用户id
//    city	是	string	国家和城市和详细地址
//    payee	是	string	收款人姓名
//    bankname	是	string	开户行名
//    cardNumber	是	string	收款账号(卡号)
//    zhifubaoId	是	string	支付宝账号
//    wechat	是	string	微信号
//    propsNumber	是	string	交易道具数量
//    traPassword	是	String	交易密码
//    phone	是	String	电话号
//    language	是	int	语言，0汉语，其他英文
//    sessionId	是	String	session校验
//    fiat	是	Bigdecimal	约个法币价值
//    countries	是
    private fun addBuyBack() {
        if (propBody.traPassword.get().isNullOrBlank()) {
            "请输入交易密码".toast()
            return
        }
        val params = mapOf(
                "userId" to userid,
                "city" to propBody.city.get()!!,
                "payee" to propBody.payee.get()!!,
                "bankname" to propBody.bankname.get()!!,
                "cardNumber" to propBody.cardNumber.get()!!,
                "zhifubaoId" to propBody.zhifubaoId.get()!!,
                "wechat" to propBody.wechat.get()!!,
                "propsNumber" to propBody.propsNumber.get()!!,
                "traPassword" to propBody.traPassword.get()!!,
                "phone" to propBody.phone.get()!!,
                "fiat" to propBody.fiatStr.get()!!,
                "countries" to if (currentCountry == null) "" else currentCountry?.countries!!

        )
        SecondRetrofitManager.service.addBuyBack(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any>() {
                    override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                        "申请已提交".toast()
                        finish()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })
    }
}
