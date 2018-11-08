-- 프로시저를 이용한 SELECT(다중행조회)
-- 조회된 결과가 여러개라면 out parameter에 담을 수 없음
-- 바인드변수로 테이블과 레코드타입은 지원안함
-- 커서의 제어권을 밖으로 내주면 됨 => SYS_REFCURSOR를 사용

-- dept 테이블에서 모든 부서정보를 조회하여 
-- out parameter로 설정하는  프로시저를 작성 

CREATE OR REPLACE PROCEDURE select_all_dept(
	cur_dept OUT SYS_REFCURSOR
)
IS  
	
--	dept_data dept%ROWTYPE;

BEGIN

	OPEN cur_dept 
		FOR SELECT deptno, dname, loc 
			  FROM dept; 
		
-- SYS_REFCURSOR를 사용할 때는 외부에서 사용할 수 있도록
-- 커서의 인출을 프로시저내에서 수행하지 않는다.			  
--	LOOP 
--		FETCH cur_dept INTO dept_data;
--		EXIT WHEN cur_dept%NOTFOUND;
--	END LOOP;    
--	CLOSE cur_dept;

END;
/
