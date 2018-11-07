-- BIND 변수 사용
-- 1. BIND 변수 선언 : VAR[VARIABLE] 변수명 데이터형(크기)
VAR name VARCHAR2(30);
-- VARIABLE name VARCHAR2(30); -- VAR나 VARIABLE 둘 다 가능
VARIABLE age NUMBER;

VAR;

SET serveroutput ON
-- 2. BIND변수 값 할당 :변수명

DECLARE
  name VARCHAR2(30);
BEGIN

	name := '테스트';

  -- 3. 바인드변수에 값 할당
  -- ':'붙으면 밖에 있는 변수
	:name :=	name||'님 안녕';
  :age := 20;

  DBMS_OUTPUT.PUT_LINE(name||' '||:name||' '||:age);

END;
/
	-- 4.바인드변수의 값 출력
	PRINT name age
