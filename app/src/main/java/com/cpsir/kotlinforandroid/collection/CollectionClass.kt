package com.cpsir.kotlinforandroid.collection

/**
 *@author Create by cpSir on 2019/11/11
 */
fun main() {
    /**
     * 集合
     */
/*创建一个空的list集合，相当于 new ArrayList()*/
    var list1 = mutableListOf<String>()

/*创建一个有初始值的list集合，相当于 CollectionsKt.mutableListOf(new String[]{"a", "b", "c"})*/
    var list2 = mutableListOf("a", "b", "c")

/*创建一个空的map集合，相当于 new LinkedHashMap()*/
    var map1 = mutableMapOf<String, String>()

/*创建一个空的set集合，相当于 new LinkedHashSet()*/
    var set = mutableSetOf<String>()

/*获取值 方式一*/
    var data1 = list2[0]

/*获取值 方式二*/
    var data2 = list2.get(0)

/*添加值*/
    list1.add("d")
    list1.add(1, "e")

    /**
     * listOf()
     * 创建不可变的List
     *  fun <T> listOf(): List<T>  返回空的List
        fun <T> listOf(T): List<T> 产生一个只有一个元素的不可变列表
        fun <T> listOf(vararg T): List<T> 接受可变数量的T类型元素并生成包含这些元素的列表
     */


    /**
     * 过滤为null的情况
     */
    var list3 = mutableListOf("a","b",null) //输出结果：[a, b, null]
    var list4 = listOfNotNull("a","b",null) //输出结果：[a, b]


    /**
     * 二分查找
     * binarySearch()
     */
    var list5 = mutableListOf("a","b","c","d","e")

    /*方式一：从所有的元素中查找a元素，默认开始位置0，结束位置 size*/
    var result = list5.binarySearch("a")

    /*方式二：从指定的元素中查找a元素，默认开始位置0，结束位置 size*/
    var result1 = list5.binarySearch("a",0,list5.size)
}