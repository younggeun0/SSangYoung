
-- HAVING : �׷����� ���� ������ �� �� ���
-- ������� 4�� �̻��� �μ��� �μ���ȣ, �����, ������, �ְ����� ��ȸ

SELECT   deptno, COUNT(empno), SUM(sal), MAX(sal)
FROM     emp
GROUP BY deptno
HAVING   COUNT(deptno) >= 4;


-- REPLACE : ���� ġȯ�� �� ���

SELECT  REPLACE('���ü�, ������, ������, ����ö', '������', '��õ���� �ڶ� ������') output
FROM	DUAL;
