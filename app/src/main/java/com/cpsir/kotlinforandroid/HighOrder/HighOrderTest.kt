package com.cpsir.kotlinforandroid.HighOrder

/**
 *@author Create by cpSir on 2019/11/13
 * 高阶函数
 *
 */

class User(var id:Int,var name:String)

val list = listOf<Int>(1,2,3,4,5,6)

fun main() {
    /**
     * 1：any
     * 只要有一个符合就返回true
     */
    val any = list.any { it > 3 }
    print(any)

    /**
     * 2：all
     * all 所有条件符合才返回true
     */
    val all = list.all { it > 3 }
    print("\n"+all)

    /**
     * 3:count
     * count 返回符合条件的数目
     */
    val count = list.count{it > 5}
    print("\n"+count)

    /**
     * 4:none
     * none 如果没有任何元素与给定的函数匹配，则返回true
     */
    val none = list.none{it > 5}
    print("\n"+none)

    /**
     * 5:max
     * max 返回最大的值，如果没有则返回null ,min同理
     */
    val maxResult = list.max()
    print("\n"+maxResult)

    /**
     * 6:min
     * min 返回最小的值，如果没有则返回null
     */
    var minResult = list.min()
    print("\n"+minResult)

    /**
     * 7:sum
     * sum 返回数据相加总数
     */
    var sum = list.sum()
    print("\n"+sum)

    /**
     * 8:drop
     * 从前面丢弃元素
     */
    var drop = list.drop(2)
    print("\n"+drop)

    /**
     * 9:dropLast
     * 从后面丢弃元素
     */
    var dropLast = list.dropLast(2)
    print("\n"+dropLast)

    /**
     * 10:groupBy分组
     * groupBy 根据函数将集合分组，返回map类型对象
     */
    var groupBy = list.groupBy { it % 2 == 0 }
    print("\n"+groupBy)

    /**
     * 11:filter
     * 过滤list,符合过滤条件的就是过滤结果
     */
    var list1 = mutableListOf(1,2,3,4)
    var filterList = list1.filter {it > 2 }
    print("\n"+filterList)

    /**
     * 12: filterNot
     * 把符合条件的过滤掉，剩下的是结果。这个操作和 filter 相反。
     */
    /*操作List*/
    var filterNot = list.filterNot { it > 2 }
    print("\n"+filterNot)

    /*操作Map*/
    var map = mutableMapOf<Int,String>()
    map.put(0,"a")
    map.put(1,"b")
    map.put(2,"c")
    var map1 = map.filterNot { it.key ==2 }
    print("\n"+map1)

    /*操作Map,filterKeys,过滤key*/
    var map2 = map.filterKeys { it == 3 }
    /*操作Map,filterValues,过滤value*/
    var map3 = map.filterValues { it == "a" }


    /**
     * 13:take,takeLast
     * 从集合中取前几个元素
     * 从集合中取后几个元素
     */
    var takeList = list.take(3)
    var takeLast = list.take(2)

    /**
     * 14：sortedBy排序
     * 在 java 中，我们要对一个list排序，需要写很多代码，但是在 kotlin 中，就简单很多了
     */
    var user1 = User(1,"张三")
    var user2 = User(3,"李四")
    var user3 = User(2,"王五")
    /*用list把三个变量装起来*/
    var userList = listOf<User>(user1,user2,user3)
    /*对 id字段进行排序,并把排序的结果赋值给 userList1*/
    var userList1 = userList.sortedBy { it.id }
    /*输出userList1*/
    userList1.forEach{
        print("\nid:$it.id -- name:${it.name}")
    }
    /*map操作符 数据结构变化，结果 [张三, 李四, 王五]*/
    var listName = userList.map { it.name }
    print("\n $listName")
    /*除此之外，还可以连续操作。比如，我们把用户名字中最后一个取出来。*/
    var lastName = userList.map { it.name }.takeLast(1)
    print("\n lastName:$lastName")




}