
SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e
RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

SELECT d.deptno, e.deptno, d.dname, e.ename
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno;

-- OUTER JOIN : ��� ���� ���̺��� ���ڵ尡 �����ϴ��� ��ȸ
-- ��� �μ��� �μ���ȣ, �μ���, �����ȣ, �����, �Ի��� ��ȸ
-- ANSI
SELECT d.deptno, e.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d
LEFT JOIN emp e
 ON e.deptno = d.deptno;

-- ORACLE
SELECT d.deptno, d.dname, e.empno, e.ename, e.hiredate
FROM dept d, emp e
WHERE e.deptno(+) = d.deptno;
