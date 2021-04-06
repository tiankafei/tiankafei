# 作者：甜咖啡
# 新建时间：2021/4/3 1:04

print("hello world" + "   123456")

import keyword
print(keyword.kwlist)

fp = open("D:/test.txt", "a+")
print("hello world", file=fp)
print("hello world", file=fp)
fp.close()

name = "hello world"
print("标识", id(name))
print("类型", type(name))
print("值", name)

# 十进制：默认的数据都是十进制
# 八进制：数据值以0o开头的数值
# 二级制：数据值以0b开头的数值
# 十六进制：数据值以0x开头的数值

print(0.1+0.2)

from decimal import Decimal
print(Decimal('0.1') + Decimal('0.2'))

print(True)     #1
print(False)    #0

print(True + 1)
print(False + 1)

str1 = 'hello world单引号'
str2 = "hello world双引号"
str3 = """hello world0,
 hello world1,
 hello world2
 """
str4 = '''hello world0,
 hello world1,
 hello world2
 '''

print(str1)
print(str2)
print(str3)
print(str4)

# print("abcdefg" + 123) 会报错
print("abcdefg" + str(123))

print(str(123), str(123.23), str(False))
print("============================")

print(int('123'))
print(int(123.12))
# print(int('123.12'))
print(int(False))
print("============================")

print(float('123.23'))
print(float('123'))
print(float(False))
print(float(98))


# present = input("你想要的礼物是什么？\n")
# print(present)

# first = input("第一个值？\n")
# second = input("第二个值？\n")
# print(int(first) + int(second))

print("============================")
print(1+1)
print(1-1)
print(2*3)
print(2/4)  # 出发运算
print(4//2) # 整除运算

print("============================")
a,b,c = 20,30,40
print(a)
print(b)
print(c)

print("============================")
a,b=10,20
print(a)
print(b)
a,b=b,a
print(a)
print(b)

print("============================")

print(0%2 == 0)

num = 100
if num > 100:
    print("大于100")
elif 90 <= num < 100:
    print("大于等于90小于100")
else:
    print("其它范围")
print("============================")
print(list(range(10)))
print(list(range(1, 10)))
print(list(range(1, 10, 2)))
r = range(0, 10, 2)
print(list(r))
print(9 in r)
print(9 not in r)
print("============================")

sum = 0
j = 0
while j < 101:
    if not bool(j % 2):
        sum += j
    j = j + 1
print(sum)
print("============================")
sum = 0
for i in range(1, 101, 1):
    # if i % 2 == 0:
    # print(i, i % 2, bool(i % 2))
    if not bool(i % 2):
       sum += i
print(sum)
print("============================")
for item in 'Python':
    print(item)
print("============================")
for i in range(10):
    print(i)
print("============================")
for _ in range(5):
    print(":::")
print("============================")

for i in range(1, 10):
    for j in range(1, i+1):
        print(i, '*', j, '=', i*j, end='\t')
    print()
print("============================")

list1 = ['hello world', 99, 'hello world']
print(list1)
print(list1.index('hello world'))
print(list1.index('hello world', 1, 3))
list2 = list(['hello world', 'hello world', 99])
print(list2)
print(list2[0])
print(list2[-len(list2)])
print(len(list2))
print("============================")

list3 = list([20, 10, 30, 40, 50, 60, 70, 80, 90])
print(id(list3))
print(list3)
list4 = list3[1:6:2]
print(id(list4))
print(list4)
print(list3[:6:2])
print(list3[1::2])
print(list3[::])
print("============================")
print(list3)
print(list3[::-1])
print(list3[7::-1])
print(list3[-7::-1])
print("============================")
list3.append(123)
print(list3)
list3.insert(2, 456)
print(list3)
list3.append([789, 654])
print(list3)
list3.extend([147, 852])
print(list3)
list3.insert(11, '你好')
print(list3)
list3.remove('你好')
print(list3)
# list3.remove(list3[11])
# print(list3)
list3.pop(11)
print(list3)
# list3.clear()
# print(list3)
# 修改
list3[1:3]=[200,4560]
print(list3)
# 删除
list3[1:3]=[]
print(list3)
# 从小到大排序
list3.sort()
print(list3)
# 从大到小排序
list3.sort(reverse=True)
print(list3)
sorted(list3)

new_List = sorted(list3)
print(new_List)
new_List = sorted(list3, reverse=True)
print(new_List)
print("============================")
list5 = [i for i in range(9)]
print(list5)
list5 = [i*i for i in range(9)]
print(list5)
list5 = [i*2 for i in range(1, 6)]
print(list5)
print("============================")

dicts = {'张三': 18, '李四': 20}
print(dicts)
print(dicts['张三'])
print(dicts.get('张三'))
# print(dicts['王五'])
print(dicts.get('王五'))
print(dicts.get('王五', 99))
dicts['王五'] = 21
print(dicts)
dicts['王五'] = 22
print(dicts)

keyList = list(dicts.keys())
for key in keyList:
    print(key)
print(keyList)
valueList = list(dicts.values())
for value in valueList:
    print(value)
print(valueList)
itemList = list(dicts.items())
for item in itemList:
    print(item[0], '===', item[1])
print(itemList)
print("============================")
dicts = dict(name='张三', age=18)
print(dicts)

dicts = {}
print(dicts)

print("============================")

keys = ['张三', '李四', '王五']
values = [18, 19, 20]
for key, value in zip(keys, values):
    dicts[key] = value
print(dicts)
dicts.clear()

dicts = {key: value for key, value in zip(keys, values)}
print(dicts)
print("============================")


print('1.', '123.12'.isalnum())
print(bool(0))

lst = [10, 29, 34, 23, 44, 53, 55]
for i in lst:
    # print(i % 2)
    if i % 2: # 非0，奇数
        print('奇数', i)
        # pass
    else:
        print('偶数', i)