-- SYS_REFCURSOR를 이용한 프로시저결과 다중행 조회
-- 부서번호를 입력받아 emp테이블에서 부서별 사원정보를 조회하여 
-- out parameter로 저장하는 프로시저 작성
-- * 사원번호, 사원명, 연봉, 부서번호, 부서명, 위치를 조회
-- * 입력값이 10~19번 입력되면 10번부서 조회
--            20~29번 입력되면 20번부서 조회
--            그외는 30번 부서를 조회

CREATE OR REPLACE PROCEDURE select_emp(
 	deptno NUMBER,
	cur_join OUT SYS_REFCURSOR 
)
IS
	temp_deptno NUMBER := deptno;
BEGIN

	-- 입력되는 부서번호를 10또는 20으로 생성                                   
	temp_deptno := TRUNC(temp_deptno/10, 0)*10;

	IF temp_deptno NOT IN (10, 20) THEN
		temp_deptno := 30;
	END IF;      
	
	OPEN cur_join 
			FOR SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
				  FROM emp e, dept d
				  WHERE (e.deptno = d.deptno)
				  	AND d.deptno = temp_deptno; 
END;
/
