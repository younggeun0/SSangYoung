
SELECT * FROM test_proc;
 
-- ���ε� ���� ����
VAR msg VARCHAR2(100);
VAR cnt NUMBER;

-- ���ν��� ���� 
-- ���� : �����ϴ� �����ȣ�� ����
EXEC delete_test_proc(2222, :msg, :cnt);
               
-- ó�� ��� ���
PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- �������� �ʴ� �����ȣ�� ����
EXEC delete_test_proc(3333, :msg, :cnt);

PRINT msg;
PRINT cnt;
