SELECT * FROM user_procedures;

SELECT * FROM test_proc;

-- ���ε� ����(�ܺ� ����) ����
VAR msg VARCHAR2(100);
VAR row_cnt NUMBER;

-- ���ν��� ����
EXEC update_test_proc(1112,'����',3000,:msg,:row_cnt);

-- ó�����(���ε� ����) ���
PRINT msg;
PRINT row_cnt;


-- ������� Ȯ��
--  ������ ���, ����, �븮, ����, ����, ����, �̻�,
--    ��, ����, ��ǥ�̻簡 �Է� �Ǿ��� ���� ����
EXEC update_test_proc(1112,'����',3100,:msg,:row_cnt);

PRINT msg;
PRINT row_cnt;

--  ������ ���� �������� �۴ٸ� ���� �������� 5% �λ������ ����
EXEC update_test_proc(1111,'����',2300,:msg,:row_cnt);

PRINT msg;
PRINT row_cnt;                      

