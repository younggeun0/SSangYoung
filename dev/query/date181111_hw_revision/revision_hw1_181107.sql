/*               

1. 입사년도를 입력받아 근속년수가 10년 이상이면 '장기근속'
  그렇지 않으면 '단기근속'이라는 메세지를 반환하는 함수 작성. 
  
*/

CREATE OR REPLACE FUNCTION cal_cs(hiredate DATE)
RETURN CHAR
IS
	re_msg CHAR(12) := '단기근속';
	w_period NUMBER;
BEGIN               

	w_period := TO_CHAR(SYSDATE, 'yyyy') - TO_CHAR(hiredate, 'yyyy');
	
	IF w_period >= 10 THEN
		re_msg := '장기근속';	
	ENd IF;                
	
	RETURN re_msg;

END;
/
