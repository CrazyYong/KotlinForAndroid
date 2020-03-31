package com.cpsir.kotlinforandroid.ClassTest


/**
 *@author Create by cpSir on 2019/11/14
 *
 *在申明一个 data class 有一些需要注意的事项
 * 主构造函数必须要至少有一个参数
   主构造函数中的所有参数必须被标记为val或者var
   数据类不能有以下修饰符：abstract，inner,open,sealed
   data class只能实现接口（Kotlin1.1以前的规则），现在也可以继承其它类
 */

data class Employee1(var id:Int,var name:String)


fun main() {
    /*toString()*/
    var employee = Employee1(1, "cpSir")
    print(employee)

    /*copy()*/
    var employee1 = Employee1(2, "czy")
    var employee2 = employee1.copy(id=2)
    print(employee2)
}
