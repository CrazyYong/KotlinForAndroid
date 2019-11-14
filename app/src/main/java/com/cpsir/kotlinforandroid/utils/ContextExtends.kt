package com.cpsir.kotlinforandroid.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 *@author Create by cpSir on 2019/11/14
 */

/*Toast*/
fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}

fun Context.toast(resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, duration).show()
}

fun Context.centerToast(resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    var t = Toast.makeText(this, resId, duration)
    t.setGravity(Gravity.CENTER, 0, 0)
    t.show()
}

/*尺寸转换*/
fun Context.dp2px(dpValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (dpValue * scale + 0.5f).toInt()
}

fun Context.px2dp(pxValue: Float): Int {
    val scale = resources.displayMetrics.density
    return (pxValue / scale + 0.5f).toInt()
}

fun Context.sp2px(spValue: Float): Int {
    val scale = resources.displayMetrics.scaledDensity
    return (spValue * scale + 0.5f).toInt()
}

fun Context.px2sp(pxValue: Float): Int {
    val scale = resources.displayMetrics.scaledDensity
    return (pxValue / scale + 0.5f).toInt()
}
