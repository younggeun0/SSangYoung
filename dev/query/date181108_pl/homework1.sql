/*
����
1. �Ʒ��� Dictionary���̺��� ����Ͽ�
user_constraints, user_tab_cols, user_tab_columns
�Էµ����̺� ���� ������׸�, �÷���, ��������
�� ��ȸ�ϴ� �������� �ۼ� .

2. ���� �۾��� �����ϴ� Procedure�� ����.
*/

-- CONSTRAINT_NAME
SELECT * FROM user_constraints;

-- TABLE_NAME, COLUMN_NAME, DATA_TYPE
SELECT * FROM user_tab_cols;

-- CONSTRAINT_NAME, COLUMN_NAME
SELECT * FROM user_cons_columns;


SELECT ucc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
FROM   user_tab_cols utc, user_constraints uc, user_cons_columns ucc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME AND uc.CONSTRAINT_NAME = ucc.CONSTRAINT_NAME)
 AND utc.COLUMN_NAME = ucc.COLUMN_NAME
 AND utc.TABLE_NAME='TABLE_UNIQUE';




-- hw2 . ���ν��� ȣ��

VAR cur_cons REFCURSOR;

EXEC select_constraints('EMP',:cur_cons);      

PRINT cur_cons;

