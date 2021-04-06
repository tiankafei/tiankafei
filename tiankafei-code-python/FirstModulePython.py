def fun():
    print('执行了fun方法')


def fun2():
    pass


class Test:
    location = '本地属性'

    def __init__(self, name, age):
        self.name = name
        self.age = age

    def test1(self):
        print(self.name, self.age)

    @classmethod
    def test2(clc):
        print('执行了类方法')

    @staticmethod
    def test3():
        print('执行了静态方法')


a = 0
b = 1
s = a + b
print(s)

t1 = Test('张三', 18)
t1.test1()
t1.test2()
t1.test3()

import math

print(math)
print(dir(math))
print(math.pow(2, 3))
print(math.pi)

from math import pi

print(pi)
print(pow(2, 3))
