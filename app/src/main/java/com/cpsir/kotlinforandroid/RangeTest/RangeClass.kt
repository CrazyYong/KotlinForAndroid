package com.cpsir.kotlinforandroid.RangeTest

/**
 *@author Create by cpSir on 2019/11/12
 */

fun main() {
    /*倒序,从0到4 步幅为1*/
//    for (i in 4 downTo 1) print(i)
//    for (i in 4 downTo 1 step 2) print(i)
//
//
//    /*从1到4 步幅为2*/
//    for (i in 1..4 step 2) print(i)
//
//
//    /*创建一个不包括其结束元素的区间，可以使用 until 函数,i in [1, 10) 排除了 10*/
//    for (i in 1 until 10) print(i)

    /**
     * rangeTo  //升序区间
       downTo()  //降序区间
       reversed()  //翻转区间
       step()  //步长
     */
    var a = 0.rangeTo(10) //相当于0..10
    var b = 10.downTo(0) //相当于10..0
    b = b.reversed() //翻转区间 相当于0..10
    var c = 10.downTo(0).step(3)
}