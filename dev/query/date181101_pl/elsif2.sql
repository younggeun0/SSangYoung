-- ������ �Է¹޾� ����������
-- 0 ~ 100 ���� - ����, ���� - ����, �ʰ� - ���� 

SET serveroutput ON
SET verify OFF  

ACCEPT input_score PROMPT '������ �Է�:'

DECLARE
	score NUMBER(3);
	output VARCHAR2(100);
BEGIN           
	score := &input_score;
	
	DBMS_OUTPUT.PUT(score||'�� ');                   
	
	IF score < 0 THEN
		output := '0���� �۾Ƽ� ����';
	ELSIF score > 100 THEN
		output := '100���� Ŀ�� ����';
	ELSE
		output := '0~100���̶� ����';
	END IF;
	
	DBMS_OUTPUT.PUT_LINE(output);

END;
/

