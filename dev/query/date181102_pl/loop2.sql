/*
-- 1~100���� ����ϴ� LOOP
SET serveroutput ON       

DECLARE
	cnt NUMBER(3);
BEGIN
	-- �ʱⰪ
	cnt := 1; 
	                  
	LOOP
		DBMS_OUTPUT.PUT(cnt||' ');
	    cnt := cnt+1;
	    EXIT WHEN (cnt > 100);
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('');

END;
/

-- 1�������� 100���� ¦���� ���
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

-- 1�������� 100���� Ȧ���� ���
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
 
-- ¦���� ��� �ٸ� ���
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