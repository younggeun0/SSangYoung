SELECT * FROM user_triggers;

-- TRIGGER ������ ���̺� ����
CREATE TABLE trigger1 (
  name VARCHAR2(30),
  age NUMBER(3),
  addr VARCHAR2(100)
);

CREATE TABLE trigger2 (
  name VARCHAR2(30),
  age NUMBER(3)
);

SELECT * FROM trigger1;
SELECT * FROM trigger2;

-- INSERT �� INSERTING ���� ����
INSERT INTO trigger1(name, age, addr)
VALUES ('������',22,'�����');

-- UPDATE �� UPDATING ���� ����
UPDATE trigger1
SET name='������'
WHERE name='������';

-- DELETE �� DELETING ���� ����
DELETE FROM trigger1
WHERE name='������';

SELECT * FROM trigger1;
SELECT * FROM trigger2;

DROP TRIGGER event_compare;


SELECT * FROM class4_info;

-- TRIGGER�� ������� ���� �����۾�
INSERT INTO class4_info(num,age)
VALUES(99,29);

COMMIT;

-- trigger1 ���̺� ���ڵ� �߰���
-- trigger2 ���̺� trigger1�� �߰��� �̸���
-- class4_info ���̺��� ��ȣ�� 99���� �л��� ���̷�
-- trigger2 ���̺� ���ڵ� �߰�

INSERT INTO trigger1(name,age,addr)
VALUES('���ٿ�', 22, '����');

SELECT * FROM trigger1;
SELECT * FROM trigger2;




-------------


SELECT * FROM cp_emp;
SELECT * FROM cp_emp3;

INSERT INTO cp_emp(empno, ename, sal)
VALUES(0001,'ȣȣ',1800);

INSERT INTO cp_emp(empno, ename, sal)
VALUES(0002,'ȣ��',3000);

DROP TRIGGER tri_emp;
