-- �� ���� �Է¹޾� ���� ���� ����ϴ� PL/SQL

SET serveroutput ON
SET verify OFF

ACCEPT num1 PROMPT 'ù��° �� : '
ACCEPT num2 PROMPT '�ι�° �� : '

DECLARE 
	result NUMBER;
BEGIN                 
                
	result := &num1 / &num2;
	
	DBMS_OUTPUT.PUT_LINE(&num1||' / '||&num2||' = '||ROUND(result, 2));   
	
	EXCEPTION
--		WHEN ZERO_DIVIDE THEN
--			DBMS_OUTPUT.PUT_LINE('0���δ� ���� �� �����ϴ�.');
--		WHEN OTHERS THEN   
--			DBMS_OUTPUT.PUT_LINE('�����ڰ� �ν����� ���� ���� : '||sqlcode);
			
--		WHEN OTHERS THEN
--			IF sqlcode = -1476 THEN
--				DBMS_OUTPUT.PUT_LINE('0���δ� ���� �� �����ϴ�.');  
--			END IF;

-- ���ܰ� �߻����� �� ORACLE���� �����ϴ� ������ ���ܸ޽����� ����ϰ�
-- ���� �� ����� ���� ����ó���� �Ѵ�.
-- RAISE_APPLICATION_ERR(�����ڵ�, '������ �޼���');

		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-21000, '����� ���� ����');
			

END;
/