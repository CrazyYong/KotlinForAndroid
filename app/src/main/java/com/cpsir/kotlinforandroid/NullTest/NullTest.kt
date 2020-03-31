package com.antonioleiva.weatherapp.test

/**
 *@author Create by cpSir on 2019/11/2
 */
class Test{
    /*定义一个不可为空的变量，用var修饰的变量可以被重新赋值，用val修饰的变量则不能，但是不能赋值为null*/
    /**
     * 分析：要定义一个可空类型的变量时，即在定义变量的类型后面加上?符号就行了。在使用的时候，
     * 记住要判断该段该变量是否为空，这个操作在Java中经常会用到...，
     * 如果定义一个不可为空类型的变量时，则判断将毫无意义，因为这个变量永远不会为空。
     */
    var length=0

    /*
    定义可空类型的变量,即变量可以被赋值为null
    定义格式为：修饰符 变量名 ： 类型? = 值
    */
    val testStr :String?=null

    val arrTest :Array<Int?> = arrayOf(1,2,null,3,null,5,6,null)

    var name:String?="a"

    class Builder{
        private var name:String? = "Tom"

        private var age:Int?=0

        private var sex:String?="男"

        fun setName(name :String) :Builder?{
            this.name = name
            return this
        }

        fun setAge(age :Int) :Builder?{
            this.age = age
            return this
        }

        fun setSex(sex:String):Builder?{
            this.sex = sex
            return this
        }

        override fun toString(): String {
            return "Builder(name=$name,age=$age,sex=$sex)"
        }
    }

    fun main(){
        val builder:Test.Builder ? = Test.Builder().setName("Lily")?.setSex("man")?.setAge(10)
        print(builder.toString())

        /**
         * 1:
         * let操作符
         * 当使用符号?.验证的时候忽略掉null
         * 例:排除掉数组中的空元素
         */
        for (index in  arrTest){
            index?.let {
                println("index => $it")
            }
        }

        /*let的返回值为let语句块的最后一行,所以letResult的值为ok*/
        var letList:ArrayList<Int>?=ArrayList()
        var letResult = letList?.let {
            it.add(1)
            it.add(2)
            it.add(3)
            "ok"
        }
        print("$letList -- $letResult")


        /**
         * 2:
         * ?:当我们定义了一个可空类型的变量时，如果该变量不为空，则使用，反之使用另外一个不为空的值
         * 当testStr不为空时，输出其长度，反之输出-1
         * 传统写法
         * length = if (testStr != null) testStr.length else -1
         * 分析：此操作符一般和?.操作符连用。当且仅当?:左边的表达式为null时，才会执行?:右边的表达式。
         */
        length = testStr?.length?:-1


        /**
         * 3:
         * !!操作符
         * !!操作符可谓是给爱好空引用异常（NullPointException）的开发者使用，因为在使用一个可空类型变量时，在该变量后面加上!!操作符，会显示的抛出NullPointException异常
         * val testStr:String?=null
         * testStr!!.length
         */
        val testStr:String?=null
        testStr!!.length//会抛出异常

        /**
         * 4:
         * as?操作符
         * 其实这里是指as操作符，表示类型转换，如果不能正常转换的情况下使用as?操作符。
         * 当使用as操作符的使用不能正常的转换的情况下会抛出类型转换（ClassCastException）异常，而使用as?操作符则会返回null,但是不会抛出异常
         */
        val num2 : Int? = "Koltin" as? Int
        print("num2 = $num2")

        /**
         * 5:
         * ?.操作符
         * 方法可空处理
         * 在 java 中我们在调用对象方法的时候，如果对象为空，就出现 NullPointerException 错误，
         * 在 kotlin 中为了避免这个问题，引入了 ?. 符号，来表示如果对象为空，就不执行这个方法。
         */
        /*当 name 为空的时候，代码 name?.length 不执行，完美了避开了空指针陷阱*/
        run()

        /**
         * 6:
         * 可空类型的集合
         * 如果你有一个可空类型元素的集合，并且想要过滤非空元素，你可以使用 filterNotNull 来实现：
         */
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
    }

    fun run(){
        name = null
        var size = name?.length
    }

}