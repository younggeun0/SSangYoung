# -*- coding:UTF-8 -*-

x = None
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))

x = 100
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))

x = 0.1
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))


x = '잡코리아'
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))

x = [1, 2, 3] # list
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))

x = (1, 2, 3) # tuple
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))

x = { 'name':'노진경', 'age':20 }
if x:
    print("데이터형 {}, {} 값 존재".format(type(x), x))
else :
    print("데이텨형 {}, {} 값 존재하지 않음".format(type(x),x))