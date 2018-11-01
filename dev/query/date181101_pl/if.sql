
-- 단일 if : 조건에 맞는 경우에만 코드를 실행해야 할 때
-- 이름을 입력받아 이름이 '이재찬'이라면 이름 출력 전에
-- '인천시의 자랑 '을 출력할 것. 다른 이름은 이름만 출력

SET serveroutput ON
SET verify OFF

ACCEPT i_name PROMPT '이름 입력 :'

DECLARE
	name VARCHAR2(15) := '&i_name';
BEGIN
	IF name = '이재찬' THEN
		DBMS_OUTPUT.PUT('인천시의 자랑 ');
	END IF;

	IF name = '오영근' THEN
		DBMS_OUTPUT.PUT('취업걱정 없는 ');
	END IF;

	DBMS_OUTPUT.PUT_LINE(name);

END;
/
                            