
-- 집계함수 - 컬럼의 값을 하나로 만들어 반환하는 함수들
-- COUNT() : NULL이 아닌 컬럼의 레코드 개수를 셀 때 사용하는 함수
-- 사원테이블의 레코드 수(사원수)
-- empno가 emp테이블의 PK, 유니크한 레코드 수가 즉 사원수
SELECT COUNT(empno)
FROM emp;

-- 사원테이블의 레코드수, 보너스를 수령하는 사원수
SELECT COUNT(empno), COUNT(comm)
FROM emp;

-- 보너스를 수령하지 않는 사원수
SELECT COUNT(empno), COUNT(comm), COUNT(empno)-COUNT(comm)
FROM emp;

-- 매니저가 있는 사원수
SELECT COUNT(mgr)
FROM emp;

-- 한 행으로 결과가 나옴
SELECT COUNT(empno), COUNT(comm), COUNT(empno)-COUNT(comm), COUNT(mgr)
FROM emp;

-- 연봉 합, 보너스의 합, 인건비의 총합 조회
SELECT SUM(sal) sal, SUM(comm) comm, SUM(sal)+SUM(comm) total
FROM emp;

-- 연봉의 평균, 보너스평균, 단, 소수이하를 절삭
SELECT TRUNC(AVG(sal),0), TRUNC(AVG(comm), 0)
FROM emp;

-- 최고연봉액, 최저연봉액, 최고연봉액과 최저연봉액의 차이
SELECT MAX(sal), MIN(sal), MAX(sal)-MIN(sal)
FROM emp;

-- **WHERE절에서는 집계함수를 사용할 수 없다
-- 사원테이블에서 평균연봉보다 많이 받는 수령하는 사원의
-- 사원번호, 사원명, 연봉, 입사일을 조회
SELECT empno, ename, sal, hiredate
FROM emp
WHERE sal > AVG(sal);

SELECT empno, ename, sal, hiredate
FROM emp
WHERE sal > (SELECT AVG(sal)
			 FROM emp);

-- 집계함수는 GROUP BY와 같이 사용하면 그룹별 집계를 조회한다
-- 부서번호, 부서별인원수, 부서별 연봉의 합, 부서별 연봉평균, 부서별 최고연봉액, 최저연봉액
SELECT deptno, COUNT(empno), SUM(sal), TRUNC(AVG(sal),2), MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- 사원테이블에서 매니저별 관리인원수, 최고연봉과 최저연봉
-- 최고연봉과 최저연봉의 차이
SELECT mgr, COUNT(empno), MAX(sal), MIN(sal), MAX(sal)-MIN(sal)
FROM emp
WHERE mgr IS NOT NULL
GROUP BY mgr
ORDER BY mgr;
                                            