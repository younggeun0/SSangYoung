
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

-- 
