SET serveroutput ON
SET verify OFF

ACCEPT name PROMPT '�̸��Է� : '  
ACCEPT height PROMPT 'Ű : '

DECLARE
	n VARCHAR2(15);
	h NUMBER(3);
BEGIN                            
-- �ּ��ȿ� &�� ������??  &comment
    n := '&name';
    h := &height;  
	DBMS_OUTPUT.PUT_LINE(n||' '||h);
END;
/