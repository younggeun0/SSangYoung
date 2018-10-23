/*
1. �Ʒ��� ���� �����͸� ������ �� �ִ� ���̺��� �����Ѵ�.
 ��ȣ - �����̸� 5�ڸ����� �Է�
 �̸� - �����������̸� �ѱ۷� 10�ڱ��� �Է�.
 ���� - ���������̸� ����� 1�� �Է�.
 �ּ� - �����������̸� �ѱ۷� 120�� �����Է�.
 ���� - �����̸� 3�ڱ��� �Է�
 �Է��� - �����Ͱ� �߰��Ǵ� ���� �Ϸ� �Է�.
*/
CREATE TABLE personal_Info(
  num NUMBER(5),
  name VARCHAR2(15),
  sex CHAR(1),
  address VARCHAR2(360),
  score NUMBER(3),
  input_date DATE DEFAULT SYSDATE
);

 /*
2. �� ���̺� �Ʒ��� ���� �����͸� �߰��Ѵ�.
  1, '����ȣ', 'M', '����� ������ ���ﵿ',64,����
  2, '������', 'M', '����� ���α� ������',87,����
  3, '������', 'F', '����� �������� ���ǵ���',97,����
  4, 'Ȳ�缺', 'M', '����� ���۱� �󵵵�',100,����
  5, '���缮', 'M', '��⵵ ������ ���뱸',100,����
*/
INSERT INTO personal_Info
VALUES (1, '����ȣ', 'M', '����� ������ ���ﵿ', 64, SYSDATE);

INSERT INTO personal_Info (num, name, sex, address, score, input_date)
VALUES (2, '������', 'M', '����� ���α� ������', 87, SYSDATE);

INSERT INTO personal_Info
VALUES (3, '������', 'F', '����� �������� ���ǵ���', 97, SYSDATE);

INSERT INTO personal_Info (input_date, score, address, sex, name, num)
VALUES (SYSDATE, 100, '����� ���۱� �󵵵�', 'M', 'Ȳ�缮', 4);

INSERT INTO personal_Info (score, sex, name, input_date, num, address)
VALUES (100, 'M', '���缮', SYSDATE, 5, '��⵵ ������ ���뱸');

/*
3. �� �Էµ� ������ �� ���� ��ȣ�� 3���̸� ������ 97���� �����
    �̸��� '�׽�Ʈ'�� ������ 'M'���� �����Ѵ�.
*/

UPDATE 	personal_Info
SET     name='�׽�Ʈ', sex='M'
WHERE	num=3 AND score=97;

COMMIT;

-- 4. ���� �����Ϳ��� �̸��� '���缮'�� ����Ǽ����� 'F'�� �����Ѵ�.

UPDATE	personal_Info
SET		sex='F'
WHERE	name='���缮';

-- 5. 4���� �۾��� ����Ѵ�.

ROLLBACK;

-- 6. ��ȣ�� 1���̸� �̸��� �������� ����� �����͸� �����Ѵ�.

 DELETE FROM personal_Info
 WHERE num=1 AND name='������';

-- 7. ��� �����͸� �����Ѵ�.
TRUNCATE TABLE personal_Info;

-- 8. ���̺��� �����Ѵ�.
DROP TABLE personal_Info;

-- 9. �������� ����.
PURGE RECYCLEBIN;

SELECT * FROM personal_Info;
