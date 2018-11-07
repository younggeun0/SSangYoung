
SELECT * FROM user_procedures;

DROP FUNCTION plus;

-- �ԷµǴ� �ֹι�ȣ�� ��ȿ�� ����
SELECT check_ssn('901201-1234567') ssn1,
	     check_ssn('333333-123') ssn2,
	     check_ssn('90020241234567') ssn3
FROM dual;

SELECT * FROM class4_info;

UPDATE class4_info
SET name='������', ssn='7702031-234567'
WHERE num = 5;

UPDATE class4_info
SET ssn = '880101-123456'
WHERE num = 6;

COMMIT;

-- class4_info ���̺��� ��ȣ, �̸�, �ֹι�ȣ,
-- �ֹι�ȣ�� ���� üũ�Ͽ� ��� ���ڵ带 ��ȸ

SELECT num, name, ssn, check_ssn(ssn) check_res
FROM class4_info;

-- �ֹι�ȣ�� ��ȿ�� �� ���̸� ���ϴ� �Լ� ���
SELECT get_age_from_ssn('010101-4234567') age,
			 get_age_from_ssn('780101-1234566') age,
			 get_age_from_ssn('990101-0234566') age,
			 get_age_from_ssn('030202-3123456') age
FROM dual;

INSERT INTO class4_info(num, name, ssn)
VALUES(8,'JAMES','890307-5234567');

INSERT INTO class4_info(num,name,ssn)
VALUES(9,'����','030102-4234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(10, '������', '990107-9234567');

-- ��ȣ, �̸�, �ֹι�ȣ, ����, ��ȸ
-- ���̴� �ֹι�ȣ�� ��ȿ���� ���� ���̸� �����ְ�
-- ��ȿ���� �ʴٸ� 0�� ������
SELECT num, name, ssn, get_age_from_ssn(ssn) age
FROM class4_info
WHERE num IN (8,9,10);

SELECT * FROM class4_info;

-- �̸��� ��ȿ�� ����
SELECT valid_email('@.'),
		   valid_email('a@b.c'),
			 valid_email('hello.com'),
			 valid_email('hello@world'),
			 valid_email('@@@@....'),
			 valid_email('hello@world.com')
FROM dual;

-- class4_info ���̺���
-- ��ȣ, �̸�, �̸���, �̸����� ��ȿ���� ��ȸ�ϴ�
SELECT num, name, email, valid_email(email)
FROM class4_info;


-- 1�������� 9999999���� 1�� ������Ű�� ������ ����
CREATE SEQUENCE seq_item
 INCREMENT BY 1
 START WITH 1
 MAXVALUE 9999999
 CACHE 10
 NOCYCLE;

SELECT * FROM user_sequences;

SELECT seq_item.nextval
FROM dual;

SELECT seq_item.currval
FROM dual;

CREATE TABLE test_func(
  num CHAR(10),
  name VARCHAR2(30),
  input_date DATE DEFAULT SYSDATE,
  CONSTRAINT pk_test_func PRIMARY KEY(num)
);

-- �Լ��� ȣ���Ͽ� ������ ������ ��ȣ�� ���
INSERT INTO test_func(num, name)
VALUES(item_num, 'young');

INSERT INTO test_func(num, name)
VALUES(item_num, 'sol');

INSERT INTO test_func(num, name)
VALUES(item_num, 'kim');

INSERT INTO test_func(num, name)
VALUES(item_num, 'Lee');

-- �Լ� ȣ�� �� ()�� ��� �� ȣ���, �־ ��
INSERT INTO test_func(num, name)
VALUES(item_num(), 'Park');

SELECT * FROM test_func;

-- �ֹι�ȣ ��ȿ�� ���� �Լ� ���
SELECT valid_ssn_check('121212-1234567')
FROM dual;

INSERT INTO class4_info(num, name, ssn)
VALUES(15, 'someone', '121212-1234567');

SELECT num, name, ssn, valid_ssn_check(ssn)
FROM class4_info;                 





























