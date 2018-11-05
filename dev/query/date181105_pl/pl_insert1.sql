-- PL/SQL에서 DML 사용

SET serveroutput ON

DECLARE

BEGIN

	INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
	VALUES(3333, '유재석', 10, '부장님최고', 8000);

  -- 수행한 행의 수 얻기 : 암시적(묵시적) 커서를 사용
  -- SQL(암시적 커서)
  -- INSERT는 추가 성공 아니면 예외가 발생하므로
  -- 굳이 암시적 커서를 사용하여 추가된 행의 수를 얻을 필요없다

	COMMIT;
  
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'행 추가');
  
  EXCEPTION
  WHEN OTHERS THEN
  	DBMS_OUTPUT.PUT_LINE('문제발생');

END;
/