package com.antonioleiva.weatherapp.test

/**
 *@author Create by cpSir on 2019/11/2
 */


class FunTest {
    /*成员函数*/
    fun foo() {}

    /*成员函数*/
    fun defArgs(numA:Int=1,numB:Float=2f){
        println("numA = $numA,numB = $numB")
    }
}

/**
 * 1:默认参数
 */
fun defArgs(numA: Int=1,numB: Float=2f,numC:Boolean=false){
    println("numA = $numA \t numB = $numB \t numC=$numC")
}

/**
 * 2:可变数量参数
 * 当一个函数中的参数是不定数量的个数并且是同一个类型，
 * 则可是使用vararg修饰符去修饰这个变量，则被vararg修饰的参数相当于一个固定类型的数组
 *声明格式：fun 函数名(vararg 参数名 ： 类型，...) ：返回值{}
 *  /*数组传递,在传递数组的时候，需要使用伸展操作符(*)*/
 * */
fun varargFun(numA: Int,vararg str:String){
    for (s in str){
        println(s)
    }
}

/**
 * 3:单表达式函数
 * 即函数具备返回值的时候，可以省略花括号并且在=赋值符号之后指定代码体，
 * 而函数的返回值是有编辑器自动推断的。
 */
/*无参数的情况*/
fun test1() =2 //自动推断返回类型为Int
/*有参数情况*/
fun test2(num:Int) = num*2 //自动推断返回类型为Int
/*或者*/
fun test3(x:Float,y:Int=2) = x*y //和默认参数一起使用,返回值为Float类型


fun main(args: Array<String>) {
    FunTest().foo()
    FunTest().defArgs()

    defArgs()

    /*普通传递*/
    varargFun(1,"2","3","4")
    /*数组传递,在传递数组的时候，需要使用伸展操作符(*)*/
    val starArray = arrayOf("aa","bb","cc")
    varargFun(1,*starArray)

    println(test1())
    println(test2(2))
    println(test3(2f))
}