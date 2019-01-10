/*
	test_proc 테이블의 모든 사원 정보를 조회하여 out parameter에 
	설정하는 Procedure
*/
CREATE OR REPLACE PROCEDURE select_all_test_proc(
	cur_emp OUT SYS_REFCURSOR,
	date_pattern IN VARCHAR2	
)
IS

BEGIN                             	

	OPEN cur_emp FOR 
	SELECT empno, ename, TO_CHAR(hiredate, date_pattern) hiredate, sal, job
	FROM test_proc;                                               

END;
/

