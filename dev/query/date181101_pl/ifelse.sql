-- �̸��� �Է¹޾� '������'�̸� '����'�� ����ϰ�
-- �׷��� ������ '���'�� ����� �� �Է��� �̸��� ����ϴ� PL/SQL�� �ۼ�

SET serveroutput ON
SET verify OFF

ACCEPT input PROMPT '�̸� :'

DECLARE
	name VARCHAR2(60);
BEGIN
	name := '&input';
	
	IF name='������' THEN
		DBMS_OUTPUT.PUT('���� ');
	ELSE 
		DBMS_OUTPUT.PUT('��� '); 
	END IF;
		
	DBMS_OUTPUT.PUT_LINE(name);
END;
/