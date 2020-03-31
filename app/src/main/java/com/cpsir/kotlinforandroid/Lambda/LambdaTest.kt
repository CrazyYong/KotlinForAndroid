package com.cpsir.kotlinforandroid.Lambda

import android.os.Build
import android.support.annotation.RequiresApi

/*可以参考下这个技术文章：https://www.cnblogs.com/webor2006/p/11519460.html*/

/**
Lambda的语法表示
1:Lambda表达式总是被大括号括着
2:其参数(如果存在)在 -> 之前声明(参数类型可以省略)
3:函数体(如果存在)在 -> 后面。
 */


/**
Lambda分三种情况
1. 无参数的情况 ：
val/var 变量名 = { 操作的代码 }

2. 有参数的情况
val/var 变量名 : (参数的类型，参数类型，...) -> 返回值类型 = {参数1，参数2，... -> 操作参数的代码 }
可等价于此种写法：即表达式的返回值类型会根据操作的代码自推导出来。
val/var 变量名 = { 参数1 ： 类型，参数2 : 类型, ... -> 操作参数的代码 }

3. lambda表达式作为函数中的参数的时候，这里举一个例子：
fun test(a : Int, 参数名 : (参数1 ： 类型，参数2 : 类型, ... ) -> 表达式返回类型){
...
}
 */

/**
 * 1：无参数情况
 */
/*源代码*/
fun test1(){println("无参数")}
/*lambda代码*/
val test2 ={ println("无参数")}

/**
 * 2：有参数情况
 */
/*源代码*/
fun testHaveParam(a:Int,b:Int):Int{
    return a+b
}
/*lambda代码*/
val testHaveParam :(Int,Int) -> Int ={a,b -> a+b}
/*或者*/
val testHaveParam1 = {a:Int,b:Int->a+b}

/**
 * 3:lambda表达式作为函数中的参数的时候
 */
/*源码*/
fun test3(a:Int,b:Int):Int{
    return a+b
}

fun sum(num1:Int,num2:Int):Int{
    return num1+num2
}

/*lambda方式*/
fun test4(a:Int,b:(num1:Int,num2:Int)->Int):Int{
    return a+b.invoke(3,5)
}

/**
 * 4:it
 * it并不是Kotlin中的一个关键字(保留字)。
 * it是在当一个高阶函数中Lambda表达式的参数只有一个的时候可以使用it来使用此参数。
 * it可表示为单个参数的隐式名称，是Kotlin语言约定的。
 */
val arr = arrayOf(1,3,5,7,9)

/**
 * 5:下划线 _
 * 在使用Lambda表达式的时候，可以用下划线(_)表示未使用的参数，表示不处理这个参数。
 */
val map =  mapOf("key1" to "value1","key2" to "value2","key3" to "value3")

/**
 * 6:匿名函数
    匿名函数的特点是可以明确指定其返回值类型。
    它和常规函数的定义几乎相似。他们的区别在于，匿名函数没有函数名。
 */
/*常规函数*/
fun anonymity(x:Int,y:Int) : Int = x+y
/*匿名函数*/
//fun(x : Int , y : Int) : Int = x + y
/*当返回值可以自动推断出来的时候，可以省略，和函数一样*/
val anonymit1 = fun(x:Int,y:Int) = x +y
val anonymit2 = fun(x:Int,y:Int):Int = x+y
val anonymit3 = fun(x:Int,y:Int):Int{
    return x+y
}


@RequiresApi(Build.VERSION_CODES.N)
fun main(){
    test1()
    testHaveParam(3,5)

    test3(10, sum(3,5))
    test4(10,{ num1: Int, num2: Int ->  num1 + num2 })

    /*过滤掉数组元素中小于5的元素 取其第一个打印*/
    println(arr.filter { it < 5 }.component1())

    map.forEach{ key,value -> println("$key \t $value") }
    map.forEach { _,value-> println("$value") }

    println("anonymit1:"+anonymit1(3,5))
    println("anonymit2:"+anonymit2(3,5))
    println("anonymit3:"+anonymit3(3,5))
}