# 容器集合

## Collection

### List

#### Vector

线程安全的，大部分方法都加了synchronized的，性能非常低

##### Stack

#### ArrayList

#### LinkedList

链表不好复制，特别麻烦，所以没有CopyOnWriteLinkedList

#### CopyOnWriteArrayList

**写的时候加锁，读的时候不用加锁**

​		写的时候把原来的数组拷贝一份，然后在新的数据中进行写操作，此时是不影响原来数组提供的读的，等写完之后，把原来数组的引用指向新的数组即可。

### Set

#### HashSet

##### LinkedHashSet

#### SortedSet

##### TreeSet

#### EnumSet

#### CopyOnWriteArraySet

#### ConcurrentSkipListSet

### Queue

## Map





# 多线程

