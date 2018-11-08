-- ���ν��� CRUD ������ ���̺� ����
CREATE TABLE test_proc
AS (SELECT empno, ename, hiredate,sal,job
    FROM emp
    WHERE 1=0);

-- pk ����
ALTER TABLE test_proc ADD CONSTRAINT pk_test_proc PRIMARY KEY(empno);

-- pk ���� Ȯ��
SELECT * FROM user_constraints
WHERE TABLE_NAME='TEST_PROC';




-- insert_test_proc ���ν��� out parameter�� ���� ���ε� ���� ����
VAR msg VARCHAR2(300);
VAR cnt NUMBER;

-- ���� ����
EXEC insert_test_proc(1111,'�׽�Ʈ',3000,'����',:msg,:cnt);

-- ���ε� ���� ���, ��� Ȯ��
PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- ������� Ȯ��

-- 1.�����ȣ 1~9999������ �Է°���
-- �����ȣ 0
EXEC insert_test_proc(0,'�׽�Ʈ',3000,'����',:msg,:cnt);

PRINT msg;
PRINT cnt;

-- �����ȣ 10000
EXEC insert_test_proc(10000,'�׽�Ʈ',3000,'����',:msg,:cnt);

PRINT msg;
PRINT cnt;

-- 2.������ 2500���� 8000���̸� �Է°���
-- ������ 2000(2500����)
EXEC insert_test_proc(1112,'�׽�Ʈ',2000,'����',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- ������ 9000(8000�̻�)
EXEC insert_test_proc(1113,'�׽�Ʈ',9000,'����',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 3.���, ����, �븮, ����, ����, ����, �̻��� ��츸 �Է°���
EXEC insert_test_proc(1114,'�׽�Ʈ',1400,'�˹�',:msg,:cnt);

PRINT msg;
PRINT cnt;

-- 4.������� ������ ��� ù ���ڴ� �빮�ڿ��� ��
EXEC insert_test_proc(1114,'kim',3300,'����',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 5.������� ��� �ԷµǴ� ��� -> EXCEPTION
EXEC insert_test_proc(1115,'������',5000,'����',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;              


