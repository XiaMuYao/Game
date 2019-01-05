package com.ydws.game.activity

import android.content.Intent
import android.view.View
import android.widget.TextView
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.ydws.game.MainActivity
import com.ydws.game.R
import com.ydws.game.base.BaseAbstractActivity
import com.ydws.game.bean.Countries
import com.ydws.game.body.GoldTradingBean
import com.ydws.game.widget.chooser.OnChooseListener
import com.ydws.game.widget.chooser.SimpleChooserDialog
import kotlinx.android.synthetic.main.activity_gold_apply.*
import kotlinx.android.synthetic.main.pupview.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import android.R.attr.data
import android.app.Activity
import com.luck.picture.lib.entity.LocalMedia



class GoldApplyActivity : BaseAbstractActivity() {

    var data: GoldTradingBean? = null

    override fun getContentLayoutID(): Int {
        return R.layout.activity_gold_apply
    }

    override fun initViews() {
        data = intent.getSerializableExtra("data") as GoldTradingBean?
        findViewById<View>(R.id.back).onClick { finish() }
        findViewById<TextView>(R.id.tv_title_bar).text = "金幣贊助"
        val selectType = ArrayList<String>()
        selectType.add("打开照相机")
        selectType.add("从手机相册获取")
        selectType.add("取消")
        ll_status.onClick {
            SimpleChooserDialog.showStrings(supportFragmentManager, selectType, OnChooseListener { dialog, content ->
                dialog.dismiss()
                when (content) {
                    "打开照相机" -> {
                        PictureSelector.create(this@GoldApplyActivity)
                                .openCamera(PictureMimeType.ofImage())
                                .forResult(PictureConfig.CHOOSE_REQUEST)
                    }
                    "从手机相册获取" ->{
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
                                .compress(false)// 是否压缩 true or false
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

        }
        ID.text = data?.id.toString()
        guojiahediqu.text = data?.city


    }

    override fun initData() {

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

                }
            }
        }
    }
}
