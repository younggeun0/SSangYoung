/*
SELECT tname FROM tab;

CREATE TABLE p_info(
  num NUMBER(5),
  name VARCHAR2(15),
  gender CHAR(1),
  address VARCHAR2(360),
  score NUMBER(3),
  i_date DATE
);

INSERT INTO p_info
VALUES(1, '����ȣ', 'm', '����� ������ ���ﵿ', 64, SYSDATE);

INSERT INTO p_info(num, name, gender, address, score, i_date)
VALUES(2, '������', 'm', '����� ���α� ������', 87, SYSDATE);

INSERT INTO p_info
VALUES(3, '������', 'f', '����� �������� ���ǵ���', 97, SYSDATE);

INSERT INTO p_info
VALUES(4, 'Ȳ�缺', 'm', '����� ���۱� �󵵵�', 100, SYSDATE);

INSERT INTO p_info
VALUES(5, '���缮', 'm', '��⵵ ������ ���뱸', 100, SYSDATE);

SELECT * FROM p_info;

UPDATE 	p_info
SET		name='�׽�Ʈ'
WHERE	num=3 AND score=97;

UPDATE	p_info
SET		gender='m'
WHERE	num=3 AND score=97;

SELECT * FROM p_info;

COMMIT;

UPDATE	p_info
SET		gender='f'
WHERE	name='���缮';

SELECT * FROM p_info;

ROLLBACK;

SELECT * FROM p_info;

DELETE FROM p_info
WHERE num=1 AND name='������';

TRUNCATE TABLE p_info;

SELECT * FROM p_info;

DROP TABLE p_info;

SELECT tname FROM tab;

PURGE RECYCLEBIN;

SELECT tname FROM tab;

COMMIT;
*/














