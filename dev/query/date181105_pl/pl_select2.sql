-- 사원번호를 입력받아 사원명, 연봉, 직무, 입사일, 부서번호를 조회
-- 단, 연봉이 2000미만이라면 연봉의 2배를 연산하여 출력하고 
-- 부서번호가 10번과 20번 이라면 입사일을 월-일-년의 형식으로
-- 그렇지 않다면 년-월-일 형식으로 출력하세요. 

SET serveroutput ON
SET verify OFF                                  

ACCEPT empno PROMPT '사원번호 : '             

DECLARE
	i_empno emp.empno%TYPE := &empno;
	ename emp.ename%TYPE;
	sal emp.sal%TYPE;
	job emp.job%TYPE;
	hiredate emp.hiredate%TYPE;
	deptno emp.deptno%TYPE;
	
	date_format VARCHAR2(30) := 'yyyy-mm-dd';
BEGIN

	SELECT ename, sal, job, hiredate, deptno
	INTO ename, sal, job, hiredate, deptno
	FROM  emp
	WHERE empno = i_empno;                                     
	         
	-- 연봉이 2000미만인 사원에 대한 처리
	IF sal < 2000 THEN
		sal := sal * 2;
	END IF;
	
	-- 부서번호에 대한 날짜 출력형식 변경 (mm-dd-yyyy)
	IF deptno IN (10, 20) THEN
  	date_format := 'mm-dd-yyyy';
	END IF;
                                               
	DBMS_OUTPUT.PUT_LINE(i_empno||'번 사원정보');
	DBMS_OUTPUT.PUT_LINE('사원명 : '||ename||', 직무 : '||
											job||', 연봉 : '||sal||', 부서번호 : '||
											deptno||', 입사일 : '
											||TO_CHAR(hiredate, date_format));
										
										
	EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('입력하신 ['||i_empno
												||']번 사원은 존재하지 않습니다..');

END;
/   