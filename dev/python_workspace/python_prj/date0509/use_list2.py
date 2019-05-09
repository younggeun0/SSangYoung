# -*- coding:UTF-8 -*-

lang = list("is javascript the same as java?")
print(lang)

print(lang.count('j'))

if 'j' in lang:
    print('it has \'j\' ')
    
    
langs = "java,javascript,css,html,sql,python"

langList = langs.split(",")
print(langList)

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