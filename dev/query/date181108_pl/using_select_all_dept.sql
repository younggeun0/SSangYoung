-- ������ ��ȸ�� �� SYS_REFCURSOR ���
-- 1. ���ε庯��(Ŀ��) ����
VAR cur_dept REFCURSOR;

-- 2. ���ν��� ����
EXEC select_all_dept(:cur_dept);

-- 3. ��� ���
PRINT cur_dept;

-- ���ν��� ���ο��� FETCH �� ���ν��� ���� - error!
EXEC select_all_dept(:cur_dept);
