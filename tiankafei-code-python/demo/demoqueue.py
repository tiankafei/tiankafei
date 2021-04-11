# 作者：甜咖啡
# 新建时间：2021/4/11 22:00

from multiprocessing import Queue


if __name__ == '__main__':
    queue = Queue(3)
    print(queue.empty())
    print(queue.qsize())
    print(queue.full())
    print(queue.put('123456'))
    print(queue.get())
