-- 사원번호, 사원명, 연봉을 사용자에게 입력받아 cp_emp2테이블에
-- 추가하는 PL/SQL 작성
-- 단, 연봉이 9000이상 입력되면 9000으로 변경하여 추가
-- 입사일은 추가되는 시점의 날짜로 추가

SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '사원번호 : '
ACCEPT ename PROMPT '사원명 : '
ACCEPT sal PROMPT '연봉 : '

DECLARE
	empno cp_emp2.empno%TYPE;
	ename cp_emp2.ename%TYPE;
	sal number:= &sal;

BEGIN

  empno := &empno;
  ename := '&ename';

	-- PL/SQL은 값을 제어한 후에 SQL문을 수행한다
	IF sal > 9000 THEN
		sal := 9000;
	END IF;

  INSERT INTO cp_emp2(empno, ename, sal, hiredate)
  VALUES(empno, ename, sal, SYSDATE);
                                    
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'행 입력 성공');
	COMMIT;      
	DBMS_OUTPUT.PUT_LINE(empno||'번 사원의 연봉을 '|| 
		sal||'로 입력하였습니다.');

	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('문제발생');

END;
/