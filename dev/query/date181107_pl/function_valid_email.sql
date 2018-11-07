-- 이메일의 유효성 검증은 6자 이상이면서 '@'과 '.'이 들어있어야 한다.
-- 검증에 통과여부에 따라 '유효', '무효' 반환
CREATE OR REPLACE FUNCTION valid_email(email VARCHAR2) 
RETURN CHAR
IS
    result_msg CHAR(6) := '무효';
BEGIN
    
    IF LENGTH(email) >= 6 AND INSTR(email, '@') != 0 
      AND INSTR(email, '.')<>0 THEN
    		result_msg := '유효';
    END IF;

    RETURN result_msg;

END;
/
