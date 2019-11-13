package com.antonioleiva.weatherapp.test


/**
 *@author Create by cpSir on 2019/11/2
 * 定义继承类的关键字为：open。不管是类、还是成员都需要使用open关键字。
 *open class 类名{
...
open var/val 属性名 = 属性值
...
open fun 函数名()
...
}
 *
 */
open class Demo {
    open var num =3

    open fun foo()="foo"

    open fun bar() ="bar"
}

class DemoTest : Demo() {

}


open class User(var age:Int){
    /*能够被覆盖*/
    open fun run(){}

    /*不能被覆盖*/
    fun run2(){}

    /*允许子类重写,用open修饰*/
    open val name : String?=null
}

class Student(age:Int): User(age) {

}


/**
 * 如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数
 */
class Student1: User {
    constructor(age: Int):super(age)

    /*子类可以用 var 来重写父类 val ， 反之则不行。因为一个 val 属性本质上声明了一个 getter 方法，而将其覆盖为 var 只是在子类中额外声明一个 setter 方法。*/
    override val name: String?=null

    override fun run() {
        super.run()
    }
}

fun main() {
    println(DemoTest().num)
    println(DemoTest().foo())
    println(DemoTest().bar())

    var student = Student(100)
    var student1 = Student1(50)
    print("年龄:"+student.age)
}