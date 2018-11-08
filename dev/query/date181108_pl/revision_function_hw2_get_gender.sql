/*
2.  주민번호를 입력받아 성별(남자 - M, 여자 - F)을 반환하는 함수 작성
    성별은 000000-X000000, X가 남자면 홀수, 여자면 짝수
*/

CREATE OR REPLACE FUNCTION hw2_get_gender(ssn CHAR)
RETURN CHAR
IS
	re_msg CHAR(1) := 'F';
	flag CHAR(1);
	
BEGIN
 
	flag := SUBSTR(ssn, 8, 1);
	
	IF MOD(flag, 2) != 0 THEN
	
		re_msg := 'M';       
	
	END IF;	     
	
	RETURN re_msg;

END;
/
