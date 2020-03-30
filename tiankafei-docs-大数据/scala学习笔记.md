# Scala学习

## 分享一个学习scala基础语法的网站

```http
https://www.runoob.com/scala/scala-tutorial.html
```

## 所有的值都是一个对象

## 所有的方法都是一个值

## Scala关键字解释

### object

声明一个静态类，里面有入口的执行方法，里面的属性也都是静态的。可以直接通过类名加属性名进行访问。

### class

声明一个对象类，通过new创建一个对象。只能通过对象访问里面的方法和属性。

### val

用来声明属性的关键字，是静态且不能改变的，相当于java中的final static。如果不指定数据类型，可以根据赋的值进行自动推断

### var

用来声明属性的关键字，是动态属性且可以改变的。如果不指定数据类型，可以根据赋的值进行自动推断

```scala
# 不指定类型：(var 可同时换成val)
var a1 = 0
var a2 = 0.0
var a3 = 0.0f
var b1 = "123"

# 指定类型：(var 可同时换成val)
var a1:Int = 0
var a2:Double = 0.0
var a3:Float = 0.0f
var b1:String = "123"
```

### println

可以直接使用 println 进行打印输入

### s

字符串拼接问题，可直接使用 s 和 $属性名 进行拼接。例如：

```scala
# 字符串前面加s之后，在字符串中间如果要拼接变量可以直接使用$属性名的方式进行字符串拼接，如果$属性名在前面或者中间，要紧跟一个空格
println(s"$name 这是主方法上面定义的输入$name")
```

### 其他问题

​		在scala中，文件名不具有任何含义。在同一个包下面，同一个object类型的名字只能出现一次，同一个calss类型的名字也只能出现一次，但是object和class的名字是可以一样。

## Scala语法剖析

### private和private[this]

```scala
// 只能在当前文件内部，通过对象进行访问
private var name = "123456";

// 只能在类内部使用，对象都不能直接使用
private[this] var age = 10;
```

### 定义一个入口方法

```scala
# 定义一个包路径，同java的方式一样
package cn.tiankafei.bigdata.scala

# object 声明一个静态类的关键字
# FirstScala 静态类的类名
object FirstScala {

  # def 声明方法的关键字
  # main 方法的名称
  # args 方法的参数
  # Array 方法参数的类型
  # String 方法参数类型由于是数组，支持泛型，里面存放的String类型的数据
  # Unit 无任何意义的返回值类型，属于scala基本数据类型的一种
  def main(args: Array[String]): Unit = {

  }

}

```

### 静态类的执行流程

```scala
package cn.tiankafei.bigdata.scala

object FirstScala {

  var name = 1

  println(s"$name 这是主方法上面定义的输入$name")

  def main(args: Array[String]): Unit = {
    println(s"$name 这是主方法里面定义的输入${name+2}")
  }

  println(s"$name 这是主方法下面定义的输入${name + 1}")

}

```

执行结果

```
1 这是主方法上面定义的输入1
1 这是主方法下面定义的输入2
1 这是主方法里面定义的输入3
```

分析：优先执行类里面的代码块，从上玩下依次执行，然后执行主方法的调用。类里面的代码块相当于java中的静态语句块，会早于方法优先执行。

### 静态类加对象类一起的执行流程

```scala
package cn.tiankafei.bigdata.scala

object FirstScala {

  var name = 1

  println(s"$name 这是主方法上面定义的输入$name")

  private val scala = new FirstScala()

  def main(args: Array[String]): Unit = {
    scala.getMessage()
    println(s"$name 这是主方法里面定义的输入${name+2}")
  }

  println(s"$name 这是主方法下面定义的输入${name + 1}")

}

class FirstScala {

  var name1 = "abc"

  println(s"$name1 这是主方法上面定义的输入$name1")

  def getMessage(): Unit = {
    println(s"$name1 这是主方法里面定义的输入${name1+2}")
  }

  println(s"$name1 这是主方法下面定义的输入${name1 + 1}")

}
```

执行结果

```
1 这是主方法上面定义的输入1
abc 这是主方法上面定义的输入abc
abc 这是主方法下面定义的输入abc1
1 这是主方法下面定义的输入2
abc 这是主方法里面定义的输入abc2
1 这是主方法里面定义的输入3
```

