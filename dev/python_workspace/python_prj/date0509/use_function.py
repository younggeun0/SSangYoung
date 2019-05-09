# -*- coding:UTF-8 -*-

def test():
    print('test')
        
# 호출    
test()

# 반환값이 존재하는 함수
def test1():
    name='이재찬'
    return name


name = test1()
print(name)

# 함수의 반환형이 없을 땐 None이 반환됨
name = test() 
print(name) 

# 
def test2(somevar = 'somevar default value'):
    print(somevar)
    

test2()
test2('호호호')


# 매개변수 있는 함수
def test3(name):
    print('이름:'+str(name))
    
    
test3('ggg')
test3('김정윤')

print("-"*30)

# 매개변수의 기본값 사용
def test4(name='김희철',addr='강남구 역삼동',age=20):
    print("name : {}, addr : {}, age : {}".format(name, addr, age))
    

test4()
test4('오영근')
test4('오영근','강남구 논현동')
test4('오영근','강남구 논현동',30)

print("-"*30)

# Variable Arguments
def test5(*names):
    print(type(names))
    print(names)
    for name in names:
        print(name)
    

test5('young','sol','minsoo')

print("-"*30)

# dict : 값을 입력할 때 '이름=값'의 형식을 가져야 한다

def test6(**info):
    print(type(info))
    print(info) 
    for k,v in info.items():
        print(k,v)
        
    print(info.get('name'))


test6(name='김희철',age=20,addr='서울시 동작구')

print("-"*30)

# 변수의 이름과 함수의 이름이 같다면 먼저 선언된 것은 사용할 수 없다
def temp():
    print('temp!!!')
    
    
temp = 3
print(temp)

temp() # error!

print("-"*30)









