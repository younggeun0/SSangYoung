-- 두 수를 입력받아 더하기 연산한 결과를 out parameter에 설정하는 프로시저                            
CREATE OR REPLACE PROCEDURE proc_plus (num1 NUMBER,
 num2 IN NUMBER, num3 OUT NUMBER)
IS  
	-- parameter명과 같은 변수는 만들 수 없다 
	-- 변수명을 정할때는 프로시저명과 다르게 설정한다.
 
BEGIN   
	-- out parameter에는 값할당이 되지만 in parameter엔 값할당 안됨
	-- num1 := 100; 하면 error!
	
	num3 := num1 + num2;
END;
/
