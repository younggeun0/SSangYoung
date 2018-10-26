
-- ROLLUP, CUBE
-- ROLLUP : �׷캰 �Ұ踦 ���� �� ���
-- �׷����� ���̴� �÷��� �ϳ��� ��쿡�� �Ѱ谡 ��µȴ�

-- ������̺��� �μ��� ������ ���� ��ȸ�ϰ� �Ѱ� ���
SELECT deptno, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno);

-- ������̺��� �μ��� ������ ���� ��ȸ�ϰ� �Ѱ� ���
SELECT deptno, SUM(sal)
FROM emp
GROUP BY CUBE(deptno);

-- �����÷��� �׷����� �������� ROLLUP�� �׷캰 �Ұ踦 �������� ���

SELECT * FROM emp;
-- ��¥�� �ʱ��� ���ƾ� �׷����� ���� �� ����.
-- emp���̺��� job, mgr, deptno�� �׷����� ���� �� �ִ�

-- ������̺��� �μ��� ������ ������ ��ȸ
SELECT deptno, job, COUNT(empno) members, SUM(sal)
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- ������ �����հ� �Ұ�, �Ѱ踦 ��ȸ
-- ROLLUP�� �ϸ� ORDER BY���� �ʾƵ� ���ĵ� ����
SELECT deptno, job, COUNT(empno) members, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);

-- �Ѱ踦 ���� ��� �׷캰�� �Ұ踦 ���� ��� �ʹٸ�? - CUBE!
-- ������̺��� �μ���, ������ ������, ������(�׷캰)�Ұ�, �Ѱ�
SELECT deptno, job, COUNT(empno) members, SUM(sal)
FROM emp
GROUP BY CUBE(deptno, job);

-- CUBE�� �Ѿ����� �� ���� �����͸� ���� �� ����(������, �μ���)
