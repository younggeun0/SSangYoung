/*
  3. �̸��� �Է¹޾� ���� �̸��� ����ϴ�  PL/SQL�� �ϼ���.
    �̸��� ���ڼ��� 3�� ���϶�� '�ܼ�'���� �Ǵ��ϰ� 4�� �̻��̶�� 
    '����' �̶�� �Ǵ��Ѵ�.
    �ܼ�- ���� �ϳ��� �� (��: ��,��,��,��),  
    ���� - ���� �ΰ��μ� (�� : ������, �簥���� ��)
    �����  ��: ��  �̸� : ��ö
*/                             

SET serveroutput ON
SET verify OFF

ACCEPT name PROMPT '�̸��� �Է��ϼ��� : '

DECLARE
	name VARCHAR(15);
	first VARCHAR(6);
	last VARCHAR(9);
BEGIN               
	name := '&name';
	
	IF LENGTH(name) <= 3 THEN
		first := SUBSTR(name, 1, 1);
		last := SUBSTR(name, 2);
	ELSE
		first := SUBSTR(name, 1, 2);
		last := SUBSTR(name, 3);
	END IF; 
	
	DBMS_OUTPUT.PUT_LINE('�� : '||first||' �̸� : '||last); 
END;
/