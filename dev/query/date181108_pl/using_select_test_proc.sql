
SELECT * FROM test_proc;

-- ���޿� ���� ��� ��, ������ ��ȸ����

-- ���ε庯�� ����
VAR cnt_emp NUMBER;
VAR sum_sal NUMBER;
VAR msg VARCHAR2(100);

-- ���ν��� ����
EXEC select_test_proc_cnt('����',:cnt_emp, :sum_sal, :msg);

-- ���ν��� ��� ���
PRINT msg;
PRINT cnt_emp;
PRINT sum_sal;



-- ������ ���� ���
EXEC select_test_proc_cnt('�˹ٻ�',:cnt_emp, :sum_sal, :msg);

PRINT msg;
PRINT cnt_emp;
PRINT sum_sal;

-- ������ ������ ����� ���� ���
EXEC select_test_proc_cnt('��ǥ�̻�',:cnt_emp, :sum_sal, :msg); 

PRINT msg;
PRINT cnt_emp;
PRINT sum_sal;
