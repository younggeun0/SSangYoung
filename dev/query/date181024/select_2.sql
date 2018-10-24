
-- ���ڿ� ������ LIKE�� ����� ���̺� ����
-- NUMBER�� ũ�⸦ �������ϸ� 22���� ���� �� ����
CREATE TABLE test_like(
	num NUMBER,
	name VARCHAR2(30),
	loc VARCHAR2(300),
	highschool VARCHAR2(60)
);

-- DROP TABLE test_like;

INSERT INTO test_like(num, name, loc, highschool)
VALUES (1, '������', '����� ������ ���ﵿ', '������');

INSERT INTO test_like
VALUES (2, '������', '����� ���α� ������', '������');

INSERT INTO test_like
VALUEs (3, '�ڿ���', '��⵵ ������', '������');

INSERT INTO test_like
VALUES (4, '����ö', '����� ���ʱ� ���ʵ�', '�԰�');

INSERT INTO test_like
VALUES (5, '��������', '���� ��絿', '�ð�');

INSERT INTO test_like
VALUES (6, '������', '��⵵ ������ ��ź��', '������');

SELECT * FROM test_like;

-- COMMIT �ϱ����� Session���� ����(�޸�), COMMIT�� ����� File������ ��������
-- �ٸ� Client Process�� �����ؼ� ����� ����������.
COMMIT;

-- LIKE ������ %, _ ���ϵ�ī�� ��ȣ�� ���� ���
-- %�� ��� ���ڿ�, _�� �� ����
-- test_like ���̺��� '�����'�� ��� ����� ��ȣ, �̸�, ��Ű���б����� ��ȸ
SELECT	num, name, highschool
FROM    test_like
WHERE 	loc LIKE '�����%';

-- LIKE�� ���� ���ϵ�ī��(%,_)�� ������� ������ '='�� �����ϴ�
SELECT 	num, loc, highschool
FROM	test_like
WHERE	name LIKE '������';

-- �̸��� '��'���� ������ ����� ��ȣ, �̸�, �ּҸ� ��ȸ
SELECT	num, name, loc
FROM	test_like
WHERE	name LIKE '%��';

-- �̸��� '��'�� ���ԵǾ� �ִ� �л��� ��ȣ, �̸�, �ּ�, ����б��� ��ȸ
SELECT  num, name, loc, highschool
FROM	test_like
WHERE	name like '%��%';

-- �̸��� 3�����̸� ��� ���ڰ� '��'�� ����� ��ȣ�� �̸��� ��ȸ
SELECT	num, name
FROM	test_like
WHERE	name LIKE '_��_';

-- �̸��� 4������ �л��� ��ȣ, �̸�, ����б��� ��ȸ
SELECT	num, name, highschool
FROM	test_like
WHERE	name LIKE '____';


-- �����ּҸ� �����ϴ� ���̺� ����
CREATE TABLE zipcode(
	zipcode CHAR(7),
	sido CHAR(6),
	gugun VARCHAR2(25),
	dong VARCHAR2(60),
	bunji VARCHAR2(25),
	seq NUMBER(5)
);

-- 3������ ����
SELECT * FROM zipcode;

-- dong�� ũ�Ⱑ �۾ұ� ������ �� �ȵ�� dong�� �� ũ�� ����
ALTER TABLE zipcode MODIFY dong VARCHAR2(80);

TRUNCATE TABLE zipcode;

-- �ش� ���̺��� ���ڵ� ���� ��ȯ�ϴ� COUNT()�Լ�
SELECT COUNT(*)
FROM zipcode;

-- �ٽ� sqlldr�� ����ؼ� �뷮�Է��ϸ� 5������ �ּҰ� ������ ����
SELECT COUNT(*)
FROM zipcode;


-- �츮���� ���� �ּҸ� ��ȸ
-- ���̸��Է� �޾Ҵ� ����

-- 3�Ǹ� ��ȸ��
SELECT	zipcode, sido, gugun, dong, bunji, seq
FROM	zipcode
WHERE   dong='�󵵵�';

-- LIKE�� �ڿ��� ���� 6���� ��ȸ��
SELECT 	*
FROM	zipcode
WHERE	dong LIKE '�󵵵�%';

-- LIKE ���ϵ�ī�带 �翷�� ���̸� �� ���� ��ȸ��
-- ��2���� �˻��Ǵ� ������ ����Ʈ�� '�󵵵�'�� ���ԵǾ��� ����
SELECT 	*
FROM	zipcode
WHERE	dong LIKE '%�󵵵�%';

-- %�� �տ� �ڿ� �Ǵ� �յڿ� ���ϰ��� �� �����ؾ� ��

-- ������̺��� ����� 'L'�� �ΰ� ����ִ� �����
-- �����ȣ, �����, �Ի��� ��ȸ
SELECT	empno, ename, hiredate
FROM	emp
WHERE	ename LIKE '%L%L%';

-- 'L'�� 'A'�� �����ؼ� ��ȸ
SELECT  empno, ename, hiredate
FROM	emp
WHERE	ename LIKE '%A%A%';


-- ��� ���̺��� �μ� ��ȣ�� ��ȸ
SELECT	deptno
FROM	emp;

-- �ߺ� ����

-- ��� ���̺��� �Ŵ�����ȣ�� ��ȸ
SELECT	mgr
FROM	emp;

-- ��, �ߺ��Ǵ� �Ŵ�����ȣ�� ������� ����
-- DISTINCT - �����Լ��� ����Ͽ� �׷캰 ���踦 ������ �� ����
SELECT DISTINCT	mgr
FROM			emp;

-- �ٸ� ���� ������ �÷��� ���� ����� ���, ��� �÷��� ���� �����ؾ� �ߺ� ������ ��
SELECT DISTINCT	mgr, ename
FROM			emp;

-- DISTINCT�� GROUP BY�� ����� ��� �ߺ������� ����
SELECT		mgr
FROM		emp
GROUP BY	mgr;


-- DISTINCT ��ȸ�ϴ� �÷��� �տ� ���, ��ȸ��� ������ �� ���� ���� �����ϴ��� �Ǵ��Ͽ�
-- ���� ���� �����ϸ� ������� ����
SELECT DISTINCT	deptno
FROM	emp;

-- ��� �÷��� ���� ��ȸ�ϸ� ��� �÷��� ���� ���� ��츸 �ߺ����� ������� �ʴ´�
SELECT DISTINCT deptno, /*ename*/
FROM	emp;


-- GROUP BY ��ȸ ����� �׷����� ���� ���
-- ��ȸ�Ǵ� �÷��� �ݵ�� �׷����� ���� �÷��̰ų�, �����Լ��� ����� �÷��� ��ȸ ����
-- �ٸ� �÷��� ��ȸ�ϸ� ���� �߻�
-- HAVING ���� �׷����� ����
SELECT		deptno
FROM		emp
GROUP BY	deptno;

SELECT		deptno
FROM		emp
GROUP BY	deptno
HAVING		deptno=10;

-- GROUP BY : �׷����� �������� ���� �÷��� ���� ���Ǹ� error.
SELECT		mgr, /*ename*/
FROM		emp
GROUP BY	mgr, ename;
                                  