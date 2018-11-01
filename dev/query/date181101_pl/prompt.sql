/*
CREATE TABLE ref_tab(
  	name VARCHAR2(60),
  	age NUMBER(3)
);
*/
-- �̸� ���̸� �Է¹޾� ref_tab ���̺��� �����Ͽ� ������
-- ����(RECORD����)�� ���� �Է��� �� �Ʒ��� ���� ����ϴ�
-- PL/SQL�� �����ϼ���.
-- ���) �̸� : xxx�� ���� : XX ��
--     (�۳⳪�� XX��, ���⳪�� : xx ��)

SET serveroutput ON
SET verify OFF
 
ACCEPT name PROMPT '�̸� :'
ACCEPT age PROMPT '���� :'

DECLARE                 
	rv ref_tab%ROWTYPE;
BEGIN                  
	rv.name := '&name';
	rv.age := &age;          
	
	INSERT INTO ref_tab(name, age)
	VALUES (rv.name, rv.age);
	
	DBMS_OUTPUT.PUT_LINE('�̸� : '||rv.name||'�� ���� : '||rv.age||' ��');
	DBMS_OUTPUT.PUT_LINE('(�۳⳪�� '||(rv.age-1)||'��, ���⳪�� : '
						 ||(rv.age+1)||' ��)');
END;
/