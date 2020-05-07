# JUC

## 一、线程相关

### 线程启动的几种方式

#### 1. 继承 Thread

```java
class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("继承 Thread 方式的线程开始执行......");
    }
}

new TestThread().start();
```

#### 2. 实现 Runnable 接口

```java
class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("实现 Runnable 接口的线程开始执行......");
    }
}

new Thread(new TestRunnable()).start();
```

#### 3. 使用 Lambda 表达式

```java
new Thread(()->{System.out.println("使用 lambda 方式的线程开始执行......");}).start();
```

#### 4. 使用线程池启动

```java
Executors.newCachedThreadPool().submit(()->{System.out.println("使用 线程池 方式的线程开始执行......");});
```

### 线程的基本方法

#### 1. Thread.sleep(1000)

使当前正在运行的线程以指定的毫秒数暂停一段时间，也就是暂时停止执行，**进入阻塞状态，不会释放CPU资源。**

1. 在指定时间内让当前正在执行的线程暂停执行，但不会释放“锁标志”,在指定时间内不会执行
2. sleep()方法给其他线程运行机会时不考虑线程的优先级

#### 2. Thread.yield();

使当前正在运行线程由执行状态，**进入就绪状态**（进入一个等待队列中），**释放CPU资源**，在下一次CPU进行调度的时候，此线程有可能被执行，也有可能没有被执行。

1. yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行
2. 调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态
3. yield()方法只会给相同优先级或更高优先级的线程有执行的机会

#### 3. 线程对象.join();

当前线程**进入阻塞状态**，等待调用 join 的线程对象所执行的线程执行完成之后，当前线程才会继续执行。

### 线程的状态

![thread-status](./images/thread-status.png)

#### 1. 新建状态

使用 new 关键字和 Thread 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 start() 这个线程。

#### 2. 就绪状态

当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。

#### 3. 运行状态

如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。

#### 4. 阻塞状态

如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：

1. 等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
2. 同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
3. 其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。

#### 5. 死亡状态

一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。

### 线程的挂起

线程的挂起操作实质上就是使线程进入“非可执行”状态下，在这个状态下CPU不会分给线程时间片，进入这个状态可以用来暂停一个线程的运行；在线程挂起后，可以通过重新唤醒线程来使之恢复运行。当一个线程进入“非可执行”状态，即挂起状态时，必然存在某种原因使其不能继续运行，这些原因可能是如下几种情况：

#### 1. sleep()：不推荐使用

通过调用sleep()方法使线程进入休眠状态，线程在指定时间内不会运行，当时间到了之后，依然会继续运行。

> 这里必须说明一下的是sleep方法，虽然它也能将线程挂起，但是它会产生`InterruptedException`异常，当sleep一定时间后它将会自动执行后面的方法，也可以通过interrupt方法进行主动打断sleep方法进行线程唤醒。

#### 2. join：不推荐使用

通过调用join()方法使线程挂起，如果某个线程在另一个线程t上调用t.join()，这个线程将被挂起，直到线程t执行完毕为止。（线程的继续运行不受人为控制）

#### 3. suspend()与resume()方法：已被废弃

thread.suspend()：线程被挂起；thread.resume()：挂起的线程继续执行；线程 thread 在运行到suspend()之后被强制挂起，暂停运行，直到主线程调用 thread.resume() 方法时才被重新唤醒。 

> Java2中已经废弃了suspend()和resume()方法，因为使用这两个方法可能会产生死锁，所以应该使用同步对象调用wait()和notify()的机制来代替suspend()和resume()进行线程控制

#### 4. wait()：推荐使用

这个是Java中常用的线程挂起方法，当调用wait方法的时候线程会自动的释放掉占有的线程资源锁，然后通过notify或notifyAll方法进行wait方法的唤醒，因此在这个地方不会出现死锁。

#### 5. park/unpark：推荐使用

park的字面量意思是指停车场的意思，使用park来挂起线程后需要调用unpark来进行唤醒，这个没有先后顺序的区分，如果你提前进行了unpark，然后在进行park也是可以的，但是提前了的多个unpark只能看做是一个unpark，不能进行重复叠加，如果再次park的话需要新的unpark来进行唤醒操作，这个比如你在停车场进行停车操作，你如果提前进行了预约停车，你在未进入停车场之前都是可以进行多次预约的，这所有的预约只扣一次钱(unpark)，但是这所有的预约操作都看作是你这一次进入停车场停车(park)的凭证，如果你离开了通过缴费凭证(unpark)一旦你想进行下一次停车，那么已经使用过的预约都不能进行作数了，你只能再次预约或者直接进入停车场，一旦要离开只能再次缴费(unpark)。

调用`park/unpark`使用的是`LockSupport.park()/LockSupport.unpark()。`

使用`park/unpark`的使用使用synchronized关键字也会出现死锁的情况，因为它并不释放线程所占用的锁资源，所以使用的时候也需要注意。

## 二、锁

###  (1) synchronized

> synchronized关键字是用来控制线程同步的，就是在多线程的环境下，控制synchronized代码段不被多个线程同时执行。**锁的是对象，而不是代码**

修饰的对象有以下几种：

1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象
2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象
3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象
4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象

#### 1. 简单使用

```java
// 以下两个方法要锁的对象是等效的
// 修饰方法
private synchronized void exe11(){
}
private void exe12(){
    // 修改代码块
    synchronized (this) {
    }
}
```

```java
// 以下两个静态方法要锁的对象是等效的
// 修饰静态方法
private synchronized static void exe21(){
}
private static void exe22(){
    // 修改代码块
    synchronized (TestSynchronized01.class) {
    }
}
```

#### 2. 锁的特点

1. 既能保证原子性，又能保证可见性
2. 不能保证指令重排序，所以某些场景需要结合 volatile 使用
3. 在执行同步方法的时候，可以调用非同步方法
4. 写加锁，读不加锁，会产生脏读。（看业务是否有严格要求，不加锁比加锁慢了100倍）
5. 可重入锁：在执行同步方法的时候，可以调用其他的同步方法（两个方法的锁必须是一把锁）
6. 程序中如果出现异常，一般情况下，锁将会被释放（没有进行异常的捕捉及处理时）
7. <font color="red">**要锁的对象不能用 String 和 Integer、Long等基础数据类型**</font>

#### 3. 锁升级

> 锁升级过程：<font color="red">无锁——>偏向锁——>轻量级锁（CAS）——>重量级锁</font>
>
> JDK早期，是重量级锁，需要找OS申请锁

![java-synchronized升级的原理](./images/java-synchronized升级的原理.png)

##### 1. 偏向锁

大多数情况下，锁总是由同一个线程多次获得。当一个线程访问同步块并获取锁时，会在对象头和栈帧中的锁记录里存储锁偏向的线程ID，偏向锁是一个可重入的锁。如果锁对象头的Mark Word里存储着指向当前线程的偏向锁，无需重新进行CAS操作来加锁和解锁。当有其他线程尝试竞争偏向锁时，持有偏向锁的线程（不处于活动状态）才会释放锁。偏向锁无法使用自旋锁优化，因为一旦有其他线程申请锁，就破坏了偏向锁的假定进而升级为轻量级锁

##### 2. 自旋锁(CAS)：有时间和次数的限制

让不满足条件的线程等待一会看能不能获得锁，通过占用处理器的时间来避免线程切换带来的开销。自旋等待的时间或次数是有一个限度的，如果自旋超过了定义的时间仍然没有获取到锁，则该线程应该被挂起。在 JDK1.6 之后，引入了自适应自旋锁，自适应意味着自旋的次数不是固定不变的，而是根据前一次在同一个锁上自旋的时间以及锁的拥有者的状态来决定。如果在同一个锁对象上，自旋等待刚刚成功获得过锁，并且持有锁的线程正在运行中，那么虚拟机就会认为这次自旋也是很有可能再次成功，进而它将允许自旋等待持续相对更长的时间。如果对于某个锁，自旋很少成功获得过，那在以后尝试获取这个锁时将可能省略掉自旋过程，直接阻塞线程，避免浪费处理器资源。

##### 3. 轻量级锁

减少无实际竞争情况下，使用重量级锁产生的性能消耗。JVM会现在当前线程的栈桢中创建用于存储锁记录的空间 LockRecord，将对象头中的 Mark Word 复制到 LockRecord 中并将 LockRecord 中的 Owner 指针指向锁对象。然后线程会尝试使用CAS将对象头中的Mark Word替换为指向锁记录的指针，成功则当前线程获取到锁，失败则表示其他线程竞争锁当前线程则尝试使用自旋的方式获取锁。自旋获取锁失败则锁膨胀升级为重量级锁。

##### 4. 重量级锁

通过对象内部的监视器(monitor)实现，其中monitor的本质是依赖于底层操作系统的Mutex Lock实 现，操作系统实现线程之间的切换需要从用户态到内核态的切换，切换成本非常高。线程竞争不使用自旋，不会消耗CPU。但是线程会进入阻塞等待被其他线程被唤醒，响应时间缓慢。

#### 5. 锁的优缺点

1. **执行时间长**或者**线程数量多**的尽量用系统锁
2. **执行时间短**且**线程数量少**的情况下，适合使用自旋锁，因为自旋为一直占用CPU

#### 6. 可重入

