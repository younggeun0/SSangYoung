/*
2. ������ �Է¹޾Ƽ�  
    100~90 ���̸� 'A'���� 
     89~80 ���̸� 'B'
    79~70 ���̸� 'C'
    69~60 ���̸� 'D'
    �׿� ��� '����� ����' �� ����ϴ�  PL/SQL�� �ۼ��ϼ���.
*/

SET serveroutput ON
SET verify OFF

ACCEPT score PROMPT '������ �Է����ּ��� : '

DECLARE
	score NUMBER(3);
	output CHAR(1);
BEGIN
	score := '&score';
	
	IF score BETWEEN 0 AND 100 THEN
		IF score >= 90 THEN
			output := 'A';
		ELSIF score >= 80 THEN
			output := 'B';
		ELSIF score >= 70 THEN
			output := 'C';
		ELSIF score >= 60 THEN
			output := 'D';
		ELSE
			DBMS_OUTPUT.PUT_LINE('����� ����..');
			RETURN;
		END IF;
			DBMS_OUTPUT.PUT_LINE(output||'������ �޾ҽ��ϴ�!');	
	ELSE 
		DBMS_OUTPUT.PUT_LINE('������ 0���� �۰ų� 100���� Ů�ϴ�..');
	END IF;  
END;
/	