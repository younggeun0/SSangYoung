

-- SELECT
-- �ܼ��� ��������
-- Scalar Subquery, SELECT ��ȸ�ϴ� �÷��� ���������� ���� ��
-- emp���̺��� �����ȣ, �����, �μ���ȣ, �μ��� ��ȸ
-- �μ����� dept���̺� ����
-- ���� �̸��� �÷��� �����ϸ� � ���̺��� �����ϴ� �÷����� �����Ͽ� ����ؾ� ��
-- (���̺��.�÷���)
SELECT empno, ename, deptno, (SELECT dname
							  FROM   dept
							  WHERE  dept.deptno=emp.deptno)
FROM emp;









