-- 사원번호를 입력받아 cp_emp2테이블에서 사원번호와 
-- 일치하는 사원을 삭제하는 PL/SQL 작성.

SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '사원번호 : '

DECLARE
  i_empno cp_emp2.empno%TYPE := &empno;
	cnt NUMBER;
BEGIN                                    
         
	-- DELETE WHERE절에서는 컬럼명과 변수명이 같다면 
	-- 모두 참으로 판단하여 모든 레코드를 삭제
	-- 변수명과 컬럼명느 구분될 수 있도록 이름을 설정해야한다.
	DELETE FROM cp_emp2 
	WHERE empno = i_empno;
	
	cnt := SQL%ROWCOUNT;
	
	IF cnt = 1 THEN
		DBMS_OUTPUT.PUT_LINE(cnt||'건이 삭제되었습니다');
  	COMMIT;
  ELSE
		DBMS_OUTPUT.PUT_LINE('여러건의 레코드는 삭제할 수 없습니다.');
    ROLLBACK;
  END IF;
		
END;
/