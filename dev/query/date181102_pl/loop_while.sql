-- 최소 0번 수행, 최대 조건까지 반복수행하는 while       
/*
SET serveroutput ON

DECLARE
    num NUMBER := 0;
BEGIN

	WHILE num < 100 LOOP
	    
		num := num + 1;
		DBMS_OUTPUT.PUT_LINE(num);
	
	END LOOP; 

END;
/ 

-- 1에서 10까지 1씩 증가하는 값을 출력 while
SET serveroutput ON

DECLARE 
	-- 초기값
	num NUMBER := 1;
BEGIN        
	-- 조건식
	WHILE num <= 10 LOOP         
		-- 반복 수행문장
		DBMS_OUTPUT.PUT_LINE(num);
		-- 증가식, 감소식 - 조건에 도달하여 반복을 멈추기 위해
		num := num + 1;
		
	END LOOP;
END;
/   


-- 0 ~ 100 사이의 홀수만 출력하는 WHILE
SET serveroutput ON

DECLARE
    num NUMBER := 0;
BEGIN
	
	WHILE num < 100 LOOP
		
		num := num + 1;
		IF MOD(num, 2) = 1 THEN
			DBMS_OUTPUT.PUT(num||' ');	
		END IF;            
	END LOOP;              
	
	DBMS_OUTPUT.PUT_LINE('');
END;
/
*/
SET serveroutput ON

DECLARE
    num NUMBER := 1;
BEGIN
    
    WHILE num < 100 LOOP
        
        DBMS_OUTPUT.PUT(num||' ');  
        num := num + 2;

    END LOOP;              
    
    DBMS_OUTPUT.PUT_LINE('');
END;
/