依然按照上述的执行流程，因为class类对象在object的代码块中new了以下，所以在new的时候，会执行class类对象里面的代码块。当主方法调用了class对象的 getMessage 方法时，才会真正执行 getMessage 里面的内容

### 默认无参构造

```scala
class FirstScala {

  var name1 = "abc"

  def this(name2:String) {
    # 其他构造方法必须显示的调用一次无参的类名构造
    this()
    name1 = name2
  }

  println(s"$name1 这是主方法上面定义的输入$name1")

  def getMessage(): Unit = {
    println(s"$name1 这是主方法里面定义的输入${name1+2}")
  }

  println(s"$name1 这是主方法下面定义的输入${name1 + 1}")

}
```

### 覆盖无参构造

```scala
class FirstScala(name3:String) {

  var name1 = "abc"

  def this(name2:Int) {
    this("")
    name1 = s"外部传参$name2"
  }

  def this(){
    this("无参构造调用类名构造")
  }

  println(s"$name1 这是主方法上面定义的输入$name1")

  def getMessage(name2:String): Unit = {
    println(s"这是name1的值：$name1")
    println(s"这是name2的值：$name2")
    println(s"这是name3的值：$name3")
  }

  println(s"$name1 这是主方法下面定义的输入${name1 + 1}")

}
```

构造方法 this后面跟的参数和定义的方法后面跟的参数默认且只能是val类型（静态，且不能改变）。类名后面跟的参数，默认为 val 类型，也可以显示的声明为 var 类型，这个构造就是覆盖的原本的无参构造，此时如果依然想要无参构造，那么需要再新写一个无参的 this 构造，然后显示的调用类名的那个构造。

### 属性声明的注意事项

1. this 构造方法里面的参数 和 方法里面的参数声明时，必须指定参数类型，否则在调用的时候，不知道传什么类型的参数，默认且只能是val类型（静态且不能改变）。
2. 类名构造方法里面的参数声明时，也必须指定参数类型，否则在调用的时候，不知道传什么类型的参数，默认为 val 类型，也可以显示的声明为 var 类型。
3. object里面的属性和方法，必须通过object类名进行调用；class里面的属性和方法，必须通过对象进行调用。

### i++

scala中的++是一个方法，所以不能使用i++的方式，要想实现i++的话，可以使用i+=1，或者i=i+1

### for

1. 不再支持for (int i = 0; i < 10; i++) 这种形式

2. 可以使用 val inclusive = 1 to 10 声明一个从1到10的集合。1 to 10（从1到10，包含10），1 until 10（从1到10，且不包含10），1 to (10, 2)（从1到10，步长为2）

3. 对集合进行遍历

   1. ```scala
      val inclusive = 1 to 10
      for (i <- inclusive) println(i)
      ```

   2. ```scala
      for (i <- 1 to 10) println(i)
      ```

   3. ```scala
      for (i <- 1 to (10,2)) println(i)
      ```

   4. 没有 break 和 continue 关键字，可以通过这种形式进行跳出或继续（一个循环逻辑，一个业务逻辑）

      ```scala
      for (i <- 1 to 10 if(i <= 6)) println(i)
      ```

   5. 使用 for 测试九九乘法表

      ```scala
          var count = 0
          for (i <- 1 to 9) {
            for (j <- 1 to 9){
              count+=1
              if(j <= i) print(s"$i * $j = ${i*j}\t")
              if(j == i) println()
            }
          }
          println(count)
      ```

      ```scala
          var count = 0
          for (i <- 1 to 9; j <- 1 to 9){
            count+=1
            if(j <= i) print(s"$i * $j = ${i*j}\t")
            if(j == i) println()
          }
          println(count)
      ```

      ```scala
          var count = 0
          for (i <- 1 to 9; j <- 1 to 9 if(j <= i)){
            count+=1
            if(j <= i) print(s"$i * $j = ${i*j}\t")
            if(j == i) println()
          }
          println(count)
      ```

   6. 收集遍历的结果集

      ```scala
          val unit = for (i <- 1 to (10,2)) yield {
            i + i
          }
          for (i <- unit) println(i)
      ```

### 定义方法函数

#### 定义方法，默认返回值为unit，也就是()

