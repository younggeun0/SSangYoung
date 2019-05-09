#--*--coding:UTF-8 --*--
from builtins import range

# 인덱스 사용 range(시작값, 끝값, 증가값)
# 증가값을 사용하지 않으면 1씩 증가한다.
for i in range(1,10):
    print(i)

# 증가값 설정
print('-'*30)
for i in range(1,10,2):
    print(i)

# List, Tuple
print('-'*30)
nameList=['공선의','이재현','최지우','김정윤','박영민']

for name in nameList:
    print( name )

print('-'*30)
nameTuple=('공선의','이재현','최지우','김정윤','박영민')
for name in nameTuple:
    print( name )

#dict
print('-'*30)
langDict={'java':'완벽한 OOP 언어','HTML5':'마크업 언어','CSS':'디자인 언어','JavaScript':'스크립트언어','Python':'수치연산에 강한 OOP언어'}

for k,v in langDict.items():
    print("key={}, value={}".format(k,v))

print('-'*30)
#숫자 거꾸로 출력 reversed 함수 사용
for i in reversed(range(1,10)):
    print(i)

print('-'*30)
for i in range(2,9):
    for j in range(1,9):
        print('{}*{}={}'.format(i,j,i*j)) 

