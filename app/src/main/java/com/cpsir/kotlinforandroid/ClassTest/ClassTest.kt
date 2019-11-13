package com.antonioleiva.weatherapp.test

annotation class Inject

/**
 *@author Create by cpSir on 2019/11/2
 * 类
 */


/**
 * 等价于
 * class Test constructor(num : Int)
 */
class TestOne(var num:Int){

    init {
        num = 5
        println("num = $num")
    }
}

// 类似下面两种情况的，都必须存在constructor关键字，并且在修饰符或者注释符后面。
class TestTwo private constructor(num: Int){
}

class TestThree @Inject constructor(num: Int){
}

/**
 * 二级构造函数
 */

class TestFour constructor(num : Int){

    init {
        println("num = $num")
    }

    constructor(num : Int,num2 :Int) : this(num){
        println(num+num2)
    }
}

/**
 * 当类的主构造函数都存在默认值时的情况
 */
class TestFive constructor(num1:Int =10,num2: Int=20){
    init {
        println("num1 = $num1 \t num2 = $num2")
    }

    constructor(num1 : Int = 1, num2 : Int = 2, num3 : Int = 3) : this(num1 , num2){
        println("num1 = $num1\t num2 = $num2 \t num3 = $num3")
    }
}


fun main() {
//    var test1 = TestOne(2)
//    var test4 = TestFour(1,2)

    var testFive = TestFive()
//    var testFive1 = TestFive
//    var testFive3 = TestFive(4,5,6)
}