```scala
  def fun01(): Unit ={
    println("执行了fun01")
  }
  private val unit: Unit = fun01()
  println(unit)
```

#### 定义方法，返回指定类型

```scala
  def fun02(): Int ={
    3
  }
  private val i: Int = fun02()
  println(i)
```

#### 定义方法，带 return 返回的指定类型

```scala
  def fun03(): Int ={
    return 3
  }
  private val i1: Int = fun03()
  println(i1)
```

#### 定义带参数的方法

```scala
  def fun04(a:Int): Int = {
    3 + a
  }
  private val i2: Int = fun04(1)
  println(i2)
```

#### 定义递归函数的调用

```scala
  def fun05(num:Int): Int = {
    if(num == 1){
      1
    }else{
      num * fun05(num - 1)
    }
  }
  private val i3: Int = fun05(4)
  println(i3)
```

#### 定义默认值函数

```scala
  def fun06(a:Int=8, b:String="abc"): Unit ={
    println(s"$a\t$b")
  }
  //第一个传值，第二个使用默认值
  private val unit1: Unit = fun06(2)
  //第一个使用默认值，第二个传值，使用参数名=参数值
  private val unit2: Unit = fun06(b="123")
```

#### 定义匿名函数

函数是第一类值；

函数的签名：(Int, Int) => Int

函数的实现：(a:Int, b:Int) => {a+b}

```scala
  private val y: (Int, Int) => Int = (a:Int, b:Int) => {
    a + b
  }
  private val i4: Int = y(2, 5)
  println(i4)
```

#### 嵌套函数

定义到类里面的方法，定义到方法里面的叫函数，子作用于的函数能看到父作用域的参数和属性

```scala
  def fun07(a:String): Unit = {
    def fun06(): Unit ={
      println(s"这是fun07里面的fun06：$a")
    }
    fun06()
  }
  fun07("hell0")
```

#### 偏应用函数

```scala
  def fun08(date:Date, tp:String, msg:String): Unit ={
    println(s"$date\t$tp\t$msg")
  }
  // 直接调用
  fun08(new Date(), "info", "OK")
  // 再次封装函数info
  var info = fun08(_:Date, "info", _:String)
  // 再次封装函数error
  var error = fun08(_:Date, "error", _:String)

  info(new Date(), "这是一个成功的日志")
  error(new Date(), "这是一个错误的日志")
```

#### 可变参数

```scala
  def fun09(a:Int*): Unit ={
    for (i <- a) println(i)

//    匿名函数：(a:Int) => {}
//    签名：(f:Int)
//    函数具体实现：{}
//    (f:Int) => {}
//    正常的匿名函数应该这样写：
//    a.foreach( (x:Int)=> { println(x) })
//    匿名函数，当参数在函数体当中只会使用一次的时候，可以简写为以下的方式：
//    a.foreach( println(_))
//    foreach要接收一个函数，而println正好是一个函数，可以再次简写为以下的方式：
    a.foreach( println )
  }
  fun09(1,2,3,4)
```



#### 高阶函数：函数做为参数

```scala
  def computer(a:Int, b:Int, f:(Int,Int) => Int): Unit = {
    val i5 = f(a, b)
    println(i5)
  }
  computer(3, 8, (x:Int, y:Int) => {x+y})
  computer(3, 8, (x:Int, y:Int) => {x*y})
  //当参数的顺序，和后面使用的顺序一样的时候，可以使用以下面的语法糖
  computer(3, 8, _+_)
  computer(3, 8, _*_)
```

#### 高阶函数：函数作为返回值

```scala
  def factory(i:String): (Int, Int) => Int = {
    def add(x:Int, y:Int): Int ={
      x+y
    }
    def sub(x:Int, y:Int): Int ={
      x-y
    }
    def mul(x:Int, y:Int): Int ={
      x*y
    }
    def div(x:Int, y:Int): Int ={
      x/y
    }
    def mod(x:Int, y:Int): Int ={
      x%y
    }
    def default(x:Int, y:Int): Int ={
      -1
    }

    if(i.equals("+")){
      add
    }else if(i.equals("-")){
      sub
    }else if(i.equals("*")) {
      mul
    }else if(i.equals("/")){
      div
    }else if(i.equals("%")){
      mod
    }else{
      default
    }
  }
  computer(3, 8, factory("+"))
  computer(3, 8, factory("-"))
  computer(3, 8, factory("*"))
  computer(3, 8, factory("/"))
  computer(3, 8, factory("%"))
  computer(3, 8, factory("="))
```

