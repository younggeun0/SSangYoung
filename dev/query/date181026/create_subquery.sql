-- 제약사항을 보는 테이블(딕셔너리)
SELECT *
FROM user_constraints;

-- deptno가 PK인걸 확인 가능
DESC dept;

-- 테이블 복사 :
CREATE TABLE cp_emp
AS (SELECT empno, ename, hiredate, sal FROM emp);

-- emp 테이블의 empno는 PK, 복사 안됨
SELECT * FROM cp_emp;

-- 연봉에 NOT NULL 제약사항 변경
ALTER TABLE cp_emp MODIFY sal NUMBER(7,2) NOT NULL;

SELECT * FROM user_constraints;

SELECT * FROM cp_emp;

-- NOT NULL 조건이 단독으로 설정되어 있다면 복사가 됨
-- 다시 말하지만 PK에 걸린 NOT NULL은 복사가 안됨

-- cp_emp테이블에서 사원번호가 7500~7599 사이에 속한
-- 사원의 사원번호, 사원명, 입사일, 연봉을 조회한 결과를
-- cp_emp2라는 테이블을 생성하고 입력
CREATE TABLE cp_emp2
AS (SELECT empno, ename, hiredate, sal
	FROM cp_emp
	WHERE empno BETWEEN 7500 AND 7599);
-- BETWEEN은 작은수가 앞에 와야 조회가 됨

-- 구조만 복사 (레코드를 조회하지 않고 서브쿼리를 수행)
-- 사원 테이블에서 사원번호, 사원명, 부서번호, 직무, 연봉을
-- 레코드가 조회되지 않도록 조회
CREATE TABLE cp_emp3
AS (SELECT empno, ename, deptno, job, sal
	FROM emp
	WHERE 1=0);

SELECT * FROM cp_emp3;
-- 조건으로 1=1을 쓰면 항상 참, 1=0을쓰면 항상 거짓으로 사용가능


