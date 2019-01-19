package com.ydws.game.activity

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.databinding.DataBindingUtil.setContentView
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.bumptech.glide.Glide
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.ydws.game.R
import com.ydws.game.R.mipmap.id
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.PayTypeBean
import com.ydws.game.bean.jinbizanshuxiangqingBean
import com.ydws.game.body.GoldTradingBody
import com.ydws.game.gone
import com.ydws.game.net.LL
import com.ydws.game.net.RetrofitManager
import com.ydws.game.net.SecondRetrofitManager
import com.ydws.game.net.base.BaseObserver
import com.ydws.game.net.base.BaseResponse
import com.ydws.game.net.scheduler.SchedulerUtils
import com.ydws.game.toast
import com.ydws.game.utils.Entry2MapUtil
import com.ydws.game.utils.SPreference
import com.ydws.game.widget.chooser.OnChooseListener
import com.ydws.game.widget.chooser.SimpleChooserDialog
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_jinbizanzhuinfo.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.toast
import org.jetbrains.anko.toast
import java.io.File
import java.util.*

class jinbizanzhuinfoActivity : BaseAbstractActivity() {

    private var userid: String by SPreference("userid", "")

    var TradingId = ""
    var photoStr: String = ""
    val payTypes: ArrayList<PayTypeBean> = ArrayList()
    var currentPayType: PayTypeBean? = null

    var temppart: MultipartBody.Part? = null;

    var dddd = jinbizanshuxiangqingBean.DataBean()
    override fun getContentLayoutID(): Int {
        return R.layout.activity_jinbizanzhuinfo
    }

    override fun initViews() {

        ID.text = "ID." + userid

        LL.d("11111111111111111111111111111111111111111")

        iv_submit.onClick {

            val body = GoldTradingBody()
            body.userId = userid

            var type = -1
            if (currentPayType == null) {
                type = dddd.payType
            } else {
                type = currentPayType?.id!!.toInt()
            }
            body.payType = type
            body.photo = photoStr
            body.tradingId = TradingId


            val map = Entry2MapUtil.toMap(body)

            SecondRetrofitManager.service.xiangQingTrue(map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object : BaseObserver<String?>() {
                        override fun onSuccees(t: BaseResponse<String?>, data: String?) {
                            "購買成功".toast()
                            finish()
                        }

                        override fun onCodeError(code: Int, msg: String) {
                        }

                    })

        }
        report.onClick {
            if (!photoStr.isNullOrBlank()) {

                val et = EditText(this@jinbizanzhuinfoActivity)
                AlertDialog.Builder(this@jinbizanzhuinfoActivity).setTitle("请输入消息")
                        .setView(et)
                        .setPositiveButton("确定") { dialogInterface, i ->

                            SecondRetrofitManager.service
                                    .report(userid, TradingId, et.toString().trim())
                                    .compose(SchedulerUtils.ioToMain())
                                    .subscribe(object : BaseObserver<Any?>() {
                                        override fun onSuccees(t: BaseResponse<Any?>, data: Any?) {
                                            finish()
                                            "举报成功".toast()
                                        }

                                        override fun onCodeError(code: Int, msg: String) {
                                            toast(msg)
                                        }

                                    })
                        }.setNegativeButton("取消", null).show()


            } else {
                toast("请上传凭证")
            }
        }



        ll_lookstatus.onClick {
            if (!photoStr.isNullOrBlank()) {
                LookImage.start(this@jinbizanzhuinfoActivity, photoStr)
            } else {
                toast("没有凭证")
            }
        }

        ll_pay_fangshi.setOnClickListener {

            SimpleChooserDialog.showParcelables(supportFragmentManager, payTypes, OnChooseListener { dialog, content ->
                dialog.dismiss()
                currentPayType = content as PayTypeBean
                Selectxianshi(currentPayType?.id!!.toInt())
            })

        }


        val selectType = ArrayList<String>()
        selectType.add("打开照相机")
        selectType.add("从手机相册获取")
        selectType.add("取消")
        ll_status.onClick {
            SimpleChooserDialog.showStrings(supportFragmentManager, selectType, OnChooseListener { dialog, content ->
                dialog.dismiss()
                when (content) {
                    "打开照相机" -> {
                        PictureSelector.create(this@jinbizanzhuinfoActivity)
                                .openCamera(PictureMimeType.ofImage())
                                .cropCompressQuality(10)
                                .compress(true)// 是否压缩 true or false
                                .forResult(PictureConfig.CHOOSE_REQUEST)
                    }
                    "从手机相册获取" -> {
                        PictureSelector.create(this@jinbizanzhuinfoActivity)
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
        initinidata()
    }

    override fun initData() {


    }

    fun initinidata() {
        TradingId = intent.getStringExtra("TradingId")

        RetrofitManager.service
                .findGold(userid, TradingId)
                .compose(SchedulerUtils.ioToMain())
                .subscribe(object : BaseObserver<jinbizanshuxiangqingBean.DataBean>() {
                    override fun onSuccees(t: BaseResponse<jinbizanshuxiangqingBean.DataBean>, data: jinbizanshuxiangqingBean.DataBean) {

                        photoStr = data.zhuanzhangPhoto
                        dddd = data
                        guojiahediqu.text = data.city
                        fuwudaili.text = data.payee
                        phone.text = data.phone
                        jinbi.text = data.goldNumber.toString()
                        fabijiazhi.text = data.usdt.toString()
                        tv_xinjiajiazhi.text = data.fiat.toString()
                        ll_pay_fangshi.isEnabled = false
                        ll_pay_fangshi.visibility = View.GONE

                        if (data.payType == 0) {
                            ll_pay_fangshi.isEnabled = true
                            ll_pay_fangshi.visibility = View.VISIBLE
                        }

                        Selectxianshi(data.payType)


                        //如果凭证没有图
                        if (!data.zhuanzhangPhoto.isNullOrBlank()) {
                            ll_status.isEnabled = false
                            ll_status.visibility = View.GONE
                        }

                    }


                    override fun onCodeError(code: Int, msg: String) {
                        toast(msg)
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

    private fun Selectxianshi(data: Int) {

        ll_zhifubao.gone()
        ll_wechat.gone()
        ll_bank.gone()
        ll_zhanghao.gone()

        when (data) {
            1 -> {
                ll_zhifubao.visibility = View.VISIBLE
                zhifubao.text = dddd.zhifubaoId
            }
            2 -> {
                ll_wechat.visibility = View.VISIBLE
                weixin.text = dddd.wechat
            }
            3 -> {
                ll_bank.visibility = View.VISIBLE
                ll_zhanghao.visibility = View.VISIBLE
                kaihuhang.text = dddd.bankname
                kahao.text = dddd.cardNumber
            }
        }
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
                    temppart = part

                    SecondRetrofitManager.service.uploadPicture(part)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(object : BaseObserver<String>() {
                                override fun onSuccees(t: BaseResponse<String>, data: String) {
                                    photoStr = t.data
                                    "上傳成功".toast()
                                }

                                override fun onCodeError(code: Int, msg: String) {
                                }
                            })

                }
            }
        }
    }


    companion object {
        fun start(context: Context, TradingId: String) {
            val starter = Intent(context, jinbizanzhuinfoActivity::class.java)
            starter.putExtra("TradingId", TradingId)
            context.startActivity(starter)
        }
    }

}
