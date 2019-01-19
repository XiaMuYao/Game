package com.ydws.game.activity

import android.content.Intent
import android.view.View
import android.widget.TextView
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.widget.chooser.OnChooseListener
import com.ydws.game.widget.chooser.SimpleChooserDialog
import kotlinx.android.synthetic.main.activity_gold_apply.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import android.app.Activity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ydws.game.*
import com.ydws.game.bean.*
import com.ydws.game.body.GoldTradingBody
import com.ydws.game.body.GoldTradingBodyCopy
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.utils.Entry2MapUtil
import com.ydws.game.utils.SPreference
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import java.io.File
import java.util.*


class GoldApplyActivity : BaseAbstractActivity() {
    private var userid: String by SPreference("userid", "")
    var intentData: GoldTradingBean? = null
    val countries: ArrayList<Countries> = ArrayList()
    val payTypes: ArrayList<PayTypeBean> = ArrayList()
    var currentCountry: Countries? = null
    var currentPayType: PayTypeBean? = null
    //    var currentImage: String? = null
    var zhifufangsh = 0
    var photostr = ""
    //    var jilyid = ""
    override fun getContentLayoutID(): Int {
        return R.layout.activity_gold_apply
    }

    override fun initViews() {
        hideAll()
        intentData = intent.getSerializableExtra("data") as GoldTradingBean?
        xuanzezhifufangshi.text = "選擇贊助方式"

        if (intent.getStringExtra("title") != null) {
            var title = intent.getStringExtra("title")
            when(title){
                "匹配信息" -> iv_shop_head.setImageResource(R.mipmap.pipeixinxi)
            }
        }
//        jilyid = intent.getStringExtra("jiluId")
        findViewById<View>(R.id.back).onClick { finish() }
        findViewById<TextView>(R.id.tv_title_bar).text = "贊助"
        val selectType = ArrayList<String>()
        selectType.add("打开照相机")
        selectType.add("从手机相册获取")
        selectType.add("取消")
        ll_status.visibility = View.GONE
        ll_status.onClick {
            SimpleChooserDialog.showStrings(supportFragmentManager, selectType, OnChooseListener { dialog, content ->
                dialog.dismiss()
                when (content) {
                    "打开照相机" -> {
                        PictureSelector.create(this@GoldApplyActivity)
                                .openCamera(PictureMimeType.ofImage())
                                .cropCompressQuality(10)
                                .compress(true)// 是否压缩 true or false
                                .forResult(PictureConfig.CHOOSE_REQUEST)
                    }
                    "从手机相册获取" -> {
                        PictureSelector.create(this@GoldApplyActivity)
                                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                                .maxSelectNum(1)// 最大图片选择数量 int
                                .minSelectNum(1)// 最小选择数量 int
                                .imageSpanCount(4)// 每行显示个数 int
                                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                                .previewImage(true)// 是否可预览图片 true or false
                                .isCamera(false)// 是否显示拍照按钮 true or false
                                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
                                .enableCrop(false)// 是否裁剪 true or false
                                .cropCompressQuality(10)
                                .compress(true)// 是否压缩 true or false
                                .isGif(false)// 是否显示gif图片 true or false
                                .minimumCompressSize(100)// 小于100kb的图片不压缩
                                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                                .isDragFrame(false)// 是否可拖动裁剪框(固定)
                                .forResult(PictureConfig.CHOOSE_REQUEST)//结果回调onActivityResult code
                    }
                    else -> {

                    }
                }
            })
        }
        ll_replace.onClick {
            if (countries.isNotEmpty()) {
                SimpleChooserDialog.showParcelables(supportFragmentManager, countries, OnChooseListener { dialog, content ->
                    dialog.dismiss()
                    currentCountry = content as Countries
                    aboutMoney()
                })
            }
        }
        zhifufangshi.onClick {
            if (payTypes.isNotEmpty()) {
                SimpleChooserDialog.showParcelables(supportFragmentManager, payTypes, OnChooseListener { dialog, content ->
                    dialog.dismiss()
                    currentPayType = content as PayTypeBean
                    zhifufangshi.text = content.payType
                    freshPayType()
                })
            }
        }
        submit.onClick {
            if (currentCountry == null) {
                "請選擇國家".toast()
                return@onClick
            }
//            if (currentImage.isNullOrBlank()) {
//                "請先上傳憑證".toast()
//                return@onClick
//            }
            if (currentPayType == null) {
                "請先選擇支付方式".toast()
                return@onClick
            }
            val body = GoldTradingBodyCopy()
            body.userId = userid

            body.countries = guojiahediqu.text.toString()
            body.goldNumber = jinbi.text.toString()
            body.bishangId = intentData?.id.toString()
            body.city = guojiahediqu.text.toString()
            body.payee = fuwudaili.text.toString()

            body.usdt = intentData?.usdt.toString()
            body.fiat = xuanzefabijiazhi.text.toString()
            body.phone = phone.text.toString()
            body.bankName = intentData?.bankName

            body.cardNumber = intentData?.cardNumber
            body.zhifubao = intentData?.zhifubao
            body.wechatCode = intentData?.wechatCode
            body.payType = currentPayType?.id!!.toInt()


            val map = Entry2MapUtil.toMap(body)

            SecondRetrofitManager.service.goldCommit(map).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : BaseObserver<Any>() {
                        override fun onSuccees(t: BaseResponse<Any>, data: Any) {
                            "購買成功".toast()
                            SponsorActivity.start(this@GoldApplyActivity)
                            finish()
                        }

                        override fun onCodeError(code: Int, msg: String) {
                        }

                    })
        }
        ID.text = "ID." + userid
        guojiahediqu.text = intentData?.city
        phone.text = intentData?.phone
        jinbi.text = intentData?.jinbi
        usdt.text = intentData?.usdt.toString()
        kaihuhang.text = intentData?.bankName
        kahao.text = intentData?.cardNumber
        weixin.text = intentData?.wechatCode
        zhifubao.text = intentData?.zhifubao
        fuwudaili.text = intentData?.payee

    }

    private fun freshPayType() {
        /**
         * 1 支付宝
         * 2 微信
         * 3 银行卡
         */
        hideAll()
        when (currentPayType?.id) {
            "1" -> {
                ll_zhifubao.visible()
                zhifufangsh = 1
            }
            "2" -> {
                ll_wechat.visible()
                zhifufangsh = 2
            }
            "3" -> {
                ll_bank.visible()
                ll_zhanghao.visible()
                zhifufangsh = 3
            }
            else -> {
            }
        }
    }

    private fun hideAll() {
        ll_bank.gone()
        ll_zhanghao.gone()
        ll_zhifubao.gone()
        ll_wechat.gone()
    }

    private fun aboutMoney() {
        showHud(true)
        SecondRetrofitManager.service.propAboutMoney(currentCountry?.countries
                ?: "", intentData?.jinbi ?: "1").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<PropAboutMoney.DataBean>() {
                    override fun onSuccees(t: BaseResponse<PropAboutMoney.DataBean>, data: PropAboutMoney.DataBean) {
                        showHud(false)
                        xuanzefabijiazhi.text = data.a.toString()
                    }

                    override fun onCodeError(code: Int, msg: String) {

                    }

                })
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

        SecondRetrofitManager.service.getPayType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<List<PayTypeBean>>() {
                    override fun onSuccees(t: BaseResponse<List<PayTypeBean>>, data: List<PayTypeBean>) {

                        val result = data.map {
                            PayTypeBean(
                                    id = it.id,
                                    payType = it.payType
                            )
                        }

                        payTypes.clear()
                        payTypes.addAll(result)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                    }

                })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode === Activity.RESULT_OK) {
            when (requestCode) {
                PictureConfig.CHOOSE_REQUEST -> {
                    // 图片、视频、音频选择结果回调
                    val selectList = PictureSelector.obtainMultipleResult(data)
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), File(selectList[0].compressPath
                            ?: selectList[0].path))
                    val part = MultipartBody.Part.createFormData("file", UUID.randomUUID().toString(), requestFile)
                    showHud(true)
                    SecondRetrofitManager.service.uploadPicture(part)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(object : BaseObserver<String>() {
                                override fun onSuccees(t: BaseResponse<String>, data: String) {
                                    showHud(false)
                                    photostr = t.data
                                    "上傳成功".toast()
//                                    currentImage = data
                                }

                                override fun onCodeError(code: Int, msg: String) {
                                }

                            })
                }
            }
        }
    }
}
