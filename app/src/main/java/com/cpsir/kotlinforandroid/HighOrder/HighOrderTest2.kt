package com.cpsir.kotlinforandroid.HighOrder

import com.cpsir.kotlinforandroid.LazyTest.name3

/**
 *@author Create by cpSir on 2019/11/13
 * apply、with、run
 */

class Student(var name:String,var age:Int)

fun main() {
    /**
     * 1:let
     * 从源码let函数的结构来看它是只有一个lambda函数块block作为参数的函数,调用T类型对象的let函数，则该对象为函数的参数。
     * 在函数块内可以通过 it 指代该对象。返回值为函数块的最后一行或指定return表达式
     * 场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。
       场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用
     */
    var testLet = "testLet"
    var resultLet = testLet.let {
        print(it.length)
        "\n"+1000
    }
    print(resultLet)

    /**
     * 2:with
     * 将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。
     */
    var student = Student("cpSir",28)
    val resultWith= with(student){
        print("Student name is $name,age is $age")
    }

    /**
     * 3:run
     * 适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，
     * 准确来说它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，
     * 直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理
     */
    var student1 = Student("cpSir",28)
    val resultRun= student1.run{
        print("Student name is $name,age is $age")
    }

    /**
     * 4:apply
     * 从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，run函数是以闭包形式返回最后一行代码的值，
     * 而apply函数的返回的是传入对象的本身
     */
    var student2 = Student("cpSir",28)
    var resultApply = student2.apply {
        print("Student name is $name,age is $age")
    }
    resultApply.age=21

    /**
     * 5:also
     * also函数的结构实际上和let很像唯一的区别就是返回值的不一样，let是以闭包的形式返回，
     * 返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值。而also函数返回的则是传入对象的本身
     */
    val testAlso = "testAls"
    val resultAlso = testAlso.also {
        print(it.length)
    }
    print(resultAlso)


}