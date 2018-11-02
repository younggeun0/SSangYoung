/*
-- 1~100까지 출력하는 LOOP
SET serveroutput ON       

DECLARE
	cnt NUMBER(3);
BEGIN
	-- 초기값
	cnt := 1; 
	                  
	LOOP
		DBMS_OUTPUT.PUT(cnt||' ');
	    cnt := cnt+1;
	    EXIT WHEN (cnt > 100);
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('');

END;
/

-- 1에서부터 100까지 짝수만 출력
SET serveroutput ON       

DECLARE
	cnt NUMBER(3);
BEGIN
	cnt := 1; 
	                  
	LOOP 
		IF MOD(cnt, 2) = 0 THEN
			DBMS_OUTPUT.PUT(cnt||' ');
		END IF;
		
	    cnt := cnt+1;
	    EXIT WHEN (cnt > 100);
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('');

END;
/                             

-- 1에서부터 100까지 홀수만 출력
SET serveroutput ON       

DECLARE
	cnt NUMBER(3);
BEGIN
	cnt := 1; 
	                  
	LOOP 
		IF MOD(cnt, 2) = 1 THEN
			DBMS_OUTPUT.PUT(cnt||' ');
		END IF;
		
	    cnt := cnt+1;
	    EXIT WHEN (cnt > 100);
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('');

END;
/  
 
-- 짝수만 출력 다른 방법
SET serveroutput ON       

DECLARE
	cnt NUMBER(3);
BEGIN
	cnt := 0; 
	                  
	LOOP    
		DBMS_OUTPUT.PUT(cnt||' ');
	    cnt := cnt+2;
	    EXIT WHEN (cnt > 100);
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('');

END;
/  
*/