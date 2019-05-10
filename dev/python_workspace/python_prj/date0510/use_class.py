# -*- coding:UTF-8 -*-

class TestClass:
    name='기미철'
    age=26

    def __init__(self):
        print('생성자')
        
    def getName(self):
        return self.name
    
    def printAge(self):
        print('나이 : {age}세'.format(age=self.age))
        return self.age
    
    def setAge(self,age):
        self.age = age
    
    
tc = TestClass()
tc.name = '김정윤'
name=tc.getName()
print('이름 : '+name)

tc.setAge(30)
tc.printAge()
