# -*- coding:UTF-8 -*-

dict1 = {}
dict2 = {'김정윤':'디자인을 잘하며 이상한 쿼리를 알려준다',
    '김희철':'질문할 때 팔의 각도가 예술이다',
    '노진경':'예비군 갔다 병얻어 왔다',
    '김정운':'아이언맨 계약만료로 사망, 이승탈출 넘버원' }

print(dict1)
print(dict2)

print(len(dict1))
print(len(dict2))

# 값 추가
dict2['이재찬'] = '햄버거가 좋아요'
dict2['이재찬'] = '피자도 좋아요' # 갚을 덮어씌운다

# 값 얻기, 변수명.get('키')
print(dict2.get('이재찬'))
print(dict2.get('오영근')) # 키가 없기 때문에 None이 반환됨

print(dict2.get('오영근','드디어 학원 일주일도 안남았다')) # default값

del dict2['김정운']

print(dict2)

# 모든 키 얻기 keys()
print(dict2.keys())

# 모든 값 얻기
print(dict2.values())

# 모든 키와 값 얻기 
print(dict2.items())

print('김정운' in dict2)

