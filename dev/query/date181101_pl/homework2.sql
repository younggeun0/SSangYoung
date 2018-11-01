/*
2. 점수를 입력받아서  
    100~90 사이면 'A'학점 
     89~80 사이면 'B'
    79~70 사이면 'C'
    69~60 사이면 'D'
    그외 라면 '노력을 요함' 을 출력하는  PL/SQL을 작성하세요.
*/

SET serveroutput ON
SET verify OFF

ACCEPT score PROMPT '점수를 입력해주세요 : '

DECLARE
	score NUMBER(3);
	output CHAR(1);
BEGIN
	score := '&score';
	
	IF score BETWEEN 0 AND 100 THEN
		IF score >= 90 THEN
			output := 'A';
		ELSIF score >= 80 THEN
			output := 'B';
		ELSIF score >= 70 THEN
			output := 'C';
		ELSIF score >= 60 THEN
			output := 'D';
		ELSE
			DBMS_OUTPUT.PUT_LINE('노력을 요함..');
			RETURN;
		END IF;
			DBMS_OUTPUT.PUT_LINE(output||'학점을 받았습니다!');	
	ELSE 
		DBMS_OUTPUT.PUT_LINE('점수가 0보다 작거나 100보다 큽니다..');
	END IF;  
END;
/	