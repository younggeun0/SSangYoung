-- 프로시저를 이용한 DELETE                         
-- 언어가 아니라 confirm dialog 없이 삭제처리
-- 사원번호를 입력받아 test_proc 테이블에서 삭제하는 PROCEDURE

CREATE OR REPLACE PROCEDURE delete_test_proc(
	i_empno NUMBER,
	msg OUT VARCHAR2,
	cnt OUT NUMBER
)                 
IS

	res_msg VARCHAR2(15);

BEGIN
    
 	DELETE FROM test_proc
 	WHERE empno = i_empno;
 	
 	cnt := SQL%ROWCOUNT; 
 	
 	IF cnt = 1 THEN
 		COMMIT;
	 	msg := i_empno||'번 사원 퇴사. 행복하세요~~';       
 	ELSE                               
 		msg := i_empno||'번 사원은 존재하지 않습니다.';	
 	END IF;
 	

END;
/
