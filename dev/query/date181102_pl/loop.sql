
/*
-- �ڵ带 ������ �ݺ� ��������ִ� LOOP ���

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
		DBMS_OUTPUT.PUT_LINE('������ �ݿ����Դϴ�.'|| i);
        
--    	IF i = 10 THEN
--    		EXIT;
--    	END IF;
    	
    	EXIT WHEN (i=10);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('������ ������Դϴ�.');

END;
/


SET serveroutput ON
SET verify OFF

ACCEPT cnt PROMPT '�ݺ��� Ƚ���� �����ϼ��� : '

DECLARE
	cnt NUMBER;
	j NUMBER := 1;
BEGIN       
	cnt := &cnt; 
	
	LOOP
		DBMS_OUTPUT.PUT_LINE('�ݺ�Ƚ�� : '||j); 
		j := j+1;
		EXIT WHEN (j > cnt);
	END LOOP;

END;
/


*/














