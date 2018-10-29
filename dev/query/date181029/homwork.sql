/*
 1. �Ʒ��� ���ǿ� �´� ���̺��� �����ϰ� ������ ��������� �ο��� ��
	��� �������ǿ� �����ϴ� ���� ������ ��쿡 ���� �����ϴ� ���
	�������� �ۼ��ϼ���.

	�μ���ȣ, �����, ����, �̸���, ��ȭ��ȣ, ����, �ּ�, �Ի���, �����ȣ��
	�����ϴ� ���̺��� ����

	�������
	- �μ���ȣ�� ���� ���ڸ��̸� dept���̺��� deptno�� �Է��� �� �ִ�
	- ������� �����������̰� �ѱ۷� 10���ڱ��� �Է� �����ϸ� �ݵ�� �Է��ؾ��Ѵ�.
	- ������ �����̰� ������� �Է��� ����, �Է°��� ������ 2400~8000���� �Է°���
	- �̸��ϰ� ��ȭ��ȣ�� ���� ���� ������ �ִٸ� ������
	- ������ ���� �Ǵ� ���ڸ� �Է°���
	- �ּҴ� ���� ���� �ִ�
	- �Ի����� ��¥�����̸� �߰��� �� �Ի����� null�̶�� ���糯¥�� �Էµ�
	- �����ȣ�� ���� 4�ڸ��̸� null�� ������� �ʰ� �����͸� �ߺ������͸� ������ �� ����

	��� ������Ȳ�� ������Ȳ�� ���� ���� �ۼ� �� FOREIGN KEY�� �ش��ϴ� ���������
	��Ȱ��ȭ ��Ų �� ������ �غ�����.
*/

CREATE TABLE personal_info(
	deptno   NUMBER(2) CONSTRAINT fk_personal_info_deptno REFERENCES dept(deptno),
	ename    VARCHAR2(30) NOT NULL,
	sal      NUMBER(9) CONSTRAINT c_sal CHECK (sal BETWEEN 24000000 AND 80000000),
	email    VARCHAR2(20) CONSTRAINT uk_personal_info_email UNIQUE,
	tel      VARCHAR2(13) CONSTRAINT uk_personal_info_tel UNIQUE,
	gender   CHAR(6) CONSTRAINT c_gender CHECK (gender IN ('����', '����')),
	address  VARCHAR2(30) NULL,
	hiredate DATE DEFAULT SYSDATE,
	empno    NUMBER(4) CONSTRAINT pk_personal_info PRIMARY KEY
);
SELECT * FROM personal_info;
ALTER TABLE personal_info MODIFY sal NUMBER(9) CONSTRAINT c_sal CHECK (sal BETWEEN 24000000 AND 80000000);
ALTER TABLE personal_info DROP CONSTRAINT c_sal;

SELECT * FROM user_constraints
WHERE  table_name='PERSONAL_INFO';

-- PK ������� �߰� ����
INSERT INTO personal_info(ename, empno)
VALUES ('������',1);

-- PK ������� ����, �ߺ��� empno�� ���
INSERT INTO personal_info(ename, empno)
VALUES ('������', 1);

-- PK ������� ����, empno���� NULL�� ���
INSERT INTO personal_info(ename)
VALUES ('������');

-- FK ������� �߰� ����, deptno�� ���
INSERT INTO personal_info(ename, empno, deptno)
VALUES('�迵��', 2, 10);
INSERT INTO personal_info(ename, empno, deptno)
VALUES('�̿���', 3, 40);

-- FK ������� �߰� ����, deptno�� null�� ���
INSERT INTO personal_info(ename, empno, deptno)
VALUES('����', 4, '');
INSERT INTO personal_info(ename, empno)
VALUES('������', 5);

-- FK ������� ����
INSERT INTO personal_info(ename, empno, deptno)
VALUES('������', 6, 100);

-- UNIQUE ������� �߰� ����, email�� tel�� UNIQUE
INSERT INTO personal_info(ename, empno, email, tel)
VALUES('�念��', 7, 'hello@world.com', '010-2222-3333');

-- UNIQUE ������� ����, email�ߺ��� �� ���� ��
INSERT INTO personal_info(ename, empno, email)
VALUES('�տ���', 8, 'hello@world.com');

-- UNIQUE ������� ����, tel�ߺ��� �� ���� ��
INSERT INTO personal_info(ename, empno, tel)
VALUES('�տ���', 8, '010-2222-3333');

-- CHECK ������� �߰� ����, sal�� gender
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('Ŵ����', 9, 28000000, '����');
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('�ּּ�', 10, 75000000, '����');

-- CHECK ������� ����, c_sal CHECK���� ����
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('�ҿ���', 11, 2400000, '����');

-- CHECK ������� ����, c_gender CHECK���� ����
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('�ּּ�', 12, 30000000, '���');

-- NOT NULL ������� �߰� ����
INSERT INTO personal_info(ename, empno)
VALUES('������', 13);

-- NOT NULL ������� ����, NULL����
INSERT INTO personal_info(empno)
VALUES(14);
INSERT INTO personal_info(ename, empno)
VALUES('', 14);

-- DEFAULT�� ��������� �ƴϴ� ����, ���� �������
INSERT INTO personal_info(ename, empno)
VALUES('��μ�', 15);

-- SYSDATE�� �װ� ���� ��� ���ڵ忡 DEFAULT������ �Էµ�
SELECT * FROM personal_info;

-- FK ������� DISABLE
ALTER TABLE personal_info DISABLE CONSTRAINT fk_personal_info_deptno;

SELECT * FROM user_constraints
WHERE  table_name='PERSONAL_INFO';

-- FK ��������� ���� �ȵ�, dept���̺� deptno���� ���� ���� ������ �Է°���
INSERT INTO personal_info(ename, empno, deptno)
VALUES('��̼�', 16, 55);

-- FK ������� ENABLE�� �� ����, empno 16�� ���ڵ尡 FK�� �����
ALTER TABLE personal_info ENABLE CONSTRAINT fk_personal_info_deptno;

-- �ٽ� empno 16�� ���ڵ� ����
DELETE FROM personal_info
WHERE empno=16;

-- �� ENABLE �����ϸ� �������� FK �������� Ȱ��ȭ
ALTER TABLE personal_info ENABLE CONSTRAINT fk_personal_info_deptno;

SELECT *
FROM user_constraints
WHERE table_name='PERSONAL_INFO';