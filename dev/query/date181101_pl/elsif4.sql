
-- 점수를 입력받아 0~100 사이일 때 점수 계산
-- 0~100사이가 아니라면 입력 실패 출력
-- 0~100사이일 때 0~40 - '과락'
-- 41~60 - '다른과목 참조'
-- 61~100점 - 합격을 출력

SET serveroutput ON
SET verify OFF
   
ACCEPT score PROMPT '정처기 점수를 입력하세요.. : '

DECLARE
	score NUMBER(3);
	output VARCHAR2(60);
BEGIN
	score := &score;
	
	IF score BETWEEN 0 AND 100 THEN 
		IF score >= 61 THEN 
			output := '합격..! o(^^O)(O^^)o';
		ELSIF score >= 41 THEN
			output := '다른과목 참조..';
		ELSE
			output := '과락.. OTL';
		END IF;
		
		DBMS_OUTPUT.PUT_LINE(output);
	ELSE
		DBMS_OUTPUT.PUT_LINE('0~100 사이 값만 입력가능합니다..');
	END IF;	
END;
/


