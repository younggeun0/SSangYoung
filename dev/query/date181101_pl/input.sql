
SET serveroutput ON   
-- 검증옵션 끄기
SET verify OFF
                
-- 외부값 입력받기
ACCEPT input_name PROMPT '이름을 입력하세요 : '
ACCEPT input_age PROMPT '나이를 입력하세요 : '

DECLARE
 name VARCHAR2(15);
 age NUMBER(3);
 yob NUMBER(4);
BEGIN              
 -- 입력된 값이 문자열인 경우 ''로 묶어서 사용
 name := '&input_name';
 age := &input_age;
 
 DBMS_OUTPUT.PUT_LINE('이름 : '||name||'님 나이는 '||age||'살입니다.');
                                
 yob := TO_CHAR(SYSDATE, 'yyyy')-age+1;
-- 태어난해 출력 : XX살 태어난해 XXXX년생
 DBMS_OUTPUT.PUT_LINE(age||'살 태어난해 : '||
 	(TO_CHAR(SYSDATE, 'yyyy')-age+1)||'년생');
END;
/