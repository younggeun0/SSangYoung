SET serveroutput ON   
SET verify OFF
                
ACCEPT input_name PROMPT '�̸��� �Է��ϼ��� : '
ACCEPT input_age PROMPT '���̸� �Է��ϼ��� : '

DECLARE
 name VARCHAR2(15);
 age NUMBER(3);
BEGIN              
 name := '&input_name';
 age := &input_age;    
                 
-- ��� �����ڰ� �ƴ� �������� ����� ����� �� ���� 
-- DBMS_OUTPUT.PUT_LINE(age > 10);
 
END;
/