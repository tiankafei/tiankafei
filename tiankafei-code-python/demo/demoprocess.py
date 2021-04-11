# 作者：甜咖啡
# 新建时间：2021/4/11 22:11

from multiprocessing import Process


def demo1(name):
    print('执行自定义函数的参数：', name)


if __name__ == '__main__':
    p = Process(target=demo1, args=('123',))
    p.start()
    p.join()
    print(p.name)
    print('主进程执行完成')
