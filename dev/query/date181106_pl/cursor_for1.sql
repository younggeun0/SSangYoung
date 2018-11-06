-- 사원번호, 사원명, 입사일, 연봉을 조회
-- 입사일은 년-월-일 분기의 형태
SET serveroutput ON

DECLARE
	-- 1.선언
	CURSOR cur_emp IS 
	 SELECT empno, ename, 
	 				TO_CHAR(hiredate,'yyyy-mm-dd q') hiredate, sal
	 FROM   emp;
BEGIN                     
--	OPEN cur_emp; 커서가 두번 열릴 수 없기 때문에 에러발생
-- FOR가 시작되며 커서 열리고 자동으로 FETCH, CLOSE까지 수행

  -- 2. FOR를 사용한 인출(FETCH를 사용하지 않는다.)
	FOR emp_data IN cur_emp LOOP
		DBMS_OUTPUT.PUT_LINE(emp_data.empno||' '
												||emp_data.ename||' '
												||emp_data.hiredate||' '
												||emp_data.sal);	
	END LOOP;                                               
	
--	CLOSE cur_emp;
--  FOR를 빠져나오는 순간 커서가 닫히기 때문에 에러발생
END;
/           


  