
SELECT * FROM user_indexes;

-- column level constraint
-- unique : ���� ���� ���� �ְ� �ִٸ� �����ؾ� �� ��
-- �̸�, �̸���, �ּҸ� �����ϴ� ���̺��� ����

CREATE TABLE column_unique(
	name    VARCHAR2(30),
	email	VARCHAR2(50) CONSTRAINT uk_email UNIQUE,
	address VARCHAR2(100)
);


SELECT * FROM user_constraints;
SELECT * FROM column_unique;

--ALTER TABLE column_unique MODIFY name VARCHAR2(30);
-- �߰� ����
-- ���� �Է� ��
INSERT INTO column_unique(name, email, address)
VALUES('������', 'lee@test.com', '��⵵ ������ ���뱸');
COMMIT;
-- �̸����� ���� ���(null�� ���� ���)
INSERT INTO column_unique(name, email, address)
VALUES('������', '', '��⵵ ������ ���뱸');

INSERT INTO column_unique(name, address)
VALUES('������1','��⵵ ������ �ȴޱ�');

SELECT * FROM column_unique;

-- �߰� �����ϴ� ���
-- ���� �̸����� �ԷµǾ��� ��
INSERT INTO column_unique(name, email, address)
VALUES('�ڿ���', 'lee@test.com', '�λ��');

-- table level constraint
-- ��ȣ, �̸�, ��ȭ��ȣ, ī���ȣ�� �����ϴ� ���̺� ����
-- ��ȭ��ȣ�� ī���ȣ�� ���� ���� �ְ� �ִٸ� �������� ��
CREATE TABLE table_unique(
	num NUMBER(5),
	name VARCHAR2(30),
	tel VARCHAR2(13),
	card_num VARCHAR2(4),
	CONSTRAINT uk_tel UNIQUE(tel),
	CONSTRAINT uk_card_num UNIQUE(card_num)
);

SELECT * FROM table_unique;

SELECT * FROM user_constraints;
SELECT * FROM user_indexes;

-- �߰� ����
-- �����Է�
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(1, '������', '010-8798-8999', '1234');

-- ��ȭ��ȣ�� ī���ȣ�� �ٸ� ���
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(2,'������','010-1111-2222','1235');

-- null�ԷµǴ� ���
INSERT INTO table_unique(num, name)
VALUES(3,'��������');

INSERT INTO table_unique(num, name, tel, card_num)
VALUES(3,'��������', '', '');

SELECT * FROM table_unique;

-- ��ȭ��ȣ�� ī���ȣ�� �� �� �ϳ��� ���ٸ� ����
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(4, '���ü�', '010-1111-3333', '1235');

-- ��ȭ��ȣ�� ī���ȣ�� �� �� �ϳ��� ���ٸ� ����
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(4, '���ü�', '010-1111-3333', '9999');                 * 
SELECT * FROM table_unique;