#### 柯里化，规整参数

```scala
  def fun10(a:Int)(b:Int)(c:String): Unit ={
    println(s"$a\t$b\t$c")
  }
  fun10(3)(8)("asfdsa")

  def fun11(a:Int*)(b:String*): Unit ={
    a.foreach(println)
    b.foreach(println)
  }
  fun11(1,2,3)("a","b","c");
```

### 集合

#### 操作符的区别

##### ++

无论操作符左右是否是可变的集合，通过++之后，原集合没有变化，会进行集合合并，产生一个新的集合。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")

    val result1 = list01 ++ list02
    println(s"result1的结果$result1\tlist01的值$list01\tlist02的值$list02")

    val result2 = list01 ++ listBuffer02
    println(s"result2的结果$result2\tlist01的值$list01\tlistBuffer02的值$listBuffer02")

    val result3 = listBuffer01 ++ list02
    println(s"result3的结果$result3\tlistBuffer01的值$listBuffer01\tlist02的值$list02")

    val result4 = listBuffer01 ++ listBuffer02
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01\tlistBuffer02的值$listBuffer02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result1的结果List(1, 2, 3, 11, 22, 33)	list01的值List(1, 2, 3)	list02的值List(11, 22, 33)
result2的结果List(1, 2, 3, 11, 22, 33)	list01的值List(1, 2, 3)	listBuffer02的值ListBuffer(11, 22, 33)
result3的结果ListBuffer(1, 2, 3, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3)	list02的值List(11, 22, 33)
result4的结果ListBuffer(1, 2, 3, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3)	listBuffer02的值ListBuffer(11, 22, 33)
```

##### ++：

无论操作符左右是否是可变的集合，通过++:之后，原集合没有变化，会进行集合合并，产生一个新的集合。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")

    val result1 = list01 ++: list02
    println(s"result1的结果$result1\tlist01的值$list01\tlist02的值$list02")

    val result2 = list01 ++: listBuffer02
    println(s"result2的结果$result2\tlist01的值$list01\tlistBuffer02的值$listBuffer02")

    val result3 = listBuffer01 ++: list02
    println(s"result3的结果$result3\tlistBuffer01的值$listBuffer01\tlist02的值$list02")

    val result4 = listBuffer01 ++: listBuffer02
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01\tlistBuffer02的值$listBuffer02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result1的结果List(1, 2, 3, 11, 22, 33)	list01的值List(1, 2, 3)	list02的值List(11, 22, 33)
result2的结果ListBuffer(1, 2, 3, 11, 22, 33)	list01的值List(1, 2, 3)	listBuffer02的值ListBuffer(11, 22, 33)
result3的结果List(1, 2, 3, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3)	list02的值List(11, 22, 33)
result4的结果ListBuffer(1, 2, 3, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3)	listBuffer02的值ListBuffer(11, 22, 33)
```

##### ++=

操作符左右的集合必须是可变集合（如果写成了不变的集合，编译器就会提示报错），右侧跟不变的或者可变的集合都可以。此时改变的是左侧可变的集合。此时如果用一个新变量接收，那么就和左侧的集合一样了。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")

    val result3 = listBuffer01 ++= list02
    println(s"result3的结果$result3\tlistBuffer01的值$listBuffer01\tlist02的值$list02")
    println("====================================")
    val result4 = listBuffer01 ++= listBuffer02
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01\tlistBuffer02的值$listBuffer02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result3的结果ListBuffer(1, 2, 3, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3, 11, 22, 33)	list02的值List(11, 22, 33)
====================================
result4的结果ListBuffer(1, 2, 3, 11, 22, 33, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3, 11, 22, 33, 11, 22, 33)	listBuffer02的值ListBuffer(11, 22, 33)
```

##### ++=：

操作符右侧的集合必须是可变集合（如果写成了不变的集合，编译器就会提示报错），左侧跟不变的或者可变的集合都可以。此时改变的是右侧可变的集合。此时如果用一个新变量接收，那么就和右侧的集合一样了。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")
    val result2 = list01 ++=: listBuffer02
    println(s"result2的结果$result2\tlist01的值$list01\tlistBuffer02的值$listBuffer02")
    println("====================================")
    val result4 = listBuffer01 ++=: listBuffer02
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01\tlistBuffer02的值$listBuffer02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result2的结果ListBuffer(1, 2, 3, 11, 22, 33)	list01的值List(1, 2, 3)	listBuffer02的值ListBuffer(1, 2, 3, 11, 22, 33)
====================================
result4的结果ListBuffer(1, 2, 3, 1, 2, 3, 11, 22, 33)	listBuffer01的值ListBuffer(1, 2, 3)	listBuffer02的值ListBuffer(1, 2, 3, 1, 2, 3, 11, 22, 33)
```

