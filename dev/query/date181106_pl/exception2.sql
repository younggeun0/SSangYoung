-- SELECT로 여러 행을 조회하거나 한 행을 조회할 때 예외처리
-- 사원번호를 입력받아 cp_emp3테이블에서 해당 사원의
-- 사원명, 부서번호, 직무, 연봉 조회하는 PL/SQL

SET serveroutput ON
SET verify OFF

	ACCEPT empno PROMPT '사원번호 : '

DECLARE
	i_empno number := &empno;
  
	TYPE rec_emp IS RECORD(
		ename cp_emp3.ename%TYPE,
		deptno cp_emp3.deptno%TYPE,
		job cp_emp3.job%TYPE,
		sal cp_emp3.sal%TYPE
	);
	
	emp_rec rec_emp;
BEGIN             

	SELECT ename, deptno, job, sal 
	INTO emp_rec
	FROM cp_emp3
	WHERE empno = i_empno;
	
	DBMS_OUTPUT.PUT_LINE(emp_rec.ename||' '
												||emp_rec.deptno||' '
												||emp_rec.job||' '
												||emp_rec.sal);

                                                
    EXCEPTION
--        WHEN TOO_MANY_ROWS THEN
--            DBMS_OUTPUT.PUT_LINE(i_empno||'번 사원이 한 건 이상 존재합니다.');
--        WHEN NO_DATA_FOUND THEN
--            DBMS_OUTPUT.PUT_LINE(i_empno||'번 사원이 존재하지 않습니다.'); 
--        WHEN OTHERS THEN
--          -- 모든 예외를 다 처리할 수 있다.
--          -- 최상위 예외이기 때문에 EXCEPTION에서 가장 먼저 정의하게되면
--          -- 하위 예외처리 객체가 예외를 처리하기 전에 OTHERS가 처리하게 됨
--            DBMS_OUTPUT.PUT_LINE('인식하지 못한 예외');                                            
          												
--    OTHERS안에서 비교구문으로 sqlcode를 이용한 에러처리도 가능하다
		WHEN OTHERS THEN                                                     
			IF sqlcode = 100 THEN
				DBMS_OUTPUT.PUT_LINE('찾는 데이터가 없습니다..');
			END IF;  
			
			IF sqlcode = -1422 THEN
				DBMS_OUTPUT.PUT_LINE('사원번호로 여러명의 사원이 조회됩니다.');
			END IF;
		
							
									
END;
/              

