package com.cpsir.kotlinforandroid.utils

import android.view.View
import android.view.ViewGroup

/**
 *@author Create by cpSir on 2019/11/14
 */

fun View.gone(){
    visibility = View.GONE
}

fun View.visible(){
    visibility = View.VISIBLE
}

var View.topMargin:Int
    get():Int{
        return (layoutParams as ViewGroup.MarginLayoutParams).topMargin
    }
    set(value){
        (layoutParams as ViewGroup.MarginLayoutParams).topMargin = value
    }

var View.bottomMargin:Int
    get() :Int{
        return (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).bottomMargin = value
    }

var View.rightMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).rightMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).rightMargin = value
    }

var View.leftMargin: Int
    get():Int {
        return (layoutParams as ViewGroup.MarginLayoutParams).leftMargin
    }
    set(value) {
        (layoutParams as ViewGroup.MarginLayoutParams).leftMargin = value
    }
