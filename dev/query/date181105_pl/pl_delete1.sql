-- ����

SET serveroutput ON

DECLARE

BEGIN
	DELETE FROM cp_emp2
	WHERE empno = 2222;
	
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'���� �����Ǿ����ϴ�.');
	
END;
/