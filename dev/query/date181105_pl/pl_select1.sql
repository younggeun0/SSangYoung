-- cp_emp2에서 사원번호가 7566인 사원의
-- 사원명, 입사일, 연봉을 조회하여 출력하는 PL/SQL
SET serveroutput ON

DECLARE
	ename cp_emp2.ename%TYPE;
	input_date VARCHAR2(10);
	sal cp_emp2.sal%TYPE;
BEGIN

	SELECT ename, TO_CHAR(hiredate, 'yyyy-mm-dd'), sal
	INTO ename, input_date, sal
	FROM cp_emp2
	WHERE empno = 7566;

	DBMS_OUTPUT.PUT_LINE(ename||' / ' ||input_date||' / '
												||sal||' / '||SQL%ROWCOUNT);  

	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('문제발생');

END;
/

