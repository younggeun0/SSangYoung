-- 사원번호, 사원명, 부서번호, 직무를 입력받아 cp_emp3 테이블에 추가하는 PL/SQL
-- 단, 사원의 연봉은 부서번호에 따라 동일 연봉으로 추가한다.
-- 10번 부서 - emp 테이블의 사원번호가 7566인 사원과 같은 연봉,
-- 20번 부서 - emp 테이블의 사원번호가 7698인 사원과 같은 연봉,
-- 30번 부서 - emp 테이블의 사원번호가 7782인 사원과 같은 연봉,
-- 그 외 부서번호가 입력되면 7788 사원의 연봉으로 추가
SET serveroutput ON
                                           
ACCEPT empno PROMPT '사원번호 입력 : '
ACCEPT ename PROMPT '사원명 입력 : '
ACCEPT deptno PROMPT '부서번호 입력 : '
ACCEPT job PROMPT '직무 입력 : ' 

DECLARE                         
	i_empno cp_emp3.empno%TYPE := &empno;
	i_ename cp_emp3.ename%TYPE := '&ename';
	i_deptno cp_emp3.deptno%TYPE := &deptno;
	i_job cp_emp3.job%TYPE := '&job';	
	
	sal cp_emp3.sal%TYPE;
	select_empno cp_emp.empno%TYPE := 7788;                       
	
BEGIN        
  
	-- 입력되는 부서번호별로 참조할 연봉을 조회하기 위한 
	-- 사원번호를 설정
	IF i_deptno = 10 THEN
		select_empno := 7566;  
	ELSIF i_deptno = 20 THEN
		select_empno := 7698;  
	ELSIF i_deptno = 30 THEN
	  select_empno := 7782;    
	END IF;
	
	-- 설정된 사원번호별로 연봉을 조회
	SELECT sal
	INTO sal
	FROM emp
	WHERE empno = select_empno;
	
	-- 조회된 연봉으로 추가 작업
	INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
	VALUES(i_empno, i_ename, i_deptno, i_job, sal);    
	
	DBMS_OUTPUT.PUT_LINE(i_empno||'번 사원정보를 추가하였습니다.');
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'건 입력 성공');
	COMMIT;
	
	EXCEPTION
	WHEN OTHERS THEN
	DBMS_OUTPUT.PUT_LINE('에러발생');

END;
/