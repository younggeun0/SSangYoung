-- �ּ� 0�� ����, �ִ� ���Ǳ��� �ݺ������ϴ� while       
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

-- 1���� 10���� 1�� �����ϴ� ���� ��� while
SET serveroutput ON

DECLARE 
	-- �ʱⰪ
	num NUMBER := 1;
BEGIN        
	-- ���ǽ�
	WHILE num <= 10 LOOP         
		-- �ݺ� ���๮��
		DBMS_OUTPUT.PUT_LINE(num);
		-- ������, ���ҽ� - ���ǿ� �����Ͽ� �ݺ��� ���߱� ����
		num := num + 1;
		
	END LOOP;
END;
/   


-- 0 ~ 100 ������ Ȧ���� ����ϴ� WHILE
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

