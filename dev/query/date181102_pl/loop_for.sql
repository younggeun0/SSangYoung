/*
-- ���۰� ���� �Ѵ��� �� �� �ִ� �ݺ��� FOR
-- ������ �����
SET serveroutput ON
SET verify OFF

ACCEPT input PROMPT '�˻��� ������ ���� �Է��ϼ��� : '

DECLARE
	input NUMBER;

	-- FOR�� �ε����� �����ϴ� ������ DECLARE���� ����� ������ ������� �ʴ´�
	i NUMBER := 1;
BEGIN
	input := &input;

 	FOR i IN 1 ..9 LOOP
 		DBMS_OUTPUT.PUT_LINE(input||' * '||i||' = '||input*i);
 	END LOOP;

	DBMS_OUTPUT.PUT_LINE(i);
END;
/


-- 1~9���� 1�� �����ϴ� ������2���� FOR�� �ۼ��Ͽ� ���
SET serveroutput ON

DECLARE
	num NUMBER(1);
BEGIN
	num := 2;
	FOR i IN 1 ..9 LOOP
		DBMS_OUTPUT.PUT_LINE(num||' * '||i||' = '||num*i);
	END LOOP;
END;
/


-- 1~100������ �� ��� : 5050 (������)
-- 1+2+3+... +100

SET serveroutput ON

DECLARE

	total NUMBER := 0;

BEGIN

	DBMS_OUTPUT.PUT_LINE('�ʱ� sum : '||total);

	FOR i IN 1 ..100 LOOP
		total := total + i;
		DBMS_OUTPUT.PUT_LINE('sum + '||i||' = '||total);
	END LOOP;

	DBMS_OUTPUT.PUT_LINE('���� sum : '||total);

END;
/

-- ���� FOR�� ����� ������ �����
SET serveroutput ON

DECLARE

BEGIN
	FOR i IN 2 ..9 LOOP
		FOR j IN 2 ..9 LOOP
			DBMS_OUTPUT.PUT(i||' * '||j||' = '||i*j||'    ');
		END LOOP;                                             
			DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
END;
/
 

-- �ٽ� ���� FOR�� ������ ���� 
SET serveroutput ON

DECLARE

BEGIN
	FOR i IN 2..9 LOOP
		DBMS_OUTPUT.PUT_LINE(i||'�� ����');
		FOR j IN 2..9 LOOP
			DBMS_OUTPUT.PUT_LINE(i||' * '||j||' = '||i*j);
		END LOOP;		
		DBMS_OUTPUT.PUT_LINE(i||'�� ��');
	END LOOP;
END;
/
      

-- FOR�� ����Ͽ� ���� ���ھ� �߶󳻼� ���
SET serveroutput ON

DECLARE
	msg VARCHAR2(30);
BEGIN                
	msg := '������ �ݿ����Դϴ�.';
	FOR i IN 1..LENGTH(msg) LOOP
		DBMS_OUTPUT.PUT_LINE(SUBSTR(msg,i,1));
	END LOOP;
END;
/
 
*/
   
-- FOR�� ����Ͽ� ���� ���ھ� �߶󳻼� ���(����) 
-- REVERSE�� ����ϸ� �ݺ��Ǵ� �ε����� �Ųٷ� ����Ѵ�
SET serveroutput ON

DECLARE
	msg VARCHAR2(30);
BEGIN                
	msg := '������ �ݿ����Դϴ�.';
	FOR i IN REVERSE 1..LENGTH(msg) LOOP
		DBMS_OUTPUT.PUT_LINE(SUBSTR(msg,i,1));
	END LOOP;    
	
	FOR i in REVERSE 1..10 LOOP
		DBMS_OUTPUT.PUT_LINE(i);	
	END LOOP;
END;
/
                      