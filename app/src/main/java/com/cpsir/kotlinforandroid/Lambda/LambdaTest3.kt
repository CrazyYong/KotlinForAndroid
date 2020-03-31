package com.cpsir.kotlinforandroid.Lambda

/**
 * 闭包
 *
&所谓闭包，即是函数中包含函数，这里的函数我们可以包含(Lambda表达式，匿名函数，局部函数，对象表达式)。
我们熟知，函数式编程是现在和未来良好的一种编程趋势。故而Kotlin也有这一个特性。

&我们熟知，Java是不支持闭包的，Java是一种面向对象的编程语言，在Java中，对象是他的一等公民。函数和变量是二等公民。

&Kotlin中支持闭包，函数和变量是它的一等公民，而对象则是它的二等公民了。
 **/

/*1：携带状态
* */
fun test(b : Int): () -> Int{
    var a = 3
    return fun() : Int{
        a++
        return a + b
    }
}

/*2：引用外部变量，并改变外部变量的值*/
var sum1:Int = 0
val arr1 = arrayOf(1,3,5,7,9)


fun main() {

//    val t = test(3)
//    println(t())
//    println(t())
//    println(t())

    arr1.filter { it < 7 }.forEach{ sum1 += it }
    println(sum1)
}