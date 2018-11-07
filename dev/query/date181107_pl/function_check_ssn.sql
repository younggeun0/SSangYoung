-- 입력되는 주민번호의 유효성 검증
-- 글자수가 14자리, 7번째 자리에 '-'이 존재하는지
-- 검증 통과 시 success, 실패 시 fail로 반환

CREATE OR REPLACE FUNCTION check_ssn(ssn CHAR)
RETURN VARCHAR2
IS         
	result_msg VARCHAR2(7) := 'fail';	
                           
BEGIN                      

	IF LENGTH(TRIM(ssn)) = 14 AND INSTR(ssn, '-') = 7 THEN
		result_msg := 'success';
	END IF;
           
	RETURN result_msg; 

END;   
/
