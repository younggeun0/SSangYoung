# -*- coding:UTF-8 -*-
li1 = ['2','2','3']
li2 = ['4','5','4']

li3 = li1+li2

print(li3)

print(li3[1:5])


print("-"*30)

li1 = list() # 비어있는 리스트 생성
li1.append('1')
li1.append("""오늘은 목요일입니다
            내일은 금요일입니다""")
li1.append(5)
li1.insert(1, '낑겨든 값값값')

li2 = ['Java', 'HTML', 'jQuery', 'JavaScript', 'CSS']

print(len(li1))
print(li2.count('Java'))

# 삭제
# 방의 내용으로 삭제
li2.remove('HTML')

# 방의 인덱스로 삭제
del li2[2]

# 모두 삭제
li2.clear() 
print(li1)

print(len(li2))
print(li2)

# 문자열을 하나씩 잘라서 리스트에 추가
li3 = list('java javascript HTML CSS 노진경')

print(li3)
word_a = 'a'

# 리스트 방의 값 개수
print("리스트에 '{}'의 개수 {} ".format(word_a,li3.count(word_a)))

print(li3.count('노'))

# 리스트에 값이 존재하는지
print('A' in li3)

if 'N' in li3:
    for val in li3:
        print(val)
else:
    print('li3에는 "N"가 존재하지 않습니다.')
    
    
    
# 여러개의 리스트 합치기

li4 = ['노진경','김희철','박영민']
li5 = ['김정윤','최지우','이지수']

memberList = li4+li5

print(memberList)
print(memberList[-1:])

# slicing : memberList에서 박영민~최지우까지만 얻기
print(memberList[2:5])


print(memberList[::2])

print('이재찬' in memberList)