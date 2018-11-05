-- 사원번호, 사원명, 연봉을 입력받아 사원번호와 일치하는 사원의 
-- 연봉과 사원명을 cp_emp2 테이블에서 변경하세요.
-- 단, 연봉은 3000이하일때 1000을 더한 연봉으로 변경한다.
SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '사원번호 : '
ACCEPT ename PROMPT '사원명 : '
ACCEPT sal PROMPT '연봉 : '

DECLARE
	i_empno cp_emp2.empno%TYPE := &empno;
	i_ename cp_emp2.ename%TYPE := '&ename';
	i_sal cp_emp2.sal%TYPE := &sal;
	cnt NUMBER;
BEGIN               
	
	IF i_sal <= 3000 THEN
		i_sal := i_sal + 1000;
	END IF;
  
	-- 변수명과 컬럼명이 같으면 오라클은 구분할 수 없음(식별안되면 항상 참)
	-- 변수명과 컬럼명이 식별되지 않는 UPDATE의 SET과 WHERE절은
	-- 변수명과 컬럼명을 구분될 수 있도록 이름을 다르게하여 작성해야된다.
	UPDATE cp_emp2
	SET sal = i_sal, ename = i_ename 
	WHERE empno = i_empno;                
	           
	cnt := SQL%ROWCOUNT;           
	
	IF cnt = 1 THEN
		DBMS_OUTPUT.PUT_LINE(cnt||'건이 변경되었습니다.');
		COMMIT;
	ELSE           
		DBMS_OUTPUT.PUT_LINE(cnt||'건은 없거나 한건이 아니므로 변경작업을 취소합니다..');
		ROLLBACK;
	END IF;

END;
/