```java
public class SynchronizedLockTest {
    synchronized void m1() {
        for(int i=0; i<10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if(i == 2) m2();
        }
    }
    synchronized void m2() {
        System.out.println("m2 ...");
    }
    public static void main(String[] args) {
        SynchronizedLockTest synchronizedLockTest = new SynchronizedLockTest();
        new Thread(synchronizedLockTest::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

### (2) ReentrantLock：可重入锁

```java
public class ReentrantLockTest {
    Lock lock = new ReentrantLock();
    void m1() {
        try {
            lock.lock();
            for(int i=0; i<10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                if(i == 2) m2();
            }
        }finally {
            lock.unlock();
        }
    }
    void m2() {
        try {
            lock.lock();
            System.out.println("m2 ...");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

#### 比synchronized有更好用的API

##### 1. 尝试获取锁

**lock.tryLock()**

使用tryLock进行尝试锁定，不管锁定与否，方法都将继续执行
可以根据tryLock的返回值来判定是否锁定
也可以指定tryLock的时间，由于tryLock(time)抛出异常，所以要注意unclock的处理，必须放到finally中

##### 2. 可以被打断的锁

**lock.lockInterruptibly()**

如果当前线程未被中断，则可以获取锁，如果已被中断则会排除 InterruptedException 异常。但是使用lock.lock()时，当前线程被中断，不会报错。打断线程的方法：线程对象.interrupt()

##### 3. 可以指定为公平锁

**默认为不公平锁**

```java
// 指定为公平锁
Lock lock = new ReentrantLock(true);
```

1. 公平锁则在于每次都是依次从队首取值，严格按照线程启动的顺序来执行的，不允许插队。

   首先判断当前AQS的state是否等于0，锁是否被占用，如果没有被占用的话，继续判断队列中是否有排在前面的线程在等待锁，没有的话就修改statte状态；然后将当前线程记录为独占锁的线程，继续判断当前线程是否为独断锁的线程，ReentrantLock是可重入的，线程可以不停地Lock来增加state的值，对应的需要unlock来解锁，减少state的值， 如果上面的条件判断失败，即获取锁失败，则将线程加入到等待线程队列队尾，然后阻塞线程，等待被唤醒。

2. 非公平锁在等待锁的过程中， 如果有任意新的线程妄图获取锁，都是有很大的几率直接获取到锁的，允许插队。

   非公平锁逻辑基本跟公平锁一致，最本质的区别是，当前的锁状态没有被占用时，当前线程可以直接占用，而不需要判断当前队列中是否有等待线程。

ReentrantLock默认使用非公平锁是基于性能考虑，公平锁为了保证线程规规矩矩地排队，需要增加阻塞和唤醒的时间开销。如果直接插队获取非公平锁，跳过了对队列的处理，速度会更快。

### (3) CountDownLatch：倒数计时器

<font color="red">**CountDownLatch是一个计数器，线程完成一个记录一个，计数器递减，只能只用一次**</font>

> 是通过一个计数器来实现的，计数器的初始值是线程的数量。每当一个线程执行完毕后，计数器的值就-1，当计数器的值为0时，表示所有线程都执行完毕，然后在闭锁上等待的线程就可以恢复工作了。

```java
public class CountDownLatchTest {
    public static void main(String[] args) {
        usingCountDownLatch();
    }
    private static void usingCountDownLatch() {
        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                int result = 0;
                for (int j = 0; j < 10000; j++) result += j;
                latch.countDown();
            });
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end latch");
    }
}
```

#### countDown()

将count值减1（原子性操作）。

#### await()

调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行。

#### await(long timeout, TimeUnit unit)

和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行。

### (4) CyclicBarrier：循环栅栏

<font color="red">**它的作用就是会让所有线程都等待完成后才会继续下一步行动。**</font>

> 举个例子，就像生活中我们会约朋友们到某个餐厅一起吃饭，有些朋友可能会早到，有些朋友可能会晚到，但是这个餐厅规定必须等到所有人到齐之后才会让我们进去。这里的朋友们就是各个线程，餐厅就是 CyclicBarrier。
>
> 深入理解：CyclicBarrier [https://blog.csdn.net/qq_39241239/article/details/87030142](https://blog.csdn.net/qq_39241239/article/details/87030142)

```java
public class CyclicBarrierTest {
    public static void main(String[] args) {
        // parties 是参与线程的个数
        // Runnable 参数，这个参数的意思是最后一个到达后，线程要做的任务
        CyclicBarrier barrier = new CyclicBarrier(20, () -> System.out.println("满人"));
        for(int i=0; i<100; i++) {
            new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
```

#### await()

线程调用 await() 表示自己已经到达栅栏

#### await(long timeout, TimeUnit unit)

和await()类似，只不过等待一定的时间后到达的线程个数少于指定的线程个数时也会继续执行。

### (5) Phaser：阶段栅栏的作用（1.7加入的）

> 深入理解：Phaser
>
> [https://www.jianshu.com/p/e5794645ca8d](https://www.jianshu.com/p/e5794645ca8d)

```java
public class PhaserTest {
    MarriagePhaser phaser = new MarriagePhaser();
    public static void main(String[] args) {
        new PhaserTest().testPhaser();
    }
    private void testPhaser(){
        phaser.bulkRegister(5);
        for(int i=0; i<5; i++) {
            final int nameIndex = i;
            new Thread(()->{
                Person p = new Person("person " + nameIndex);
                p.arrive();
                phaser.arriveAndAwaitAdvance();

                p.eat();
                phaser.arriveAndAwaitAdvance();

                p.leave();
                phaser.arriveAndAwaitAdvance();
            }).start();
        }
    }
    class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！");
                    return false;
                case 1:
                    System.out.println("所有人吃完了！");
                    return false;
                case 2:
                    System.out.println("所有人离开了！");
                    System.out.println("婚礼结束！");
                    return true;
                default:
                    return true;
            }
        }
    }
    class Person {
        String name;
        Random r = new Random();
        public Person(String name) {
            this.name = name;
        }
        public void arrive() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
        }
        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
        }
        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
        }
        void milliSleep(int milli) {
            try {
                TimeUnit.MILLISECONDS.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java
public class Phaser2Test {
    MarriagePhaser phaser = new MarriagePhaser();
    public static void main(String[] args) {
        new Phaser2Test().testPhaser();
    }
    private void testPhaser(){
        phaser.bulkRegister(7);
        for(int i=0; i<5; i++) {
            new Thread(new Person("p" + i)).start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();
    }
    class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                    return true;
                default:
                    return true;
            }
        }
    }
    class Person implements Runnable {
        String name;
        Random r = new Random();
        public Person(String name) {
            this.name = name;
        }
        public void arrive() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
            phaser.arriveAndAwaitAdvance();
        }
        public void eat() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
            phaser.arriveAndAwaitAdvance();
        }
        public void leave() {
            milliSleep(r.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
            phaser.arriveAndAwaitAdvance();
        }
        private void hug() {
            if(name.equals("新郎") || name.equals("新娘")) {
                milliSleep(r.nextInt(1000));
                System.out.printf("%s 洞房！\n", name);
                phaser.arriveAndAwaitAdvance();
            } else {
                phaser.arriveAndDeregister();
            }
        }
        void milliSleep(int milli) {
            try {
                TimeUnit.MILLISECONDS.sleep(milli);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }
}
```

#### arriveAndAwaitAdvance()

到达并等待下一个任务的开始

#### arriveAndDeregister()

到达就完成，不再参与下一个任务了

#### onAdvance()

在Phaser类中，在每个线程中，每个线程完成一个阶段后都会等待其他线程完成后再一起进行，当所有线程都完成了一个任务的时候，会调用Phaser的onAdvance方法。如果我们想在每个阶段，所有线程都完成他们的阶段工作后做点啥事的话，那就得继承Phaser类来重写Onadvance这个方法来实现我们的目的，

### (6) ReentrantReadWriteLock：读写锁

```java
public class ReentrantReadWriteLockTest {
    static Lock lock = new ReentrantLock();
    private static int value;
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    public static void read(Lock lock) {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println("read over!");
            //模拟读取操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void write(Lock lock, int v) {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = v;
            System.out.println("write over!");
            //模拟写操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        //Runnable readR = ()-> read(lock);
        Runnable readR = () -> read(readLock);
        //Runnable writeR = ()->write(lock, new Random().nextInt());
        Runnable writeR = () -> write(writeLock, new Random().nextInt());
        for (int i = 0; i < 18; i++) new Thread(readR).start();
        for (int i = 0; i < 2; i++) new Thread(writeR).start();
    }
}
```

#### 共享锁

当一个线程进行读取的时候，其他线程如果是读请求，则可以直接进行读取，如果是写锁，则需要等待所有的读请求完成之后，才允许写

#### 排他锁

当一个线程进行写操作时，其他线程无论是读还是写，都将被阻塞，只有等写线程完成之后，才允许其他线程获得锁

### (7) Semaphore：信号灯（限流、收费站）

```java
public class SemaphoreTest {
    public static void main(String[] args) {
        // 允许 n 个线程同时执行
        // 是否公平锁，默认非公平锁
        Semaphore semaphore = new Semaphore(1, true);
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        }).start();
        new Thread(()->{
            try {
                semaphore.acquire();
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
```

#### semaphore.acquire();

获取执行的许可：每次执行，信号量-1，如果减到0，后面的线程将会被阻塞

#### semaphore.release();

每次执行，信号量+1，加1以后，后面阻塞的线程将有机会被执行

### (8) Exchanger：两者交换

```java
public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            String s = "T1";
            try {
                // 阻塞，直到另外一个线程执行了 exchange 进行交换后，会继续执行
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t1").start();
        new Thread(()->{
            String s = "T2";
            try {
                // 阻塞，直到另外一个线程执行了 exchange 进行交换后，会继续执行
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);
        }, "t2").start();
    }
}
```

#### exchange

阻塞，直到另外一个线程执行了 exchange 进行交换后，会继续执行

### (9) LockSupport

> `LockSupport`是一个线程阻塞工具类，所有的方法都是静态方法，可以让线程在任意位置阻塞，当然阻塞之后肯定得有唤醒的方法。

```java
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i == 5) {
                    LockSupport.park();
                }
            }
        });
        t.start();
        Thread.sleep(2000);
        LockSupport.unpark(t);
    }
}
```

#### LockSupport.park(Object blocker)

暂停当前线程

#### LockSupport.parkNanos(Object blocker, long nanos)

暂停当前线程，不过有超时时间的限制

#### LockSupport.parkUntil(Object blocker, long deadline)

暂停当前线程，直到某个时间

#### LockSupport.park()

无期限暂停当前线程

#### LockSupport.parkNanos(long nanos)

暂停当前线程，不过有超时时间的限制

#### LockSupport.parkUntil(long deadline)

暂停当前线程，直到某个时间

#### LockSupport.unpark(t)

恢复当前线程

### (10) Object.wait()、Object.notify()

1. 当前线程必须拥有当前对象锁
2. wait()和notify()必须在synchronized函数或synchronized代码块中进行调用
3. wait()让当前线程等待，会释放锁，从而使别的线程有机会抢占该锁
4. 唤醒当前对象锁的等待线程使用notify或notifyAll方法，也必须拥有相同的对象锁
5. notify()不会释放锁

### (11) AbstractQueuedSynchronizer： AQS

>AQS的核心思想是：如果被请求的共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并将共享资源设置为锁定状态，如果被请求的共享资源被占用，那么就需要一套线程阻塞等待以及被唤醒时锁分配的机制，这个机制AQS是用CLH队列锁实现的，即将暂时获取不到锁的线程加入到队列中。
>AQS是将每一条请求共享资源的线程封装成一个CLH锁队列的一个结点（Node），来实现锁的分配。
>用大白话来说，AQS就是基于CLH队列，用volatile修饰共享变量state，线程通过CAS去改变状态符，成功则获取锁成功，失败则进入等待队列，等待被唤醒。
>AQS是自旋锁：在等待唤醒的时候，使用自旋（while(!cas())）的方式，不停地尝试获取锁，直到被其他线程获取成功。

**核心数据结构：双向链表 + （volatile）state(锁状态)**

**底层操作：CAS**

![AQS结构图](./images/AQS实现.png)

#### 重要的API

##### 1. isHeldExclusively()

该线程是否正在独占资源。只有用到condition才需要去实现它。

##### 2. tryAcquire(int)

独占方式。尝试获取资源，成功则返回true，失败则返回false。

##### 3. tryRelease(int)

独占方式。尝试释放资源，成功则返回true，失败则返回false。

##### 4. tryAcquireShared(int)

共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。

##### 5. tryReleaseShared(int)

共享方式。尝试释放资源，如果释放后允许唤醒后续等待结点返回true，否则返回false。

##### 6. addWaiter(Node)

将当前线程加入上面锁的双向链表（等待队列）中

```java
private Node addWaiter(Node mode) {
    // 要加入的节点
    Node node = new Node(Thread.currentThread(), mode);
    // 一个中间变量指向最后一个节点
    Node pred = tail;
    if (pred != null) {
        // 当前节点的前一个节点指向中间变量（也就是最后一个节点）
        node.prev = pred;
        // CAS操作
        if (compareAndSetTail(pred, node)) {
            // 中间变量的下一个节点指向当前节点（加入队列成功）
            pred.next = node;
            return node;
        }
    }
    enq(node);
    return node;
}
```

##### 7. acquireQueued(Node, int)

通过自旋，判断当前队列节点是否可以获取锁。

```java
// 公平锁的获取
final boolean acquireQueued(final Node node, int arg) {
    boolean failed = true;
    try {
        boolean interrupted = false;
        // 死循环，每个节点都有机会执行下面的逻辑
        for (;;) {
            // 获取当前节点的前一个节点
            final Node p = node.predecessor();
            // 前一个节点是头节点，并且已经获取到锁的时候
            if (p == head && tryAcquire(arg)) {
                // 把当前节点设置为头结点
                setHead(node);
                // 设置为空，help GC
                p.next = null; 
                failed = false;
                return interrupted;
            }
            // 进入阻塞状态，进行等待
            if (shouldParkAfterFailedAcquire(p, node) && parkAndCheckInterrupt())
                interrupted = true;
        }
    } finally {
        if (failed)
            cancelAcquire(node);
    }
}
```

##### 8. VarHandle：变量句柄

>VarHandle 的出现替代了java.util.concurrent.atomic和sun.misc.Unsafe的部分操作。并且提供了一系列标准的内存屏障操作，用于更加细粒度的控制内存排序。在安全性、可用性、性能上都要优于现有的API。

```java
int STATE = MethodHandles.lookup().findVarHandle(Class, "state", int.class);
```

1. JKD9发布的新特性
2. 可以对普通属性做一些原子性操作
3. 比反射快，直接操作二进制码

#### 实现了AQS的锁有

1. 自旋锁
2. 互斥锁
3. 读锁写锁
4. 条件产量
5. 信号量
6. 栅栏

## 三、volatile 

> 用来确保将变量的更新操作通知到其他线程。当把变量声明为 volatile 类型后，编译器与运行时都会注意到这个变量是共享的，因此不会将该变量上的操作与其他内存操作一起重排序。volatile变量不会被缓存在寄存器或者对其他处理器不可见的地方，因此在读取volatile类型的变量时总会返回最新写入的值。

### 1. Java内存模型

![Java内存模型](./images/Java内存模型.png)

### 2. 内存间的交互动作

| 动作           | 作用                                                         |
| -------------- | ------------------------------------------------------------ |
| lock（锁定）   | 作用于主内存变量，把一个变量标示为一条线程独占的状态         |
| unlock（解锁） | 作用于主内存的变量，把一个处于锁定状态的变量释放出来，<br />释放后的变量才可以被其他线程锁定 |
| read（读取）   | 作用于主内存的变量，把一个变量的值从主内存传输到线程的工作内存中，<br />以便随后的load动作使用 |
| load（载入）   | 作用于工作内存的变量，把read操作从主存中得到的变量值放入工作内存的变量副本中 |
| use（使用）    | 作用于工作内存的变量，把工作内存中一个变量的值传递给执行引擎，<br />每当虚拟机遇到一个需要使用到变量的值的字节码指令时将会执行这个操作 |
| assign（赋值） | 作用于工作内存的变量，把一个从执行引擎接收到的值赋给工作内存中的变量，<br />每当虚拟机遇到一个给变量赋值的字节码指令时执行这个操作 |
| store（存储）  | 作用于工作内存的变量，把工作内存中一个变量的值传送到主内存中，<br />以便随后的write操作使用 |
| write（写入）  | 作用于主内存的变量，把store操作从工作内存中得到的变量的值放入主内存的变量中 |

![Java-内存间的交互动作](./images/Java-内存间的交互动作.png)

### 3. volatile 的特点

在访问volatile变量时不会执行加锁操作，因此也就不会使执行线程阻塞，因此volatile变量是一种比sychronized关键字更轻量级的同步机制。

![vlolatile](./images/vlolatile.png)

当对非 volatile 变量进行读写的时候，每个线程先从内存拷贝变量到CPU缓存中。如果计算机有多个CPU，每个线程可能在不同的CPU上被处理，这意味着每个线程可以拷贝到不同的 CPU cache 中。而声明变量是 volatile 的，JVM 保证了每次读变量都从内存中读，跳过 CPU cache 这一步。

#### 1. 保证线程可见性

当一个线程修改了这个变量的值，volatile 保证了新值能立即同步到主内存，以及每次使用前立即从主内存刷新。但普通变量做不到这点，普通变量的值在线程间传递均需要通过主内存来完成。

#### 2. 禁止指令重排序

在虚拟机层面，为了尽可能减少内存操作速度远慢于CPU运行速度所带来的CPU空置的影响，虚拟机会按照自己的一些规则(这规则后面再叙述)将程序编写顺序打乱——即写在后面的代码在时间顺序上可能会先执行，而写在前面的代码会后执行——以尽可能充分地利用CPU。

在硬件层面，CPU会将接收到的一批指令按照其规则重排序，同样是基于CPU速度比缓存速度快的原因，和上一点的目的类似，只是硬件处理的话，每次只能在接收到的有限指令范围内重排序，而虚拟机可以在更大层面、更多指令范围内重排序。

new 一个对象的指令会分成三步

1. 给这个对象申请内存，此时对象的成员变量是一个默认值
2. 给对象的成员变量初始化
3. 把这块内存赋值给外部变量

##### 内存屏障

##### 1. LoadLoad屏障

对于这样的语句Load1; LoadLoad; Load2，在Load2及后续读取操作要读取的数据被访问前，保证Load1要读取的数据被读取完毕。

##### 2. StoreStore屏障

对于这样的语句Store1; StoreStore; Store2，在Store2及后续写入操作执行前，保证Store1的写入操作对其它处理器可见。

##### 3. LoadStore屏障

对于这样的语句Load1; LoadStore; Store2，在Store2及后续写入操作被刷出前，保证Load1要读取的数据被读取完毕。

##### 4. StoreLoad屏障

对于这样的语句Store1; StoreLoad; Load2，在Load2及后续所有读取操作执行前，保证Store1的写入对所有处理器可见。它的开销是四种屏障中最大的。在大多数处理器的实现中，这个屏障是个万能屏障，兼具其它三种内存屏障的功能。

#### 3. 不能保证原子性

以i++为例，其包括读取、操作、赋值三个操作，下面是两个线程的操作顺序

![volatile不能保证原子性](./images/volatile不能保证原子性.png)

假如说线程A在做了i+1，但未赋值的时候，线程B就开始读取i，那么当线程A赋值i=1，并回写到主内存，而此时线程B已经不再需要i的值了，而是直接交给处理器去做+1的操作，于是当线程B执行完并回写到主内存，i的值仍然是1，而不是预期的2。也就是说，volatile缩短了普通变量在不同线程之间执行的时间差，但仍然存有漏洞，依然不能保证原子性。

### 4. 缓存一致性协议：MESI



## 四、CAS：无锁优化、自旋锁、乐观锁

<font color="red">**CAS操作是CPU原语的支持，中间的指令不会被打断**</font>

CAS 操作包含三个操作数 —— 内存位置（V）、预期原值（A）和新值(B)。 如果内存位置的值与预期原值相匹配，那么处理器会自动将该位置值更新为新值 。否则，处理器不做任何操作。

使用 Unsafe 进行CAS操作。

```java
Unsafe.getUnsafe().compareAndSwapInt();
Unsafe.getUnsafe().compareAndSwapLong();
Unsafe.getUnsafe().compareAndSwapObject();
```

**Unsafe 可直接操作JVM中的内存**

### 1. CAS存在的问题

#### 1. ABA问题

因为CAS需要在操作值的时候检查下值有没有发生变化，如果没有发生变化则更新，但是如果一个值原来是A，变成了B，又变成了A，那么使用CAS进行检查时会发现它的值没有发生变化，但是实际上却变化了。ABA问题的解决思路就是使用版本号。在变量前面追加上版本号，每次变量更新的时候把版本号加一，那么A－B－A 就会变成1A-2B－3A。

> 从Java1.5开始JDK的atomic包里提供了一个类 **AtomicStampedReference** 来解决ABA问题。这个类的compareAndSet 方法作用是首先检查当前引用是否等于预期引用，并且当前标志是否等于预期标志，如果全部相等，则以原子方式将该引用和该标志的值设置为给定的更新值。

**如果是基础数据类型，无所谓，影响不大**

**如果是引用类型，就需要注意里面的属性是否已经发生了变化**

#### 2. 循环时间长开销大

自旋CAS如果长时间不成功，会给CPU带来非常大的执行开销。如果JVM能支持处理器提供的pause指令那么效率会有一定的提升，pause指令有两个作用，第一它可以延迟流水线执行指令（de-pipeline）,使CPU不会消耗过多的执行资源，延迟的时间取决于具体实现的版本，在一些处理器上延迟时间是零。第二它可以避免在退出循环的时候因内存顺序冲突（memory order violation）而引起CPU流水线被清空（CPU pipeline flush），从而提高CPU的执行效率。

#### 3. 只能保证一个共享变量的原子操作

当对一个共享变量执行操作时，我们可以使用循环CAS的方式来保证原子操作，但是对多个共享变量操作时，循环CAS就无法保证操作的原子性，这个时候就可以用锁，或者有一个取巧的办法，就是把多个共享变量合并成一个共享变量来操作。比如有两个共享变量i＝2,j=a，合并一下ij=2a，然后用CAS来操作ij。从Java1.5开始JDK提供了AtomicReference类来保证引用对象之间的原子性，你可以把多个变量放在一个对象里来进行CAS操作。

### 2. 使用CAS操作的 JDK 内部类

1. AtomicInteger
2. AtomicLong
3. AtomicBoolean

### 3. LongAdder

LongAdder在高并发的场景下会比它的前辈——AtomicLong 具有更好的性能，代价是消耗更多的内存空间。

在并发量较低的环境下，线程冲突的概率比较小，自旋的次数不会很多。但是，高并发环境下，N个线程同时进行自旋操作，会出现大量失败并不断自旋的情况，此时**AtomicLong**的自旋会成为瓶颈。

**LongAdder**的基本思路就是**分散热点**，将value值分散到一个数组中，不同线程会命中到数组的不同槽中，各个线程只对自己槽中的那个值进行CAS操作，这样热点就被分散了，冲突的概率就小很多。如果要获取真正的long值，只要将各个槽中的变量值累加返回。**（分段锁）**

这种做法有没有似曾相识的感觉？没错，ConcurrentHashMap 中的“分段锁”其实就是类似的思路。

## 五、两个线程之间等待输出

### 1. LockSupport方式

```java
public class Demo1 {
    private Thread t1 = null;
    private Thread t2 = null;
    public static void main(String[] args) {
        Demo1 demo = new Demo1();
        demo.execute();
    }
    private void execute() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
                if (i == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });
        t2 = new Thread(() -> {
            LockSupport.park();
            System.out.println("............");
            LockSupport.unpark(t1);
        });
        t1.start();
        t2.start();
    }
}
```

### 2. CountDownLatch的方式

```java
public class Demo2 {
    private Thread t1 = null;
    private Thread t2 = null;
    private CountDownLatch countDownLatch1 = new CountDownLatch(1);
    private CountDownLatch countDownLatch2 = new CountDownLatch(1);
    public static void main(String[] args) {
        Demo2 demo = new Demo2();
        demo.execute();
    }
    private void execute() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
                if (i == 5) {
                    countDownLatch1.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2 = new Thread(() -> {
            try {
                countDownLatch1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("............");
            countDownLatch2.countDown();
        });
        t1.start();
        t2.start();
    }
}
```

### 3. Object.wait()、Object.notify()方式

```java
public class Demo3 {
    private Thread t1 = null;
    private Thread t2 = null;
    private Object o1 = new Object();
    public static void main(String[] args) {
        Demo3 demo = new Demo3();
        demo.execute();
    }
    private void execute() {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
                if (i == 5) {
                    synchronized (o1) {
                        try {
                            o1.notify();
                            o1.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t2 = new Thread(() -> {
            synchronized (o1) {
                try {
                    o1.wait();
                    System.out.println("............");
                    o1.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
```

### 4. Semaphore方式

```java
public class Demo4 {
    private Thread t1 = null;
    private Thread t2 = null;
    private Semaphore semaphore = new Semaphore(1);
    public static void main(String[] args) {
        Demo4 demo = new Demo4();
        demo.execute();
    }
    private void execute() {
        t1 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 6; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
            }
            semaphore.release();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 6; i < 10; i++) {
                System.out.println(i);
                ThreadSleepUtil.sleepSeconds(1);
            }
            semaphore.release();
        });
        t2 = new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("............");
            semaphore.release();
        });
        t1.start();
        t2.start();
    }
}
```

## 六、生产者消费者问题

> 写一个固定容量同步容器，拥有get和put方法，以及getCount方法，能够支持2个生产者和10个消费者线程的阻塞调用

### 1. ReentrantLock.newCondition方式

```java
public class Demo8 {
    final private LinkedList<String> lists = new LinkedList<>();
    //最多10个元素
    final private int MAX = 10;
    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();
    public static void main(String[] args) {
        Demo8 c = new Demo8();
        //启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    c.get();
                }
            }, "c" + i).start();
        }
        //启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    c.put(Thread.currentThread().getName());
                }
            }, "p" + i).start();
        }
    }
    public void put(String str) {
        try {
            lock.lock();
            //想想为什么用while而不是用if？
            while (lists.size() == MAX) {
                producer.await();
            }
            lists.add(str);
            System.out.println("生产者生产完成后剩余:" + lists.size());
            ThreadSleepUtil.sleepMilliSeconds(300);
            consumer.signalAll(); //通知消费者线程进行消费
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void get() {
        try {
            lock.lock();
            while (lists.size() == 0) {
                consumer.await();
            }
            lists.removeFirst();
            System.out.println("消费者消费完成后剩余:" + lists.size());
            ThreadSleepUtil.sleepSeconds(1);
            producer.signalAll(); //通知生产者进行生产
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
```

## 七、强软弱虚引用

### 1. 概述

JDK1.2之后，Java对引用的概念进行了扩充，分为强引用（Strong Reference）、软引用（Soft Reference）、弱引用（Weak Reference）、虚引用（Phantom Reference）4中，这4种引用强度逐渐减弱。

![强软弱虚引用类型](./images/强软弱虚引用类型.jpg)

### 2. 强引用

强引用虽然在开发过程中并不怎么提及，但是无处不在。平时我们编程的时候例如：Object object=new Object（）；那object就是一个强引用了。当内存空 间不足，Java虚拟机宁愿抛出OutOfMemoryError错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足问题。

```java
public class ObjectTest {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc(); //DisableExplicitGC
        System.in.read();
    }
}
```

>对GC知识比较熟悉的可以知道，HotSpot JVM目前的垃圾回收算法一般默认是可达性算法，即在每一轮GC的时候，选定一些对象作为GC ROOT，然后以它们为根发散遍历，遍历完成之后，如果一个对象不被任何GC ROOT引用，那么它就是不可达对象，则在接下来的GC过程中很可能会被回收。
>
>强引用最重要的就是它能够让引用变得强（Strong），这就决定了它和垃圾回收器的交互。具体来说，如果一个对象通过一串强引用链接可到达(Strongly reachable)，它是不会被回收的。如果你不想让你正在使用的对象被回收，这就正是你所需要的。

### 3. 软引用：SoftReference

如果一个对象只具有软引用，如果内存空间足够，垃圾回收器就不会回收它，如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。软引用可用来实现内存敏感的高速缓存。 

```java
// 启动参数增加堆内存的大小限制
public class SoftReferenceTest {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        //m = null;
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        //再分配一个数组，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());
    }
}
```

> 软引用是用来描述一些还有用但是并非必须的对象。对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收返回之后进行第二次回收。如果这次回收还没有足够的内存，才会抛出内存溢出异常

### 4. 弱引用：WeakReference

弱引用与软引用的区别在于：弱引用的对象拥有更短暂的生命周期。在垃圾回收器进行线程扫描的过程中，一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。

ThreadLocal使用了弱引用

![弱引用](./images/弱引用.png)

```java
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
```

### 5. 虚引用：PhantomReference

如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收。 虚引用主要用来跟踪对象被垃圾回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列（ReferenceQueue）联合使用。当垃圾回收器准备回收一个对象时，如果发现它还有虚引用，就会在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中。

一般用来管理堆外内存

```java
public class PhantomReferenceTest {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();
    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();
        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("--- 虚引用对象被jvm回收了 ---- " + poll);
                }
            }
        }).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

>虚引用也成为幽灵引用或者幻影引用，它是最弱的一种引用关系。一个瑞祥是否有虚引用的存在，完全不会对其生存时间造成影响，也无法通过虚引用来取得一个对象的实例。为一个对象设置虚引用关联的唯一目的就是在这个对象被GC时收到一个系统通知。

## 八、ThreadLocal

ThreadLocal叫做线程变量，意思是ThreadLocal中填充的变量属于**当前**线程，该变量对其他线程而言是隔离的。ThreadLocal为变量在每个线程中都创建了一个副本，那么每个线程可以访问自己内部的副本变量。

### 1. 应用示例

```java
public class ThreadLocalTest {
    public static void main(String[] args) {
        new ThreadLocalTest().testThreadLocal();
    }
    private void testThreadLocal(){
        ThreadLocal<Person> tl = new ThreadLocal<>();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }
    class Person {
        String name = "zhangsan";
    }
}
```

### 2. 私有变量存储在哪里

#### 1. ThreadLocal存储数据的容器

在代码中，我们使用ThreadLocal实例提供的set/get方法来存储/使用value，但ThreadLocal实例其实只是一个引用，真正存储值的是一个Map，其key实ThreadLocal实例本身，value是我们设置的值，分布在堆区。这个Map的类型是ThreadL.ThreadLocalMap（ThreadLocalMap是ThreadLocal的内部类），其key的类型是ThreadLocal，value是Object，类定义如下：

```java
static class ThreadLocalMap {
    ThreadLocalMap(ThreadLocal<?> firstKey, Object firstValue) {
        table = new Entry[INITIAL_CAPACITY];
        int i = firstKey.threadLocalHashCode & (INITIAL_CAPACITY - 1);
        table[i] = new Entry(firstKey, firstValue);
        size = 1;
        setThreshold(INITIAL_CAPACITY);
    }
    // 继承了软引用，说明Entry是一个软引用，垃圾回收一旦触发，就会回收这块内存
    static class Entry extends WeakReference<ThreadLocal<?>> {
        Object value;
        Entry(ThreadLocal<?> k, Object v) {
            super(k);
            value = v;
        }
    }
}
```

那么当我们重写init或者调用set/get的时候，内部的逻辑是怎样的呢，按照上面的说法，应该是将value存储到了ThreadLocalMap中，或者从已有的ThreadLocalMap中获取value，我们来通过代码分析一下。

#### 2. ThreadLocal.set(T value)

set的逻辑比较简单，就是获取当前线程的ThreadLocalMap，然后往map里添加KV，K是this，也就是当前ThreadLocal实例，V是我们传入的value。

```java
public void set(T value) {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null)
        map.set(this, value);
    else
        createMap(t, value);
}
```

其内部实现首先需要获取关联的Map，我们看下getMap和createMap的实现

```java
ThreadLocalMap getMap(Thread t) {
    return t.threadLocals;
}
void createMap(Thread t, T firstValue) {
    t.threadLocals = new ThreadLocalMap(this, firstValue);
}
```

可以看到，getMap就是返回了当前Thread实例的map(t.threadLocals)，create也是创建了Thread的map(t.threadLocals)，也就是说对于一个Thread实例，ThreadLocalMap是其内部的一个属性，在需要的时候，可以通过ThreadLocal创建或者获取，然后存放相应的值。我们看下Thread类的关键代码：

```java
public class Thread implements Runnable {
    ThreadLocal.ThreadLocalMap threadLocals = null;
}
```

可以看到，Thread中定义了属性threadLocals，但其初始化和使用的过程，都是通过ThreadLocal这个类来执行的。

#### 3. ThreadLocal.get()

get是获取当前线程的对应的私有变量，是我们之前set或者通过initialValue指定的变量，其代码如下

```java
public T get() {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null) {
        // 这是一个软引用，垃圾回收一旦触发，就会回收这块内存
        ThreadLocalMap.Entry e = map.getEntry(this);
        if (e != null) {
            @SuppressWarnings("unchecked")
            T result = (T)e.value;
            return result;
        }
    }
    return setInitialValue();
}
private T setInitialValue() {
    T value = initialValue();
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t);
    if (map != null)
        map.set(this, value);
    else
        createMap(t, value);
    return value;
}
```

可以看到，其逻辑也比较简单清晰：

1. 获取当前线程的ThreadLocalMap实例
2. 如果不为空，以当前ThreadLocal实例为key获取value
3. 如果ThreadLocalMap为空或者根据当前ThreadLocal实例获取的value为空，则执行setInitialValue()

`setInitialValue()`内部如下：

1. 调用我们重写的initialValue得到一个value
2. 将value放入到当前线程对应的ThreadLocalMap中
3. 如果map为空，先实例化一个map，然后赋值KV

#### 4. 关键设计小结

代码分析到这里，其实对于ThreadLocal的内部主要设计以及其和Thread的关系比较清楚了：

1. 每个线程，是一个Thread实例，其内部拥有一个名为threadLocals的实例成员，其类型是ThreadLocal.ThreadLocalMap
2. 通过实例化ThreadLocal实例，我们可以对当前运行的线程设置一些线程私有的变量，通过调用ThreadLocal的set和get方法存取
3. ThreadLocal本身并不是一个容器，我们存取的value实际上存储在ThreadLocalMap中，ThreadLocal只是作为TheadLocalMap的key
4. <font color="red">**每个线程实例都对应一个TheadLocalMap实例，我们可以在同一个线程里实例化很多个ThreadLocal来存储很多种类型的值，这些ThreadLocal实例分别作为key，对应各自的value**</font>
5. 当调用ThreadLocal的set/get进行赋值/取值操作时，首先获取当前线程的ThreadLocalMap实例，然后就像操作一个普通的map一样，进行put和get

> 当然，这个ThreadLocalMap并不是一个普通的Map（比如常用的HashMap），而是一个特殊的，key为弱引用的map。

### 3. ThreadLocal 内存模型

通过上一节的分析，其实我们已经很清楚ThreadLocal的相关设计了，对数据存储的具体分布也会有个比较清晰的概念。下面的图是网上找来的常见到的示意图，我们可以通过该图对ThreadLocal的存储有个更加直接的印象。

![ThreadLocal](./images/ThreadLocal.jpeg)

我们知道Thread运行时，线程的的一些局部变量和引用使用的内存属于Stack（栈）区，而普通的对象是存储在Heap（堆）区。根据上图，基本分析如下：

1. 线程运行时，我们定义的TheadLocal对象被初始化，存储在Heap，同时线程运行的栈区保存了指向该实例的引用，也就是图中的ThreadLocalRef
2. 当ThreadLocal的set/get被调用时，虚拟机会根据当前线程的引用也就是CurrentThreadRef找到其对应在堆区的实例，然后查看其对用的TheadLocalMap实例是否被创建，如果没有，则创建并初始化
3. Map实例化之后，也就拿到了该ThreadLocalMap的句柄，然后如果将当前ThreadLocal对象作为key，进行存取操作
4. 图中的虚线，表示key对ThreadLocal实例的引用是个弱引用

### 4. 可能的内存泄露分析

#### 1. 内存泄露分析

根据上一节的内存模型图我们可以知道，由于ThreadLocalMap是以弱引用的方式引用着ThreadLocal，换句话说，就是**ThreadLocal是被ThreadLocalMap以弱引用的方式关联着，因此如果ThreadLocal没有被ThreadLocalMap以外的对象引用，则在下一次GC的时候，ThreadLocal实例就会被回收，那么此时ThreadLocalMap里的一组KV的K就是null**了，因此在没有额外操作的情况下，此处的V便不会被外部访问到，而且**只要Thread实例一直存在，Thread实例就强引用着ThreadLocalMap，因此ThreadLocalMap就不会被回收，那么这里K为null的V就一直占用着内存**。

综上，发生内存泄露的条件是：

1. ThreadLocal实例没有被外部强引用，比如我们假设在提交到线程池的task中实例化的ThreadLocal对象，当task结束时，ThreadLocal的强引用也就结束了
2. ThreadLocal实例被回收，但是在ThreadLocalMap中的V没有被任何清理机制有效清理
3. 当前Thread实例一直存在，则会一直强引用着ThreadLocalMap，也就是说ThreadLocalMap也不会被GC

也就是说，如果Thread实例还在，但是ThreadLocal实例却不在了，则ThreadLocal实例作为key所关联的value无法被外部访问，却还被强引用着，因此出现了内存泄露。ThreadLocal如果使用的不当，是有可能引起内存泄露的，虽然触发的场景不算很容易。

>这里要额外说明一下，这里说的内存泄露，是因为对其内存模型和设计不了解，且编码时不注意导致的内存管理失联，而不是有意为之的一直强引用或者频繁申请大内存。比如如果编码时不停的人为塞一些很大的对象，而且一直持有引用最终导致OOM，不能算作ThreadLocal导致的“内存泄露”，只是代码写的不当而已！

#### 2. TheadLocal本身的优化

进一步分析ThreadLocalMap的代码，可以发现ThreadLocalMap内部也是做了一定的优化的

```java
private void set(ThreadLocal<?> key, Object value) {
    // We don't use a fast path as with get() because it is at
    // least as common to use set() to create new entries as
    // it is to replace existing ones, in which case, a fast
    // path would fail more often than not.
    Entry[] tab = table;
    int len = tab.length;
    int i = key.threadLocalHashCode & (len-1);
    for (Entry e = tab[i];
         e != null;
         e = tab[i = nextIndex(i, len)]) {
        ThreadLocal<?> k = e.get();
        if (k == key) {
            e.value = value;
            return;
        }
        if (k == null) {
            replaceStaleEntry(key, value, i);
            return;
        }
    }
    tab[i] = new Entry(key, value);
    int sz = ++size;
    if (!cleanSomeSlots(i, sz) && sz >= threshold)
        rehash();
}
```

可以看到，在set值的时候，有一定的几率会执行`replaceStaleEntry(key, value, i)`方法，其作用就是将当前的值替换掉以前的key为null的值，重复利用了空间。

### 5. ThreadLocal使用建议

通过前面几节的分析，我们基本弄清楚了ThreadLocal相关设计和内存模型，对于是否会发生内存泄露做了分析，下面总结下几点建议：

1. 当需要存储线程私有变量的时候，可以考虑使用ThreadLocal来实现
2. 当需要实现线程安全的变量时，可以考虑使用ThreadLocal来实现
3. 当需要减少线程资源竞争的时候，可以考虑使用ThreadLocal来实现
4. 注意Thread实例和ThreadLocal实例的生存周期，因为他们直接关联着存储数据的生命周期
5. 如果频繁的在线程中new ThreadLocal对象，在使用结束时，最好调用ThreadLocal.remove来释放其value的引用，避免在ThreadLocal被回收时value无法被访问却又占用着内存
6. 在进行对象跨层传递的时候，使用ThreadLocal可以避免多次传递，打破层次间的约束
7. 进行事务操作，用于存储线程事务信息
8. 数据库连接，Session会话管理

### 6. ThreadLocal需要注意的点

上面这张图详细的揭示了ThreadLocal和Thread以及ThreadLocalMap三者的关系。

1. Thread中有一个map，就是ThreadLocalMap
2. ThreadLocalMap的key是ThreadLocal，值是我们自己设定的
3. ThreadLocal是一个弱引用，当为null时，会被当成垃圾回收
4. 重点来了，如果ThreadLocal是null了，也就是要被垃圾回收器回收了，但是此时我们的ThreadLocalMap生命周期和Thread的一样，它不会回收，这时候就出现了一个现象。那就是ThreadLocalMap的key没了，但是value还在，这就造成了内存泄漏（永远不会被回收）。
5. 解决办法：使用完ThreadLocal后，执行remove操作，避免出现内存溢出情况。

## 九、队列的接口

### 1. Queue：队列

![Queue](./images/Queue.png)

#### add(E)

增加一个元索；如果队列已满，则抛出一个IIIegaISlabEepeplian异常

#### element()

返回队列头部的元素；如果队列为空，则抛出一个NoSuchElementException异常

#### offer(E)

添加一个元素并返回true；如果队列已满，则返回false

#### peek()

返回队列头部的元素；如果队列为空，则返回null

#### poll()

移除并返回队列头部的元素；如果队列为空，则返回null

#### remove()

移除并返回队列头部的元素；如果队列为空，则抛出一个NoSuchElementException异常

### 2. Deque：双端队列（extends Queue）

![Deque](./images/Deque.png)

#### addFirst(E)

在双端队列的前面增加一个元索；如果队列已满，则抛出一个IIIegaISlabEepeplian异常。当使用容量限制的deque时，通常最好使用方法offerFirst(E)。

#### addLast(E);

在双端队列的后面增加一个元索；如果队列已满，则抛出一个IIIegaISlabEepeplian异常。当使用容量限制的deque时，通常最好使用方法offerLast(E)。

#### offerFirst(E);

在双端队列的前面添加一个元素并返回true；如果队列已满，则返回false

#### offerLast(E);

在双端队列的后面添加一个元素并返回true；如果队列已满，则返回false

#### removeFirst()

移除并返回队列头部的元素；如果队列为空，则抛出一个NoSuchElementException异常

#### removeLast()

移除并返回队列尾部的元素；如果队列为空，则抛出一个NoSuchElementException异常

#### pollFirst()

移除并返回队列头部的元素；如果队列为空，则返回null

#### pollLast()

移除并返回队列尾部的元素；如果队列为空，则返回null

#### getFirst()

返回队列头部的元素；如果队列为空，则抛出一个NoSuchElementException异常

#### getLast()

返回队列尾部的元素；如果队列为空，则抛出一个NoSuchElementException异常

#### peekFirst()

返回队列头部的元素；如果队列为空，则返回null

#### peekLast()

返回队列尾部的元素；如果队列为空，则返回null

#### removeFirstOccurrence(Object)

删除指定元素第一次出现的位置所在的元素，删除成功返回true，否则返回false

#### removeLastOccurrence(Object)

删除指定元素最后一次出现的位置所在的元素，删除成功返回true，否则返回false

#### push(E)

将元素推送到此双端队列的头部；如果队列已满，则抛出一个IIIegaISlabEepeplian异常。此方法相当于addFirst(E)。

#### pop()

从这个双端队列中弹出一个元素，也就是说删除并返回此双端队列的第一个元素；如果队列为空，则抛出一个NoSuchElementException异常。 此方法相当于removeFirst() 。 

### 3. BlockingQueue：阻塞队列（extends Queue）

![BlockingQueue](./images/BlockingQueue.png)

#### put(E)

将指定的元素插入到此队列中，如果队列已满，则进行阻塞等待

#### take()

移除并返回队列头部的元素；如果队列为空，则进行阻塞等待

### 4. BlockingDeque：阻塞的双端队列（extends BlockingQueue, Deque）

![BlockingDeque](./images/BlockingDeque.png)

#### offer(E e, long timeout, TimeUnit unit) 

添加一个元素到双端队列的尾部。如果队列不满，则直接返回true；如果队列满了，在指定的时间内，队列依然是满的，则返回false，否则返回true。

#### offerFirst(E e, long timeout, TimeUnit unit) 

添加一个元素到双端队列的头部。如果队列不满，则直接返回true；如果队列满了，在指定的时间内，队列依然是满的，则返回false，否则返回true。

#### offerLast(E e, long timeout, TimeUnit unit) 

添加一个元素到双端队列的尾部。如果队列不满，则直接返回true；如果队列满了，在指定的时间内，队列依然是满的，则返回false，否则返回true。

#### poll(long timeout, TimeUnit unit) 

移除并返回队列头部的元素；如果队列为空，在指定的时间内，队列依然是空的，则返回null，否则返回指定的元素。 

#### pollFirst(long timeout, TimeUnit unit)

移除并返回队列头部的元素；如果队列为空，在指定的时间内，队列依然是空的，则返回null，否则返回指定的元素。 

#### pollLast(long timeout, TimeUnit unit) 

移除并返回队列尾部的元素；如果队列为空，在指定的时间内，队列依然是空的，则返回null，否则返回指定的元素。 

#### putFirst(E e)

将指定的元素插入到此双端队列的头部，如果队列已满，则进行阻塞等待

#### putLast(E e) 

将指定的元素插入到此双端队列的尾部，如果队列已满，则进行阻塞等待

#### takeFirst() 

移除并返回队列头部的元素；如果队列为空，则进行阻塞等待

#### takeLast() 

移除并返回队列尾部的元素；如果队列为空，则进行阻塞等待

### 5. TransferQueue

![TransferQueue](./images/TransferQueue.png)

#### tryTransfer(E e)

如果存在一个消费者已经等待接收它，则立即传送指定的元素，否则返回false，并且不进入队列。

#### tryTransfer(E e, long timeout, TimeUnit unit)

在上述方法的基础上设置超时时间

#### transfer(E e)

如果存在一个消费者已经等待接收它，则立即传送指定的元素，否则等待直到元素被消费者接收。

#### hasWaitingConsumer()

如果至少有一位消费者在等待，则返回true

#### getWaitingConsumerCount()

获取所有等待获取元素的消费线程数量

## 十、BlockingQueue的实现类

### (1). ArrayBlockingQueue

#### 1. 概述

根据 ArrayBlockingQueue 的名字我们都可以看出，它是一个队列，并且是一个基于数组的阻塞队列。同时也是一个有界队列，有界也就意味着，它不能够存储无限多数量的对象。所以在创建 ArrayBlockingQueue 时，必须要给它指定一个队列的大小。

#### 2. 使用场景

1. 先进先出队列（队列头的是最先进队的元素；队列尾的是最后进队的元素）
2. 有界队列（即初始化时指定的容量，就是队列最大的容量，不会出现扩容，容量满，则阻塞进队操作；容量空，则阻塞出队操作）
3. 队列不支持空元素

#### 3. 锁类型

单锁 + 两个condition

### (2). LinkedBlockingQueue

> 内部存储是基于链表的无界阻塞队列，由于使用了两个ReentrantLock来实现出入队列的线程安全，比ArrayBlockingQueue的吞吐量要高很多。

#### 1. 概述

LinkedBlockingQueue不同于ArrayBlockingQueue，它如果不指定容量，默认为`Integer.MAX_VALUE`，也就是无界队列。所以为了避免队列过大造成机器负载或者内存爆满的情况出现，我们在使用的时候建议手动传一个队列的大小。

#### 2. 源码剖析

##### 1. 属性

```java
/**
 * 节点类，用于存储数据
 */
static class Node<E> {
    E item;
    Node<E> next;

    Node(E x) { item = x; }
}

/** 阻塞队列的大小，默认为Integer.MAX_VALUE */
private final int capacity;

/** 当前阻塞队列中的元素个数 */
private final AtomicInteger count = new AtomicInteger();

/**
 * 阻塞队列的头结点
 */
transient Node<E> head;

/**
 * 阻塞队列的尾节点
 */
private transient Node<E> last;

/** 获取并移除元素时使用的锁，如take, poll, etc */
private final ReentrantLock takeLock = new ReentrantLock();

/** notEmpty条件对象，当队列没有数据时用于挂起执行删除的线程 */
private final Condition notEmpty = takeLock.newCondition();

/** 添加元素时使用的锁如 put, offer, etc */
private final ReentrantLock putLock = new ReentrantLock();

/** notFull条件对象，当队列数据已满时用于挂起执行添加的线程 */
private final Condition notFull = putLock.newCondition();
```

从上面的属性我们知道，每个添加到LinkedBlockingQueue队列中的数据都将被封装成Node节点，添加的链表队列中，其中head和last分别指向队列的头结点和尾结点。与ArrayBlockingQueue不同的是，LinkedBlockingQueue内部分别使用了takeLock 和 putLock 对并发进行控制，也就是说，添加和删除操作并不是互斥操作，可以同时进行，这样也就可以大大提高吞吐量。

这里如果不指定队列的容量大小，也就是使用默认的Integer.MAX_VALUE，如果存在添加速度大于删除速度时候，有可能会内存溢出，这点在使用前希望慎重考虑。

另外，LinkedBlockingQueue对每一个lock锁都提供了一个Condition用来挂起和唤醒其他线程。

##### 2. 构造函数

```java
public LinkedBlockingQueue() {
    // 默认大小为Integer.MAX_VALUE
    this(Integer.MAX_VALUE);
}

public LinkedBlockingQueue(int capacity) {
    if (capacity <= 0) throw new IllegalArgumentException();
    this.capacity = capacity;
    last = head = new Node<E>(null);
}

public LinkedBlockingQueue(Collection<? extends E> c) {
    this(Integer.MAX_VALUE);
    final ReentrantLock putLock = this.putLock;
    putLock.lock();
    try {
        int n = 0;
        for (E e : c) {
            if (e == null)
                throw new NullPointerException();
            if (n == capacity)
                throw new IllegalStateException("Queue full");
            enqueue(new Node<E>(e));
            ++n;
        }
        count.set(n);
    } finally {
        putLock.unlock();
    }
}
```

默认的构造函数和最后一个构造函数创建的队列大小都为Integer.MAX_VALUE，只有第二个构造函数用户可以指定队列的大小。第二个构造函数最后初始化了last和head节点，让它们都指向了一个元素为null的节点。

![LinkedBlockingQueue-init](./images/LinkedBlockingQueue-init.png)

最后一个构造函数使用了putLock来进行加锁，但是这里并不是为了多线程的竞争而加锁，只是为了放入的元素能立即对其他线程可见。

##### 3. 入队方法

LinkedBlockingQueue提供了多种入队操作的实现来满足不同情况下的需求，入队操作有如下几种：

###### 1. put(E e)

```java
public void put(E e) throws InterruptedException {
    if (e == null) throw new NullPointerException();
    int c = -1;
    Node<E> node = new Node<E>(e);
    final ReentrantLock putLock = this.putLock;
    final AtomicInteger count = this.count;
    // 获取锁中断
    putLock.lockInterruptibly();
    try {
        //判断队列是否已满，如果已满阻塞等待
        while (count.get() == capacity) {
            notFull.await();
        }
        // 把node放入队列中
        enqueue(node);
        c = count.getAndIncrement();
        // 再次判断队列是否有可用空间，如果有唤醒下一个线程进行添加操作
        if (c + 1 < capacity)
            notFull.signal();
    } finally {
        putLock.unlock();
    }
    // 如果队列中有一条数据，唤醒消费线程进行消费
    if (c == 0)
        signalNotEmpty();
}
```

小结put方法来看，它总共做了以下情况的考虑：

1. 队列已满，阻塞等待。
2. 队列未满，创建一个node节点放入队列中，如果放完以后队列还有剩余空间，继续唤醒下一个添加线程进行添加。如果放之前队列中没有元素，放完以后要唤醒消费线程进行消费。

###### 2. enqueue(Node node)

我们来看看该方法中用到的几个其他方法，先来看看enqueue(Node node)方法：

```java
private void enqueue(Node<E> node) {
    last = last.next = node;
}
```

该方法可能有些同学看不太懂，我们用一张图来看看往队列里依次放入元素A和元素B，毕竟无图无真相：

![LinkedBlockingQueue-enqueue](./images/LinkedBlockingQueue-enqueue.png)

接下来我们看看signalNotEmpty，顺带着看signalNotFull方法：

```java
private void signalNotEmpty() {
    final ReentrantLock takeLock = this.takeLock;
    takeLock.lock();
    try {
        notEmpty.signal();
    } finally {
        takeLock.unlock();
    }
}

private void signalNotFull() {
    final ReentrantLock putLock = this.putLock;
    putLock.lock();
    try {
        notFull.signal();
    } finally {
        putLock.unlock();
    }
}
```

为什么要这么写？因为signal的时候要获取到该signal对应的Condition对象的锁才行。

###### 3. offer(E e)

```java
public boolean offer(E e) {
    if (e == null) throw new NullPointerException();
    final AtomicInteger count = this.count;
    if (count.get() == capacity)
        return false;
    int c = -1;
    Node<E> node = new Node<E>(e);
    final ReentrantLock putLock = this.putLock;
    putLock.lock();
    try {
        // 队列有可用空间，放入node节点，判断放入元素后是否还有可用空间，
        // 如果有，唤醒下一个添加线程进行添加操作。
        if (count.get() < capacity) {
            enqueue(node);
            c = count.getAndIncrement();
            if (c + 1 < capacity)
                notFull.signal();
        }
    } finally {
        putLock.unlock();
    }
    if (c == 0)
        signalNotEmpty();
    return c >= 0;
}
```

可以看到offer仅仅对put方法改动了一点点，当队列没有可用元素的时候，不同于put方法的阻塞等待，offer方法直接方法false。

###### 4. offer(E e, long timeout, TimeUnit unit)

```java
public boolean offer(E e, long timeout, TimeUnit unit)
        throws InterruptedException {

    if (e == null) throw new NullPointerException();
    long nanos = unit.toNanos(timeout);
    int c = -1;
    final ReentrantLock putLock = this.putLock;
    final AtomicInteger count = this.count;
    putLock.lockInterruptibly();
    try {
        // 等待超时时间nanos，超时时间到了返回false
        while (count.get() == capacity) {
            if (nanos <= 0)
                return false;
            nanos = notFull.awaitNanos(nanos);
        }
        enqueue(new Node<E>(e));
        c = count.getAndIncrement();
        if (c + 1 < capacity)
            notFull.signal();
    } finally {
        putLock.unlock();
    }
    if (c == 0)
        signalNotEmpty();
    return true;
}
```

该方法只是对offer方法进行了阻塞超时处理，使用了Condition的awaitNanos来进行超时等待，这里为什么要用while循环？因为awaitNanos方法是可中断的，为了防止在等待过程中线程被中断，这里使用while循环进行等待过程中中断的处理，继续等待剩下需等待的时间。

##### 4. 出队方法

LinkedBlockingQueue提供了多种出队操作的实现来满足不同情况下的需求

###### 1. take()

```java
public E take() throws InterruptedException {
    E x;
    int c = -1;
    final AtomicInteger count = this.count;
    final ReentrantLock takeLock = this.takeLock;
    takeLock.lockInterruptibly();
    try {
        // 队列为空，阻塞等待
        while (count.get() == 0) {
            notEmpty.await();
        }
        x = dequeue();
        c = count.getAndDecrement();
        // 队列中还有元素，唤醒下一个消费线程进行消费
        if (c > 1)
            notEmpty.signal();
    } finally {
        takeLock.unlock();
    }
    // 移除元素之前队列是满的，唤醒生产线程进行添加元素
    if (c == capacity)
        signalNotFull();
    return x;
}
```

take方法看起来就是put方法的逆向操作，它总共做了以下情况的考虑：

1. 队列为空，阻塞等待。
2. 队列不为空，从队首获取并移除一个元素，如果消费后还有元素在队列中，继续唤醒下一个消费线程进行元素移除。如果放之前队列是满元素的情况，移除完后要唤醒生产线程进行添加元素。

###### 2. dequeue()

我们来看看dequeue方法

```java
private E dequeue() {
    // 获取到head节点
    Node<E> h = head;
    // 获取到head节点指向的下一个节点
    Node<E> first = h.next;
    // head节点原来指向的节点的next指向自己，等待下次gc回收
    h.next = h; // help GC
    // head节点指向新的节点
    head = first;
    // 获取到新的head节点的item值
    E x = first.item;
    // 新head节点的item值设置为null
    first.item = null;
    return x;
}
```

可能有些童鞋链表算法不是很熟悉，我们可以结合注释和图来看就清晰很多了。

![LinkedBlockingQueue-enqueue-take](./images/LinkedBlockingQueue-enqueue-take.png)

其实这个写法看起来很绕，我们其实也可以这么写：

```java
private E dequeue() {
    // 获取到head节点
    Node<E> h = head;
    // 获取到head节点指向的下一个节点，也就是节点A
    Node<E> first = h.next;
    // 获取到下下个节点，也就是节点B
    Node<E> next = first.next;
    // head的next指向下下个节点，也就是图中的B节点
    h.next = next;
    // 得到节点A的值
    E x = first.item;
    first.item = null; // help GC
    first.next = first; // help GC
    return x;
}
```

###### 3. poll()

```java
public E poll() {
    final AtomicInteger count = this.count;
    if (count.get() == 0)
        return null;
    E x = null;
    int c = -1;
    final ReentrantLock takeLock = this.takeLock;
    takeLock.lock();
    try {
        if (count.get() > 0) {
            x = dequeue();
            c = count.getAndDecrement();
            if (c > 1)
                notEmpty.signal();
        }
    } finally {
        takeLock.unlock();
    }
    if (c == capacity)
        signalNotFull();
    return x;
}
```

poll方法去除了take方法中元素为空后阻塞等待这一步骤，这里也就不详细说了。同理，poll(long timeout, TimeUnit unit)也和offer(E e, long timeout, TimeUnit unit)一样，利用了Condition的awaitNanos方法来进行阻塞等待直至超时。这里就不列出来说了。

##### 5. 获取元素方法

```java
public E peek() {
    if (count.get() == 0)
        return null;
    final ReentrantLock takeLock = this.takeLock;
    takeLock.lock();
    try {
        Node<E> first = head.next;
        if (first == null)
            return null;
        else
            return first.item;
    } finally {
        takeLock.unlock();
    }
}
```

加锁后，获取到head节点的next节点，如果为空返回null，如果不为空，返回next节点的item值。

##### 6. 删除元素方法

```java
public boolean remove(Object o) {
    if (o == null) return false;
    // 两个lock全部上锁
    fullyLock();
    try {
        // 从head开始遍历元素，直到最后一个元素
        for (Node<E> trail = head, p = trail.next;
             p != null;
             trail = p, p = p.next) {
            // 如果找到相等的元素，调用unlink方法删除元素
            if (o.equals(p.item)) {
                unlink(p, trail);
                return true;
            }
        }
        return false;
    } finally {
        // 两个lock全部解锁
        fullyUnlock();
    }
}

void fullyLock() {
    putLock.lock();
    takeLock.lock();
}

void fullyUnlock() {
    takeLock.unlock();
    putLock.unlock();
}
```

因为remove方法使用两个锁全部上锁，所以其他操作都需要等待它完成，而该方法需要从head节点遍历到尾节点，所以时间复杂度为O(n)。我们来看看unlink方法。

```java
void unlink(Node<E> p, Node<E> trail) {
    // p的元素置为null
    p.item = null;
    // p的前一个节点的next指向p的next，也就是把p从链表中去除了
    trail.next = p.next;
    // 如果last指向p，删除p后让last指向trail
    if (last == p)
        last = trail;
    // 如果删除之前元素是满的，删除之后就有空间了，唤醒生产线程放入元素
    if (count.getAndDecrement() == capacity)
        notFull.signal();
}
```

##### 7. 看源码的时候，我给自己抛出了一个问题

1. 为什么dequeue里的h.next不指向null，而指向h？
2. 为什么unlink里没有p.next = null或者p.next = p这样的操作？

这个疑问一直困扰着我，直到我看了迭代器的部分源码后才豁然开朗，下面放出部分迭代器的源码：

```java
private Node<E> current;
private Node<E> lastRet;
private E currentElement;

Itr() {
    fullyLock();
    try {
        current = head.next;
        if (current != null)
            currentElement = current.item;
    } finally {
        fullyUnlock();
    }
}

private Node<E> nextNode(Node<E> p) {
    for (;;) {
        // 解决了问题1
        Node<E> s = p.next;
        if (s == p)
            return head.next;
        if (s == null || s.item != null)
            return s;
        p = s;
    }
}
```

迭代器的遍历分为两步，第一步加双锁把元素放入临时变量中，第二部遍历临时变量的元素。也就是说remove可能和迭代元素同时进行，很有可能remove的时候，有线程在进行迭代操作，而如果unlink中改变了p的next，很有可能在迭代的时候会造成错误，造成不一致问题。这个解决了问题2。

而问题1其实在nextNode方法中也能找到，为了正确遍历，nextNode使用了 s == p的判断，当下一个元素是自己本身时，返回head的下一个节点。

##### 8. 总结

LinkedBlockingQueue是一个阻塞队列，内部由两个ReentrantLock来实现出入队列的线程安全，由各自的Condition对象的await和signal来实现等待和唤醒功能。它和ArrayBlockingQueue的不同点在于：

1. 队列大小有所不同，ArrayBlockingQueue是有界的初始化必须指定大小，而LinkedBlockingQueue可以是有界的也可以是无界的(Integer.MAX_VALUE)，对于后者而言，当添加速度大于移除速度时，在无界的情况下，可能会造成内存溢出等问题。
2. 数据存储容器不同，ArrayBlockingQueue采用的是数组作为数据存储容器，而LinkedBlockingQueue采用的则是以Node节点作为连接对象的链表。
3. 由于ArrayBlockingQueue采用的是数组的存储容器，因此在插入或删除元素时不会产生或销毁任何额外的对象实例，而LinkedBlockingQueue则会生成一个额外的Node对象。这可能在长时间内需要高效并发地处理大批量数据的时，对于GC可能存在较大影响。
4. 两者的实现队列添加或移除的锁不一样，ArrayBlockingQueue实现的队列中的锁是没有分离的，即添加操作和移除操作采用的同一个ReenterLock锁，而LinkedBlockingQueue实现的队列中的锁是分离的，其添加采用的是putLock，移除采用的则是takeLock，这样能大大提高队列的吞吐量，也意味着在高并发的情况下生产者和消费者可以并行地操作队列中的数据，以此来提高整个队列的并发性能。

##### 9. 锁类型

双锁 + 每个condition

参考：[https://blog.csdn.net/tonywu1992/article/details/83419448](https://blog.csdn.net/tonywu1992/article/details/83419448)

### (3). SynchronousQueue

#### 1. 概述

SynchronousQueue是无界的，同时也是一个同步阻塞队列，但它的特别之处在于**它内部没有容器**。每一个 put操作都必须等待一个take操作。每一个take操作也必须等待一个put操作。

SynchronousQueue是没有容量的，无法存储元素节点信息，不能通过peek方法获取元素，peek方法会直接返回null。由于没有元素，所以不能被迭代，它的iterator方法会返回一个空的迭代器`Collections.emptyIterator();`

#### 2. 用途

SynchronousQueue比较适合**线程通信**、**传递信息**、**状态切换**等应用场景，一个线程必须等待另一个线程传递某些信息给他才可以继续执行。

#### 3. 数据结构

##### 1. 堆栈

先进后出（LIFO），非公平模式，TransferStack

##### 2. 队列

先进先出（FIFO），公平模式，TransferQueue

```java
// Transferer有两个实现类：TransferQueue 和 TransferStack
public SynchronousQueue() {
    this(false);
}
//构造函数指定公平策略。默认是非公平
public SynchronousQueue(boolean fair) {
    transferer = fair ? new TransferQueue<E>() : new TransferStack<E>();
}
```

##### 3. Transferer

Transferer是SynchronousQueue的内部抽象类，双栈和双队列算法共享该类。他只有一个transfer方法，用于转移元素，从生产者转移到消费者；或者消费者调用该方法从生产者取数据。

```java
abstract static class Transferer<E> {
    abstract E transfer(E e, boolean timed, long nanos);
}
```

1. e：若不为空，就是put数据，但是当前线程需要等待消费者取走数据才可以返回。若为空，就是消费者来取数据，如果没有数据可以取就阻塞。他取走的数据就是生产者put进来的数据。
2. timed：是否设置超时时间
3. nanos：超时时间
4. transfer方法返回值如果为空，代表超时或者中断

transfer的基本思想：循环处理下面两种情况

1. 如果队列是空的，或者队列中都是相同模式（same-mode）的节点，则将当前节点添加到等待队列。等待完成或取消，然后返回匹配的item
2. 如果队列中已经存在等待的节点，并且等待的节点与当前节点的模式不同，则将等待队列对头节点出队，返回匹配项。

**解释**

由于`SynchronousQueue`是同步阻塞队列，他又不存储任何的数据（等待队列中存的是线程，不是数据队列），那么当队列空时，来了一个put请求，那么他就入队，等待take将数据取走。如果一个put请求来时，队列中已经存在了很多的put线程等待，那么这个线程直接入队，如果已经有很多take线程等待，说明有很多线程等着取数据，那么直接将数据给等待的第一个线程即可，反之亦然。

这里隐含告诉我们：**如果队列不为空，那么他们的模式（读还是写）肯定相同。**

#### 4. 简单demo

```java
public class SynchronousQueueTest2 {

    static class SynchronousQueueProducer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousQueueProducer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = UUID.randomUUID().toString();
                    System.out.println("Put: " + data);
                    blockingQueue.put(data);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SynchronousQueueConsumer implements Runnable {

        protected BlockingQueue<String> blockingQueue;

        public SynchronousQueueConsumer(BlockingQueue<String> queue) {
            this.blockingQueue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String data = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " take(): " + data);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final BlockingQueue<String> synchronousQueue = new SynchronousQueue<String>();

        SynchronousQueueProducer queueProducer = new SynchronousQueueProducer(synchronousQueue);
        new Thread(queueProducer).start();

        SynchronousQueueConsumer queueConsumer1 = new SynchronousQueueConsumer(synchronousQueue);
        new Thread(queueConsumer1).start();

        SynchronousQueueConsumer queueConsumer2 = new SynchronousQueueConsumer(synchronousQueue);
        new Thread(queueConsumer2).start();
    }
}
```

> 插入数据的线程和获取数据的线程，交替执行

#### 5. 应用场景

Executors.newCachedThreadPool()

```java
/**
 * Creates a thread pool that creates new threads as needed, but
 * will reuse previously constructed threads when they are
 * available, and uses the provided
 * ThreadFactory to create new threads when needed.
 * @param threadFactory the factory to use when creating new threads
 * @return the newly created thread pool
 * @throws NullPointerException if threadFactory is null
 */
public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
	return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
								  60L, TimeUnit.SECONDS,
								  new SynchronousQueue<Runnable>(),
								  threadFactory);
}
```

由于ThreadPoolExecutor内部实现任务提交的时候调用的是工作队列（BlockingQueue接口的实现类）的非阻塞式入队列方法（offer方法），因此，在使用SynchronousQueue作为工作队列的前提下，客户端代码向线程池提交任务时，而线程池中又没有空闲的线程能够从SynchronousQueue队列实例中取一个任务，那么相应的offer方法调用就会失败（即任务没有被存入工作队列）。此时，ThreadPoolExecutor会新建一个新的工作者线程用于对这个入队列失败的任务进行处理（假设此时线程池的大小还未达到其最大线程池大小）。

所以，使用SynchronousQueue作为工作队列，工作队列本身并不限制待执行的任务的数量。但此时需要限定线程池的最大大小为一个合理的有限值，而不是Integer.MAX_VALUE，否则可能导致线程池中的工作者线程的数量一直增加到系统资源所无法承受为止。

> 如果应用程序确实需要比较大的工作队列容量，而又想避免无界工作队列可能导致的问题，不妨考虑SynchronousQueue。SynchronousQueue实现上并不使用存储空间。
>
> 使用SynchronousQueue的目的就是保证“对于提交的任务，如果有空闲线程，则使用空闲线程来处理；否则新建一个线程来处理任务”。

参考文档：

SynchronousQueue实现原理：https://zhuanlan.zhihu.com/p/29227508

SynchronousQueue原理解析：https://www.jianshu.com/p/af6f83c78506

Java阻塞队列SynchronousQueue详解：https://www.jianshu.com/p/376d368cb44f

### (4). LinkedTransferQueue

#### 1. 概述

LinkedTransferQueue是一个由链表结构组成的无界阻塞TransferQueue队列。相对于其他阻塞队列，LinkedTransferQueue多了tryTransfer和transfer方法。

LinkedTransferQueue采用一种预占模式。意思就是消费者线程取元素时，如果队列不为空，则直接取走数据，若队列为空，那就生成一个节点（节点元素为null）入队，然后消费者线程被等待在这个节点上，后面生产者线程入队时发现有一个元素为null的节点，生产者线程就不入队了，直接就将元素填充到该节点，并唤醒该节点等待的线程，被唤醒的消费者线程取走元素，从调用的方法返回。我们称这种节点操作为“匹配”方式。

LinkedTransferQueue是ConcurrentLinkedQueue、SynchronousQueue（公平模式下转交元素）、LinkedBlockingQueue（阻塞Queue的基本方法）的超集。而且LinkedTransferQueue更好用，因为它不仅仅综合了这几个类的功能，同时也提供了更高效的实现。

#### 2. 关键源码剖析

> 阻塞队列不外乎`put ，take，offer ，poll`等方法，再加上`TransferQueue`的 几个 `tryTransfer` 方法。我们看看这几个方法的实现。

##### 1. Node

```java
static final class Node {
    // 如果是消费者请求的节点，则isData为false，否则该节点为生产（数据）节点为true
    final boolean isData;   // false if this is a request node
    // 数据节点的值，若是消费者节点，则item为null
    volatile Object item;   // initially non-null if isData; CASed to match
    // 指向下一个节点
    volatile Node next;
    // 等待线程
    volatile Thread waiter; // null until waiting
 
