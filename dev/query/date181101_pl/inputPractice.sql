SET serveroutput ON
SET verify OFF

ACCEPT name PROMPT '이름입력 : '  
ACCEPT height PROMPT '키 : '

DECLARE
	n VARCHAR2(15);
	h NUMBER(3);
BEGIN                            
-- 주석안에 &가 있으면??  &comment
    n := '&name';
    h := &height;  
	DBMS_OUTPUT.PUT_LINE(n||' '||h);
END;
/