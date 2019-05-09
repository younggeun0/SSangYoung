# -*- coding:UTF-8 -*-

# 인덱스 사용 range(시작값, 끝값, 증가값)
# 증가값을 사용하지 않으면 1씩 증가

for i in range(1, 10):
    print(i)
    
print("-"*30)
# list, tuple

nameList = ['공선의','이재현','최지우','김정윤','박영민']

for name in nameList:
    print(name)

print("-"*30)

nameTuple = ('공선의','이재현','최지우','김정윤','박영민')

for name in nameTuple:
    print(name)
    
print("-"*30)

# dict

langDict = { 'java':'완벽한 OOP언어', 'HTML5':'마크업 언어',
             'CSS':'디자인언어', 'JavaScript':'스크립트 언어',
              'Python':'수치연산에 강한 OOP언어' }

for k,v in langDict.items():
    print('key={}, value={}'.format(k, v))

print("-"*30)

for i in reversed(range(1,10)):
    print(i)
print("-"*30)

for i in range(2,9):
    for j in range(1,9):
        print('{}*{}={}'.format(i,j,i*j))
    
