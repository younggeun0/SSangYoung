-- 부서 번호를 입력받아 해당 부서에 따른 
-- 사원번호, 사원명, 입사일, 연봉을 조회
-- 입사일은 년-월-일 분기의 형태   
-- 부서번호가 10,20,30이 아니라면 
-- 10번 부서로 조회하여 출력할 것

SET serveroutput ON 
SET verify OFF

ACCEPT deptno PROMPT '부서번호 : '

DECLARE         
-- 입력값에 대한 IF문을 사용한 제약설정(값 검증)은 
-- DECLARE-BEGIN사이에서 할 수 없다
	i_deptno NUMBER(2) := &deptno;
BEGIN                     

	IF &deptno NOT IN (10, 20, 30) THEN
	  i_deptno := 10; 
	END IF; 
	
	FOR emp_data IN (SELECT empno, ename, 
													TO_CHAR(hiredate,'yyyy-mm-dd q') hiredate, sal
									 FROM   emp
									 WHERE  deptno = i_deptno) 
	LOOP								 
		DBMS_OUTPUT.PUT_LINE(emp_data.empno||' '
												||emp_data.ename||' '
												||emp_data.hiredate||' '
												||emp_data.sal);	
	END LOOP;            
	
END;
/         