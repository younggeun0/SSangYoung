# -*- coding:UTF-8 -*-

name = input('이름 : ')

star_cnt = 0
if name=='이재찬':
    print('반장')
    star_cnt=5
elif name=='이봉현' or name=='박영민' or name=='오영근':
    print('조장')
    star_cnt=3
elif name=='김정윤':
    print('디잘잘','면잘잘')
    star_cnt=2
else:
    print('평조원')
    star_cnt=1

print(name)
print('★'*star_cnt)