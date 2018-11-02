/*
-- 시작과 끝을 한눈에 알 수 있는 반복문 FOR
-- 구구단 만들기
SET serveroutput ON
SET verify OFF

ACCEPT input PROMPT '검색할 구구단 수를 입력하세요 : '

DECLARE
	input NUMBER;

	-- FOR의 인덱스를 저장하는 변수는 DECLARE에서 선언된 변수를 사용하지 않는다
	i NUMBER := 1;
BEGIN
	input := &input;

 	FOR i IN 1 ..9 LOOP
 		DBMS_OUTPUT.PUT_LINE(input||' * '||i||' = '||input*i);
 	END LOOP;

	DBMS_OUTPUT.PUT_LINE(i);
END;
/


-- 1~9까지 1씩 증가하는 구구단2단을 FOR를 작성하여 출력
SET serveroutput ON

DECLARE
	num NUMBER(1);
BEGIN
	num := 2;
	FOR i IN 1 ..9 LOOP
		DBMS_OUTPUT.PUT_LINE(num||' * '||i||' = '||num*i);
	END LOOP;
END;
/


-- 1~100까지의 합 출력 : 5050 (누적합)
-- 1+2+3+... +100

SET serveroutput ON

DECLARE

	total NUMBER := 0;

BEGIN

	DBMS_OUTPUT.PUT_LINE('초기 sum : '||total);

	FOR i IN 1 ..100 LOOP
		total := total + i;
		DBMS_OUTPUT.PUT_LINE('sum + '||i||' = '||total);
	END LOOP;

	DBMS_OUTPUT.PUT_LINE('최종 sum : '||total);

END;
/

-- 다중 FOR를 사용한 구구단 만들기
SET serveroutput ON

DECLARE

BEGIN
	FOR i IN 2 ..9 LOOP
		FOR j IN 2 ..9 LOOP
			DBMS_OUTPUT.PUT(i||' * '||j||' = '||i*j||'    ');
		END LOOP;                                             
			DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
END;
/
 

-- 다시 다중 FOR문 구구단 연습 
SET serveroutput ON

DECLARE

BEGIN
	FOR i IN 2..9 LOOP
		DBMS_OUTPUT.PUT_LINE(i||'단 시작');
		FOR j IN 2..9 LOOP
			DBMS_OUTPUT.PUT_LINE(i||' * '||j||' = '||i*j);
		END LOOP;		
		DBMS_OUTPUT.PUT_LINE(i||'단 끝');
	END LOOP;
END;
/
      

-- FOR를 사용하여 글자 한자씩 잘라내서 출력
SET serveroutput ON

DECLARE
	msg VARCHAR2(30);
BEGIN                
	msg := '오늘은 금요일입니다.';
	FOR i IN 1..LENGTH(msg) LOOP
		DBMS_OUTPUT.PUT_LINE(SUBSTR(msg,i,1));
	END LOOP;
END;
/
 
*/
   
-- FOR를 사용하여 글자 한자씩 잘라내서 출력(역순) 
-- REVERSE를 사용하면 반복되는 인덱스를 거꾸로 사용한다
SET serveroutput ON

DECLARE
	msg VARCHAR2(30);
BEGIN                
	msg := '오늘은 금요일입니다.';
	FOR i IN REVERSE 1..LENGTH(msg) LOOP
		DBMS_OUTPUT.PUT_LINE(SUBSTR(msg,i,1));
	END LOOP;    
	
	FOR i in REVERSE 1..10 LOOP
		DBMS_OUTPUT.PUT_LINE(i);	
	END LOOP;
END;
/
                      