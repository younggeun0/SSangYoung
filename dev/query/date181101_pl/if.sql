
-- ���� if : ���ǿ� �´� ��쿡�� �ڵ带 �����ؾ� �� ��
-- �̸��� �Է¹޾� �̸��� '������'�̶�� �̸� ��� ����
-- '��õ���� �ڶ� '�� ����� ��. �ٸ� �̸��� �̸��� ���

SET serveroutput ON
SET verify OFF

ACCEPT i_name PROMPT '�̸� �Է� :'

DECLARE
	name VARCHAR2(15) := '&i_name';
BEGIN
	IF name = '������' THEN
		DBMS_OUTPUT.PUT('��õ���� �ڶ� ');
	END IF;

	IF name = '������' THEN
		DBMS_OUTPUT.PUT('������� ���� ');
	END IF;

	DBMS_OUTPUT.PUT_LINE(name);

END;
/
                            