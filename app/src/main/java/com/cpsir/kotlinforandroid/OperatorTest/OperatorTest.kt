package com.antonioleiva.weatherapp.test

/**
 *@author Create by cpSir on 2019/11/2
 * 操作符
 */

class SymbolTest{
    var a:Int =6
    var b:Int = 7
    var s = 3 in a..b

    fun main(args:Array<String>){
        /* a+b */
        a.plus(b)

        /* a-b */
        a.minus(b)

        /* a*b */
        a.times(b)

        /* a/b */
        a.div(b)

        /* a%b */
        a.rem(b)

        /* a..b */
        a.rangeTo(b)
    }
}