package com.cpsir.kotlinforandroid.ClassTest

/**
 *@author Create by cpSir on 2019/11/12
 * 接口
 */
interface MyInterface{
    /*抽象的,必须被重写*/
    val prop:Int

    /*可选的,不必须被重写*/
    val propertyWithImplementation: String
        get() = "foo"

    /*抽象的,必须被重写*/
    fun bar()

    /*可选方法体,不必须被重写*/
    fun foo(){
    }
}

class Child : MyInterface{
    override val prop: Int
        get() = 29

    override fun bar() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

interface Named{
    val name:String
}

interface Person : Named{
    val firstName:String
    val lastName:String

    override val name: String
        get() = "$firstName $lastName"
}

data class Employee(override val firstName: String, override val lastName: String) : Person

/**
解决覆盖冲突
**/
interface A{
    fun foo(){
        print("A")}
    fun bar()
}

interface B{
    fun foo(){
        print("B")}
    fun bar(){
        print("bar")}
}

class C:A{
    override fun bar() {
        print("bar")
    }
}


class D:A,B{
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}