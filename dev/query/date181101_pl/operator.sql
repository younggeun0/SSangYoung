SET serveroutput ON   
SET verify OFF
                
ACCEPT input_name PROMPT '이름을 입력하세요 : '
ACCEPT input_age PROMPT '나이를 입력하세요 : '

DECLARE
 name VARCHAR2(15);
 age NUMBER(3);
BEGIN              
 name := '&input_name';
 age := &input_age;    
                 
-- 산술 연산자가 아닌 연산자의 결과는 출력할 수 없다 
-- DBMS_OUTPUT.PUT_LINE(age > 10);
 
END;
/