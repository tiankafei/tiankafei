# 作者：甜咖啡
# 新建时间：2021/4/11 22:11

import _thread
import time
import threading


def fun1(name):
    print("开始运行fun1开始：{0}".format(name))
    time.sleep(4)
    print('运行fun1结束')


def fun2(name):
    print("开始运行fun2开始：{0}".format(name))
    time.sleep(2)
    print('运行fun2结束')


def fun11(name):
    print("开始运行fun11开始：{0}".format(name))
    time.sleep(4)
    print('运行fun11结束')


def fun12(name):
    print("开始运行fun12开始：{0}".format(name))
    time.sleep(2)
    print('运行fun12结束')


def fun(name, age):
    print('接收到的参数：{0}, {1}'.format(name, age))


class MyThread(threading.Thread):
    def __init__(self, func, name, args):
        # super().__init__(target=func, name=name, args=args)
        super().__init__(target=func, name=name, args=args)

    def run(self):
        self._target(*self._args)


if __name__ == '__main__':
    print('开始运行')
    t1 = _thread.start_new_thread(fun1, ('第一个线程',))
    t2 = _thread.start_new_thread(fun2, ('第二个线程',))
    print("线程启动完成")
    time.sleep(5)
    print("==================================")

    t1 = threading.Thread(target=fun11, args=('第一个线程',))
    t1.start()

    t2 = threading.Thread(target=fun12, args=('第二个线程',))
    t2.start()

    print("线程启动完成")
    time.sleep(5)
    print("==================================")
    # 通过继承来实现线程
    t1 = MyThread(func=fun, name='testThread1', args=('123456', 123))
    t1.start()

    print("主进程执行完成")
