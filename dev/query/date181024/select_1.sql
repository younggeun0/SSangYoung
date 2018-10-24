-- �÷��� �ٿ� ���ڿ��� ��ȸ : || �����ڸ� ���
-- EMP ���̺��� �����ȣ, �����, ������ ��ȸ
-- ��������� : �����(�����ȣ)���� �����Դϴ�.

SELECT *
FROM emp;

-- ','�� �÷��� ������ ��ȸ��
SELECT	ename, empno, job
FROM	emp;

-- �÷��� �ϳ��� �������� �˾ƺ��Ⱑ ����
SELECT 	ename || empno || job
FROM 	emp;

SELECT	ename||' ('||empno||')���� '||job||'�Դϴ�.' output
FROM	emp;

-- alias�� �ֵ���ǥ�� ��� �ο��ϸ� ��ҹ��ڰ� ������, ��ȸ �� �����ϹǷ� �����
SELECT ename AS "Ename"
FROM   emp;

-- alias�� �ٷ� �Ʒ� WHERE������ ����� �� ����
SELECT  empno, ename, sal
FROM	emp
WHERE	sal < 3000;

-- �Ʒ� ���� ���� �� '�������� �ĺ���' ���� �߻�
SELECT	empno, ename, sal s
FROM	emp
WHERE	s < 3000;

-- ��������� : +, -, *, /
-- ������̺��� �����ȣ, �����, ����, ������ ��ȸ
-- ��, ������ ������ 3.3% ����Ͽ� ���
SELECT  empno, ename, sal, sal * 0.033 tax
FROM	emp;

-- �����ȣ�� ���� ��ȣ�� 10�� ���� ������ ���
SELECT 	empno, empno + 10 new_empno
FROM 	emp;

-- �÷������� ���굵 ����
SELECT  empno - mgr
FROM	emp;

-- null�� ����Ǹ� ����� null�� ����
-- ������̺��� �����ȣ, ����, ���ʽ�, �� ���ɾ��� ��ȸ
-- ��, �� ���ɾ��� ������ ���ʽ��� �ջ��� �ݾ����� ��ȸ

-- SAL + COMM ���� �� COMM�� ���� ������� null�� �ջ��ϴ� ������ �� ��
SELECT * FROM emp;

-- NULL�� �÷��� �� �ִ� �÷� ���� �� NULL�� ����
-- NULL�� �÷��� ������ �ϱ� ���ؼ� NVL �Լ��� ���
SELECT	empno, sal, comm, sal+NVL(comm, 0) total
FROM    emp;

-- ���� ������ : mod(�÷���, ������) �Լ� ���
SELECT  sal, mod(sal, 3)
FROM	emp;

-- dual ���̺��� ��� �������� ����� �� �ִ� �������̺�
-- �ԷµǴ� ������ �÷��� �����Ͽ� ��ȸó��
SELECT '������', mod(1, 3) FROM DUAL;

SELECT  '������' name
FROM	dual;

SELECT	mod(10,2), mod(11,2), mod(3,2), mod(5,2)
FROM	dual;

-- ����/12 ������ ���ϱ�
SELECT  mod(1990,12)
FROM	dual;
-- 0~11
-- 11:��, 10:��, 9:��, 8:��, 7:�䳢, 6:ȣ����,
-- 5:�Ҷ�, 4:��, 3:����, 2:��, 1:��, 0:������


-- ��ȸ�ϴ� �÷��� ���迬���ڸ� ����ϸ� error
SELECT  sal > 3000
FROM	emp;

SELECT 	sal
FROM	emp
WHERE 	sal > 3000;



-- ���迬���� : WHERE��, HAVING������ ���
-- >, <, >=, <=, =, !=(<>)
-- ������̺��� ������ 3000���� �۰ų� ����  ����� �����ȣ,
-- �����, �Ŵ�����ȣ, ����, �Ի���, �μ���ȣ ��ȸ
SELECT  empno, ename, mgr, sal, hiredate, deptno
FROM	emp
WHERE	sal <= 3000;

-- ��� ���̺��� ������ 3000�̻��� ����� �����ȣ,
-- �����, �Ŵ�����ȣ, ����, �Ի���, �μ���ȣ ��ȸ
SELECT	empno, ename, mgr,sal, hiredate, deptno
FROM	emp
WHERE	sal >= 3000;


-- ��� ���̺��� �μ���ȣ�� '30'���� �������
-- �����ȣ, �����, ����, �Ի���, �μ���ȣ�� ��ȸ
SELECT  empno, ename, job, hiredate, deptno
FROM	emp
WHERE	deptno=30;


-- ��� ���̺��� �μ���ȣ�� 20���� �ƴ� �������
-- �����ȣ, �μ���ȣ, �����, ������ ��ȸ
SELECT	empno, deptno, ename, job
FROM	emp
WHERE 	deptno<>20;
--WHERE	deptno!=20;

-- ��� ���̺��� ���ʽ��� ���� ����� �����ȣ, �����, ����, ���ʽ� ��ȸ
-- null�� ���� �����ڷ� ���� �� ����.
-- IS NULL, IS NOT NULL�� ��ȸ
SELECT	empno, ename, sal, comm
FROM	emp
WHERE	comm IS NULL;

-- ���ʽ��� �ִ� �����
SELECT 	empno, ename, sal, comm
FROM	emp
WHERE	comm IS NOT NULL AND comm!=0;

-- �� ������ : AND, OR, NOT
-- AND (��� �������� �´� ���ڵ带 ��ȸ)
-- OR (�����ǿ� �ش��ϴ� ��� ���ڵ带 ��ȸ)
-- ������̺��� �����ȣ�� 7369 �̸鼭 ������ clerk�� �����
-- �����ȣ, �����, ����, �Ի���, ������ ��ȸ
SELECT	empno, ename, job, hiredate,sal
FROM	emp
WHERE	empno=7369 AND job='CLERK';

-- ������̺��� ������ 1500�̻� 3000������ �������
-- �����ȣ, �����, ����, �Ի���, ���� ��ȸ
SELECT	empno, ename, job, hiredate, sal
FROM 	emp
WHERE	sal >= 1500 AND sal <= 3000;

-- ������ �˻��������� ����� ������ BETWEEN�� ����� �� �ִ�.
-- ����) �÷��� BETWEEN ������ AND ū��
SELECT 	empno, ename, job, hiredate, sal
FROM	emp
WHERE	sal BETWEEN 1500 AND 3000;

-- ��� ���̺��� 7902, 7839, 7566 �Ŵ����� ������ �޴� �����
-- �����ȣ, �����, �Ŵ�����ȣ, ����, �Ի��� ��ȸ
SELECT  empno, ename, mgr, sal, hiredate
FROM	emp
WHERE	mgr=7902 OR mgr=7839 OR mgr=7566;

-- OR�� ���� ������Ƿ� IN()���� �ٲ� �� �� �ִ�.
-- ����) �÷��� IN (��, ��, ...)
SELECT	empno, ename, mgr, sal, hiredate
FROM	emp
WHERE	mgr NOT IN (7902, 7839, 7566);

-- IN()�� �����ϴ� ��� ��ȸ, NOT IN()�� �������� �ʴ� ��� ��ȸ






