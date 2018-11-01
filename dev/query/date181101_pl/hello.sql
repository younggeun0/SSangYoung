
SET serveroutput ON

DECLARE
 var VARCHAR2(15) := '안녕!';
BEGIN
                              
 -- PUT_LINE은 출력후 줄 변경
 DBMS_OUTPUT.PUT_LINE(var);
 DBMS_OUTPUT.PUT_LINE('hello PL/SQL');
 DBMS_OUTPUT.PUT_LINE('오늘은 목요일입니다');
 -- PUT은 출력 후 줄변경 하지 않는다
 DBMS_OUTPUT.PUT('내일은 금요일');
 -- PUT으로만 출력이 종료되면 출력내용이 출력되지 않음
 DBMS_OUTPUT.PUT_LINE('모레는 토요일');        
 
 DBMS_OUTPUT.PUT('월요일');
 DBMS_OUTPUT.PUT('화요일');
 DBMS_OUTPUT.PUT_LINE('');
END;     
/
