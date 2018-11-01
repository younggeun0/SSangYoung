/*
CREATE TABLE ref_tab(
  	name VARCHAR2(60),
  	age NUMBER(3)
);
*/
-- 이름 나이를 입력받아 ref_tab 테이블을 참조하여 생성한
-- 변수(RECORD변수)에 값을 입력한 후 아래와 같이 출력하는
-- PL/SQL을 생성하세요.
-- 출력) 이름 : xxx님 나이 : XX 살
--     (작년나이 XX살, 내년나이 : xx 살)

SET serveroutput ON
SET verify OFF
 
ACCEPT name PROMPT '이름 :'
ACCEPT age PROMPT '나이 :'

DECLARE                 
	rv ref_tab%ROWTYPE;
BEGIN                  
	rv.name := '&name';
	rv.age := &age;          
	
	INSERT INTO ref_tab(name, age)
	VALUES (rv.name, rv.age);
	
	DBMS_OUTPUT.PUT_LINE('이름 : '||rv.name||'님 나이 : '||rv.age||' 살');
	DBMS_OUTPUT.PUT_LINE('(작년나이 '||(rv.age-1)||'살, 내년나이 : '
						 ||(rv.age+1)||' 살)');
END;
/