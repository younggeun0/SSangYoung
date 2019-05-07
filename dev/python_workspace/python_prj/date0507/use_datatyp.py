# -*- coding:UTF-8 -*-
# Python은 동적데이터형
# - 변수에 값이 할당될 때 데이터형이 결정됨

flag = True  # bool
print(flag)

# type함수를 쓰면 타입확인가능, Python은 다 객체
print(type(flag))  

# str()를 안쓰면 error 발생
print(str(type(flag)) + " " + str(flag))  

# str()을 매번 쓰는것보다 format()이 편함
print("{}, {} ".format(type(flag), flag))

i = 5  # int
print("{}, {}".format(type(i), i)) 

j = 3.3  # float

print("{}, {}".format(type(j), j))

# 큰 길이의 숫자도 사용가능
k = 5555555555555555555555555555555555555555555
print("{}, {}".format(type(k), k))

# msg = '한줄 문자열' # 문자열은 큰따옴표 작은 따옴표 둘 다 가능
msg = "한줄 문자열" 
print("{}, {}".format(type(msg), msg))

msg = '''
오늘은 화요일 입니다
내일은 수요일 입니다
'''

print("{}, {}".format(type(msg), msg))

# list
name_list = ["이재찬", "김정윤", "정택성", "김희철"]
print("{}, {}".format(type(name_list), name_list))

# tuple
name_tuple = ("자바", "오라클", "Python")
print("{}, {}".format(type(name_tuple), name_tuple))

# dict
name_dict = {"자바":"객체지향언어", "Oracle":"대용량 데이터베이스",
             "Python":"수치연산에 강력한 언어"} 
print("{}, {}".format(type(name_dict), name_dict))

