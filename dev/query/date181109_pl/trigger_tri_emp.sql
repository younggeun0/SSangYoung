-- cp_emp테이블에 레코드가 추가되면
-- cp_emp3 테이블에 사원번호, 사원명, 부서번호, 직무('사원'), 연봉을
-- 추가하는 TRIGGER를 작성
-- 단, 부서번호는 emp테이블의 사원번호가 7788인 사원과 동일한 deptno로 추가
-- 연봉이 2000이하가 추가되면 cp_emp3엔 연봉의 500을 더해 추가하는 트리거 작성

CREATE OR REPLACE TRIGGER tri_emp 
AFTER INSERT ON cp_emp
FOR EACH ROW 
DECLARE
	deptno NUMBER;
BEGIN

	SELECT deptno
	INTO deptno
	FROM emp
	WHERE emp.empno=7788;                  
	
	IF :new.sal <= 2000 THEN
		INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
		VALUES(:new.empno, :new.ename, deptno, '사원', :new.sal+500);
	ELSE
		INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
		VALUES(:new.empno, :new.ename, deptno, '사원', :new.sal);
	END IF;
END; 