    // CAS设置next
    final boolean casNext(Node cmp, Node val) {
        return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
    }
 
    // CAS设置item
    final boolean casItem(Object cmp, Object val) {
        // assert cmp == null || cmp.getClass() != Node.class;
        return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
    }
 
    // 构造方法
    Node(Object item, boolean isData) {
        UNSAFE.putObject(this, itemOffset, item); // relaxed write
        this.isData = isData;
    }
 
    // 将next指向自己
    final void forgetNext() {
        UNSAFE.putObject(this, nextOffset, this);
    }
 
    // 匹配或者节点被取消的时候会调用，设置item自连接，waiter为null
    final void forgetContents() {
        UNSAFE.putObject(this, itemOffset, this);
        UNSAFE.putObject(this, waiterOffset, null);
    }
 
    // 节点是否被匹配过了
    final boolean isMatched() {
        Object x = item;
        return (x == this) || ((x == null) == isData);
    }
 
    // 是否是一个未匹配的请求节点
    // 如果是的话，则isData为false，且item为null，因为如果被匹配过了，item就不再为null，而是指向自己
    final boolean isUnmatchedRequest() {
        return !isData && item == null;
    }
 
    // 如果给定节点不能连接在当前节点后则返回true
    final boolean cannotPrecede(boolean haveData) {
        boolean d = isData;
        Object x;
        return d != haveData && (x = item) != this && (x != null) == d;
    }
 
