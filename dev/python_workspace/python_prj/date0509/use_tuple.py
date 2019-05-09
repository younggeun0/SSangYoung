# -*- coding:UTF-8 -*-
# 빈튜플을 생성할 수 있지만 값을 추가할 수 없다

tu1 = ()
tu2 = ('1','2','3')

# tu1.append('ho'), error!

# 값 추가, 삭제
print(len(tu1))
print(len(tu2))

tu3 = ('자바', '오라클', '자바스크립트')

tu4 = tu2 + tu3
print(tu4)