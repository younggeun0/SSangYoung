-- SYS_REFCURSOR 의 사용
-- 커서의 제어권을 외부로 전달할 때 주로 사용

-- 사원테이블에서 매니저번호를 입력받아 매너지가 관리하는
-- 사원의 사원번호, 사원명, 입사일, 부서번호, 연봉을 조회
-- 입력된 매니저번호가 emp테이블에 존재하는 매니저 번호일때만
-- 검색을 수행한다. (7839, 7782, 7698, 7902, 7566, 7788)

SET serveroutput ON
SET verify OFF

	ACCEPT mgr PROMPT '매니저번호 : '

DECLARE
	i_mgr NUMBER;
	
	-- 1. SYS_REFCURSOR 선언 : 커서명 SYS_REFCURSOR;
	cur_mgr SYS_REFCURSOR;
	
	-- 조회결과를 저장할 레코드형 선언
	TYPE rec_emp IS RECORD (
	  empno emp.empno%TYPE,
	  ename emp.ename%TYPE,
	  hiredate emp.hiredate%TYPE,
	  deptno emp.deptno%TYPE,
	  sal emp.sal%TYPE
	);	
	
	emp_rec rec_emp;
	
BEGIN

	-- 입력된 매니저 번호가 존재하는지 검색
	-- 커서 돌리면 받아오는 값은 레코드 변수! .를 사용해서 컬럼명을 참조한다.**
	FOR temp_rec IN (SELECT DISTINCT mgr
							     FROM emp
							     WHERE mgr = &mgr)
	LOOP
		i_mgr := temp_rec.mgr;
	END LOOP;


	IF i_mgr IS NOT NULL THEN
		
		-- 2. 커서 열기 : 조회 쿼리문 작성
		OPEN cur_mgr FOR SELECT empno, ename, hiredate, deptno, sal
		                 FROM emp
		                 WHERE mgr = i_mgr; 
		                 
		LOOP   
		  -- 3. 인출
			FETCH cur_mgr INTO emp_rec;		
			EXIT WHEN cur_mgr%NOTFOUND; 
			
			DBMS_OUTPUT.PUT_LINE(emp_rec.empno||' '
			                    ||emp_rec.ename||' '
			                    ||TO_CHAR(emp_rec.hiredate,'yyyy-mm-dd')||' '
			                    ||emp_rec.deptno||' '
			                    ||emp_rec.sal);
		
		END LOOP;
	
		IF cur_mgr%ISOPEN THEN
			-- 4. 닫기
			CLOSE cur_mgr;
			DBMS_OUTPUT.PUT_LINE('커서를 닫습니다..');
		END IF;		
		
	ELSE
		DBMS_OUTPUT.PUT_LINe('&mgr 은 없는 매니저번호입니다.');
  END IF;


		
END;
/