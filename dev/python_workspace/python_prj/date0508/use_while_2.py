# -*- coding:UTF-8 -*-

i = 0

while i<10:
    print(i)
    i+=1
    
print('-'*50)

# 분기문 : break

i = 0

while i<10:
    if i==5:
        break
    print(i)
    i+=1