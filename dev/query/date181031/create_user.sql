-- ���� ���� : ������ ������ ��������
-- CREATE USER ������ IDENTIFIED BY ��й�ȣ;

CREATE USER test IDENTIFIED BY 1234;

-- ���� ���� : CONNECT
GRANT CONNECT TO test;

SELECT '1'
FROM dual;

-- ���̺� ���� X
CREATE TABLE my_table(num NUMBER);

-- ���̺��� ��� SELECT�� ������ �� �ִ°� ����..
-- DUAL�� ��밡��

SELECT SYSDATE
FROM   DUAL;

-- �ڿ���� ���� : RESOURCE
GRANT RESOURCE TO test;

-- �������ؾ� ���������

-- RESOURCE �������� ���̺� ���� ����
CREATE TABLE my_table(num NUMBER);

INSERT INTO my_table VALUES(1);
COMMIT;

SELECT * FROM my_table;


-- ������ ���� : DBA
GRANT DBA TO test;


-- ������ ���� �ο� ��
-- ���� ������� �Ұ���
shutdown abort;

-- ������ ���� �ο� �� �Ϲݰ����� ������ ������ ����
-- ��������, ���� ���� �ο���


-- SCOTT
CREATE VIEW test_view
AS (SELECT num
	FROM my_table);

-- user_views ���� ����� �� �� ����
SELECT * FROM user_views;

DROP VIEW test_view;

-- ���� ȸ��
-- REVOKE ����, ...  FROM ������;
REVOKE DBA FROM test;

-- ���� ȸ�� �� ��������, VIEW ���� �� ��� ���Ѻ���� ���� �߻�
CREATE USER test1 IDENTIFIED BY 2222;

-- ���� ����
-- ������ ���ӵǾ� �ִٸ� �������� �ʴ´�
-- �����ϴ� ������ ���� ��ü���� �����Ѵٸ� ������ �ȵ�
-- CASCADE �ɼ����� ��� �������Ѿ� ������ �ȴ�


-- system ���� �α��� ��
--
SELECT tname FROM tab;

-- ���� ��ȸ(all_users, dba_users)
SELECT * FROM all_users;

SELECT * FROM dba_users;
                          