##### +=

单值插入尾部，操作符左侧的必须是一个可变的集合（如果写了不变的集合，编译期就会报错），操作符右侧必须是同类型的单值（如果不是单值或者不是同类型的单值，编译器就会报错），最终会改变左侧的集合（在后面追加一个单值）。此时如果用一个新变量接收，那么就和左侧的集合一样了。

```scala
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")
    val result3 = listBuffer01 += 4
    println(s"result3的结果$result3\tlistBuffer01的值$listBuffer01")
    println("====================================")
    val result4 = listBuffer01 += 4
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01")
```

```
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result3的结果ListBuffer(1, 2, 3, 4)	listBuffer01的值ListBuffer(1, 2, 3, 4)
====================================
result4的结果ListBuffer(1, 2, 3, 4, 4)	listBuffer01的值ListBuffer(1, 2, 3, 4, 4)
```

##### +=:

单值插入头部，操作符右侧的必须是一个可变的集合（如果写了不变的集合，编译期就会报错），操作符左侧必须是同类型的单值（如果不是单值或者不是同类型的单值，编译器就会报错），最终会改变右侧的集合（在前面追加一个单值）。此时如果用一个新变量接收，那么就和右侧的集合一样了。

```scala
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")
    val result3 = 0 +=: listBuffer01
    println(s"result3的结果$result3\tlistBuffer01的值$listBuffer01")
    println("====================================")
    val result4 = 0 +=: listBuffer01
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01")
```

```
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result3的结果ListBuffer(0, 1, 2, 3)	listBuffer01的值ListBuffer(0, 1, 2, 3)
====================================
result4的结果ListBuffer(0, 0, 1, 2, 3)	listBuffer01的值ListBuffer(0, 0, 1, 2, 3)
```

##### --=

左侧必须是一个可变集合（如果写了不变集合，编译期就会报错），右侧是不是可变集合都可以。从左侧集合中删除右侧集合中的元素，会改变左侧集合的值（删除从左至右第一次出现的值）。此时如果用一个新变量接收，那么就和左侧的集合一样了。

```scala
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(1,2,11, 22, 33)
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")
    val result4 = listBuffer01 --= listBuffer02
    println(s"result4的结果$result4\tlistBuffer01的值$listBuffer01\tlistBuffer02的值$listBuffer02")
```

```
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(1, 2, 11, 22, 33)
====================================
result4的结果ListBuffer(3)	listBuffer01的值ListBuffer(3)	listBuffer02的值ListBuffer(1, 2, 11, 22, 33)
```

##### -=

左侧必须是一个可变集合（如果写了一个不变的集合，编译期就会报错），右侧必须是一个同类型的单值（如果不是单值或者不是同类型的单值，编译期就会报错）。从左侧集合当中删除指定元素，会改变左侧集合的值（删除从左至右第一次出现的值）。此时如果用一个新变量接收，那么就和左侧的集合一样了。

```scala
    //可变集合01
    val listBuffer01 = ListBuffer(1, 1, 2, 3)
    println(s"listBuffer01的值$listBuffer01")
    println("====================================")
    val result3 = listBuffer01 -= 1
    println(s"result3的结果$result3\tlistBuffer01的值$listBuffer01")
```

```
listBuffer01的值ListBuffer(1, 1, 2, 3)
====================================
result3的结果ListBuffer(1, 2, 3)	listBuffer01的值ListBuffer(1, 2, 3)
```

##### +：

