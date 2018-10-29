
-- ALTER

-- ���� ��ױ� : �����ڸ� ����
ALTER USER scott ACCOUNT LOCK;

-- ���� : system, ��� : ��ġ�� �Է��� ���

-- ���� ����
ALTER USER scott ACCOUNT UNLOCK;

-- ��� ����
ALTER USER scott IDENTIFIED BY 1111;
ALTER USER scott IDENTIFIED BY tiger;

-- ���̺� ����
CREATE TABLE test_atler(
	num NUMBER,
	neam VARCHAR2(30),
	addr NUMBER
);

-- ���̺�� ����
ALTER TABLE test_atler RENAME TO test_alter;

-- �÷��� ����
ALTER TABLE test_alter RENAME COLUMN neam TO name;

SELECT * FROM test_alter;

-- �÷��� �������� ���� : ���ڵ尡 �����Ƿ� ������������ ���� ����
-- addr�� NUMBER�� VARCHAR2(100), NOT NULL����������� ����
ALTER TABLE test_alter MODIFY addr VARCHAR2(100) NOT NULL;

INSERT INTO test_alter(num, name, addr)
VALUES(1, '�׽�Ʈ', '����� ������');

COMMIT;
-- ���������� ������ ���� ���ڵ尡 ����־�� ��
ALTER TABLE test_alter MODIFY addr NUMBER;

-- ���ڵ尡 �����Ҷ��� ���� ������������ ũ�⸸ ���� ����(���X)
ALTER TABLE test_alter MODIFY addr VARCHAR(200);

-- �÷� �߰� :�߰��Ǵ� �÷��� ���� �������� �߰���
-- ���ڵ尡 �������� ������ ��� ��������� �ο��� �� ����
-- ���ڵ尡 �����ϸ� ��Ȳ�� ���� �ο� ���ϴ� ��������� ���� �� ����
ALTER TABLE test_alter ADD id VARCHAR2(15);

-- �÷� ����
ALTER TABLE test_alter DROP COLUMN addr;

SELECT * FROM test_alter;

-- ������� �߰�
ALTER TABLE test_alter ADD CONSTRAINT pk_test_alter
 PRIMARY KEY(id);

UPDATE test_alter
SET    id='test'
WHERE  id IS NULL;

SELECT * FROM test_alter;

SELECT * FROM user_constraints
WHERE table_name='TEST_ALTER';

-- ������� ��Ȱ��ȭ : ���������� �������� ����
ALTER TABLE test_alter DISABLE constraint pk_test_alter;

INSERT INTO test_alter(num, name, id)
VALUES(2, '������', 'test');

SELECT * FROM test_alter;

-- ������� Ȱ��ȭ : ���ڵ��� ������ ���� �ٸ�
--
ALTER TABLE test_alter ENABLE constraint pk_test_alter;

DELETE FROM test_alter WHERE num=2;

-- ������� ����
ALTER TABLE test_alter DROP CONSTRAINT pk_test_alter;


