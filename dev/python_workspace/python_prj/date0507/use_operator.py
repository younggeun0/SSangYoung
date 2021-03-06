# -*- coding:UTF-8 -*-
''' 
연산자
'''

'''
# 산술 연산자 : +, -, *, /, //(몫), %
print("{} + {} = {} ".format(5, 7, 5+7))
print("{} - {} = {} ".format(5, 7, 5-7))
print("{} * {} = {} ".format(5, 7, 5*7))
print("{} / {} = {} ".format(5, 7, 5/7))
print("{} // {} = {} ".format(8, 3, 8//3))
print("{} % {} = {} ".format(5, 7, 5%7))

# 쉬프트 연산자 : 비트밀기 연산
print("{} << {} = {}".format(3,2,3<<2)) # 0011 << 2 = 1100
print("{} >> {} = {}".format(30,3,30>>3)) # 0001 1110 >> 3 = 0000 0011 

# 관계 연산자 : >, <, >=, <=, ==, !=
print("{} > {} = {}".format(5, 7, 5 > 7))
print("{} < {} = {}".format(5, 7, 5 < 7))
print("{} >= {} = {}".format(5, 7, 5 >= 7))
print("{} <= {} = {}".format(5, 7, 5 <= 7))
print("{} == {} = {}".format(5, 7, 5 == 7))
print("{} != {} = {}".format(5, 7, 5 != 7))


# 논리연산자 : and, or, not
print("{} and {} = {}".format(5 > 4, 7 < 10, 5 > 4 and 7 < 10))
print("{} or {} = {}".format(5 < 4, 7 > 10, 5 < 4 or 7 > 10))
print("not {} = {}".format(True, not True))

# 비트 연산자 : &, |, ^, ~
print("{} & {} = {}".format(5, 7, 5&7)) # 0101 & 0111 = 0101
print("{} | {} = {}".format(5, 7, 5|7)) # 0101 & 0111 = 0111
print("{} ^ {} = {}".format(5, 7, 5^7)) # 0101 ^ 0111 = 0010
print("~{} = {}".format(5, ~5)) # ~0101 = 1111 ... 1010  

'''

# 대입 연산자 : =, +=, -=, *=, /=, //=, %=, <<=, >>=, &=, |=, ^=
i = 5

i += 7 # i = i+7 # 12
i -= 3 # i = i-3 # 9 
i *= 2 # i = i*2 # 18
i /= 4 # i = i/4 # 4.5
i //= 3 # i = i//3 # 1.0
i %= 2 # i = i%2 # 1.0

i = 2

i <<= 2 # 0010 << 2 = 1000 # 8
i >>= 1 # 1000 >> 1 = 0100 # 4
i &= 5 # 0100 & 0101 = 0100 # 4
i |= 6 # 0100 | 0110 = 0110 # 6
i ^= 3 # 0110 | 0011 = 0101 # 5 

print(i)