一般用于单值头部插入集合，如果左侧值是一个集合，则这个集合作为第一个元素插入到右侧的集合当中。通过+:之后，原集合没有变化，产生一个新的集合。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")

    val result1 = 0 +: list01
    println(s"result1的结果$result1\tlist01的值$list01")

    val result2 = 0 +: listBuffer01
    println(s"result2的结果$result2\tlistBuffer01的值$listBuffer01")

    val result3 = 0 +: list02
    println(s"result3的结果$result3\tlist02的值$list02")

    val result4 = 0 +: listBuffer02
    println(s"result4的结果$result4\tlistBuffer02的值$listBuffer02")
    println("====================================")

    val result5 = list01 +: list02
    println(s"result5的结果$result5\tlist01的值$list01\tlist02的值$list02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result1的结果List(0, 1, 2, 3)	list01的值List(1, 2, 3)
result2的结果ListBuffer(0, 1, 2, 3)	listBuffer01的值ListBuffer(1, 2, 3)
result3的结果List(0, 11, 22, 33)	list02的值List(11, 22, 33)
result4的结果ListBuffer(0, 11, 22, 33)	listBuffer02的值ListBuffer(11, 22, 33)
====================================
result5的结果List(List(1, 2, 3), 11, 22, 33)	list01的值List(1, 2, 3)	list02的值List(11, 22, 33)
```

##### :+

一般用于单值尾部插入集合，如果右侧值是一个集合，则这个集合作为最后一个元素插入到左侧的集合当中。通过:+之后，原集合没有变化，产生一个新的集合。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    //可变集合01
    val listBuffer01 = ListBuffer(1, 2, 3)
    //可变集合02
    val listBuffer02 = ListBuffer(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println(s"listBuffer01的值$listBuffer01")
    println(s"listBuffer02的值$listBuffer02")
    println("====================================")

    val result1 = list01 :+ 4
    println(s"result1的结果$result1\tlist01的值$list01")

    val result2 = listBuffer01 :+ 4
    println(s"result2的结果$result2\tlistBuffer01的值$listBuffer01")

    val result3 = list02 :+ 4
    println(s"result3的结果$result3\tlist02的值$list02")

    val result4 = listBuffer02 :+ 4
    println(s"result4的结果$result4\tlistBuffer02的值$listBuffer02")
    println("====================================")

    val result5 = list01 :+ list02
    println(s"result5的结果$result5\tlist01的值$list01\tlist02的值$list02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
listBuffer01的值ListBuffer(1, 2, 3)
listBuffer02的值ListBuffer(11, 22, 33)
====================================
result1的结果List(1, 2, 3, 4)	list01的值List(1, 2, 3)
result2的结果ListBuffer(1, 2, 3, 4)	listBuffer01的值ListBuffer(1, 2, 3)
result3的结果List(11, 22, 33, 4)	list02的值List(11, 22, 33)
result4的结果ListBuffer(11, 22, 33, 4)	listBuffer02的值ListBuffer(11, 22, 33)
====================================
result5的结果List(1, 2, 3, List(11, 22, 33))	list01的值List(1, 2, 3)	list02的值List(11, 22, 33)
```

##### ::

单值插入头部，操作符右侧的必须是一个不变的集合（如果写了可变的集合，编译期就会报错），操作符左侧必须是同类型的单值（如果不是单值或者不是同类型的单值，编译器就会报错）。通过++之后，原集合没有变化，会进行集合合并，产生一个新的集合（如果左侧是一个不变的集合，则左侧集合作为第一个元素插入到最终的结果当中）。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println("====================================")

    val result1 = 0 :: list02
    println(s"result1的结果$result1\tlist02的值$list02")

    val result3 = list01 :: list02
    println(s"result3的结果$result3\tlist01的值$list01\tlist02的值$list02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
====================================
result1的结果List(0, 11, 22, 33)	list02的值List(11, 22, 33)
result3的结果List(List(1, 2, 3), 11, 22, 33)	list01的值List(1, 2, 3)	list02的值List(11, 22, 33)
```

##### :::

集合合并，操作符左右两侧都必须是一个不变的集合（如果是可变的集合或者是一个单值，编译期就会报错）。通过:::之后，原集合没有变化，会进行集合合并，产生一个新的集合。

```scala
    //不可变集合01
    val list01 = List(1, 2, 3)
    //不可变集合02
    val list02 = List(11, 22, 33)
    println(s"list01的值$list01")
    println(s"list02的值$list02")
    println("====================================")

    val result3 = list01 ::: list02
    println(s"result3的结果$result3\tlist01的值$list01\tlist02的值$list02")
```

```
list01的值List(1, 2, 3)
list02的值List(11, 22, 33)
====================================
result3的结果List(1, 2, 3, 11, 22, 33)	list01的值List(1, 2, 3)	list02的值List(11, 22, 33)
```

##### 图片总结

![scala操作符](./images/scala操作符.png)

#### 使用java语言中的LinkedList

```scala
    val strings = new util.LinkedList[String]()
    strings.add("111")
    strings.add("222")
    strings.forEach(println)
```

#### 数组

```scala
    //    java泛型是<>，scala中是[]，所以数组用(n)
    //    val 约等于 final 不可变描述的是：val指定的引用的值
    //    数组
    val arr01 = Array[Int](1, 2, 3, 4)
    arr01(1) = 99
    println(arr01(1))
    for (elem <- arr01) {
      println(elem)
    }
    // 遍历元素，需要函数接收元素
    arr01.foreach(println)
```

#### 链表

```scala
    //    链表
    // scala中collections中有2个包，immutable,mutable，默认是不可变的immutable
    val list01 = List(1, 2, 3, 4, 1, 3, 2, 4, 2, 1)
    for (i <- list01) println(i)
    list01.foreach(println)

    // 可变的list
    val list02 = new ListBuffer[Int]()
    list02.+=(33)
    list02.+=(34)
    list02.+=(35)
    list02.+=(36)
    list02.+=(37)
    list02.foreach(println)
```

#### set

```scala
    // 默认不可变
    val set01 = Set(1, 2, 3, 4, 3, 2, 1)
    for (e <- set01) println(e)
    set01.foreach(println)
    println("----------------------")

    // 导入可变的
    import scala.collection.mutable.Set
    val set02 = Set(11, 22, 33, 11, 22)
    set02.add(44)
    set02.add(33)
    set02.foreach(println)

    // 再次使用不可变的
    val set03 = scala.collection.immutable.Set(111, 222, 333, 111)
    set03.foreach(println)
```

#### tuple

```scala
    val tuple2 = new Tuple2(111, "abc")
    val tuple3 = Tuple3(3, "asfdas", "dsgfd")
    val tuple4 = (1, 2, 3, 4)
    val tuple = ((a:Int) => a+8, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22)
    println(tuple2._1)
    println(tuple4._3)
    println(tuple._1(11))
    println(tuple._1)
    println("tuple----------------------")
```

#### map

```scala
    // 不可变map
    val map01 = Map( ("a", 33), "b"->22, ("c",42), ("a", 333) )
    println(map01.get("a").getOrElse("hello world"))
    println(map01.get("w").getOrElse("hello world"))

    val keys = map01.keys
    for (key <- keys) {
      println(s"key：$key\tvalue=${map01.get(key).get}")
    }

    // 可变map
    val map02 = scala.collection.mutable.Map( ("a","b"), ("c","d") )
    map02.put("e","f")
    println(map02.get("a").get)
    println(map02.get("s").getOrElse("hello world"))
    val keys1 = map02.keys
    for (key <- keys1) {
      println(s"key：$key\tvalue=${map02.get(key).get}")
    }
    println("map----------------------")
```

#### 类java的StreamAPI

```scala
    val list = List("hello world", "hello mashibing", "goog idea")
    val flatMap = list.flatMap(_.split(" ")).map((_, 1))
    flatMap.foreach(println)
    println("list直接调用--------------------------------")

    val map = list.iterator.flatMap(_.split(" ")).map((_, 1))
    map.foreach(println)
    println("list的迭代器调用--------------------------------")
```

##### iterator迭代器模式





### 继承：trait   with

```scala
object TestExtends {

  def main(args: Array[String]): Unit = {
    val p = new Dog("abc");
    p.test()
    p.test1()
    p.test2()
    p.test3()
  }
  trait Dog3 {
    def test3(): Unit ={
      println("执行了test3方法")
    }
  }
  trait Dog2 {
    def test2(): Unit ={
      println("执行了test2方法")
    }
  }
  trait Dog1 {
    def test1(): Unit ={
      println("执行了tes1方法")
    }
  }
  class Dog(name:String) extends Dog1 with Dog2 with Dog3 {
    def test(): Unit ={
      println(s"执行了test方法$name")
    }
  }

}
```

### lombok增强版：case

相当于java中的lombok，会自动生成toString，hashcode，equals等方法

```scala
object TestCaseClass {

  def main(args: Array[String]): Unit = {
    val person1 = new Person1("张三", 22)
    val person2 = new Person1("张三", 22)
    println(person1.equals(person2))
    println(person1 == person2)

    val person3 = Person2("张三", 22)
    val person4 = Person2("张三", 22)
    println(person3.equals(person4))
    println(person3 == person4)
  }

  case class Person2(name:String, age:Int) {
    println(s"name值为$name,age值为$age")
  }

  class Person1(name:String, age:Int) {
    println(s"name值为$name,age值为$age")
  }

}
```

### switch增强版：match

java中switch的增强版；match，只要上面的匹配到了，下面的就不会在匹配了

```scala
object TestMatch {

  def main(args: Array[String]): Unit = {
    val tuple = (1.0, 88, "abc", false)

    val iterator = tuple.productIterator

    val res = iterator.map((x) => {
      x match {
        case x: Int => x + 99
        case x: Double => x + 100
        case x: String => x + "def"
        case x: Boolean => !x
        case false => false
        case 1 => 1 + 100
        case _ => x
      }
    })
//    res.foreach(println)

    while (res.hasNext) {
      println(res.next())
    }
  }

}
```

### Lambda中的单进单出的Function的增强版

```scala
object TestPartiaFunction {

  def main(args: Array[String]): Unit = {

    def xxx:PartialFunction[ Any, Any ] = {
      case x:String => s"$x 你好"
      case 44 => 44 * 2
      case _  => "none"
    }
    println(xxx("张三"))
    println(xxx(44))
    println(xxx(45))
  }

}
```

### 隐式方法转换

implicit 方法的参数必须是精确匹配的类型

```scala
object TestImplicitMethod {

  def main(args: Array[String]): Unit = {
    implicit def cgfdghda[T](list: util.ArrayList[T]): xxx[T] ={
      val iter:util.Iterator[T] = list.iterator()
      new xxx(iter)
    }
    implicit def asfdasdfs[T](list: util.LinkedList[T]): xxx[T] ={
      val iter:util.Iterator[T] = list.iterator()
      new xxx(iter)
    }
    val linkedList = new util.LinkedList[Int]()
    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)
    val listXXX = new xxx[Int](linkedList.iterator())
    listXXX.foreach(println)
    println("listXXX.foreach(println)--------------------------")
    linkedList.foreach(println)
    println("linkedList.foreach(println)--------------------------")

    val arrayList = new util.ArrayList[Int]()
    arrayList.add(11)
    arrayList.add(22)
    arrayList.add(33)
    val arrayXXX = new xxx[Int](arrayList.iterator())
    arrayXXX.foreach(println)
    println("arrayXXX.foreach(println)--------------------------")
    arrayList.foreach(println)
    println("arrayList.foreach(println)--------------------------")
  }

  class xxx[T](list: util.Iterator[T]) {
    def foreach(f: (T) => Unit): Unit = {
      while (list.hasNext) {
        f(list.next())
      }
    }
  }

}
```

### 隐式属性转换

```scala
object TestImplicitField {

  def main(args: Array[String]): Unit = {

    implicit val fdasfdasfdasf:String = "lisi"
    def ooxx1(implicit name:String): Unit ={
      println(name)
    }
    ooxx1("zhangsan")
    ooxx1
    println("-----------------------------")
    implicit val sfdasfas:Int = 22
    def ooxx2(implicit name:String, age:Int): Unit ={
      println(s"$name\t$age")
    }
    ooxx2("abc", 33)
    ooxx2
    println("-----------------------------")
    def ooxx3(age:Int)(implicit name:String): Unit ={
      println(s"$name\t$age")
    }
    ooxx3(22)("abc")
    ooxx3(12)
  }

}

```

