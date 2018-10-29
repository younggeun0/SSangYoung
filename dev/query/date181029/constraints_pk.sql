
-- ��������� Ȯ�� : user_constraints
-- ������׸��� ���̺��ó�� �����ؾ� ��
SELECT * FROM user_constraints;

-- column level constraint
-- ��ȣ, �̸�, ��ȭ��ȣ, �ֹι�ȣ, �̸��� �����ϴ� ���̺��� ����
-- �ֹι�ȣ�� null�� ������� �����鼭 �����ؾ���(PK)
CREATE TABLE column_primary(
	num NUMBER,
	name VARCHAR2(15),
	phone VARCHAR2(13),
	ssn CHAR(14) PRIMARY KEY,
	email VARCHAR2(50)
);

SELECT * FROM user_constraints;

INSERT INTO column_primary(num, name, ssn)
VALUES(1, 'test', '880101-1234567');

INSERT INTO dept(deptno, dname, loc)
VALUES (10, 't', 't');

DROP TABLE column_primary;
PURGE RECYCLEBIN;

CREATE TABLE column_primary(
	num NUMBER,
	name VARCHAR2(15),
	phone VARCHAR2(13),
	ssn CHAR(14) CONSTRAINT pk_column_primary PRIMARY KEY,
	email VARCHAR2(50)
);

SELECT * FROM user_constraints;

-- �÷��ϳ��� PK�� �����Ǵ� ���
-- �߰� ����
-- ���� ���ڵ� ����
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (1, '������','010-1234-5678','880101-1234567','lee@test.com');
COMMIT;

-- �ֹι�ȣ�� �ٸ� ���
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (2,'������','010-2222-6532','890101-1234567','jae@test.com');


-- �߰� ����
-- ���� �ֹι�ȣ�� �ԷµǴ� ��� ����
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (3,'���ü�','010-7281-3332','890101-1234567','jung@test.com');

-- NULL�� �ԷµǴ� ���
-- ����, ��¥�� �÷��� �����Ǹ� NULL�� �Էµǰ�
-- ���ڿ�(��������, ��������)�� �÷��� �����Ǵ� ���� ''(empty)�� �����Ͱ� �߰��Ǵ� ��쿡 null�� �Էµȴ�
-- �÷��� �����Ǿ� insert�Ǵ� ���
INSERT INTO column_primary(num, name, phone, email)
VALUES (4, '������', '010-2332-2222', 'oh@test.com');

-- �÷��� ���ǵǾ� ������ ''�� ���
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (4, '������', '010-2332-2222', '','oh@test.com');

SELECT * FROM column_primary;

-- table level constraint
-- �̸�, ���̵�, ��й�ȣ �����ϴ� ���̺� ����
-- ���̵�� null�� ������� �����鼭 ���� �����ؾ��Ѵ�
CREATE TABLE table_primary(
	name VARCHAR2(30),
	id VARCHAR2(20),
	pw VARCHAR2(30),
	CONSTRAINT pk_table_primary PRIMARY KEY(id)
);

SELECT * FROM user_constraints;

-- �߰� ����
INSERT INTO table_primary(name, id, pw)
VALUES('����ö', 'kim', '1234');

COMMIT;

INSERT INTO table_primary(name, id, pw)
VALUES('��ȣȣ','test','1234');

SELECT * FROM table_primary;

-- �߰� ����
INSERT INTO table_primary(name, pw)
VALUES('����ȣ','1234');

INSERT INTO table_primary(name, id, pw)
VALUES('����ö', '', '1234');


-- �������� �÷��� PK�� �����Ǵ� ���
-- table level constraint(���̺� ���� �������)���θ� ���� ����

-- ���� ū�����ȣ ��ȣ���� 1������ ������ emp_00007899�� ������ ���� ���� ��ȸ
SELECT CONCAT('emp_', LPAD(MAX(empno)+1, 8, 0)) output
FROM   emp;

-- �����۸�, ������ ��ȣ, ����
-- �����۹�ȣ�� ���ڵ尡 �߰��� �� ���������� �����ϸ�
-- 'ITEM_0001'�� ������ ������.
-- �����۹�ȣ�� �����۸��� ���� �� ����
-- �������� ����ϴ��� ���������� ����� ���� �� ����.
CREATE TABLE table_multi_primary(
    item VARCHAR2(60),
    item_num CHAR(9),
    item_desc VARCHAR2(4000),
    CONSTRAINT pk_table_multi_primary PRIMARY KEY(item_num, item)
);


-- ���ڵ尡 ���� ��
-- table_multi_primary���̺���
-- item�� 'ITEM_0001'�� �������� ��ȸ
SELECT CONCAT('ITEM_',LPAD(NVL(MAX(item_num), 0)+1, 4, 0)) output
FROM   table_multi_primary;

-- �������� �÷��� �ϳ��� PK�� �����Ǵ� ���
-- �߰� ���� : ���ʵ����� �Է�
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT 'ITEM_'||LPAD(NVL(MAX(item_num),0), 4, 0)
         FROM   table_multi_primary),'����ź','�����Ÿ� ��2');

-- �� �÷��� ���� ��� �ٸ� ��� ����
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT CONCAT('ITEM_', LPAD(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1))+1,4,0))
FROM table_multi_primary),'����ź2', '�����Ÿ� ��2');

-- �� �÷� �� �ϳ��� �÷��� �ٸ� ��쵵 ����
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT CONCAT('ITEM_', LPAD(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1))+1,4,0))
FROM table_multi_primary),'����ź2', '�����Ÿ� ��3');

SELECT * FROM table_multi_primary;

-- ������ �߻��ϴ� ���
-- �� �÷��� ��� ���� ���� �����ٸ� Error!
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ('ITEM_0002','����ź2', '������ �ٸ� ����ź2 ������ PK �ΰ��� ���Ƽ� ������ ������');

-- �� �� �ϳ��� null�� �߰��� �� Error!
INSERT INTO table_multi_primary(item_num, item_desc)
VALUES('ITEM_0003', '�ռ� Ư�� ���̴��� �����Ͽ� �̻��� �߻�');

COMMIT;
/*
DELETE FROM dept
WHERE       deptno=30;

SELECT * FROM dept;
-- FK, �θ����̺��� �ڽķ��ڵ尡 �߰ߵǸ� ������ �� ����
ROLLBACK;
*/
DELETE FROM table_multi_primary;

SELECT * FROM table_multi_primary;
SELECT  'ITEM_'||LPAD(NVL(MAX(item_num), 0), 4, 0) output
FROM	table_multi_primary;

INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT 'ITEM_'||LPAD(NVL(MAX(item_num),0)+1, 4, 0)
         FROM   table_multi_primary),'���','�ٶ��ǳ��� �⺻��');

INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT 'ITEM_'||LPAD(NVL(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1)),0)+1, 4, 0)
		 FROM   table_multi_primary),'���4','�ٶ��ǳ��� �⺻��3');

SELECT * FROM table_multi_primary;












