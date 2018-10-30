
-- 사원테이블에서 'SCOTT'인 사원보다 연봉을 작게 받는 사원의
-- 사원번호, 사원명, 입사일, 연봉을 조회

-- 서브쿼리를 사용하는 방법
SELECT empno, ename, hiredate, sal
FROM   emp
WHERE  sal < (SELECT sal
			  FROM   emp
			  WHERE  ename='SCOTT');

-- SELF JOIN을 사용하는 방법
SELECT e1.empno, e1.ename, e1.hiredate, e1.sal
FROM   emp e1, emp e2
WHERE  (e1.sal < e2.sal) AND e2.ename='SCOTT';

SELECT ename, sal, dname
FROM(SELECT e.ename, e.sal, d.dname
	 FROM   emp e, dept d
	 WHERE  e.deptno = d.deptno);
