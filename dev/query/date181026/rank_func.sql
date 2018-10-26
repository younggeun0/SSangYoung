
-- ���� ���ϱ�
-- ��ü ���� ���ϱ�
-- RANK() OVER( ORDER BY �����������÷��� ���Ĺ��) - �ߺ���ȣ �߻�����

-- ������̺��� �����ȣ, �����, ����, ��������
-- RANK() OVER()�� �ߺ����� �߻��� �� ����
SELECT empno, ename, sal, RANK() OVER(ORDER BY sal DESC) rank
FROM emp;

-- �� ������ �ߺ������� �߻����� �ʵ��� ó���Ͽ� ��ȸ
SELECT empno, ename, sal, ROW_NUMBER() OVER(ORDER BY sal DESC) rank
FROM emp;

-- ��ȸ�� ���ڵ带 �׷캰 ���� �ű�� : PARTITION BY
-- ������̺��� �����ȣ, �����, ����, �μ���ȣ,  �μ����������� ��ȸ
SELECT empno, ename, sal, deptno, RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) deptrank
FROM emp;

-- �μ������������� �ߺ���ȸ�� ���� ��ȸ
SELECT empno, ename, sal, deptno, ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal DESC) deptrank
FROM emp;

