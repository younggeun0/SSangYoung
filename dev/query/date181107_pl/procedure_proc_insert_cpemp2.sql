-- cp_emp2 테이블에 사원변호, 사원명, 입사일, 연봉을 추가하고
-- 추가된 행의 수를 외부로 반환하는 Procedure

CREATE OR REPLACE PROCEDURE proc_insert_cpemp2(
	empno IN cp_emp2.empno%TYPE,
	ename IN cp_emp2.ename%TYPE,
	sal IN cp_emp2.sal%TYPE,
	cnt OUT NUMBER,
	msg OUT VARCHAR2
)                      
IS 


BEGIN

	INSERT INTO cp_emp2(empno, ename, hiredate, sal)
	VALUES(empno, ename, SYSDATE, sal); 

	cnt := SQL%ROWCOUNT;
	msg := '추가성공';        
	
	COMMIT;
	
	EXCEPTION
	WHEN OTHERS THEN
		cnt := 0;
		msg := '추가실패';
		
END;
/