    // 匹配一个数据节点
    final boolean tryMatchData() {
        // assert isData;
        Object x = item;
        if (x != null && x != this && casItem(x, null)) {
            LockSupport.unpark(waiter);
            return true;
        }
        return false;
    }
 
    private static final long serialVersionUID = -3375979862319811754L;
 
    // Unsafe mechanics
    private static final sun.misc.Unsafe UNSAFE;
    private static final long itemOffset;
    private static final long nextOffset;
    private static final long waiterOffset;
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = Node.class;
            itemOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("item"));
            nextOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("next"));
            waiterOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("waiter"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
```

匹配前后节点item的变化，其中node1为数据节点，node2为消费者请求的占位节点：

| Node   | node1（isData-item） | node2（isData-item） |
| ------ | -------------------- | -------------------- |
| 匹配前 | true-item            | false-null           |
| 匹配后 | true-null            | false-this           |

1. 数据节点，则匹配前item不为null且不为自身，匹配后设置为null。
2. 占位请求节点，匹配前item为null，匹配后自连接。

##### 2. 重要属性

```java
// 是否为多核
private static final boolean MP =
Runtime.getRuntime().availableProcessors() > 1;
 
// 作为第一个等待节点在阻塞之前的自旋次数
private static final int FRONT_SPINS   = 1 << 7;
 
// 前驱节点正在处理，当前节点在阻塞之前的自旋次数
private static final int CHAINED_SPINS = FRONT_SPINS >>> 1;
 
// sweepVotes的阈值
static final int SWEEP_THRESHOLD = 32;
 
// 队列首节点
transient volatile Node head;
 
// 队列尾节点
private transient volatile Node tail;
 
// 断开被删除节点失败的次数
private transient volatile int sweepVotes;
 
// xfer方法的how参数的可能取值
// 用于无等待的poll、tryTransfer
private static final int NOW   = 0; // for untimed poll, tryTransfer
// 用于offer、put、add
private static final int ASYNC = 1; // for offer, put, add
// 用于无超时的阻塞transfer、take
private static final int SYNC  = 2; // for transfer, take
// 用于超时等待的poll、tryTransfer
private static final int TIMED = 3; // for timed poll, tryTransfer
```

##### 3. 入队出队方法

```java
// 入队方法
public void put(E e) {
    xfer(e, true, ASYNC, 0);
}
 
public boolean offer(E e, long timeout, TimeUnit unit) {
    xfer(e, true, ASYNC, 0);
    return true;
}
 
public boolean offer(E e) {
    xfer(e, true, ASYNC, 0);
    return true;
}
 
public boolean add(E e) {
    xfer(e, true, ASYNC, 0);
    return true;
}

public boolean tryTransfer(E e) {
    return xfer(e, true, NOW, 0) == null;
}
 
public void transfer(E e) throws InterruptedException {
    if (xfer(e, true, SYNC, 0) != null) {
        Thread.interrupted(); // failure possible only due to interrupt
        throw new InterruptedException();
    }
}
 
public boolean tryTransfer(E e, long timeout, TimeUnit unit)
    throws InterruptedException {
    if (xfer(e, true, TIMED, unit.toNanos(timeout)) == null)
        return true;
    if (!Thread.interrupted())
        return false;
    throw new InterruptedException();
}
 
// 出队方法
public E take() throws InterruptedException {
    E e = xfer(null, false, SYNC, 0);
    if (e != null)
        return e;
    Thread.interrupted();
    throw new InterruptedException();
}
 
public E poll() {
    return xfer(null, false, NOW, 0);
}
 
public E poll(long timeout, TimeUnit unit) throws InterruptedException {
    E e = xfer(null, false, TIMED, unit.toNanos(timeout));
    if (e != null || !Thread.interrupted())
        return e;
    throw new InterruptedException();
}
```

我们可以看到，这些出队、入队方法都会调用xfer方法，因为LinkedTransferQueue是无界的，入队操作都会成功，所以入队操作都是ASYNC的，而出队方法，则是根据不同的要求传入不同的值，比如需要阻塞的出队方法就传入SYNC，需要加入超时控制的就传入TIMED。

##### 4. xfer方法

```java
private E xfer(E e, boolean haveData, int how, long nanos) {
    // 如果haveData但是e为null，则抛出NullPointerException异常
    if (haveData && (e == null))
        throw new NullPointerException();
    // s是将要被添加的节点，如果需要
    Node s = null;                        // the node to append, if needed
 
    retry:
    for (;;) {                            // restart on append race
        // 从首节点开始匹配
        for (Node h = head, p = h; p != null;) { // find & match first node
            boolean isData = p.isData;
            Object item = p.item;
            // 判断节点是否被匹配过
            // item != null有2种情况：一是put操作，二是take的item被修改了(匹配成功)
            // (itme != null) == isData 要么表示p是一个put操作，要么表示p是一个还没匹配成功的take操作
            if (item != p && (item != null) == isData) { // unmatched
                // 节点与此次操作模式一致，无法匹配
                if (isData == haveData)   // can't match
                    break;
                // 匹配成功
                if (p.casItem(item, e)) { // match
                    for (Node q = p; q != h;) {
                        Node n = q.next;  // update by 2 unless singleton
                        // 更新head为匹配节点的next节点
                        if (head == h && casHead(h, n == null ? q : n)) {
                            // 将旧节点自连接
                            h.forgetNext();
                            break;
                        }                 // advance and retry
                        if ((h = head)   == null ||
                            (q = h.next) == null || !q.isMatched())
                            break;        // unless slack < 2
                    }
                    // 匹配成功，则唤醒阻塞的线程
                    LockSupport.unpark(p.waiter);
                    // 类型转换，返回匹配节点的元素
                    return LinkedTransferQueue.<E>cast(item);
                }
            }
            // 若节点已经被匹配过了，则向后寻找下一个未被匹配的节点
            Node n = p.next;
            // 如果当前节点已经离队，则从head开始寻找
            p = (p != n) ? n : (h = head); // Use head if p offlist
        }
 
        // 若整个队列都遍历之后，还没有找到匹配的节点，则进行后续处理
        // 把当前节点加入到队列尾
        if (how != NOW) {                 // No matches available
            if (s == null)
                s = new Node(e, haveData);
            // 将新节点s添加到队列尾并返回s的前驱节点
            Node pred = tryAppend(s, haveData);
            // 前驱节点为null，说明有其他线程竞争，并修改了队列，则从retry重新开始
            if (pred == null)
                continue retry;           // lost race vs opposite mode
            // 不为ASYNC方法，则同步阻塞等待
            if (how != ASYNC)
                return awaitMatch(s, pred, e, (how == TIMED), nanos);
        }
        // how == NOW，则立即返回
        return e; // not waiting
    }
}
```

xfer方法的整个操作流程如下所示：

1. 寻找和操作匹配的节点
   - 从head开始向后遍历寻找未被匹配的节点，找到一个未被匹配并且和本次操作的模式不同的节点，匹配节点成功就通过CAS 操作将匹配节点的item字段设置为e，若修改失败，则继续向后寻找节点
   - 通过CAS操作更新head节点为匹配节点的next节点，旧head节点进行自连接，唤醒匹配节点的等待线程waiter，返回匹配的 item。如果CAS失败，并且松弛度大于等于2，就需要重新获取head重试。
2. 如果在上述操作中没有找到匹配节点，则根据参数how做不同的处理：
   - NOW：立即返回，也不会插入节点
   - SYNC：插入一个item为e（isData = haveData）到队列的尾部，然后自旋或阻塞当前线程直到节点被匹配或者取消。
   - ASYNC：插入一个item为e（isData = haveData）到队列的尾部，不阻塞直接返回。

上面提到了一个松弛度的概念，它是什么作用呢？

在节点被匹配（被删除）之后，不会立即更新head/tail，而是当 head/tail 节点和最近一个未匹配的节点之间的距离超过一个“松弛阀值”之后才会更新（在LinkedTransferQueue中，这个值为 2）。这个“松弛阀值”一般为1-3，如果太大会降低缓存命中率，并且会增加遍历链的长度；太小会增加 CAS 的开销。

##### 5. 入队操作则是调用了tryAppend方法

```java
private Node tryAppend(Node s, boolean haveData) {
    // 从尾节点开始
    for (Node t = tail, p = t;;) {        // move p to last node and append
        Node n, u;                        // temps for reads of next & tail
        // 队列为空，则将s设置为head并返回s
        if (p == null && (p = head) == null) {
            if (casHead(null, s))
                return s;                 // initialize
        }
        else if (p.cannotPrecede(haveData))
            return null;                  // lost race vs opposite mode
        // 不是最后一个节点
        else if ((n = p.next) != null)    // not last; keep traversing
            p = p != t && t != (u = tail) ? (t = u) : // stale tail
                (p != n) ? n : null;      // restart if off list
        // CAS失败
        else if (!p.casNext(null, s))
            p = p.next;                   // re-read on CAS failure
        else {
            // 更新tail
            if (p != t) {                 // update if slack now >= 2
                while ((tail != t || !casTail(t, s)) &&
                        (t = tail)   != null &&
                        (s = t.next) != null && // advance and retry
                        (s = s.next) != null && s != t);
            }
            return p;
        }
    }
}
```

该方法主要逻辑为：添加节点s到队列尾并返回s的前继节点，失败时（与其他不同模式线程竞争失败）返回null，没有前继节点则返回自身。

加入队列后，如果how还不是ASYNC则调用awaitMatch()方法阻塞等待：

##### 6. awaitMatch阻塞等待

```java
private E awaitMatch(Node s, Node pred, E e, boolean timed, long nanos) {
    // 计算超时时间点
    final long deadline = timed ? System.nanoTime() + nanos : 0L;
    // 获取当前线程对象
    Thread w = Thread.currentThread();
    // 自旋次数
    int spins = -1; // initialized after first item and cancel checks
    // 随机数
    ThreadLocalRandom randomYields = null; // bound if needed
 
    for (;;) {
        Object item = s.item;
        // 若有其它线程匹配了该节点
        if (item != e) {                  // matched
            // assert item != s;
            // 撤销该节点，并返回匹配值
            s.forgetContents();           // avoid garbage
            return LinkedTransferQueue.<E>cast(item);
        }
        // 线程中断或者超时，则将s的节点item设置为s
        if ((w.isInterrupted() || (timed && nanos <= 0)) &&
                s.casItem(e, s)) {        // cancel
            // 断开节点
            unsplice(pred, s);
            return e;
        }
 
        // 自旋
        if (spins < 0) {                  // establish spins at/near front
            // 计算自旋次数
            if ((spins = spinsFor(pred, s.isData)) > 0)
                randomYields = ThreadLocalRandom.current();
        }
        else if (spins > 0) {             // spin
            --spins;
            // 生成随机数来让出CPU时间
            if (randomYields.nextInt(CHAINED_SPINS) == 0)
                Thread.yield();           // occasionally yield
        }
        // 将s的waiter设置为当前线程
        else if (s.waiter == null) {
            s.waiter = w;                 // request unpark then recheck
        }
        // 超时阻塞
        else if (timed) {
            nanos = deadline - System.nanoTime();
            if (nanos > 0L)
                LockSupport.parkNanos(this, nanos);
        }
        // 非超时阻塞
        else {
            LockSupport.park(this);
        }
    }
}
```

当前操作为同步操作时，会调用awaitMatch方法阻塞等待匹配，成功返回匹配节点 item，失败返回给定参数e（s.item）。在等待期间如果线程被中断或等待超时，则取消匹配，并调用unsplice方法解除节点s和其前继节点的链接。

##### 7. unsplice解除节点链接

```java
final void unsplice(Node pred, Node s) {
    // 设置item自连接，waiter为null
    s.forgetContents(); // forget unneeded fields
    
    if (pred != null && pred != s && pred.next == s) {
        // 获取s的后继节点
        Node n = s.next;
        // s的后继节点为null，或不为null，就将s的前驱节点的后继节点设置为n
        if (n == null ||
            (n != s && pred.casNext(s, n) && pred.isMatched())) {
            for (;;) {               // check if at, or could be, head
                Node h = head;
                if (h == pred || h == s || h == null)
                    return;          // at head or list empty
                if (!h.isMatched())
                    break;
                Node hn = h.next;
                if (hn == null)
                    return;          // now empty
                if (hn != h && casHead(h, hn))
                    h.forgetNext();  // advance head
            }
            if (pred.next != pred && s.next != s) { // recheck if offlist
                for (;;) {           // sweep now if enough votes
                    int v = sweepVotes;
                    if (v < SWEEP_THRESHOLD) {
                        if (casSweepVotes(v, v + 1))
                            break;
                    }
                    // 达到阀值，进行“大扫除”，清除队列中的无效节点
                    else if (casSweepVotes(v, 0)) {
                        sweep();
                        break;
                    }
                }
            }
        }
    }
}
```

如果s的前继节点pred还是指向s（pred.next == s），尝试解除s的链接，若s不是自连接节点，就把pred的next引用指向s的next节点。如果s不能被解除（由于它是尾节点或者pred可能被解除链接，并且pred和s都不是head节点或已经出列），则添加到sweepVotes，sweepVotes累计到阀值SWEEP_THRESHOLD之后就调用sweep()对队列进行一次“大扫除”，清除队列中所有的无效节点：

##### 8. sweep清除无效节点

```java
private void sweep() {
    for (Node p = head, s, n; p != null && (s = p.next) != null; ) {
        if (!s.isMatched())
            // Unmatched nodes are never self-linked
            p = s;
        else if ((n = s.next) == null) // trailing node is pinned
            break;
        else if (s == n)    // stale
            // No need to also check for p == s, since that implies s == n
            p = head;
        else
            p.casNext(s, n);
    }
}
```

##### 9. 整个过程如下图：

![LinkedTransferQueue-xfer.webp](./images/LinkedTransferQueue-xfer.webp.jpg)

相比较 `SynchronousQueue` 多了一个可以存储的队列，相比较 `LinkedBlockingQueue` 多了直接传递元素，少了用锁来同步。性能更高，用处更大。

##### 10. 总结

`LinkedTransferQueue`是 `SynchronousQueue` 和 `LinkedBlockingQueue` 的合体，性能比 `LinkedBlockingQueue` 更高（没有锁操作），比 `SynchronousQueue`能存储更多的元素。

当 `put` 时，如果有等待的线程，就直接将元素 “交给” 等待者， 否则直接进入队列。

`put`和 `transfer` 方法的区别是，put 是立即返回的， transfer 是阻塞等待消费者拿到数据才返回。`transfer`方法和 `SynchronousQueue`的 put 方法类似。

参考文档：

[https://blog.csdn.net/qq_38293564/article/details/80593821](https://blog.csdn.net/qq_38293564/article/details/80593821)

### (5). PriorityBlockingQueue

#### 1. 概述

PriorityBlockingQueue是一个支持优先级的无界阻塞队列，直到系统资源耗尽。默认情况下元素采用自然顺序升序排列。也可以自定义类实现compareTo()方法来指定元素排序规则，或者初始化PriorityBlockingQueue时，指定构造参数Comparator来对元素进行排序。但需要注意的是不能保证同优先级元素的顺序。PriorityBlockingQueue也是基于最小二叉堆实现，使用基于CAS实现的自旋锁来控制队列的动态扩容，保证了扩容操作不会阻塞take操作的执行。

#### 2. 前置知识：优先队列(堆)

##### 1. 队列与优先队列的区别

1. **队列**是一种**FIFO**（First-In-First-Out）先进先出的数据结构，对应于生活中的排队的场景，排在前面的人总是先通过，**依次进行**。
2. **优先队列**是特殊的队列，从“优先”一词，可看出**有“插队现象”**。比如在火车站排队进站时，就会有些比较急的人来插队，他们就在前面先通过验票。优先队列**至少含有两种操作**的数据结构：**insert（插入）**，即将元素插入到优先队列中（入队）；以及**deleteMin（删除最小者）**，它的作用是找出、删除优先队列中的最小的元素（出队）。

![优先队列基本模型](./images/优先队列基本模型.jpg)

##### 2. 优先队列（堆）的特性

优先队列的实现常选用**二叉堆**，**在数据结构中，优先队列一般也是指堆**。

**堆的两个性质：**

1. **结构性**：**堆是一颗除底层外被完全填满的二叉树，底层的节点从左到右填入，**这样的树叫做**完全二叉树。**
2. **堆序性：**由于我们想很快找出最小元，则最小元应该在根上，**任意节点都小于它的后裔**，这就是**小顶堆（Min-Heap）**；如果是查找最大元，则最大元应该在根上，**任意节点都要大于它的后裔**，这就是**大顶堆(Max-heap)。**

##### 3. 结构性

![一颗 完全二叉树的结构性](./images/一颗完全二叉树的结构性.jpg)

通过观察发现，**完全二叉树可以直接使用一个数组表示**而不需要使用其他数据结构。所以我们只需要传入一个size就可以构建优先队列的结构（元素之间使用compareTo方法进行比较）。

![完全二叉树的数组实现](./images/完全二叉树的数组实现.jpg)

对于数组中的任意位置 i 的元素，其**左儿子**在位置 **2i** 上，则**右儿子**在 **2i+1** 上，**父节点**在 在 **i/2**（向下取整）上。通常从数组下标1开始存储，这样的好处在于很方便找到左右、及父节点。如果从0开始，左儿子在2i+1,右儿子在2i+2,父节点在(i-1)/2（向下取整）。

##### 4. 堆序性

我们这建立**最小堆，即对于每一个元素X，X的父亲中的关键字小于（或等于）X中的关键字，根节点除外（它没有父节点）。**

![一颗完全二叉树的堆序性](./images/一颗完全二叉树的堆序性.jpg)

如图所示，只有左边是堆，右边红色节点违反堆序性。根据堆序性，只需要常O(1)找到最小元。

##### 5. 堆的基本操作：insert（插入）

**上滤**：**为了插入元素X，我们在下一个可用的位置建立空穴**（否则会破坏结构性，不是完全二叉树）。**如果此元素放入空穴不破坏堆序性，则插入完成；否则，将父节点下移到空穴，即空穴向根的方向上冒一步。**继续该过程，直到X插入空穴为止。这样的过程称为上滤。

![二叉堆尝试插入-1](./images/二叉堆尝试插入-1.jpg)

![二叉堆尝试插入-2](./images/二叉堆尝试插入-2.jpg)

图中演示了18插入的过程，**在下一个可用的位置建立空穴（满足结构性），发现不能直接插入，将父节点移下来，空穴上冒。继续这个过程，直到满足堆序性。**这样就实现了元素插入到优先队列（堆）中。

##### 6. java实现上滤

```java
/**
 * 插入到优先队列，维护堆序性
 *
 * @param x ：插入的元素
 */
public void insert(T x) {
	if (null == x) {
		return;
	}
	//扩容
	if (currentSize == array.length - 1) {
		enlargeArray(array.length * 2 + 1);
	}
	//上滤
	int hole = ++currentSize;
	for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
		array[hole] = array[hole / 2];
	}
	array[hole] = x;
}

