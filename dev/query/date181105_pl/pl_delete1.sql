-- 삭제

SET serveroutput ON

DECLARE

BEGIN
	DELETE FROM cp_emp2
	WHERE empno = 2222;
	
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'건이 삭제되었습니다.');
	
END;
/