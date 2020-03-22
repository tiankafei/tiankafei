# java基础

## 特殊关键字解释

| 关键字                            | 描述                                                         |
| --------------------------------- | ------------------------------------------------------------ |
| default                           | 默认，1.用在switch语句中，表明一个默认的分支；2.接口的默认实现 |
| do                                | 用在do-while循环结构中                                       |
| const                             | 保留关键字，没有具体含义                                     |
| goto                              | 保留关键字，没有具体含义                                     |
| instanceof                        | 用来测试一个对象是否是指定类型的实例对象                     |
| native                            | 用来声明一个方法是由与计算机相关的语言（如C/C++/FORTRAN语言）实现的 |
| transient                         | 声明不用序列化的成员域                                       |
| volatile                          | 内存屏障：1.保证不同线程之间的可见性（引用类型除外）；2.禁止指令重排序 |
| <font color="red">strictfp</font> | <font color="red">用来声明FP_strict（单精度或双精度浮点数）表达式遵循[IEEE 754](https://baike.baidu.com/item/IEEE 754)算术规范 [1]</font> |

## java集合

### ArrayList

![ArrayList](.\images\ArrayList.png)

1. 在不指定初始容量的时候，默认初始容量为10

2. 集合的本质依然是数组，当数组长度不够时，会自动触发扩容（当数据的长度大于数组的长度时会自动触发扩容机制）：

   ```java
   //oldCapacity >> 1 右移运算符 原来长度的一半 再加上原长度
   int newCapacity = oldCapacity + (oldCapacity >> 1);
   ```

   扩容是原来的数组长度的1.5倍，扩容之后就是把老数组的数据 copy 到新数组中。

### Vector

![Vector](.\images\Vector.png)

1. 是线程安全的，与操作元素相关的方法都加上了锁，所以是线程安全的，但是性能较低。

2. 在不指定初始容量的时候，默认初始容量为10。

3. 集合的本质依然是数组，当数组长度不够时，会自动触发扩容（当数据的长度大于数组的长度时会自动触发扩容机制）：

   ```java
   // 当capacityIncrement大于0的时候，新容量=oldCapacity+oldCapacity，故容量翻倍
   int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                    capacityIncrement : oldCapacity);
   ```

   扩容是原来的数组长度的2倍，扩容之后就是把老数组的数据 copy 到新数组中。

### Stack

![Stack](.\images\Stack.png)

1. 从Vector继承而来，故拥有Vector的一切特定
2. 拥有栈的特点：后进先出。
3. pop() 会弹出栈顶元素并返回栈顶的值，
4. peek() 只是获取栈顶的值，但是并不会把元素从栈顶弹出来

### Collections.synchronizedList

![SynchronizedList](.\images\SynchronizedList.png)

1. 使用同步代码块，减少了锁影响的范围
2. listlterator方法并没有做同步处理，所以在遍历的时候，需要手动加锁，所以可以指定锁对象
3. SynchronizedList有很好的扩展和兼容功能, 可以将所有的List子类转成线程安全的类
4. 扩容机制与ArrayList一样