/**
 * 扩容方法
 *
 * @param newSize ：扩容后的容量，为原来的2倍+1
 */
private void enlargeArray(int newSize) {
	T[] old = array;
	array = (T[]) new Comparable[newSize];
	System.arraycopy(old, 0, array, 0, old.length);
}
```

可以反复使用交换操作来进行上滤过程，但如果插入X上滤d层，则需要3d次赋值；我们这种方式只需要d+1次赋值。

如果插入的元素是新的最小元从而一直上滤到根处，那么这种插入的时间长达O(logN)。但平均来看，上滤终止得要早。**业已证明，执行依次插入平均需要2.607次比较，因此平均insert操作上移元素1.607层。**上滤次数只比插入次数少一次。

##### 7. 堆的基本操作：deleteMin（删除）

**下滤**：类似于上滤操作。因为我们建立的是最小堆，所以删除最小元，就是将根节点删掉，这样就破坏了结构性。所以**我们在根节点处建立空穴，为了满足结构性，堆中最后一个元素X必须移动到合适的位置，如果可以直接放到空穴，则删除完成（一般不可能）；否则，将空穴的左右儿子中较小者移到空穴，即空穴下移了一层。继续这样的操作，直到X可以放入到空穴中。**这样就可以满足结构性与堆序性。这个过程称为下滤。

![二叉堆删除最小元-1](./images/二叉堆删除最小元-1.jpg)

![二叉堆删除最小元-2](./images/二叉堆删除最小元-2.jpg)

如图所示：**在根处建立空穴，将最后一个元素放到空穴，已满足结构性；为满足堆序性，需要将空穴下移到合适的位置。**

**注意：堆**的实现中，经常发生的错误是**只有偶数个元素**，**即有一个节点只有一个儿子。**所以**需要测试右儿子的存在性。**

##### 8. java实现下滤

```java
/**
 * 删除最小元
 * 若优先队列为空，抛出UnderflowException
 *
 * @return ：返回最小元
 */
public T deleteMin() {
	if (isEmpty()) {
		throw new UnderflowException();
	}

	T minItem = findMin();
	array[1] = array[currentSize--];
	percolateDown(1);

	return minItem;
}

 /**
 * 下滤方法
 *
 * @param hole ：从数组下标hole1开始下滤
 */
private void percolateDown(int hole) {
	int child;
	T tmp = array[hole];

	for (; hole * 2 <= currentSize; hole = child) {
		//左儿子
		child = hole * 2;
		//判断右儿子是否存在
		if (child != currentSize &&
				array[child + 1].compareTo(array[child]) < 0) {
			child++;
		}
		if (array[child].compareTo(tmp) < 0) {
			array[hole] = array[child];
		} else {
			break;
		}
	}
	array[hole] = tmp;
}
```

**这种操作最坏时间复杂度是O(logN)。平均而言，被放到根处的元素几乎下滤到底层（即来自的那层），所以平均时间复杂度是O(logN)。**

##### 7. 总结

优先队列常使用二叉堆实现，本篇图解了二叉堆最基本的两个操作：插入及删除最小元。insert以O(1)常数时间执行，deleteMin以O(logN)执行。

#### 3. 源码剖析

##### 1. 定义的重要属性

```java
// 默认容量
private static final int DEFAULT_INITIAL_CAPACITY = 11;

// 最大容量
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

// 二叉堆数组
private transient Object[] queue;

// 队列元素的个数
private transient int size;

// 比较器，如果为空，则为自然顺序
private transient Comparator<? super E> comparator;

// 内部锁
private final ReentrantLock lock;

private final Condition notEmpty;

// 
private transient volatile int allocationSpinLock;

