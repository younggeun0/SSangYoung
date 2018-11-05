-- 사원번호, 사원명, 연봉을 사용자에게 입력받아 cp_emp2테이블에
-- 연봉이 5000이상이면 cp_emp3테이블에 추가하고 5000미만이라면
-- cp_emp2 테이블에 추가하는 PL/SQL 작성
-- 단, cp_emp3 테이블에 추가되는 사원의 부서 번호는 10번부서로 추가

SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '사원번호 : '
ACCEPT ename PROMPT '사원명 : '
ACCEPT sal PROMPT '연봉 : '

DECLARE
	empno cp_emp2.empno%TYPE;
	ename cp_emp2.ename%TYPE;
	sal NUMBER := &sal;
BEGIN

	empno := &empno;
	ename := '&ename';

	IF sal >= 5000 THEN
		INSERT INTO cp_emp3(empno, ename, sal, deptno)
		VALUES(empno, ename, sal, 10);
		DBMS_OUTPUT.PUT_LINE('연봉이 5000이상이므로 cp_emp3 테이블에 추가');
	ELSE
		INSERT INTO cp_emp2(empno, ename, sal, hiredate)
		VALUES(empno, ename, sal, SYSDATE);
		DBMS_OUTPUT.PUT_LINE('연봉이 5000미만이므로 cp_emp2 테이블에 추가');
	END IF;

	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'행 입력성공');
	COMMIT;

	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('Exception!');

END;
/
