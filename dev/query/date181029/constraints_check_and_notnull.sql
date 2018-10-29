
-- CHECK, NOT NULL, DEFAULT
-- CHECK : �÷��� ���� ��ȿ�� ������ ������ �߰��� �� ���
-- NOT NULL : ���� �ݵ�� �Է¹޾ƾ� �� �� ���
-- DEFAULT : �÷��� �����Ǿ� NULL�� �Էµ� �� ��� �� �⺻ ������ ���

-- �̸�, ����, �ּ�, �Է����� �����ϴ� ���̺��� ����
-- ��, �̸��� �ʼ��Է��̰� ���̴� 20~30�븸 �Է°����ϰ�
-- �Է����� ���� �� ���糯¥�� �Էµǵ��� ����
CREATE TABLE other_constraints(
	name VARCHAR2(30byte) CONSTRAINT c_name NOT NULL,
	age NUMBER(2) CONSTRAINT c_age CHECK(age BETWEEN 20 AND 39),
	addr VARCHAR2(20byte) NULL,
	input_date DATE DEFAULT SYSDATE
);
--ALTER TABLE other_constraints MODIFY addr VARCHAR2(30);

-- usr_constraints������ �������(PK, FK, UK, CHECK, NOT NULL)�� Ȯ�ΰ���
SELECT * FROM user_constraints;

-- DEFAULT�� user_tab_cols ��ųʸ����� Ȯ�� ����
SELECT COLUMN_NAME, DATA_DEFAULT FROM user_tab_cols
WHERE table_name='OTHER_CONSTRAINTS';

-- �߰� ����
-- ���� ������
INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('������',27,'�����','2018-10-26');

-- �ּҿ� �Է��� ����
INSERT INTO other_constraints(name, age)
VALUES('�ڿ���', 57);

SELECT * FROM other_constraints;

-- �������� ���
-- �̸��� �����Ǵ� ��� NOT NULL���� ����
INSERT INTO other_constraints(age, addr, input_date)
VALUES(27, '�����', '2018-10-28');

INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('', 27, '�����', '2018-10-28');

-- ���̰� 20~30�밡 �ƴ� ���
INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('������', 15, '�����', '2018-10-28');

INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('������', 40, '�����', '2018-10-28');

-- NOT NULL�� ���̺� ���� ����������δ� ������ �� ����
CREATE TABLE temp(
	name VARCHAR2(10),
	CONSTRAINT c_name1 NOT NULL(name)
);