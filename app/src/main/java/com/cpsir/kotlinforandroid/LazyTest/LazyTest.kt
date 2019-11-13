package com.cpsir.kotlinforandroid.LazyTest

/**
 *@author Create by cpSir on 2019/11/13
 * 延迟初始化
 */

/*Koltin中属性在声明的同时也要求要被初始化，否则会报错*/
private var name1: String = "xiaoming"

/**
 * 1:lateinit 延迟初始化
 */
/*lateinit var 只能用来修饰类属性，
不能用来修饰局部变量，并且只能用来修饰对象，
不能用来修饰基本类型(因为基本类型的属性在类加载后的准备阶段都会被初始化为默认值)。
lateinit var的作用也比较简单，就是让编译期在检查时不要因为属性变量未被初始化而报错
*/
private lateinit var name2: String

/**
 * 2:lazy延迟初始化
 * by lazy要求属性声明为val，即不可变变量，在java中相当于被final修饰。
 * 这意味着该变量一旦初始化后就不允许再被修改值了(基本类型是值不能被修改，对象类型是引用不能被修改)。
 * {}内的操作就是返回唯一一次初始化的结果
 * by lazy可以使用于类属性或者局部变量
 */
/*by lazy本身是一种属性委托。属性委托的关键字是by。by lazy的写法如下*/
/*用于属性延迟初始化*/
val name3:Int by lazy { 1 }