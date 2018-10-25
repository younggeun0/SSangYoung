
-- �����Լ� - �÷��� ���� �ϳ��� ����� ��ȯ�ϴ� �Լ���
-- COUNT() : NULL�� �ƴ� �÷��� ���ڵ� ������ �� �� ����ϴ� �Լ�
-- ������̺��� ���ڵ� ��(�����)
-- empno�� emp���̺��� PK, ����ũ�� ���ڵ� ���� �� �����
SELECT COUNT(empno)
FROM emp;

-- ������̺��� ���ڵ��, ���ʽ��� �����ϴ� �����
SELECT COUNT(empno), COUNT(comm)
FROM emp;

-- ���ʽ��� �������� �ʴ� �����
SELECT COUNT(empno), COUNT(comm), COUNT(empno)-COUNT(comm)
FROM emp;

-- �Ŵ����� �ִ� �����
SELECT COUNT(mgr)
FROM emp;

-- �� ������ ����� ����
SELECT COUNT(empno), COUNT(comm), COUNT(empno)-COUNT(comm), COUNT(mgr)
FROM emp;

-- ���� ��, ���ʽ��� ��, �ΰǺ��� ���� ��ȸ
SELECT SUM(sal) sal, SUM(comm) comm, SUM(sal)+SUM(comm) total
FROM emp;

-- ������ ���, ���ʽ����, ��, �Ҽ����ϸ� ����
SELECT TRUNC(AVG(sal),0), TRUNC(AVG(comm), 0)
FROM emp;

-- �ְ�����, ����������, �ְ����װ� ������������ ����
SELECT MAX(sal), MIN(sal), MAX(sal)-MIN(sal)
FROM emp;

-- **WHERE�������� �����Լ��� ����� �� ����
-- ������̺��� ��տ������� ���� �޴� �����ϴ� �����
-- �����ȣ, �����, ����, �Ի����� ��ȸ
SELECT empno, ename, sal, hiredate
FROM emp
WHERE sal > AVG(sal);

SELECT empno, ename, sal, hiredate
FROM emp
WHERE sal > (SELECT AVG(sal)
			 FROM emp);

-- �����Լ��� GROUP BY�� ���� ����ϸ� �׷캰 ���踦 ��ȸ�Ѵ�
-- �μ���ȣ, �μ����ο���, �μ��� ������ ��, �μ��� �������, �μ��� �ְ�����, ����������
SELECT deptno, COUNT(empno), SUM(sal), TRUNC(AVG(sal),2), MAX(sal), MIN(sal)
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- ������̺��� �Ŵ����� �����ο���, �ְ����� ��������
-- �ְ����� ���������� ����
SELECT mgr, COUNT(empno), MAX(sal), MIN(sal), MAX(sal)-MIN(sal)
FROM emp
WHERE mgr IS NOT NULL
GROUP BY mgr
ORDER BY mgr;
                                            