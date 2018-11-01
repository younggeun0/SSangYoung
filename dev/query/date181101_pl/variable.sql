
SET serveroutput ON

DECLARE
-- 1. 변수 선언 : 변수명 데이터형(크기);
	name1 VARCHAR2(60);
	name2 VARCHAR2(60);
	temp VARCHAR2(60);

BEGIN
-- 2. 값 할당 : 변수명 := 값;
	name1 := '오영영';
	name2 := '손솔솔';
	temp := name1;
	name1 := name2;
	name2 := temp;

-- 3. 사용 : 출력, 연산참여, 재할당
	DBMS_OUTPUT.PUT_LINE('name1 : '||name1);
	DBMS_OUTPUT.PUT_LINE('name2 : '||name2);
END;
/
