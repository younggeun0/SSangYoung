
SET serveroutput ON

DECLARE
 var VARCHAR2(15) := '�ȳ�!';
BEGIN
                              
 -- PUT_LINE�� ����� �� ����
 DBMS_OUTPUT.PUT_LINE(var);
 DBMS_OUTPUT.PUT_LINE('hello PL/SQL');
 DBMS_OUTPUT.PUT_LINE('������ ������Դϴ�');
 -- PUT�� ��� �� �ٺ��� ���� �ʴ´�
 DBMS_OUTPUT.PUT('������ �ݿ���');
 -- PUT���θ� ����� ����Ǹ� ��³����� ��µ��� ����
 DBMS_OUTPUT.PUT_LINE('�𷹴� �����');        
 
 DBMS_OUTPUT.PUT('������');
 DBMS_OUTPUT.PUT('ȭ����');
 DBMS_OUTPUT.PUT_LINE('');
END;     
/
