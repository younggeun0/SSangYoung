
-- ������̺��� 'SCOTT'�� ������� ������ �۰� �޴� �����
-- �����ȣ, �����, �Ի���, ������ ��ȸ

-- ���������� ����ϴ� ���
SELECT empno, ename, hiredate, sal
FROM   emp
WHERE  sal < (SELECT sal
			  FROM   emp
			  WHERE  ename='SCOTT');

-- SELF JOIN�� ����ϴ� ���
SELECT e1.empno, e1.ename, e1.hiredate, e1.sal
FROM   emp e1, emp e2
WHERE  (e1.sal < e2.sal) AND e2.ename='SCOTT';

SELECT ename, sal, dname
FROM(SELECT e.ename, e.sal, d.dname
	 FROM   emp e, dept d
	 WHERE  e.deptno = d.deptno);