// 优先队列：主要用于序列化，这是为了兼容之前的版本。只有在序列化和反序列化才非空
private PriorityQueue<E> q;
```

内部仍然采用可重入锁ReentrantLock来实现同步机制，但是这里只有一个notEmpty的Condition，了解了ArrayBlockingQueue我们知道它定义了两个Condition，之类为何只有一个呢？原因就在于PriorityBlockingQueue是一个无界队列，插入总是会成功，除非消耗尽了资源导致服务器挂。

##### 2. 入列：put

put(E e) ：将指定元素插入此优先级队列。

```java
public void put(E e) {
    offer(e); // never need to block
}
```

PriorityBlockingQueue是无界的，所以不可能会阻塞。内部调用offer(E e)：

##### 3. 入列：offer

```java
public boolean offer(E e) {
    // 不能为null
    if (e == null)
        throw new NullPointerException();
    // 获取锁
    final ReentrantLock lock = this.lock;
    lock.lock();
    int n, cap;
    Object[] array;
    // 扩容
    while ((n = size) >= (cap = (array = queue).length))
        tryGrow(array, cap);
    try {
        Comparator<? super E> cmp = comparator;
        // 根据比较器是否为null，做不同的处理
        if (cmp == null)
            siftUpComparable(n, e, array);
        else
            siftUpUsingComparator(n, e, array, cmp);
        size = n + 1;
        // 唤醒正在等待的消费者线程
        notEmpty.signal();
    } finally {
        lock.unlock();
    }
    return true;
}
```

##### 4. siftUpComparable

当比较器comparator为null时，采用自然排序，调用siftUpComparable方法：

```java
private static <T> void siftUpComparable(int k, T x, Object[] array) {
    Comparable<? super T> key = (Comparable<? super T>) x;
    // “上冒”过程
    while (k > 0) {
        // 父级节点 （n - ） / 2
        int parent = (k - 1) >>> 1;
        Object e = array[parent];

        // key >= parent 完成（最大堆）
        if (key.compareTo((T) e) >= 0)
            break;
        // key < parant 替换
        array[k] = e;
        k = parent;
    }
    array[k] = key;
}
```

这段代码所表示的意思：将元素X插入到数组中，然后进行调整以保持二叉堆的特性。

##### 5. siftUpUsingComparator

当比较器不为null时，采用所指定的比较器，调用siftUpUsingComparator方法：

```java
private static <T> void siftUpUsingComparator(int k, T x, Object[] array,
                                              Comparator<? super T> cmp) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = array[parent];
        if (cmp.compare(x, (T) e) >= 0)
            break;
        array[k] = e;
        k = parent;
    }
    array[k] = x;
}
```

##### 6. tryGrow：扩容

```java
private void tryGrow(Object[] array, int oldCap) {
    lock.unlock();      // 扩容操作使用自旋，不需要锁主锁，释放
    Object[] newArray = null;
    // CAS 占用
    if (allocationSpinLock == 0 && UNSAFE.compareAndSwapInt(this, allocationSpinLockOffset, 0, 1)) {
        try {

            // 新容量  最小翻倍
            int newCap = oldCap + ((oldCap < 64) ? (oldCap + 2) :  (oldCap >> 1));

            // 超过
            if (newCap - MAX_ARRAY_SIZE > 0) {    // possible overflow
                int minCap = oldCap + 1;
                if (minCap < 0 || minCap > MAX_ARRAY_SIZE)
                    throw new OutOfMemoryError();
                newCap = MAX_ARRAY_SIZE;        // 最大容量
            }
            if (newCap > oldCap && queue == array)
                newArray = new Object[newCap];
        } finally {
            allocationSpinLock = 0;     // 扩容后allocationSpinLock = 0 代表释放了自旋锁
        }
    }
    // 到这里如果是本线程扩容newArray肯定是不为null，为null就是其他线程在处理扩容，那就让给别的线程处理
    if (newArray == null)
        Thread.yield();
    // 主锁获取锁
    lock.lock();
    // 数组复制
    if (newArray != null && queue == array) {
        queue = newArray;
        System.arraycopy(array, 0, newArray, 0, oldCap);
    }
}
```

整个添加元素的过程和上面二叉堆一模一样：先将元素添加到数组末尾，然后采用“上冒”的方式将该元素尽量往上冒。

##### 7. 出列：poll

```java
public E poll() {
    final ReentrantLock lock = this.lock;
    lock.lock();
    try {
        return dequeue();
    } finally {
        lock.unlock();
    }
}
```

先获取锁，然后调用dequeue()方法：

##### 8. dequeue

```java
private E dequeue() {
    // 没有元素 返回null
    int n = size - 1;
    if (n < 0)
        return null;
    else {
        Object[] array = queue;
        // 出对元素
        E result = (E) array[0];
        // 最后一个元素（也就是插入到空穴中的元素）
        E x = (E) array[n];
        array[n] = null;
        // 根据比较器释放为null，来执行不同的处理
        Comparator<? super E> cmp = comparator;
        if (cmp == null)
            siftDownComparable(0, x, array, n);
        else
            siftDownUsingComparator(0, x, array, n, cmp);
        size = n;
        return result;
    }
}
```

##### 9. siftDownComparable

如果比较器为null，则调用siftDownComparable来进行自然排序处理：

```java
private static <T> void siftDownComparable(int k, T x, Object[] array,
                                           int n) {
    if (n > 0) {
        Comparable<? super T> key = (Comparable<? super T>)x;
        // 最后一个叶子节点的父节点位置
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;       // 待调整位置左节点位置
            Object c = array[child];        //左节点
            int right = child + 1;          //右节点

            //左右节点比较，取较小的
            if (right < n &&
                ((Comparable<? super T>) c).compareTo((T) array[right]) > 0)
                c = array[child = right];

            //如果待调整key最小，那就退出，直接赋值
            if (key.compareTo((T) c) <= 0)
                break;
            //如果key不是最小，那就取左右节点小的那个放到调整位置，然后小的那个节点位置开始再继续调整
            array[k] = c;
            k = child;
        }
        array[k] = key;
    }
}
```

处理思路和二叉堆删除节点的逻辑一样：就第一个元素定义为空穴，然后把最后一个元素取出来，尝试插入到空穴位置，并与两个子节点值进行比较，如果不符合，则与其中较小的子节点进行替换，然后继续比较调整。

##### 10. siftDownUsingComparator

如果指定了比较器，则采用比较器来进行调整：

```java
private static <T> void siftDownUsingComparator(int k, T x, Object[] array,
                                                int n,
                                                Comparator<? super T> cmp) {
    if (n > 0) {
        int half = n >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = array[child];
            int right = child + 1;
            if (right < n && cmp.compare((T) c, (T) array[right]) > 0)
                c = array[child = right];
            if (cmp.compare(x, (T) c) <= 0)
                break;
            array[k] = c;
            k = child;
        }
        array[k] = x;
    }
}
```

PriorityBlockingQueue采用二叉堆来维护，所以整个处理过程不是很复杂，添加操作则是不断“上冒”，而删除操作则是不断“下掉”。掌握二叉堆就掌握了PriorityBlockingQueue，无论怎么变还是。对于PriorityBlockingQueue需要注意的是他是一个无界队列，所以添加操作是不会失败的，除非资源耗尽。

#### 4. 参考文档：

最详细版图解优先队列（堆）：[https://www.cnblogs.com/9dragon/p/10739121.html](https://www.cnblogs.com/9dragon/p/10739121.html)

PriorityBlockingQueue 源码分析：[https://www.cnblogs.com/yaowen/p/10708249.html](https://www.cnblogs.com/yaowen/p/10708249.html)

JUC之阻塞队列PriorityBlockingQueue：[https://www.jianshu.com/p/43954715aa28](https://www.jianshu.com/p/43954715aa28)

### (6). DelayQueue

#### 1. 概述

DelayQueue是一个无界的BlockingQueue实现，加入其中的元素必需实现Delayed接口。当生产者线程调用put之类的方法加入元素时，会触发Delayed接口中的compareTo方法进行排序，也就是说队列中元素的顺序是按到期时间排序的，而非它们进入队列的顺序。排在队列头部的元素是最早到期的，越往后到期时间赿晚。

**执行过程描述**

消费者线程查看队列头部的元素，注意是查看不是取出。然后调用元素的getDelay方法，如果此方法返回的值小０或者等于０，则消费者线程会从队列中取出此元素，并进行处理。如果getDelay方法返回的值大于0，则消费者线程wait返回的时间值后，再从队列头部取出元素，此时元素应该已经到期。

DelayQueue是Leader-Followr模式的变种，消费者线程处于等待状态时，总是等待最先到期的元素，而不是长时间的等待。消费者线程尽量把时间花在处理任务上，最小化空等的时间，以提高线程的利用效率。

以下通过队列及消费者线程状态变化大致说明一下DelayQueue的运行过程。

#### 2. 初始状态

![delayQueue-初始状态](./images/delayQueue-初始状态.png)

因为队列是没有边界的，向队列中添加元素的线程不会阻塞，添加操作相对简单，所以此图不考虑向队列添加元素的生产者线程。假设现在共有三个消费者线程。

队列中的元素按到期时间排序，队列头部的元素2s以后到期。消费者线程１查看了头部元素以后，发现还需要2s才到期，于是它进入等待状态，2s以后醒来，等待头部元素到期的线程称为Leader线程。

消费者线程2与消费者线程3处于待命状态，它们不等待队列中的非头部元素。当消费者线程１拿到对象5以后，会向它们发送signal。这个时候两个中的一个会结束待命状态而进入等待状态。

#### 3. 2s以后

![delayQueue-2s以后](./images/delayQueue-2s以后.png)

消费者线程１已经拿到了对象５，从等待状态进入处理状态，处理它取到的对象５，同时向消费者线程2与消费者线程3发送signal。

消费者线程2与消费者线程3会争抢领导权，这里是消费者线程2进入等待状态，成为Leader线程，等待2s以后对象4到期。而消费者线程3则继续处于待命状态。

此时队列中加入了一个新元素对象６，它10s后到期，排在队尾。

#### 4. 又2s之后

![delayQueue-又2s以后](./images/delayQueue-又2s以后.png)

先看线程１，如果它已经结束了对象5的处理，则进入待命状态。如果还没有结束，则它继续处理对象5。

消费线程２取到对象4以后，也进入处理状态，同时给处于待命状态的消费线程３发送信号，消费线程３进入等待状态，成为新的Leader。现在头部元素是新插入的对象7，因为它1s以后就过期，要早于其它所有元素，所以排到了队列头部。

#### 5. 又1s之后

**一种不好的结果：**

![delayQueue-又1s以后-不好的结果](./images/delayQueue-又1s以后-不好的结果.png)

消费线程３一定正在处理对象7。消费线程１与消费线程２还没有处理完它们各自取得的对象，无法进入待命状态，也更加进入不了等待状态。此时对象3马上要到期，那么如果它到期时没有消费者线程空下来，则它的处理一定会延期。

可以想见，如果元素进入队列的速度很快，元素之间的到期时间相对集中，而处理每个到期元素的速度又比较慢的话，则队列会越来越大，队列后边的元素延期处理的时间会越来越长。

**好的结果：**

![delayQueue-又1s以后-好的结果](./images/delayQueue-又1s以后-好的结果.png)

消费线程１与消费线程２很快的完成对取出对象的处理，及时返回重新等待队列中的到期元素。一个处于等待状态(Leader)，对象3一到期就立刻处理。另一个则处于待命状态。这样，每一个对象都能在到期时被及时处理，不会发生明显的延期。

所以，消费者线程的数量要够，处理任务的速度要快。否则，队列中的到期元素无法被及时取出并处理，造成任务延期、队列元素堆积等情况。

#### 6. 示例代码

DelayQueue的一个应用场景是定时任务调度。本例中先让主线程向DelayQueue添加１０个任务，任务之间的启动间隔在1~2s之间，每个任务的执行时间固定为2s，代码如下：

```java
package com.zhangdb.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class DelayTask implements Delayed {
    private static long currentTime = System.currentTimeMillis();
    protected final String taskName;
    protected final int timeCost;
    protected final long scheduleTime;

    protected static final AtomicInteger taskCount = new AtomicInteger(0);

    // 定时任务之间的启动时间间隔在1~2s之间，timeCost表示处理此任务需要的时间，本示例中为2s
    public DelayTask(String taskName, int timeCost) {
        this.taskName = taskName;
        this.timeCost = timeCost;
        taskCount.incrementAndGet();
        currentTime += 1000 + (long) (Math.random() * 1000);
        scheduleTime = currentTime;
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.scheduleTime - ((DelayTask) o).scheduleTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long expirationTime = scheduleTime - System.currentTimeMillis();
        return unit.convert(expirationTime, TimeUnit.MILLISECONDS);
    }

    public void execTask() {
        long startTime = System.currentTimeMillis();
        System.out.println("Task " + taskName + ": schedule_start_time=" + scheduleTime + ",real start time="
                           + startTime + ",delay=" + (startTime - scheduleTime));
        try {
            Thread.sleep(timeCost);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DelayTaskComsumer extends Thread {
    private final BlockingQueue<DelayTask> queue;

    public DelayTaskComsumer(BlockingQueue<DelayTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        DelayTask task = null;
        try {
            while (true) {
                task = queue.take();
                task.execTask();
                DelayTask.taskCount.decrementAndGet();
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " finished");
        }
    }
}

public class DelayQueueExample {

    public static void main(String[] args) {

        BlockingQueue<DelayTask> queue = new DelayQueue<DelayTask>();

        for (int i = 0; i < 10; i++) {
            try {
                queue.put(new DelayTask("work " + i, 2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ThreadGroup g = new ThreadGroup("Consumers");

        for (int i = 0; i < 1; i++) {
            new Thread(g, new DelayTaskComsumer(queue)).start();
        }

        while (DelayTask.taskCount.get() > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        g.interrupt();
        System.out.println("Main thread finished");
    }
}
```

首先启动一个消费者线程。因为消费者线程处单个任务的时间为2s，而任务的调度间隔为1~2s。这种情况下，每当消费者线程处理完一个任务，回头再从队列中新取任务时，新任务肯定延期了，无法按给定的时间调度任务。而且越往后情况越严重。运行代码看一下输出：

```java
Task work 0: schedule_start_time=1554203579096,real start time=1554203579100,delay=4
Task work 1: schedule_start_time=1554203580931,real start time=1554203581101,delay=170
Task work 2: schedule_start_time=1554203582884,real start time=1554203583101,delay=217
Task work 3: schedule_start_time=1554203584660,real start time=1554203585101,delay=441
Task work 4: schedule_start_time=1554203586075,real start time=1554203587101,delay=1026
Task work 5: schedule_start_time=1554203587956,real start time=1554203589102,delay=1146
Task work 6: schedule_start_time=1554203589041,real start time=1554203591102,delay=2061
Task work 7: schedule_start_time=1554203590127,real start time=1554203593102,delay=2975
Task work 8: schedule_start_time=1554203591903,real start time=1554203595102,delay=3199
Task work 9: schedule_start_time=1554203593577,real start time=1554203597102,delay=3525
Main thread finished
Thread-0 finished
```

最后一个任务的延迟时间已经超过3.5s了。

再作一次测试，将消费者线程的个数调整为２，这时任务应该能按时启动，延迟应该很小，运行程序看一下结果：

```java
Task work 0: schedule_start_time=1554204395427,real start time=1554204395430,delay=3
Task work 1: schedule_start_time=1554204396849,real start time=1554204396850,delay=1
Task work 2: schedule_start_time=1554204398050,real start time=1554204398051,delay=1
Task work 3: schedule_start_time=1554204399590,real start time=1554204399590,delay=0
Task work 4: schedule_start_time=1554204401289,real start time=1554204401289,delay=0
Task work 5: schedule_start_time=1554204402883,real start time=1554204402883,delay=0
Task work 6: schedule_start_time=1554204404663,real start time=1554204404664,delay=1
Task work 7: schedule_start_time=1554204406154,real start time=1554204406154,delay=0
Task work 8: schedule_start_time=1554204407991,real start time=1554204407991,delay=0
Task work 9: schedule_start_time=1554204409540,real start time=1554204409540,delay=0
Main thread finished
Thread-0 finished
Thread-2 finished
```

基本上按时启动，最大延迟为3毫秒，大部分都是0毫秒。

将消费者线程个数调整成３个，运行看一下结果：

```java
Task work 0: schedule_start_time=1554204499695,real start time=1554204499698,delay=3
Task work 1: schedule_start_time=1554204501375,real start time=1554204501376,delay=1
Task work 2: schedule_start_time=1554204503370,real start time=1554204503371,delay=1
Task work 3: schedule_start_time=1554204504860,real start time=1554204504861,delay=1
Task work 4: schedule_start_time=1554204506419,real start time=1554204506420,delay=1
Task work 5: schedule_start_time=1554204508191,real start time=1554204508192,delay=1
Task work 6: schedule_start_time=1554204509495,real start time=1554204509496,delay=1
Task work 7: schedule_start_time=1554204510663,real start time=1554204510664,delay=1
Task work 8: schedule_start_time=1554204512598,real start time=1554204512598,delay=0
Task work 9: schedule_start_time=1554204514276,real start time=1554204514277,delay=1
Main thread finished
Thread-0 finished
Thread-2 finished
Thread-4 finished
```

大部分延迟时间变成1毫秒，情况好像还不如2个线程的情况。

将消费者线程数调整成5，运行看一下结果：

```java
Task work 0: schedule_start_time=1554204635015,real start time=1554204635019,delay=4
Task work 1: schedule_start_time=1554204636856,real start time=1554204636857,delay=1
Task work 2: schedule_start_time=1554204637968,real start time=1554204637970,delay=2
Task work 3: schedule_start_time=1554204639758,real start time=1554204639759,delay=1
Task work 4: schedule_start_time=1554204641089,real start time=1554204641090,delay=1
Task work 5: schedule_start_time=1554204642879,real start time=1554204642880,delay=1
Task work 6: schedule_start_time=1554204643941,real start time=1554204643942,delay=1
Task work 7: schedule_start_time=1554204645006,real start time=1554204645007,delay=1
Task work 8: schedule_start_time=1554204646309,real start time=1554204646310,delay=1
Task work 9: schedule_start_time=1554204647537,real start time=1554204647538,delay=1
Thread-2 finished
Thread-0 finished
Main thread finished
Thread-8 finished
Thread-4 finished
Thread-6 finished
```

与３个消费者线程的情况差不多。

#### 7. 结论

最优的消费者线程的个数与任务启动的时间间隔好像存在这样的关系：单个任务处理时间的最大值　/  相邻任务的启动时间最小间隔　＝　最优线程数，如果最优线程数是小数，则取整数后加１，比如1.3的话，那么最优线程数应该是2。

本例中，单个任务处理时间的最大值固定为2s。
相邻任务的启动时间最小间隔为1s。
则消费者线程数为2/1=2。

如果消费者线程数小于此值，则来不及处理到期的任务。如果大于此值，线程太多，在调度、同步上花更多的时间，无益改善性能。

参考文档：[https://blog.csdn.net/dkfajsldfsdfsd/article/details/88966814](https://blog.csdn.net/dkfajsldfsdfsd/article/details/88966814)


## 十一、BlockingDeque的实现类

### (1). LinkedBlockingDeque

#### 1. 概述

LinkedBlockingDeque是双向链表实现的双向并发阻塞队列。该阻塞队列同时支持FIFO和FILO两种操作方式，即可以从队列的头和尾同时操作(插入/删除)；并且，该阻塞队列是支持线程安全。还有，LinkedBlockingDeque还是可选容量的(防止过度膨胀)，即可以指定队列的容量。如果不指定，默认容量大小等于Integer.MAX_VALUE。

#### 2. 示例代码

```java
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author tiankafei
 * @Date 2020/5/7
 * @Version V1.0
 **/
public class LinkedBlockingDequeTest {
    public static void main(String[] args) {
        /**
         * 1.1、LinkedBlockingDeque():
         *           创建一个容量为 Integer.MAX_VALUE 的 LinkedBlockingDeque。
         * 1.2、LinkedBlockingDeque(int capacity):
         *           创建一个具有给定（固定）容量的 LinkedBlockingDeque。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        /**
         * 1、add(E e):在不违反容量限制的情况下，将指定的元素插入此双端队列的末尾，返回值为Boolean。
         */
        Boolean addBoolean = linkedBlockingDeque.add(5);
        System.out.println("是否添加成功：" + addBoolean);


        /**
         *  2、addFirst(E e)：如果立即可行且不违反容量限制，则将指定的元素插入此双端队列的开头；
         *                   如果当前没有空间可用，则抛出 IllegalStateException。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque1 = new LinkedBlockingDeque<>();
        linkedBlockingDeque1.addFirst(1);
        linkedBlockingDeque1.addFirst(2);
        linkedBlockingDeque1.addFirst(3);


        /**
         * 3、iterator()：返回在此双端队列元素上以恰当顺序进行迭代的迭代器。
         */
        Iterator<Integer> iterator = linkedBlockingDeque1.iterator();
        while (iterator.hasNext()){
            System.out.println("Iterator的addFirst结果：" + iterator.next());
        }


        /**
         * 4、addLast(E e) ：如果立即可行且不违反容量限制，则将指定的元素插入此双端队列的末尾；
         *                   如果当前没有空间可用，则抛出 IllegalStateException
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque2 = new LinkedBlockingDeque<>();
        linkedBlockingDeque2.addLast(1);
        linkedBlockingDeque2.addLast(2);
        linkedBlockingDeque2.addLast(3);
        Iterator<Integer> iterator1 = linkedBlockingDeque2.iterator();
        while (iterator1.hasNext()){
            System.out.println("Iterator的addLast结果：" + iterator1.next());
        }


        /**
         * 5、clear()：以原子方式 (atomically) 从此双端队列移除所有元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque3 = new LinkedBlockingDeque<>();
        linkedBlockingDeque3.add(1);
        linkedBlockingDeque3.add(2);
        linkedBlockingDeque3.add(3);
        linkedBlockingDeque3.clear();
        System.out.println("================");
        Iterator<Integer> iterator2 = linkedBlockingDeque3.iterator();
        while (iterator2.hasNext()){
            System.out.println("Iterator的clear结果：" + iterator2.next());
        }
        System.out.println("================");

        /**
         * 6、contains(Object o) ：如果此双端队列包含指定的元素，则返回 true
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque4 = new LinkedBlockingDeque<>();
        linkedBlockingDeque4.add(1);
        linkedBlockingDeque4.add(2);
        linkedBlockingDeque4.add(3);
        Boolean contains3Boolean = linkedBlockingDeque4.contains(3);
        Boolean contains4Boolean = linkedBlockingDeque4.contains(4);
        System.out.println("是否包含3：" + contains3Boolean + " 是否包含4：" + contains4Boolean);

        /**
         * 7、element()：获取但不移除此双端队列表示的队列的头部
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque5 = new LinkedBlockingDeque<>();
        linkedBlockingDeque5.add(1);
        linkedBlockingDeque5.add(2);
        linkedBlockingDeque5.add(3);
        Integer elementResult = linkedBlockingDeque5.element();
        System.out.println("队列的头部: " + elementResult);

        /**
         * 8、getFirst() ：获取，但不移除此双端队列的第一个元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque6 = new LinkedBlockingDeque<>();
        linkedBlockingDeque6.add(1);
        linkedBlockingDeque6.add(2);
        linkedBlockingDeque6.add(3);
        Integer firstResult = linkedBlockingDeque6.getFirst();
        System.out.println("双端队列的第一个元素: " + firstResult);


        /**
         * 9、	getLast() :获取，但不移除此双端队列的最后一个元素
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque7 = new LinkedBlockingDeque<>();
        linkedBlockingDeque7.add(3);
        linkedBlockingDeque7.add(4);
        linkedBlockingDeque7.add(5);
        Integer lastResult = linkedBlockingDeque7.getLast();
        System.out.println("双端队列的最后一个元素: " + lastResult);


        /**
         * 10.1、offer(E e) :如果立即可行且不违反容量限制，
         *                  则将指定的元素插入此双端队列表示的队列中（即此双端队列的尾部），
         *                  并在成功时返回 true；如果当前没有空间可用，则返回 false
         *
         * 10.2、offer(E e, long timeout, TimeUnit unit) :
         *                  将指定的元素插入此双端队列表示的队列中（即此双端队列的尾部），
         *                  必要时将在指定的等待时间内一直等待可用空间,返回值为Boolean。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque8 = new LinkedBlockingDeque<>();
        linkedBlockingDeque8.offer(1);
        linkedBlockingDeque8.offer(2);
        linkedBlockingDeque8.offer(3);
        Iterator<Integer> iterator3 = linkedBlockingDeque8.iterator();
        while (iterator3.hasNext()){
            System.out.println("Iterator的offer结果：" + iterator3.next());
        }


        /**
         * 11.1、offerFirst(E e) ：
         *           如果立即可行且不违反容量限制，则将指定的元素插入此双端队列的开头，
         *           并在成功时返回 true；如果当前没有空间可用，则返回 false。
         * 11.2、fferFirst(E e, long timeout, TimeUnit unit)：
         *           将指定的元素插入此双端队列的开头，必要时将在指定的等待时间内等待可用空间。
         *           返回值为Boolean。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque9 = new LinkedBlockingDeque<>();
        linkedBlockingDeque9.offerFirst(1);
        linkedBlockingDeque9.offerFirst(2);
        linkedBlockingDeque9.offerFirst(3);
        Iterator<Integer> iterator4 = linkedBlockingDeque9.iterator();
        while (iterator4.hasNext()){
            System.out.println("Iterator的offerFirst结果：" + iterator4.next());
        }



        /**
         * 12.1、offerLast(E e):
         *           如果立即可行且不违反容量限制，则将指定的元素插入此双端队列的末尾，并在成功时返回 true；如果当前没有空间可用，则返回 false。
         * 12.2、offerLast(E e, long timeout, TimeUnit unit):
         *           将指定的元素插入此双端队列的末尾，必要时将在指定的等待时间内等待可用空间。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque10 = new LinkedBlockingDeque<>();
        linkedBlockingDeque10.offerLast(1);
        linkedBlockingDeque10.offerLast(2);
        linkedBlockingDeque10.offerLast(3);
        Iterator<Integer> iterator5 = linkedBlockingDeque10.iterator();
        while (iterator5.hasNext()){
            System.out.println("Iterator的offerLast结果：" + iterator5.next());
        }


        /**
         * 13、peek():获取但不移除此双端队列表示的队列的头部（即此双端队列的第一个元素）；
         *            如果此双端队列为空，则返回 null
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque11 = new LinkedBlockingDeque<>();
        linkedBlockingDeque11.add(1);
        linkedBlockingDeque11.add(2);
        linkedBlockingDeque11.add(3);
        Integer peekResult = linkedBlockingDeque11.peek();
        System.out.println("peekResult的结果：" + peekResult);

        /**
         * 14、peekFirst():获取，但不移除此双端队列的第一个元素；如果此双端队列为空，则返回 null。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque12 = new LinkedBlockingDeque<>();
        linkedBlockingDeque12.add(3);
        linkedBlockingDeque12.add(4);
        linkedBlockingDeque12.add(5);
        Integer peekFirstResult = linkedBlockingDeque12.peekFirst();
        System.out.println("peekFirstResult的结果：" + peekFirstResult);


        /**
         * 15、peekLast() ：获取，但不移除此双端队列的最后一个元素；如果此双端队列为空，则返回 null。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque13 = new LinkedBlockingDeque<>();
        linkedBlockingDeque13.add(6);
        linkedBlockingDeque13.add(7);
        linkedBlockingDeque13.add(8);
        Integer peekLastResult = linkedBlockingDeque13.peekLast();
        System.out.println("peekLastResult的结果：" + peekLastResult);

        /**
         * 16.1、poll() :获取并移除此双端队列表示的队列的头部（即此双端队列的第一个元素）；
         *            如果此双端队列为空，则返回 null。
         * 16.2、poll(long timeout, TimeUnit unit)：
         *           获取并移除此双端队列表示的队列的头部（即此双端队列的第一个元素），
         *           如有必要将在指定的等待时间内等待可用元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque14 = new LinkedBlockingDeque<>();
        linkedBlockingDeque14.add(9);
        linkedBlockingDeque14.add(10);
        linkedBlockingDeque14.add(11);
        Integer pollResult = linkedBlockingDeque14.poll();
        System.out.println("peekLastResult的结果：" + pollResult);
        System.out.println("linkedBlockingDeque14是否还包含9：" + linkedBlockingDeque14.contains(9));


        /**
         * 17.1、pollFirst() ：
         *           获取并移除此双端队列的第一个元素；如果此双端队列为空，则返回 null。
         * 17.2、pollFirst(long timeout, TimeUnit unit) :
         *           获取并移除此双端队列的第一个元素，必要时将在指定的等待时间等待可用元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque15 = new LinkedBlockingDeque<>();
        linkedBlockingDeque15.addFirst(9);
        linkedBlockingDeque15.addFirst(10);
        linkedBlockingDeque15.addFirst(11);
        Integer pollFirstResult = linkedBlockingDeque15.pollFirst();
        System.out.println("pollFirstResult的结果：" + pollFirstResult);
        System.out.println("linkedBlockingDeque15是否还包含11：" + linkedBlockingDeque15.contains(11));

        /**
         * 18.1、pollLast()
         *           获取并移除此双端队列的最后一个元素；如果此双端队列为空，则返回 null。
         * 18.2、pollLast(long timeout, TimeUnit unit)
         *           获取并移除此双端队列的最后一个元素，必要时将在指定的等待时间内等待可用元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque16 = new LinkedBlockingDeque<>();
        linkedBlockingDeque16.add(9);
        linkedBlockingDeque16.add(10);
        linkedBlockingDeque16.add(11);
        Integer pollLastResult = linkedBlockingDeque16.pollLast();
        System.out.println("pollLastResult的结果：" + pollLastResult);
        System.out.println("linkedBlockingDeque16是否还包含11：" + linkedBlockingDeque16.contains(11));

        /**
         * 19、	pop() :从此双端队列所表示的堆栈中弹出一个元素（移除效果）
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque17 = new LinkedBlockingDeque<>();
        linkedBlockingDeque17.addFirst(1);
        linkedBlockingDeque17.addFirst(2);
        linkedBlockingDeque17.addFirst(3);
        Integer pop1Result = linkedBlockingDeque17.pop();
        System.out.println("pop2Result的结果：" + pop1Result);
        Integer pop2Result = linkedBlockingDeque17.pop();
        System.out.println("pop2Result的结果：" + pop2Result);
        System.out.println("linkedBlockingDeque17是否还包含2：" + linkedBlockingDeque17.contains(2));

        /**
         * 20、push(E e) ：将元素推入此双端队列表示的栈。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque18 = new LinkedBlockingDeque<>();
        linkedBlockingDeque18.push(1);
        linkedBlockingDeque18.push(2);
        linkedBlockingDeque18.push(3);
        Iterator<Integer> iterator6 = linkedBlockingDeque18.iterator();
        while (iterator6.hasNext()){
            System.out.println("Iterator的push结果：" + iterator6.next());
        }

        /**
         * 21、put(E e) :将指定的元素插入此双端队列表示的队列中（即此双端队列的尾部），
         *               必要时将一直等待可用空间。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque19 = new LinkedBlockingDeque<>();
        try {
            linkedBlockingDeque19.put(1);
            linkedBlockingDeque19.put(2);
            linkedBlockingDeque19.put(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator<Integer> iterator7 = linkedBlockingDeque19.iterator();
        while (iterator7.hasNext()){
            System.out.println("Iterator的put结果：" + iterator7.next());
        }

        /**
         * 22、putFirst(E e) :将指定的元素插入此双端队列的开头，必要时将一直等待可用空间。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque20 = new LinkedBlockingDeque<>();
        try {
            linkedBlockingDeque20.putFirst(1);
            linkedBlockingDeque20.putFirst(2);
            linkedBlockingDeque20.putFirst(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator<Integer> iterator8 = linkedBlockingDeque20.iterator();
        while (iterator8.hasNext()){
            System.out.println("Iterator的putFirst结果：" + iterator8.next());
        }

        /**
         * 23、putLast(E e) :将指定的元素插入此双端队列的末尾，必要时将一直等待可用空间。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque21 = new LinkedBlockingDeque<>();
        try {
            linkedBlockingDeque21.putLast(1);
            linkedBlockingDeque21.putLast(2);
            linkedBlockingDeque21.putLast(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator<Integer> iterator9 = linkedBlockingDeque21.iterator();
        while (iterator9.hasNext()){
            System.out.println("Iterator的putLast结果：" + iterator9.next());
        }


        /**
         * 24、remove():获取并移除此双端队列表示的队列的头部。返回一个E
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque22 = new LinkedBlockingDeque<>();
        linkedBlockingDeque22.addFirst(1);
        linkedBlockingDeque22.addFirst(2);
        linkedBlockingDeque22.addFirst(3);
        Integer removeResult = linkedBlockingDeque22.remove();
        System.out.println("removeResult的结果：" + removeResult);
        System.out.println("linkedBlockingDeque22是否还包含3：" + linkedBlockingDeque22.contains(3));


        /**
         * 25、remove(Object o) :从此双端队列移除第一次出现的指定元素,返回值为Boolean。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque23 = new LinkedBlockingDeque<>();
        linkedBlockingDeque23.addFirst(1);
        linkedBlockingDeque23.addFirst(2);
        linkedBlockingDeque23.addFirst(3);
        Boolean removeBoolean = linkedBlockingDeque23.remove(3);
        System.out.println("是否remove了3 ：" + removeBoolean);

        /**
         * 26、removeFirst():获取并移除此双端队列第一个元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque24 = new LinkedBlockingDeque<>();
        linkedBlockingDeque24.addLast(1);
        linkedBlockingDeque24.addLast(2);
        linkedBlockingDeque24.addLast(3);
        Integer removeFirstResult = linkedBlockingDeque24.removeFirst();
        System.out.println("removeFirstResult：" + removeFirstResult);
        System.out.println("linkedBlockingDeque24是否还包含1：" + linkedBlockingDeque24.contains(1));


        /**
         * 27、	removeLast():获取并移除此双端队列的最后一个元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque25 = new LinkedBlockingDeque<>();
        linkedBlockingDeque25.addLast(4);
        linkedBlockingDeque25.addLast(5);
        linkedBlockingDeque25.addLast(6);
        Integer removeLastResult = linkedBlockingDeque25.removeLast();
        System.out.println("removeLastResult：" + removeLastResult);
        System.out.println("linkedBlockingDeque25是否还包含6：" + linkedBlockingDeque25.contains(6));


        /**
         * 28、take():获取并移除此双端队列表示的队列的头部（即此双端队列的第一个元素），
         *           必要时将一直等待可用元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque26 = new LinkedBlockingDeque<>();
        linkedBlockingDeque26.push(4);
        linkedBlockingDeque26.push(5);
        linkedBlockingDeque26.push(6);
        Integer takeResult = null;
        try {
            takeResult = linkedBlockingDeque26.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("takeResult：" + takeResult);
        System.out.println("linkedBlockingDeque26是否还包含6：" + linkedBlockingDeque26.contains(6));

        /**
         * 29、takeFirst() :获取并移除此双端队列的第一个元素，必要时将一直等待可用元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque27 = new LinkedBlockingDeque<>();
        linkedBlockingDeque27.push(7);
        linkedBlockingDeque27.push(8);
        linkedBlockingDeque27.push(9);
        Integer takeFirstResult = null;
        try {
            takeFirstResult = linkedBlockingDeque27.takeFirst();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("takeFirst：" + takeFirstResult);
        System.out.println("linkedBlockingDeque27是否还包含9：" + linkedBlockingDeque27.contains(9));


        /**
         * 30、takeLast():获取并移除此双端队列的最后一个元素，必要时将一直等待可用元素。
         */
        LinkedBlockingDeque<Integer> linkedBlockingDeque28 = new LinkedBlockingDeque<>();
        linkedBlockingDeque28.push(10);
        linkedBlockingDeque28.push(11);
        linkedBlockingDeque28.push(12);
        Integer takeLastResult = null;
        try {
            takeLastResult = linkedBlockingDeque28.takeLast();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("takeLastResult：" + takeLastResult);
        System.out.println("linkedBlockingDeque28是否还包含10：" + linkedBlockingDeque28.contains(10));
    }
}
```

#### 3. 总结

LinkedBlockingDeque和LinkedBlockingQueue的**相同点**在于：

1. 基于链表
2. 通过ReentrantLock实现锁
3. 利用Condition实现队列的阻塞等待，唤醒
4. 容量可选，不设置的话，就是Int的最大值

LinkedBlockingDeque和LinkedBlockingQueue的**不同点**在于：

1. LinkedBlockingQueue只能一端出一端如的单向队列结构，是有FIFO特性的，并且是通过两个ReentrantLock和两个Condition来实现的
2. LinkedBlockingQueue采用了两把锁来对队列进行操作，也就是队尾添加的时候，队头仍然可以删除等操作
3. 对于LinkedBlockingQueue来说，有两个ReentrantLock分别控制队头和队尾，这样就可以使得添加操作分开来做，一般的操作是获取一把锁就可以，但有些操作例如remove操作，则需要同时获取两把锁

1. LinkedBlockingDeque就是一个双端队列，任何一端都可以进行元素的出入
2. LinkedBlockingDeque 和 ArrayBlockingQueue 结构还是很类似的，也是一个ReentrantLock和两个Condition使用，但是仅仅是在这二者使用上，其实内部运转还是很大不同的

参考文档：

[https://blog.csdn.net/qq_38293564/article/details/80592429](https://blog.csdn.net/qq_38293564/article/details/80592429)

[https://www.jianshu.com/p/91d9f434da91](https://www.jianshu.com/p/91d9f434da91)

## 十二、Queue的实现类

### (1). PriorityQueue

#### 1. 概述

PriorityQueue 一个基于优先级的无界队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。该队列不允许使用 null 元素也不允许插入不可比较的对象(没有实现Comparable接口的对象)。PriorityQueue 队列的头指排序规则最小那个元素。如果多个元素都是最小值则随机选一个。PriorityQueue 是一个无界队列，但是初始的容量11(实际是一个Object[])，随着不断向优先级队列添加元素，其容量会自动扩容。

#### 2. 基本使用

PriorityQueue使用跟普通队列一样，唯一区别是PriorityQueue会根据排序规则决定谁在队头，谁在队尾。

往队列中添加可比较的对象String

```java
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<String>();
        //入列
        q.offer("1");
        q.offer("2");
        q.offer("5");
        q.offer("3");
        q.offer("4");
        //出列
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //5
    }
}
```

观察打印结果， 入列：12534， 出列是12345， 也是说出列时做了相关判断，将最小的值返回。默认情况下PriorityQueue使用自然排序法，最小元素先出列。

自定义排序规则

```java
public class Student {
    private String name;  //名字
    private int score;    //分数

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
```

```java
public class PriorityQueueTest1 {
    public static void main(String[] args) {
        //通过改造器指定排序规则
        PriorityQueue<Student> q = new PriorityQueue<Student>(new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                //按照分数低到高，分数相等按名字
                if(o1.getScore() == o2.getScore()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getScore() - o2.getScore();
            }
        });
        //入列
        q.offer(new Student("dafei", 20));
        q.offer(new Student("will", 17));
        q.offer(new Student("setf", 30));
        q.offer(new Student("bunny", 20));
        //出列
        System.out.println(q.poll());  //Student{name='will', score=17}
        System.out.println(q.poll());  //Student{name='bunny', score=20}
        System.out.println(q.poll());  //Student{name='dafei', score=20}
        System.out.println(q.poll());  //Student{name='setf', score=30}
    }
}
```

PriorityQueue优先级规则可以由我们根据具体需求而定制， 方式有2种：

1. 添加元素自身实现了Comparable接口，确保元素是可排序的对象
2. 如果添加元素没有实现Comparable接口，可以在创建PriorityQueue队列时直接指定比较器。

#### 3. 源码剖析

##### 1. 重要属性

```java
public class PriorityQueue<E> extends AbstractQueue<E>
    implements java.io.Serializable {
    transient Object[] queue;    //队列容器， 默认是11
    private int size = 0;  //队列长度
    private final Comparator<? super E> comparator;  //队列比较器， 为null使用自然排序
    //....
}
```

##### 2. 入列

```java
public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);      //当队列长度大于等于容量值时，自动拓展
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e); //
    return true;
}
```

```java
private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);   //指定比较器
    else
        siftUpComparable(k, x);   //没有指定比较器，使用默认的自然比较器
}
```

##### 3. 使用默认的自然比较器

```java
private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (key.compareTo((E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}
```

##### 4. 使用指定的比较器

```java
private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}
```

从源码上看PriorityQueue的入列操作并没对所有加入的元素进行优先级排序。仅仅保证数组第一个元素是最小的即可。

##### 5. 出列

```java
public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);
    return result;
}
```

```java
private void siftDown(int k, E x) {
    if (comparator != null)
        siftDownUsingComparator(k, x);  //指定比较器
    else
        siftDownComparable(k, x);    //默认比较器
}
```

##### 6. 使用默认的自然比较器

```java
private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        int child = (k << 1) + 1; // assume left child is least
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        if (key.compareTo((E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = key;
}
```

##### 7. 使用指定的比较器

```java
private void siftDownUsingComparator(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}
```

上面源码，当第一个元素出列之后，对剩下的元素进行再排序，挑选出最小的元素排在数组第一个位置。

通过上面源码，也可看出PriorityQueue并不是线程安全队列，因为offer/poll都没有对队列进行锁定，所以，如果要拥有线程安全的优先级队列，需要额外进行加锁操作。

#### 4. 总结

1. PriorityQueue是一种无界的，**线程不安全的队列**
2. PriorityQueue是一种通过数组实现的，并拥有优先级的队列
3. PriorityQueue存储的元素要求必须是可比较的对象， 如果不是就必须明确指定比较器

参考文档：[https://www.jianshu.com/p/f1fd9b82cb72](https://www.jianshu.com/p/f1fd9b82cb72)

### (2). ConcurrentLinkedQueue

#### 1. 概述

ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规则对节点进行排序，当我们添加一个元素的时候，它会添加到队列的尾部，当我们获取一个元素时，它会返回队列头部的元素。

ConcurrentLinkedQueue由head节点和tail节点组成，每个节点（Node）由节点元素（item）和指向下一个节点的引用(next)组成，节点与节点之间就是通过这个next关联起来，从而组成一张链表结构的队列。

#### 2. 源码剖析

##### 1. Node类型

```java
private static class Node<E> {
    volatile E item;
    volatile Node<E> next;
 
    Node(E item) {
        UNSAFE.putObject(this, itemOffset, item);
    }
 
    boolean casItem(E cmp, E val) {
        return UNSAFE.compareAndSwapObject(this, itemOffset, cmp, val);
    }
 
    void lazySetNext(Node<E> val) {
        UNSAFE.putOrderedObject(this, nextOffset, val);
    }
 
    boolean casNext(Node<E> cmp, Node<E> val) {
        return UNSAFE.compareAndSwapObject(this, nextOffset, cmp, val);
    }
 
    private static final sun.misc.Unsafe UNSAFE;
    private static final long itemOffset;
    private static final long nextOffset;
 
    static {
        try {
            UNSAFE = sun.misc.Unsafe.getUnsafe();
            Class<?> k = Node.class;
            itemOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("item"));
            nextOffset = UNSAFE.objectFieldOffset
                (k.getDeclaredField("next"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }
}
```

##### 2. 构造方法

```java
// 默认构造方法，head节点存储的元素为空，tail节点等于head节点
public ConcurrentLinkedQueue() {
    head = tail = new Node<E>(null);
}
 
// 根据其他集合来创建队列
public ConcurrentLinkedQueue(Collection<? extends E> c) {
    Node<E> h = null, t = null;
    // 遍历节点
    for (E e : c) {
        // 若节点为null，则直接抛出NullPointerException异常
        checkNotNull(e);
        Node<E> newNode = new Node<E>(e);
        if (h == null)
            h = t = newNode;
        else {
            t.lazySetNext(newNode);
            t = newNode;
        }
    }
    if (h == null)
        h = t = new Node<E>(null);
    head = h;
    tail = t;
}
```

默认情况下head节点存储的元素为空，tail节点等于head节点。

```java
head = tail = new Node<E>(null);
```

##### 3. 入队操作

入队列就是将入队节点添加到队列的尾部。为了方便理解入队时队列的变化，以及head节点和tail节点的变化，每添加一个节点我就做了一个队列的快照图：

![ConcurrentLinkedQueue-入队](./images/ConcurrentLinkedQueue-入队.png)

上图所示的元素添加过程如下：

1. 添加元素1：队列更新head节点的next节点为元素1节点。又因为tail节点默认情况下等于head节点，所以它们的next节点都指向元素1节点。
2. 添加元素2：队列首先设置元素1节点的next节点为元素2节点，然后更新tail节点指向元素2节点。
3. 添加元素3：设置元素2节点的next节点为元素3节点（也就意味着tail节点的next节点也是元素3节点）。
4. 添加元素4：设置元素3的next节点为元素4节点，然后将tail节点指向元素4节点。

入队操作主要做两件事情，第一是将入队节点设置成当前队列尾节点的下一个节点。第二是更新tail节点，如果tail节点的next节点不为空，则将入队节点设置成tail节点，如果tail节点的next节点为空，则将入队节点设置成tail的next节点，所以tail节点不总是尾节点，理解这一点很重要。

上面的分析让我们从单线程入队的角度来理解入队过程，但是多个线程同时进行入队情况就变得更加复杂，因为可能会出现其他线程插队的情况。如果有一个线程正在入队，那么它必须先获取尾节点，然后设置尾节点的下一个节点为入队节点，但这时可能有另外一个线程插队了，那么队列的尾节点就会发生变化，这时当前线程要暂停入队操作，然后重新获取尾节点。

##### 4. 入队方法

```java
public boolean add(E e) {
    return offer(e);
}
 
public boolean offer(E e) {
    // 如果e为null，则直接抛出NullPointerException异常
    checkNotNull(e);
    // 创建入队节点
    final Node<E> newNode = new Node<E>(e);
 
    // 循环CAS直到入队成功
    // 1、根据tail节点定位出尾节点（last node）；2、将新节点置为尾节点的下一个节点；3、cas Tail更新尾节点
    for (Node<E> t = tail, p = t;;) {
        // p用来表示队列的尾节点，初始情况下等于tail节点
        // q是p的next节点
        Node<E> q = p.next;
        // 判断p是不是尾节点，tail节点不一定是尾节点，判断是不是尾节点的依据是该节点的next是不是null
        // 如果p是尾节点
        if (q == null) {
            // p is last node
            // 设置p节点的下一个节点为新节点，设置成功则casNext返回true；否则返回false，说明有其他线程更新过尾节点
            if (p.casNext(null, newNode)) {
                // Successful CAS is the linearization point
                // for e to become an element of this queue,
                // and for newNode to become "live".
                // 如果p != t，则将入队节点设置成tail节点，更新失败了也没关系，因为失败了表示有其他线程成功更新了tail节点
                if (p != t) // hop two nodes at a time
                    casTail(t, newNode);  // Failure is OK.
                return true;
            }
            // Lost CAS race to another thread; re-read next
        }
        // 多线程操作时候，由于poll时候会把旧的head变为自引用，然后将head的next设置为新的head
        // 所以这里需要重新找新的head，因为新的head后面的节点才是激活的节点
        else if (p == q)
            // We have fallen off list.  If tail is unchanged, it
            // will also be off-list, in which case we need to
            // jump to head, from which all live nodes are always
            // reachable.  Else the new tail is a better bet.
            p = (t != (t = tail)) ? t : head;
        // 寻找尾节点
        else
            // Check for tail updates after two hops.
            p = (p != t && t != (t = tail)) ? t : q;
    }
}
```

从源代码角度来看整个入队过程主要做两件事情：

1. 第一是定位出尾节点
2. 第二是使用CAS算法能将入队节点设置成尾节点的next节点，如不成功则重试。

第一步定位尾节点。tail节点并不总是尾节点，所以每次入队都必须先通过tail节点来找到尾节点，尾节点可能就是tail节点，也可能是tail节点的next节点。代码中循环体中的第一个if就是判断tail是否有next节点，有则表示next节点可能是尾节点。获取tail节点的next节点需要注意的是p节点等于q节点的情况，出现这种情况的原因我们后续再来介绍。
第二步设置入队节点为尾节点。p.casNext(null, newNode)方法用于将入队节点设置为当前队列尾节点的next节点，q如果是null表示p是当前队列的尾节点，如果不为null表示有其他线程更新了尾节点，则需要重新获取当前队列的尾节点。

##### 5. tail节点不一定为尾节点的设计意图

对于先进先出的队列入队所要做的事情就是将入队节点设置成尾节点，doug lea写的代码和逻辑还是稍微有点复杂。那么我用以下方式来实现行不行？

```java
public boolean offer(E e) {
    checkNotNull(e);
    final Node<E> newNode = new Node<E>(e);
    
    for (;;) {
        Node<E> t = tail;
        
        if (t.casNext(null ,newNode) && casTail(t, newNode)) {
            return true;
        }
    }
}
```

让tail节点永远作为队列的尾节点，这样实现代码量非常少，而且逻辑非常清楚和易懂。但是这么做有个缺点就是每次都需要使用循环CAS更新tail节点。如果能减少CAS更新tail节点的次数，就能提高入队的效率。

在JDK 1.7的实现中，作者使用hops变量来控制并减少tail节点的更新频率，并不是每次节点入队后都将 tail节点更新成尾节点，而是当tail节点和尾节点的距离大于等于常量HOPS的值（默认等于1）时才更新tail节点，tail和尾节点的距离越长使用CAS更新tail节点的次数就会越少，但是距离越长带来的负面效果就是每次入队时定位尾节点的时间就越长，因为循环体需要多循环一次来定位出尾节点，但是这样仍然能提高入队的效率，因为从本质上来看它通过增加对volatile变量的读操作来减少了对volatile变量的写操作，而对volatile变量的写操作开销要远远大于读操作，所以入队效率会有所提升。

在JDK 1.8的实现中，tail的更新时机是通过p和t是否相等来判断的，其实现结果和JDK 1.7相同，即当tail节点和尾节点的距离大于等于1时，更新tail。

##### 6. 入队操作整体逻辑如下图所示：

![ConcurrentLinkedQueue-入队整体逻辑](./images/ConcurrentLinkedQueue-入队整体逻辑.png)

##### 7. 出队操作

出队列的就是从队列里返回一个节点元素，并清空该节点对元素的引用。让我们通过每个节点出队的快照来观察下head节点的变化：

![ConcurrentLinkedQueue-出队](./images/ConcurrentLinkedQueue-出队.png)

从上图可知，并不是每次出队时都更新head节点，当head节点里有元素时，直接弹出head节点里的元素，而不会更新head节点。只有当head节点里没有元素时，出队操作才会更新head节点。采用这种方式也是为了减少使用CAS更新head节点的消耗，从而提高出队效率。让我们再通过源码来深入分析下出队过程。

##### 8. 出队方法

```java
public E poll() {
    restartFromHead:
    for (;;) {
        // p节点表示首节点，即需要出队的节点
        for (Node<E> h = head, p = h, q;;) {
            E item = p.item;
 
            // 如果p节点的元素不为null，则通过CAS来设置p节点引用的元素为null，如果成功则返回p节点的元素
            if (item != null && p.casItem(item, null)) {
                // Successful CAS is the linearization point
                // for item to be removed from this queue.
                // 如果p != h，则更新head
                if (p != h) // hop two nodes at a time
                    updateHead(h, ((q = p.next) != null) ? q : p);
                return item;
            }
            // 如果头节点的元素为空或头节点发生了变化，这说明头节点已经被另外一个线程修改了。
            // 那么获取p节点的下一个节点，如果p节点的下一节点为null，则表明队列已经空了
            else if ((q = p.next) == null) {
                // 更新头结点
                updateHead(h, p);
                return null;
            }
            // p == q，则使用新的head重新开始
            else if (p == q)
                continue restartFromHead;
            // 如果下一个元素不为空，则将头节点的下一个节点设置成头节点
            else
                p = q;
        }
    }
}
```

该方法的主要逻辑就是首先获取头节点的元素，然后判断头节点元素是否为空，如果为空，表示另外一个线程已经进行了一次出队操作将该节点的元素取走，如果不为空，则使用CAS的方式将头节点的引用设置成null，如果CAS成功，则直接返回头节点的元素，如果不成功，表示另外一个线程已经进行了一次出队操作更新了head节点，导致元素发生了变化，需要重新获取头节点。

在入队和出队操作中，都有p == q的情况，那这种情况是怎么出现的呢？我们来看这样一种操作：

![ConcurrentLinkedQueue](./images/ConcurrentLinkedQueue.png)

在弹出一个节点之后，tail节点有一条指向自己的虚线，这是什么意思呢？我们来看poll()方法，在该方法中，移除元素之后，会调用updateHead方法：

```java
final void updateHead(Node<E> h, Node<E> p) {
    if (h != p && casHead(h, p))
        // 将旧的头结点h的next域指向为h
        h.lazySetNext(h);
}
```

我们可以看到，在更新完head之后，会将旧的头结点h的next域指向为h，上图中所示的虚线也就表示这个节点的自引用。

如果这时，再有一个线程来添加元素，通过tail获取的next节点则仍然是它本身，这就出现了p == q的情况，出现该种情况之后，则会触发执行head的更新，将p节点重新指向为head，所有“活着”的节点（指未删除节点），都能从head通过遍历可达，这样就能通过head成功获取到尾节点，然后添加元素了。

##### 9. peek()方法

```java
// 获取链表的首部元素（只读取而不移除）
public E peek() {
    restartFromHead:
    for (;;) {
        for (Node<E> h = head, p = h, q;;) {
            E item = p.item;
            if (item != null || (q = p.next) == null) {
                updateHead(h, p);
                return item;
            }
            else if (p == q)
                continue restartFromHead;
            else
                p = q;
        }
    }
}
```

从源码中可以看到，peek操作会改变head指向，执行peek()方法后head会指向第一个具有非空元素的节点。

##### 10. size()方法

```java
public int size() {
    int count = 0;
    // first()获取第一个具有非空元素的节点，若不存在，返回null
    // succ(p)方法获取p的后继节点，若p == p的后继节点，则返回head
    for (Node<E> p = first(); p != null; p = succ(p))
        if (p.item != null)
            // Collection.size() spec says to max out
            // 最大返回Integer.MAX_VALUE
            if (++count == Integer.MAX_VALUE)
                break;
    return count;
}
```

size()方法用来获取当前队列的元素个数，但在并发环境中，其结果可能不精确，因为整个过程都没有加锁，所以从调用size方法到返回结果期间有可能增删元素，导致统计的元素个数不精确。

##### 11. remove(Object o)方法

```java
public boolean remove(Object o) {
    // 删除的元素不能为null
    if (o != null) {
        Node<E> next, pred = null;
 
        for (Node<E> p = first(); p != null; pred = p, p = next) {
            boolean removed = false;
            E item = p.item;
 
            // 节点元素不为null
            if (item != null) {
                // 若不匹配，则获取next节点继续匹配
                if (!o.equals(item)) {
                    next = succ(p);
                    continue;
                }
 
                // 若匹配，则通过CAS操作将对应节点元素置为null
                removed = p.casItem(item, null);
            }
 
            // 获取删除节点的后继节点
            next = succ(p);
            // 将被删除的节点移除队列
            if (pred != null && next != null) // unlink
                pred.casNext(p, next);
            if (removed)
                return true;
        }
    }
    return false;
}
```

##### 12. contains(Object o)方法

```java
public boolean contains(Object o) {
    if (o == null) return false;
 
    // 遍历队列
    for (Node<E> p = first(); p != null; p = succ(p)) {
        E item = p.item;
        // 若找到匹配节点，则返回true
        if (item != null && o.equals(item))
            return true;
    }
    return false;
}
```

该方法和size方法类似，有可能返回错误结果，比如调用该方法时，元素还在队列里面，但是遍历过程中，该元素被删除了，那么就会返回false。

#### 3. 总结

ConcurrentLinkedQueue 的非阻塞算法实现可概括为下面 5 点：

1. 使用 CAS 原子指令来处理对数据的并发访问，这是非阻塞算法得以实现的基础。
2. head/tail 并非总是指向队列的头 / 尾节点，也就是说允许队列处于不一致状态。 这个特性把入队 / 出队时，原本需要一起原子化执行的两个步骤分离开来，从而缩小了入队 / 出队时需要原子化更新值的范围到唯一变量。这是非阻塞算法得以实现的关键。
3. 由于队列有时会处于不一致状态。为此，ConcurrentLinkedQueue 使用[三个不变式](https://www.ibm.com/developerworks/cn/java/j-lo-concurrent/index.html)来维护非阻塞算法的正确性。
4. 以批处理方式来更新 head/tail，从整体上减少入队 / 出队操作的开销。
5. 为了有利于垃圾收集，队列使用特有的 head 更新机制；为了确保从已删除节点向后遍历，可到达所有的非删除节点，队列使用了特有的向后推进策略。

参考地址：[https://blog.csdn.net/qq_38293564/article/details/80798310](https://blog.csdn.net/qq_38293564/article/details/80798310)

## 十三、Deque的实现类

### (1). ArrayDeque

#### 1. 概述

ArrayDeque 是 Deque 接口的一种具体实现，是依赖于可变数组来实现的。ArrayDeque 没有容量限制，可根据需求自动进行扩容。ArrayDeque 可以作为栈来使用，效率要高于 Stack；ArrayDeque 也可以作为队列来使用，效率相较于基于双向链表的 LinkedList 也要更好一些。注意，ArrayDeque 不支持为 null 的元素。<font color="red">**非线程安全**</font>

#### 2. 实现思路

我先来总结下ArrayDeque的实现思路。

首先，ArrayDeque内部是拥有一个内部数组用于存储数据。其次，假设采用简单的方案，即队列数组按顺序在数组里排开，那么：

1. 由于ArrayDeque的两端都能增删数据，那么把数据插入到队列头部也就是数组头部，会造成O(N)的时间复杂度。
2. 假设只再队尾加入而只从队头删除，队头就会空出越来越多的空间。

那么该怎么实现？也很简单。将物理上的连续数组回绕，形成逻辑上的一个 **环形结构**。即a[size - 1]的下一个位置是a[0].
之后，使用头尾指针标识队列头尾，在队列头尾增删元素，反映在头尾指针上就是这两个指针绕着环赛跑。

这个是大体思路，具体的还有一些细节，后面代码里分析：

1. head和tail的具体概念是如何界定？
2. 如果判断队满和队空？
3. 数组满了怎么办？

#### 3. 源码剖析

##### 1. 重要的属性

```java
//数据存放数组,默认初始容量为16，每次扩容都是容量翻倍
transient Object[] elements;
//头部元素下标
transient int head;
//尾部元素下标
transient int tail;
```

![ArrayDeque结构](./images/ArrayDeque结构.png)

##### 2. 构造函数

```java
public ArrayDeque() {
    elements = new Object[16]; // 默认的数组长度大小  
}

public ArrayDeque(int numElements) {
    allocateElements(numElements);// 需要的数组长度大小  
}

private void allocateElements(int numElements) {
    elements = new Object[calculateSize(numElements)];
}
```

1. 如果没有指定内部数组的初始大小，默认为16。
2. 如果指定了内部数组的初始大小，则通过`calculateSize`函数二次计算出大小。

##### 3. calculateSize函数

```java
private static final int MIN_INITIAL_CAPACITY = 8;

private static int calculateSize(int numElements) {
    int initialCapacity = MIN_INITIAL_CAPACITY;
    // 找到大于需要长度的最小的2的幂整数。  
    // Tests "<=" because arrays aren't kept full.
    if (numElements >= initialCapacity) {
        initialCapacity = numElements;
        initialCapacity |= (initialCapacity >>>  1);
        initialCapacity |= (initialCapacity >>>  2);
        initialCapacity |= (initialCapacity >>>  4);
        initialCapacity |= (initialCapacity >>>  8);
        initialCapacity |= (initialCapacity >>> 16);
        initialCapacity++;

        if (initialCapacity < 0)   // Too many elements, must back off
            initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
    }
    return initialCapacity;
}
```

1. 如果小于8，那么大小就为8。
2. 如果大于等于8，则按照2的幂对齐。

##### 4. 入队

```java
public void addFirst(E e) {
    if (e == null)
        throw new NullPointerException();
    elements[head = (head - 1) & (elements.length - 1)] = e;
    if (head == tail)
        doubleCapacity();
}

public void addLast(E e) {
    if (e == null)
        throw new NullPointerException();
    elements[tail] = e;
    if ( (tail = (tail + 1) & (elements.length - 1)) == head)
        doubleCapacity();
}
```

`addFirst`是从队头插入，`addLast`是从队尾插入。

从该代码能够分析出head和tail指针的含义：

1. head指针指向的是队头元素的位置，除非队列为空。
2. tail指针指向的是队尾元素后一格的位置，即尾后指针。

因此：

1. 如果队列没有满，tail指向的是空位置，head指向的是队头元素，永远不可能一样。
2. 但是当队列满时，tail回绕会追上head，当tail等于head时，表示队列满了。

理清楚了这一点，上面的代码也就十分容易理解了：

1. 对应位置插入位置，移动指针。
2. 当tail和head相等时，扩容。

最后，这句：

```java
(head - 1) & (elements.length - 1)
```

假如被余数是2的幂次方，那么模运算就能够优化成按位与运算。也即相当于：

```java
(head - 1) % elements.length
```

##### 5. 出队

```java
public E pollFirst() {
    int h = head;
    @SuppressWarnings("unchecked")
    E result = (E) elements[h];
    // Element is null if deque empty
    if (result == null)
        return null;
    elements[h] = null;     // Must null out slot
    head = (h + 1) & (elements.length - 1);
    return result;
}

public E pollLast() {
    int t = (tail - 1) & (elements.length - 1);
    @SuppressWarnings("unchecked")
    E result = (E) elements[t];
    if (result == null)
        return null;
    elements[t] = null;
    tail = t;
    return result;
}
```

##### 6. 扩容

```java
// 扩容为原来的2倍。  
private void doubleCapacity() {
    assert head == tail;
    int p = head;
    int n = elements.length;
    int r = n - p; // number of elements to the right of p
    int newCapacity = n << 1;
    // 扩容后的大小小于0（溢出），也即队列最大应该是2的30次方
    if (newCapacity < 0)
        throw new IllegalStateException("Sorry, deque too big");
    Object[] a = new Object[newCapacity];
    // 既然是head和tail已经重合了，说明tail是在head的左边。
    System.arraycopy(elements, p, a, 0, r); // 拷贝原数组从head位置到结束的数据  
    System.arraycopy(elements, 0, a, r, p); // 拷贝原数组从开始到head的数据  
    elements = a;
    head = 0;// 重置head和tail为数据的开始和结束索引  
    tail = n;
}
// 拷贝该数组的所有元素到目标数组
private <T> T[] copyElements(T[] a) {
    if (head < tail) { // 开始索引大于结束索引，一次拷贝  
        System.arraycopy(elements, head, a, 0, size());
    } else if (head > tail) {// 开始索引在结束索引的右边，分两段拷贝  
        int headPortionLen = elements.length - head;
        System.arraycopy(elements, head, a, 0, headPortionLen);
        System.arraycopy(elements, 0, a, headPortionLen, tail);
    }
    return a;
}
```

![ArrayDeque扩容](./images/ArrayDeque扩容.png)

扩容的实现为按 **两倍** 扩容原数组，将原数倍拷贝过去。

其中值得注意的是对数组大小溢出的处理。

#### 4. 总结

参考文档：[https://segmentfault.com/a/1190000016330001](https://segmentfault.com/a/1190000016330001)

### (2). IdentityLinkedList

#### 1. 概述





### (3). ConcurrentLinkedDeque

#### 1. 概述





## 十四、其他重要的容器

### (1). ConcurrentHashMap

#### 1. 概述





### (2). ConcurrentSkipListMap

#### 1. 概述





### (3). ConcurrentSkipListSet

#### 1. 概述





### (4). CopyOnWriteArrayList

#### 1. 概述





### (5). CopyOnWriteArraySet

#### 1. 概述





## 十五、线程池

