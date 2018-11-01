-- 이름을 입력받아 '이재찬'이면 '반장'을 출력하고
-- 그렇지 않으면 '평민'을 출력한 후 입력한 이름을 출력하는 PL/SQL을 작성

SET serveroutput ON
SET verify OFF

ACCEPT input PROMPT '이름 :'

DECLARE
	name VARCHAR2(60);
BEGIN
	name := '&input';
	
	IF name='이재찬' THEN
		DBMS_OUTPUT.PUT('반장 ');
	ELSE 
		DBMS_OUTPUT.PUT('평민 '); 
	END IF;
		
	DBMS_OUTPUT.PUT_LINE(name);
END;
/