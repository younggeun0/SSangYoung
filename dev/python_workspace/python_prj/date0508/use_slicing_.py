# -*- coding:UTF-8 -*-

str = 'ABCDEFG.txt'
#      0123456

print(str)
print(str[0:]) # 시작부터 끝까지
print(str[2:5]) # 특정 위치만 자르기 (CDE)
print(str[:5]) # 시작부터 특정 위치까지만 자르기 (ABCDE)
print(str[::-1]) # 글자 뒤집기
print(str[::2]) #시작부터 특정위치(배수)의 문자만 자르기
print(str[-3:]) # 뒤에서부터 특정 자리의 문자만 자르기