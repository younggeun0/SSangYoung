/*
  사원번호를 입력받아 사원명, 연봉, 직무, 입사일을 반환하는 Procedure
*/                                                                   

CREATE OR REPLACE PROCEDURE select_one_test_proc(
	i_empno IN NUMBER,
	cur_emp OUT SYS_REFCURSOR,
	err_msg OUT VARCHAR2
)
IS
BEGIN         
	
	err_msg := '성공';
	OPEN cur_emp FOR             
		SELECT ename, sal, job, TO_CHAR(hiredate, 'yy-mm-dd day') hiredate
		FROM test_proc
		WHERE empno = i_empno;

	EXCEPTION 
	WHEN OTHERS THEN
		err_msg := '문제 발생'||sqlerrm;

END;
/
