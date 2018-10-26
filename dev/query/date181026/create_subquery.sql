-- ��������� ���� ���̺�(��ųʸ�)
SELECT *
FROM user_constraints;

-- deptno�� PK�ΰ� Ȯ�� ����
DESC dept;

-- ���̺� ���� :
CREATE TABLE cp_emp
AS (SELECT empno, ename, hiredate, sal FROM emp);

-- emp ���̺��� empno�� PK, ���� �ȵ�
SELECT * FROM cp_emp;

-- ������ NOT NULL ������� ����
ALTER TABLE cp_emp MODIFY sal NUMBER(7,2) NOT NULL;

SELECT * FROM user_constraints;

SELECT * FROM cp_emp;

-- NOT NULL ������ �ܵ����� �����Ǿ� �ִٸ� ���簡 ��
-- �ٽ� �������� PK�� �ɸ� NOT NULL�� ���簡 �ȵ�

-- cp_emp���̺��� �����ȣ�� 7500~7599 ���̿� ����
-- ����� �����ȣ, �����, �Ի���, ������ ��ȸ�� �����
-- cp_emp2��� ���̺��� �����ϰ� �Է�
CREATE TABLE cp_emp2
AS (SELECT empno, ename, hiredate, sal
	FROM cp_emp
	WHERE empno BETWEEN 7500 AND 7599);
-- BETWEEN�� �������� �տ� �;� ��ȸ�� ��

-- ������ ���� (���ڵ带 ��ȸ���� �ʰ� ���������� ����)
-- ��� ���̺��� �����ȣ, �����, �μ���ȣ, ����, ������
-- ���ڵ尡 ��ȸ���� �ʵ��� ��ȸ
CREATE TABLE cp_emp3
AS (SELECT empno, ename, deptno, job, sal
	FROM emp
	WHERE 1=0);

SELECT * FROM cp_emp3;
-- �������� 1=1�� ���� �׻� ��, 1=0������ �׻� �������� ��밡��


