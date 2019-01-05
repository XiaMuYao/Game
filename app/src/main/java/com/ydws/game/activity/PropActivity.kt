package com.ydws.game.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.Countries
import com.ydws.game.bean.FindCountriesBean
import com.ydws.game.bean.PropAboutMoney
import com.ydws.game.bean.SelectBuyBack
import com.ydws.game.body.PropBody
import com.ydws.game.databinding.ActivityPropBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
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
    private var currentCountry :Countries? = null

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
    }

    override fun initViews() {
        findViewById<View>(R.id.submit).setOnClickListener(this)

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
                .subscribe(object : BaseObserver<SelectBuyBack.DataBean>() {
                    override fun onSuccees(t: BaseResponse<SelectBuyBack.DataBean>, data: SelectBuyBack.DataBean) {
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

    private fun  aboutMoney(){
        showHud(true)
        SecondRetrofitManager.service.propAboutMoney(currentCountry?.countries?:"",propBody.propsNumber.get()?:"1").subscribeOn(Schedulers.io())
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
            R.id.submit -> {
            }
        }
    }
}
