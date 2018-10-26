
-- ROLLUP, CUBE
-- ROLLUP : 그룹별 소계를 얻을 때 사용
-- 그룹으로 묶이는 컬럼이 하나인 경우에는 총계가 출력된다

-- 사원테이블에서 부서별 연봉의 합을 조회하고 총계 출력
SELECT deptno, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno);

-- 사원테이블에서 부서별 연봉의 합을 조회하고 총계 출력
SELECT deptno, SUM(sal)
FROM emp
GROUP BY CUBE(deptno);

-- 여러컬럼이 그룹으로 묶여지면 ROLLUP은 그룹별 소계를 마지막에 출력

SELECT * FROM emp;
-- 날짜는 초까지 같아야 그룹으로 묶을 수 있음.
-- emp테이블에선 job, mgr, deptno가 그룹으로 묶을 수 있다

-- 사원테이블에서 부서별 직무의 연봉합 조회
SELECT deptno, job, COUNT(empno) members, SUM(sal)
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- 직무의 연봉합과 소계, 총계를 조회
-- ROLLUP을 하면 ORDER BY하지 않아도 정렬돼 나옴
SELECT deptno, job, COUNT(empno) members, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);

-- 총계를 먼저 얻고 그룹별로 소계를 먼저 얻고 싶다면? - CUBE!
-- 사원테이블에서 부서별, 직무의 연봉합, 직무별(그룹별)소계, 총계
SELECT deptno, job, COUNT(empno) members, SUM(sal)
FROM emp
GROUP BY CUBE(deptno, job);

-- CUBE가 롤업보다 더 많은 데이터를 얻을 수 있음(직무별, 부서별)
