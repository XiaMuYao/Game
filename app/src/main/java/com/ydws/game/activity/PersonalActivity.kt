package com.ydws.game.activity

import android.app.Activity
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType

import com.ydws.game.R
import com.ydws.game.adapter.PersonalAdapter
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.*
import com.ydws.game.databinding.ActivityPersonalBinding
import com.ydws.game.databinding.LayoutYanZhengMiBaoBinding
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import com.ydws.game.utils.Drawable2FileUtils
import com.ydws.game.utils.SPreference
import com.ydws.game.widget.chooser.OnChooseListener
import com.ydws.game.widget.chooser.SimpleChooserDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_personal.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.toast
import java.io.File
import java.util.*

/**
 * 个人页
 */
class PersonalActivity : BaseAbstractActivity(), View.OnClickListener, BaseQuickAdapter.OnItemChildClickListener {
    val imgs = ArrayList<Int>()
    private val countries = arrayListOf<Countries>()
    var stutas = -1
    private var dddd: Int by SPreference("intcode", -1)
    var currentPayType: PayTypeBeanTwo? = PayTypeBeanTwo(0, "未知")
    private var currentCountry: Countries? = null


    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {


        val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),
                Drawable2FileUtils.drawableToFile(this@PersonalActivity,
                        imgs[position],
                        imgs[position].toString()))
        val part = MultipartBody.Part.createFormData("file", UUID.randomUUID().toString(), requestFile)

        showHud(true)
        SecondRetrofitManager.service.uploadPicture(part)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {
                    override fun onSuccees(t: BaseResponse<String>, data: String) {
                        currentImage = data
                        SecondRetrofitManager.service.updPhoto(userid, data)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(object : BaseObserver<Any?>() {
                                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                        showHud(false)
                                        "上傳成功".toast()
                                        Glide.with(this@PersonalActivity).load(currentImage).into(activityPersonalBinding.ivUserIcon)

                                        var dataDecoders: MutableList<PersonalBean>? = ArrayList()
                                        imgs.clear()

                                        when (position) {
                                            0 -> {
                                                imgs.add(R.mipmap.sone)
                                                imgs.add(R.mipmap.two)
                                                imgs.add(R.mipmap.three)
                                                imgs.add(R.mipmap.four)
                                            }
                                            1 -> {
                                                imgs.add(R.mipmap.one)
                                                imgs.add(R.mipmap.stwo)
                                                imgs.add(R.mipmap.three)
                                                imgs.add(R.mipmap.four)
                                            }
                                            2 -> {
                                                imgs.add(R.mipmap.one)
                                                imgs.add(R.mipmap.two)
                                                imgs.add(R.mipmap.sthree)
                                                imgs.add(R.mipmap.four)
                                            }
                                            3 -> {
                                                imgs.add(R.mipmap.one)
                                                imgs.add(R.mipmap.two)
                                                imgs.add(R.mipmap.three)
                                                imgs.add(R.mipmap.sfour)
                                            }
                                        }



                                        for (i in imgs.indices) {
                                            val personalBean = PersonalBean()
                                            personalBean.imgId = imgs[i]

                                            dataDecoders?.add(personalBean)
                                        }

                                        personalAdapter?.setNewData(dataDecoders)
                                    }

                                    override fun onCodeError(code: Int, msg: String) {
                                        showHud(false)
                                    }
                                })
//                                    showHud(false)
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        showHud(false)
                    }

                })
    }

    private var personalRv: RecyclerView? = null
    private var personalAdapter: PersonalAdapter? = null
    private var datas: MutableList<PersonalBean>? = null
    private var currentImage: String? = null
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
        activityPersonalBinding.tvUpdateIcon.setOnClickListener {
            val selectType = ArrayList<String>()
            selectType.add("打开照相机")
            selectType.add("从手机相册获取")
            selectType.add("取消")
            SimpleChooserDialog.showStrings(supportFragmentManager, selectType, OnChooseListener { dialog, content ->
                dialog.dismiss()
                when (content) {
                    "打开照相机" -> {
                        PictureSelector.create(this@PersonalActivity)
                                .openCamera(PictureMimeType.ofImage())
                                .cropCompressQuality(10)
                                .compress(true)// 是否压缩 true or false
                                .forResult(PictureConfig.CHOOSE_REQUEST)
                    }
                    "从手机相册获取" -> {
                        PictureSelector.create(this@PersonalActivity)
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

        show_age.setOnClickListener {
            SimpleChooserDialog.showParcelables(supportFragmentManager, countries, OnChooseListener { dialog, content ->
                dialog.dismiss()
                currentCountry = content as Countries
                show_age.text = currentCountry.toString().substring(0, currentCountry.toString().indexOf("/"))
            })
        }

        sex.setOnClickListener {
            val payTypes: ArrayList<PayTypeBeanTwo> = ArrayList()

            payTypes.add(PayTypeBeanTwo(1, "男"))
            payTypes.add(PayTypeBeanTwo(2, "女"))

            SimpleChooserDialog.showParcelables(supportFragmentManager, payTypes, OnChooseListener { dialog, content ->
                dialog.dismiss()

                currentPayType = content as PayTypeBeanTwo

                show_sex.text = currentPayType?.payType
            })
        }

        show_sex.setOnClickListener {

            val payTypes: ArrayList<PayTypeBeanTwo> = ArrayList()

            payTypes.add(PayTypeBeanTwo(1, "男"))
            payTypes.add(PayTypeBeanTwo(2, "女"))

            SimpleChooserDialog.showParcelables(supportFragmentManager, payTypes, OnChooseListener { dialog, content ->
                dialog.dismiss()

                currentPayType = content as PayTypeBeanTwo

                show_sex.text = currentPayType?.payType
            })

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
                        if (personalInfo?.wechat.isNullOrBlank() &&
                                personalInfo?.zhifubao.isNullOrBlank() &&
                                personalInfo?.cardNumber.isNullOrBlank() &&
                                personalInfo?.bankName.isNullOrBlank()) {
                            stutas = 1
                        } else {
                            stutas = 0
                        }

                        if (personalInfo?.sex == 1) {
                            currentPayType!!.id = 1
                            currentPayType!!.payType = "男"
                        } else {
                            currentPayType!!.id = 2
                            currentPayType!!.payType = "女"
                        }

                        Glide.with(this@PersonalActivity).load(data.photo).into(activityPersonalBinding.ivUserIcon)
                        //手机和姓名被修改
                        if (!personalInfo?.payee.isNullOrBlank()) {
                            show_name.isEnabled = false
                            show_tel.isEnabled = false
                        }

                    }

                    override fun onCodeError(code: Int, msg: String) {

                    }

                })
    }

    override fun initViews() {

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
    }


    override fun initData() {
        findViewById<View>(R.id.iv_reset_password).setOnClickListener(this)
        findViewById<View>(R.id.iv_jiaoyi_mima).setOnClickListener(this)
        findViewById<View>(R.id.button).setOnClickListener(this)
        findViewById<View>(R.id.iv_personal_zanzhu).setOnClickListener(this)


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        personalAdapter = PersonalAdapter(R.layout.item_personal)
        personalAdapter?.onItemChildClickListener = this
        datas = ArrayList()
        imgs.clear()
        imgs.add(R.mipmap.one)
        imgs.add(R.mipmap.two)
        imgs.add(R.mipmap.three)
        imgs.add(R.mipmap.four)
        datas?.clear()
        for (i in imgs.indices) {
            val personalBean = PersonalBean()
            personalBean.imgId = imgs[i]

            datas!!.add(personalBean)
        }
        personalAdapter!!.setNewData(datas)
        activityPersonalBinding.rvPersonal.adapter = personalAdapter
        activityPersonalBinding.rvPersonal.layoutManager = layoutManager
    }

    private fun tryChangePayment() {
        if (personalInfo == null) {
            showMessage("信息獲取中，請稍後")
            return
        }

        if (stutas == 0) {
            showQuestionAndAnswer()
        } else if (stutas == 1) {
            changePayment()
        }
    }

    private fun showQuestionAndAnswer() {
        val binding = LayoutYanZhengMiBaoBinding.inflate(LayoutInflater.from(this))
        val builder = AlertDialog.Builder(this)
        builder.setView(binding.root)
        builder.setTitle("驗證密保")
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
                        stutas = 1
                        changePayment()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        stutas = 0
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
            if (personalInfo?.bankName.isNullOrBlank() || personalInfo?.cardNumber.isNullOrBlank()) {
                showMessage("銀行卡信息不能為空")
                return
            }
        }
        val params = mapOf(
                "id" to userid,
                "wechat" to (personalInfo?.wechat ?: ""),
                "zhifubao" to (personalInfo?.zhifubao ?: ""),
                "bankName" to (personalInfo?.bankName ?: ""),
                "stutas" to (stutas.toString()),
                "cardNumber" to (personalInfo?.cardNumber ?: "")

        )
        SecondRetrofitManager.service.gameUpdateGathering(params).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<Any?>() {
                    override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                        toast("修改成功")
                        fetchData()
                    }

                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
                    }

                })

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.iv_reset_password -> startActivity(Intent(this, SetPasswordActivity::class.java))
            R.id.iv_jiaoyi_mima -> {
                if (personalInfo?.tradingWord == 0) {
                    startActivity(Intent(this, SetTradePasswordActivity::class.java))
                } else {
                    startActivity(Intent(this, ResetPasswordActivity::class.java))
                }
            }
            //修改信息
            R.id.button -> {
                if (show_name.text.isNullOrBlank() ||
                        show_sex.text.isNullOrBlank() ||
                        show_age.text.isNullOrBlank() ||
                        show_tel.text.isNullOrBlank() ||
                        show_nicheng.text.isNullOrBlank()
                ) {
                    toast("有信息为空")
                    return
                }

                RetrofitManager.service
                        .updateUserEntity(userid,
                                show_name.text.toString().trim(),
                                personalInfo!!.photo,
                                currentPayType!!.id,
                                show_tel.text.toString().trim(),
                                show_nicheng.text.toString().trim(),
                                show_age.text.toString().trim()
                        )
                        .compose(SchedulerUtils.ioToMain())
                        .subscribe(object : BaseObserver<Any?>() {
                            override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                toast(t.message)

                            }

                            override fun onCodeError(code: Int, msg: String) {
                                toast(msg)
                            }
                        })


            }


            //赞助
            R.id.iv_personal_zanzhu -> {
                startActivity(Intent(this, SponsorActivity::class.java))
            }

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
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
                                    currentImage = data
                                    SecondRetrofitManager.service.updPhoto(userid, data)
                                            .subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(object : BaseObserver<Any?>() {
                                                override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                                    showHud(false)
                                                    "上傳成功".toast()
                                                    Glide.with(this@PersonalActivity).load(currentImage).into(activityPersonalBinding.ivUserIcon)
                                                }

                                                override fun onCodeError(code: Int, msg: String) {
                                                    showHud(false)
                                                }

                                            })

//                                    showHud(false)

                                }

                                override fun onCodeError(code: Int, msg: String) {
                                    showHud(false)
                                }

                            })

                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }
}
