/*
  3. 이름을 입력받아 성과 이름을 출력하는  PL/SQL을 하세요.
    이름의 글자수가 3자 이하라면 '단성'으로 판단하고 4자 이상이라면 
    '복성' 이라고 판단한다.
    단성- 성이 하나인 성 (예: 김,이,오,박),  
    복성 - 성이 두개인성 (예 : 선우용녀, 재갈공명 등)
    출력은  성: 김  이름 : 희철
*/                             

SET serveroutput ON
SET verify OFF

ACCEPT name PROMPT '이름을 입력하세요 : '

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
	
	DBMS_OUTPUT.PUT_LINE('성 : '||first||' 이름 : '||last); 
END;
/