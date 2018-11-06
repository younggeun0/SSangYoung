-- 두 수를 입력받아 나눈 값을 출력하는 PL/SQL

SET serveroutput ON
SET verify OFF

ACCEPT num1 PROMPT '첫번째 수 : '
ACCEPT num2 PROMPT '두번째 수 : '

DECLARE 
	result NUMBER;
BEGIN                 
                
	result := &num1 / &num2;
	
	DBMS_OUTPUT.PUT_LINE(&num1||' / '||&num2||' = '||ROUND(result, 2));   
	
	EXCEPTION
--		WHEN ZERO_DIVIDE THEN
--			DBMS_OUTPUT.PUT_LINE('0으로는 나눌 수 없습니다.');
--		WHEN OTHERS THEN   
--			DBMS_OUTPUT.PUT_LINE('개발자가 인식하지 못한 예외 : '||sqlcode);
			
--		WHEN OTHERS THEN
--			IF sqlcode = -1476 THEN
--				DBMS_OUTPUT.PUT_LINE('0으로는 나눌 수 없습니다.');  
--			END IF;

-- 예외가 발생했을 때 ORACLE에서 제공하는 형식의 예외메시지를 출력하고
-- 싶을 때 사용자 정의 예외처리를 한다.
-- RAISE_APPLICATION_ERR(에러코드, '제공할 메세지');

		WHEN OTHERS THEN
			RAISE_APPLICATION_ERROR(-21000, '사용자 정의 예외');
			

END;
/