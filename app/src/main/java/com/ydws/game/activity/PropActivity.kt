package com.ydws.game.activity

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ydws.game.MainActivity

import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.Countries
import com.ydws.game.bean.FindCountriesBean
import com.ydws.game.databinding.ActivityPropBinding
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
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
    override fun getContentLayoutID(): Int {
        return R.layout.activity_prop
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPropBinding = DataBindingUtil.setContentView(this, R.layout.activity_prop)
        setupView()
    }

    private fun setupView() {
        activityPropBinding.llReplace.setOnClickListener {
            if (countries.isNotEmpty()) {
                SimpleChooserDialog.showParcelables(supportFragmentManager, countries, OnChooseListener { _, content ->

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
                        Log.e("tag","---${data.size}")

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
                        showMessage(msg)
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
