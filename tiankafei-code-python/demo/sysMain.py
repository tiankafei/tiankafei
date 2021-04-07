# 作者：甜咖啡
# 新建时间：2021/4/6 20:33

import sys
import time
import os
import calendar
import urllib.request
import json
import re
import math
import decimal
import logging
import schedule
import turtle

print(sys.getsizeof(24))
print(sys.getsizeof(45))
print(sys.getsizeof(True))
print(sys.getsizeof(False))
print('===============================================')

print(time.time())
print(time.localtime(time.time()))
print('===============================================')

# print(urllib.request.urlopen('http://www.baidu.com').read())

print(math.pi)
print(math.ceil(1.23))
print('===============================================')

# 执行系统命令
# os.system('notepad.exe')
# os.system('calc.exe')
# 打开系统程序
# os.startfile('')

print(os.getcwd())
print(os.listdir())
print(os.listdir('package1'))

t = turtle.Pen()

for x in range(360):
    t.forward(x)
    t.left(59)
