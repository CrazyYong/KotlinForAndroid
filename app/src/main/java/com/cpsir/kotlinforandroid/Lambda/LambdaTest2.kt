package com.cpsir.kotlinforandroid.Lambda


/**
 * 结构声明
 */
data class MyResult(val result:String,val status:Int)

fun myMethod():MyResult{
    return MyResult("Success",1)
}

fun myMethod2():Pair<String,Int>{
    return Pair("Success",1)
}

/**
 * 在kotlin中，提供了指定的接受者对象调用Lambda表达式的功能。在函数字面值的函数体中，
 * 可以调用该接收者对象上的方法而无需任何额外的限定符。它类似于扩展函数，它允你在函数体内访问接收者对象的成员。
 */
/*匿名函数作为接收者类型*/
val iop = fun Int.(other:Int):Int = this+other
val sum = fun Int.(other:Int):Int = this + other
/*Lambda表达式作为接收者类型，要用Lambda表达式作为接收者类型的前提是接收着类型可以从上下文中推断出来*/
val substract:Int.(other:Int) -> Int = {other -> this - other}
val myEquals:String.(Int) -> Boolean ={param -> this.toIntOrNull() == param}

fun main() {
    val method = myMethod()
    println(method.result)
    println(method.status)

    println("------------")
    val (result,status) = myMethod()
    println(result)
    println(status)

    println("------------")

    val (result2,status2) = myMethod2()
    println(result2)
    println(status2)


    println(1.substract(3))
    println(1.sum(2))
    println("11".myEquals(11))
    println(2.iop(3))
}