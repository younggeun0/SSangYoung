
-- ������ �Է¹޾� 0~100 ������ �� ���� ���
-- 0~100���̰� �ƴ϶�� �Է� ���� ���
-- 0~100������ �� 0~40 - '����'
-- 41~60 - '�ٸ����� ����'
-- 61~100�� - �հ��� ���

SET serveroutput ON
SET verify OFF
   
ACCEPT score PROMPT '��ó�� ������ �Է��ϼ���.. : '

DECLARE
	score NUMBER(3);
	output VARCHAR2(60);
BEGIN
	score := &score;
	
	IF score BETWEEN 0 AND 100 THEN 
		IF score >= 61 THEN 
			output := '�հ�..! o(^^O)(O^^)o';
		ELSIF score >= 41 THEN
			output := '�ٸ����� ����..';
		ELSE
			output := '����.. OTL';
		END IF;
		
		DBMS_OUTPUT.PUT_LINE(output);
	ELSE
		DBMS_OUTPUT.PUT_LINE('0~100 ���� ���� �Է°����մϴ�..');
	END IF;	
END;
/


