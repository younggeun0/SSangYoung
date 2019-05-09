#--*-- coding:UTF-8 --*--

# name=input('이름>> ')
# 
# if name=='이재찬':
#     print('반장')
# else:
#     print('평민')
#     
# print(name)    

# 조건식을 넣지 않았을 때 False 판정인 상황
# x=None # 객체는 None(null)인 경우 False
# x=100 # int는 0인 경우 False
# x=0.1 # float 0.0 인 경우 False
# x='잡코리아' # str은 ''인 경우 False
# x=[1,2,3] # list는 [] 인 경우 False (대괄호 사용)
# x=(1,2,3) # tuple () 인 경우 False (소괄호 사용)
x={'name':'노진경','age':20} # dict {} 인 경우 False (중괄호 사용)
if x:
    print("데이터형 {},{} 값 존재".format(type(x),x))
else:
    print("데이터형 {},{} 값 존재하지 않음".format(type(x),x))













