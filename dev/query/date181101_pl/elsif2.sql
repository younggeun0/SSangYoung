-- 점수를 입력받아 판정내리기
-- 0 ~ 100 사이 - 성공, 이하 - 실패, 초과 - 실패 

SET serveroutput ON
SET verify OFF  

ACCEPT input_score PROMPT '점수를 입력:'

DECLARE
	score NUMBER(3);
	output VARCHAR2(100);
BEGIN           
	score := &input_score;
	
	DBMS_OUTPUT.PUT(score||'는 ');                   
	
	IF score < 0 THEN
		output := '0보다 작아서 실패';
	ELSIF score > 100 THEN
		output := '100보다 커서 실패';
	ELSE
		output := '0~100사이라서 성공';
	END IF;
	
	DBMS_OUTPUT.PUT_LINE(output);

END;
/

