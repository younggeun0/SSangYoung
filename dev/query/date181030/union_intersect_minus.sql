
SELECT * FROM cp_emp3;
SELECT * FROM cp_emp2;

INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1112, '이재찬', 10, '대리', 3500);
INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1113, '이재현', 20, '차장', 7500);
INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1114, '정택성', 20, '알바', 1500);

COMMIT;

-- emp : 미국본사, cp_emp3 : 한국지사라 가정했을 시
/*
DELETE FROM cp_emp3
WHERE ename IN (SELECT ename FROM emp);
*/
-- 미국본사와 한국지사 연봉이 2000이하인 사원급여를
-- 올려주고 싶어 2000이하인 사원의 사원번호, 사원명, 연봉, 직무를 조회

-- UNION : 중복데이터가 조회되지 않음
SELECT empno, ename, sal, job
FROM   emp
WHERE  sal <= 2000
UNION
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;

-- cp_emp3에 emp테이블에서 30번 부서 사원정보를 모두 추가
INSERT INTO cp_emp3(empno, ename, deptno, sal, job)
(SELECT empno, ename, deptno, sal, job
 FROM   emp
 WHERE  deptno=30);

SELECT * FROM cp_emp3;

COMMIT;

-- UNION ALL : 중복데이터가 조회됨
SELECT empno, ename, sal, job
FROM   emp
WHERE  sal <= 2000
UNION ALL
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;

-- 컬럼의 갯수가 일치하지 않거나 데이터형이 일치하지 않으면 에러발생
SELECT empno, ename, sal
FROM   emp
WHERE  sal <= 2000
UNION
SELECT empno, ename
FROM   cp_emp3
WHERE  sal <= 2000;

SELECT empno, ename, sal
FROM   emp
WHERE  sal <= 2000
UNION ALL
SELECT empno, ename, job
FROM   cp_emp3
WHERE  sal <=2000;


-- INTERSECT
-- 미국본사의 사원정보와 한국지사의 사원정보 중 일치하는 정보만 조회
SELECT empno, ename, sal, job
FROM   emp
WHERE  sal <= 2000
INTERSECT
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;

-- MINUS : 상위 SELECT에서 조회된 결과에서 하위 SELECT에서 조회된
-- 	       결과를 뺀 나머지를 조회함
SELECT empno, ename, sal, job
FROM   emp
MINUS
SELECT empno, ename, sal, job
FROM   cp_emp3
WHERE  sal <=2000;
