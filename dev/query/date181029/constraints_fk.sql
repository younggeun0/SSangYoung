-- �ܷ�Ű : �ٸ����̺�(�θ�)�� �÷������θ� ���� �߰��ؾ� �� �� ���
-- null�� �ߺ����� �����
-- �÷����� ������� : foreign key Ű���� ������(���̺� ���� ������� �� ����)


-- table_primary ���̺��� id���� �����Ͽ� �����͸� �߰��ϴ� foreign key ����
-- �ڽ����̺��� �÷����� ���� �ʿ�� ����, ���������� ũ�⸸ �����ָ� ��
SELECT * FROM table_primary;

CREATE TABLE column_foreign(
	f_id VARCHAR2(20) CONSTRAINT fk_f_id REFERENCES table_primary(id),
	phone VARCHAR2(13),
	address VARCHAR2(400)
);

SELECT * FROM column_foreign;

-- �߰� ����
-- �θ����̺� �����ϴ� ������ �߰�
INSERT INTO column_foreign(f_id, phone, address)
VALUES('kim', '010-1113-2311', 'SM');

INSERT INTO column_foreign(f_id, phone, address)
VALUES('test', '010-3313-2311', '����� ������ �ѵ�����');


-- ���� ���̵�� ���� �߰��� �� �ִ�. (�ߺ����)
INSERT INTO column_foreign(f_id, phone, address)
VALUES('kim', '010-1113-2311', 'JYP');

SELECT * FROM column_foreign;

-- null ���
INSERT INTO column_foreign(phone, address)
VALUES('010-3939-9999', '�̽�ƽ');

-- �θ����̺� ���� ���� �߰��ϸ� error
INSERT INTO column_foreign(f_id, phone, address)
VALUES('kim1', '010-3939-9999', '�̽�ƽ');

-- �θ����̺��� �����ϴ� �ڽķ��ڵ尡 �����Ѵٸ� �������� �ʴ´�
INSERT INTO table_primary(name, id, pw)
VALUES('��ȣ��','kang','1234');

COMMIT;
SELECT * FROM table_primary;

-- kim�̳� test�� �����ϴ� ���ڵ尡 �����ϹǷ� ���� �Ұ�
DELETE FROM table_primary
WHERE id='kim';
DELETE FROM table_primary
WHERE id='test';

-- kang�� �����ϴ� ���ڵ尡 �������� �����Ƿ� ������
DELETE FROM table_primary
WHERE id='kang';

ROLLBACK;

-- ON DELETE CASCADE�� �������� �ʾ��� ������
-- �����ϴ� �ڽķ��ڵ带 ��� �����ϰ� �θ��ڵ带 �����Ѵ�
DELETE FROM column_foreign
WHERE f_id='kim' OR f_id='test';

DELETE FROM table_primary
WHERE id='kim' OR id='test';

SELECT * FROM table_primary;

COMMIT;

-- ���̺� ���� �������
CREATE TABLE table_foreign(
	id VARCHAR2(20),
	java_score NUMBER(3),
	oracle_score NUMBER(3),
	CONSTRAINT fk_table_foreign_id FOREIGN KEY(id) REFERENCES table_primary(id)
);

SELECT * FROM user_constraints;

-- �θ����̺��� �����ϴ� ������ �߰�
-- �ߺ�, null ���
INSERT INTO table_foreign(id, java_score, oracle_score)
VALUES('kim', 97, 78);

COMMIT;

SELECT * FROM table_foreign;

-- �����ϴ� �ڽ� ���ڵ尡 �����Ѵٸ� �θ����̺��� �ٷ� ���� �Ұ�
DELETE FROM table_primary
WHERE id='kim';

INSERT INTO table_primary(name, id, pw)
VALUES('���߱�','song','1234');
INSERT INTO table_primary(name, id, pw)
VALUES('����','gong','1234');

SELECT * FROM table_primary;
COMMIT;

-- �θ��ڵ带 �����ϸ� �����ϴ� ��� �ڽķ��ڵ带 �����ϰ�
-- �θ� ���ڵ带 �����ϴ� ON DELETE CASCADE ���

CREATE TABLE test_cascade(
	id VARCHAR2(20),
	address VARCHAR2(100),
	CONSTRAINT fk_test_id FOREIGN KEY(id)
	  REFERENCES table_primary(id)
	  ON DELETE CASCADE
);

INSERT INTO test_cascade(id, address)
VALUES('song','������ ���ﵿ');

INSERT INTO test_cascade(id, address)
VALUES('gong','������ ���ﵿ');

INSERT INTO test_cascade(id, address)
VALUES('kang','������ ���ﵿ');
COMMIT;

SELECT * FROM test_cascade;

-- ON DELETE CASCADE�� �����Ǹ�
-- �θ� ���ڵ尡 �����Ǹ� �ڽ� ���ڵ嵵 �Բ� ������

DELETE FROM table_primary
WHERE id='gong';

SELECT * FROM table_primary;
SELECT * FROM test_cascade;
SELECT * FROM table_foreign;


-- ON DELETE CASCADE�� ������ ���� ���̺��� �����ϴ� ���ڵ��
-- �������� �ʴ´�
