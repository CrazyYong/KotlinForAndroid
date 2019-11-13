package com.antonioleiva.weatherapp.test

/**
 *@author Create by cpSir on 2019/11/2
 */


class FunTest {
    fun foo() {}

    fun defArgs(numA:Int=1,numB:Float=2f){
        println("numA = $numA,numB = $numB")
    }
}


fun main(args: Array<String>) {
    FunTest().foo()
    FunTest().defArgs()
}