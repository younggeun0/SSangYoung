-- PL/SQL에서 UPDATE 사용
SET serveroutput ON

DECLARE
	cnt NUMBER;
BEGIN

	UPDATE cp_emp2
	SET sal = 3500
	WHERE empno = 5443;

	-- 암시적(묵시적) 커서 SQL을 사용하여 변경한 행의 수를 얻는다
	cnt := SQL%ROWCOUNT;
	-- 변경된 사원이 1명일때만 Transcation을 완료하고 그렇지 않다면
	-- 작업을 취소.

	IF cnt = 1 THEN
  	DBMS_OUTPUT.PUT_LINE(cnt||'건이 변경되었습니다');
		COMMIT;
	ELSE 
		DBMS_OUTPUT.PUT_LINE('조회된 사원이 여러명이거나 없으므로 변경작업을 취소합니다..');
		ROLLBACK;
	END IF;



END;
/
