# -*- coding:UTF-8 -*-

group1List = ['김정윤','이재찬','박은영','백인재','이봉현','정택성']
num = 5

try:
    print("1조의 희망 {name}은 오후에 조퇴각".format(name=group1List[num]))
    num1 = num/2
    print(num1)
except IndexError as ie:
    print('잘못된 인덱스 번호 : ',ie)
except ZeroDivisionError as zde:
    print('0으로 나눌 수 없습니다 : ',zde)
except:
    print('모든 예외를 처리할 수 있다')
else:
    print('정상적으로 종료되었을 때 실행될 코드')
finally:
    print('반드시 실행될 코드')