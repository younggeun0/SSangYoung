/* 도시락 코드를 "L_00000001"를 반환하는 함수 */
CREATE OR REPLACE FUNCTION lunch_code
RETURN CHAR
IS

BEGIN
	RETURN concat('L_', LPAD(seq_lunch.nextval,8,0));
END;
/
