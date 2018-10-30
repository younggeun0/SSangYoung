
SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e
RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- OUTER JOIN : 어느 한쪽 테이블에만 레코드가 존재하더라도 조회
-- 모든 부서의 부서번호, 부서명, 사원번호, 사원명, 입사일 조회
-- ANSI
SELECT d.deptno, e.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d
LEFT JOIN emp e
 ON e.deptno = d.deptno;

-- ORACLE
SELECT d.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d, emp e
WHERE e.deptno(+) = d.deptno;
