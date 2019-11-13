package com.cpsir.kotlinforandroid.ClassTest

import android.content.Context

/**
 *@author Create by cpSir on 2019/11/12
 * 单例模式
 */

/**
无参单例模式-线程安全
**/
object User{
    var name:String? = null
    fun run(){
        print("name:$name")
    }
}

/**
 * 懒加载单例模式-线程安全
 */
class Manager private constructor(){
    companion object{
        val instance by lazy {
            Manager()
        }
    }

    fun run(){

    }
}

/**
 * 有参单例模式-线程安全
 *
 */
open class SingletonHolder<out T:Any,in A>(creator: (A) -> T){
    private var creator:((A) -> T)?=null
    @Volatile private var instance:T?=null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }

}

class Manager2 private constructor(context: Context){
    init {
        // Init using context argument
    }

    companion object : SingletonHolder<Manager2, Context>(::Manager2)

    fun run() {
        //running now
    }

}


fun main() {
    /*调用成员变量*/
    User.name ="cpSir"
    /*调用成员函数*/
    User.run()

    /*Kolin 版本*/
    Manager.instance.run()

//    Manager2.getInstance(baseContext).run()
}
