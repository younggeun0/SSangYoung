
-- 1. ���ε庯�� ����
VAR cnt NUMBER;
VAR msg VARCHAR2(12);

-- 2. ����
EXEC proc_insert_cpemp2(1111, '������', 4000, :cnt, :msg);

-- 3. ���ε� ���� ���
PRINT cnt;
PRINT msg;

SELECT * FROM cp_emp2;

