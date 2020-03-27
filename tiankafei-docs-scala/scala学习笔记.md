# Scala学习

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

1. 定义方法，默认返回值为unit，也就是()

   ```scala
     def fun01(): Unit ={
       println("执行了fun01")
     }
     private val unit: Unit = fun01()
     println(unit)
   ```

2. 定义方法，返回指定类型

   ```scala
     def fun02(): Int ={
       3
     }
     private val i: Int = fun02()
     println(i)
   ```

3. 定义方法，带 return 返回的指定类型

   ```scala
     def fun03(): Int ={
       return 3
     }
     private val i1: Int = fun03()
     println(i1)
   ```

4. 定义带参数的方法

   ```scala
     def fun04(a:Int): Int = {
       3 + a
     }
     private val i2: Int = fun04(1)
     println(i2)
   ```

5. 定义递归函数的调用

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

6. 定义默认值函数

   ```scala
     def fun06(a:Int=8, b:String="abc"): Unit ={
       println(s"$a\t$b")
     }
     //第一个传值，第二个使用默认值
     private val unit1: Unit = fun06(2)
     //第一个使用默认值，第二个传值，使用参数名=参数值
     private val unit2: Unit = fun06(b="123")
   ```

7. 定义匿名函数

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

8. 嵌套函数

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

9. 偏应用函数

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

10. 可变参数

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

11. 高阶函数

    1. 函数做为参数

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

    2. 函数作为返回值

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

12. 柯里化，规整参数

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

13. 
