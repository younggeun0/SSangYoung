
SET serveroutput ON   
-- �����ɼ� ����
SET verify OFF
                
-- �ܺΰ� �Է¹ޱ�
ACCEPT input_name PROMPT '�̸��� �Է��ϼ��� : '
ACCEPT input_age PROMPT '���̸� �Է��ϼ��� : '

DECLARE
 name VARCHAR2(15);
 age NUMBER(3);
 yob NUMBER(4);
BEGIN              
 -- �Էµ� ���� ���ڿ��� ��� ''�� ��� ���
 name := '&input_name';
 age := &input_age;
 
 DBMS_OUTPUT.PUT_LINE('�̸� : '||name||'�� ���̴� '||age||'���Դϴ�.');
                                
 yob := TO_CHAR(SYSDATE, 'yyyy')-age+1;
-- �¾�� ��� : XX�� �¾�� XXXX���
 DBMS_OUTPUT.PUT_LINE(age||'�� �¾�� : '||
 	(TO_CHAR(SYSDATE, 'yyyy')-age+1)||'���');
END;
/