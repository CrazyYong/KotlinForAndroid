package com.cpsir.kotlinforandroid.ClassTest

/**
 * 枚举类
 * 声明格式：
 * enum class 类名{
 *
 * }
**/

/**
 * 1:枚举常量
 * 枚举类中的每一个枚举常量都是一个对象
 **/

enum class State{
    /*
        NORMAL : 正常
        NO_DATA : 数据为空
        NO_INTERNET : 网络未连接
        ERROR : 错误
        OTHER : 其他
    */

    NORMAL,NO_DATA,NO_INTERNET,ERROR,OTHER
}

/**
 * 2:访问枚举常量
 * 不需要实例化枚举类就可以访问枚举常量
 * 使用方式为:枚举类名.枚举常量.属性
 *  State.NORMAL.name
    State.NO_DATA.name
    State.NO_INTERNET.name
    State.ERROR.name
    State.OTHER.name
 **/

/**
 * 3：枚举常量的初始化
 * 因为每一个枚举都是枚举类的实例，所以他们可以是初始化过的。
 */
enum class Color(var argb : Int){
    RED(0xFF0000),
    WHITE(0xFFFFFF),
    BLACK(0x000000),
    GREEN(0x00FF00)
}

/**
 * 4:枚举常量的匿名类
 * 要实现枚举常量的匿名类，则必须提供一个抽象方法（必须重写的方法）。且该方法定义在枚举类内部。而且必须在枚举变量的后面。
 * 枚举变量之间使用逗号（,）分割开。但是最后一个枚举变量必须使用分号结束。不然定义不了抽象方法。
 */
enum class ConsoleColor(var argb : Int){
    RED(0xFF0000){
        override fun print() {
            println("我是枚举常量 RED ")
        }
    },
    WHITE(0xFFFFFF){
        override fun print() {
            println("我是枚举常量 WHITE ")
        }
    },
    BLACK(0x000000){
        override fun print() {
            println("我是枚举常量 BLACK ")
        }
    },
    GREEN(0x00FF00){
        override fun print() {
            println("我是枚举常量 GREEN ")
        }
    };

    abstract fun print()
}

/**
 * 5:枚举类的使用
 * 每个枚举常量都包含两个属性：name（枚举常量名）和ordinal（枚举常量位置）
 * 提供了values()和valueOf()方法来检测指定的名称与枚举类中定义的任何枚举常量是否匹配。
 *Color.BLACK.name    Color.BLACK.ordinal
 */

/**
 * 6:使用enumValues<T>() 和 enumValueOf<T>()访问
 * enumValues<Color>().joinToString { it.name }
 * enumValueOf<Color>("RED")
 */

/**
 * 7:使用valueOf() 和values()检测
 *
 */

fun main() {
    println(State.NORMAL.name)
    ConsoleColor.BLACK.print()
    println("name="+Color.BLACK.name+"\tordinal = "+Color.BLACK.ordinal)

    println(enumValues<Color>().joinToString { it.name })
    println(enumValueOf<Color>("RED"))

    println(Color.valueOf("RED"))
    println(Color.values()[0])

}

