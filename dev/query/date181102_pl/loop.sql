
/*
-- 코드를 여러번 반복 실행시켜주는 LOOP 사용

SET serveroutput ON
SET verify OFF

DECLARE
	i NUMBER(1) := 1;
BEGIN 
	LOOP
 		DBMS_OUTPUT.PUT_LINE(i); 	
 		i := i+1;
 		EXIT WHEN (i > 5); 
	END LOOP;
END;
/ 


SET serveroutput ON

DECLARE
	i NUMBER := 0;
BEGIN
    
    LOOP
		i := i+1;  
		DBMS_OUTPUT.PUT_LINE('오늘은 금요일입니다.'|| i);
        
--    	IF i = 10 THEN
--    		EXIT;
--    	END IF;
    	
    	EXIT WHEN (i=10);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('내일은 토요일입니다.');

END;
/


SET serveroutput ON
SET verify OFF

ACCEPT cnt PROMPT '반복할 횟수를 선택하세요 : '

DECLARE
	cnt NUMBER;
	j NUMBER := 1;
BEGIN       
	cnt := &cnt; 
	
	LOOP
		DBMS_OUTPUT.PUT_LINE('반복횟수 : '||j); 
		j := j+1;
		EXIT WHEN (j > cnt);
	END LOOP;

END;
/


*/














