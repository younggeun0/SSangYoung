
SELECT * FROM user_sequences;

-- SEQUENCE : ���������� �����ϴ� ���� ����ϴ� ��ü
-- 1�������� 9999999���� 1�� �����ϴ� �������� ����
CREATE SEQUENCE seq_test
 INCREMENT BY 1
 START WITH 1
 MAXVALUE 999999;

DROP SEQUENCE seq_test;
SELECT * FROM user_sequences;

-- currval�� �޸𸮿� �ø��� ���� �� ��
SELECT seq_test.currval
FROM   DUAL;

SELECT	seq_test.nextval
FROM	dual;

-- �������� ���� ���п��� �������� �������
INSERT INTO cp_emp(empno, ename, hiredate, sal)
VALUES(seq_test.nextval, '�ȱ��2', SYSDATE, 300);

SELECT * FROM cp_emp;

-- ������ ����
DROP SEQUENCE seq_test;

CREATE SEQUENCE seq_test2
 INCREMENT BY 2
 START WITH 1
 MAXVALUE 9999999
 CACHE 40
 NOCYCLE;

SELECT * FROM user_sequences;

SELECT  seq_test2.nextval
FROM	dual;

DROP SEQUENCE seq_test2;
                             
-- �������� �����ϴ� ���� ������ PK�� ����ؾ��� �� ����ϸ� ����