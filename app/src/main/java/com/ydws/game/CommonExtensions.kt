package com.ydws.game

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlin.reflect.KClass

/**
 * Created by Nelson on 2018/2/5.
 * 有志不在年高，无志空活百岁
 */

fun View.startActivity(className: KClass<*>) {
    this.context.startActivity(Intent(this.context, className.java))
}

fun Context.callActivity(className: KClass<*>) {
    startActivity(Intent(this, className.java))
}


fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.toggle(gone: Boolean = true) {
    visibility = if (visibility == View.VISIBLE) {
        if (gone) {
            View.GONE
        } else {
            View.INVISIBLE
        }
    } else {
        View.VISIBLE
    }
}

fun View.isVisible() = visibility == View.VISIBLE


fun String.toast() {
    Toast.makeText(App.instance, this, Toast.LENGTH_SHORT).show()
}

fun String.loge(tag: String){
    Log.e(tag,this)
}

fun String.logd(tag: String){
    Log.d(tag,this)
}

fun String.logi(tag: String){
    Log.i(tag,this)
}

//获取颜色
fun Context.getResColor(id: Int): Int{
    return ContextCompat.getColor(this,id)
}




/**
 * Convert pixel to dp. Preserve the negative value as it's used for representing
 * MATCH_PARENT(-1) and WRAP_CONTENT(-2).
 * Ignore the round error that might happen in dividing the pixel by the density.
 *
 * @param pixel   the value in pixel
 *
 * @return the converted value in dp
 */
fun Context.pixelToDp(pixel: Int): Int {
    val displayMetrics = this.resources.displayMetrics
    return if (pixel < 0) pixel else Math.round(pixel / displayMetrics.density)
}

/**
 * Convert dp to pixel. Preserve the negative value as it's used for representing
 * MATCH_PARENT(-1) and WRAP_CONTENT(-2).
 *
 * @param dp      the value in dp
 *
 * @return the converted value in pixel
 */
fun Context.dpToPixel(dp: Int): Int {
    val displayMetrics = this.resources.displayMetrics
    return if (dp < 0) dp else Math.round(dp * displayMetrics.density)
}
