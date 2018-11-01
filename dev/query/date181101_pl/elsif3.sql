-- 100~90 A
-- 90~70 B
-- 70~50 C
-- 50~40 D
-- 나머진 F

SET serveroutput ON
SET verify OFF

ACCEPT score PROMPT '성적을 입력하세요 :'

DECLARE
	score NUMBER(3);
	grade CHAR(1);
BEGIN
	score := &score;
	
	IF score >=90 THEN
		grade := 'A';
	ELSIF score >=70 THEN
		grade := 'B';
	ELSIF score >=50 THEN
		grade := 'C';
	ELSIF score >=40 THEN
		grade := 'D';
	ELSE
	    grade := 'F';
	END IF;
	
	DBMS_OUTPUT.PUT_LINE('당신의 성적은 '||grade||'입니다..');
END;
/