/*
����
1. �Ʒ��� Dictionary���̺��� ����Ͽ�
user_constraints, user_tab_cols, user_tab_columns
�Էµ����̺� ���� ������׸�, �÷���, ��������
�� ��ȸ�ϴ� �������� �ۼ� .

2. ���� �۾��� �����ϴ� Procedure�� ����.
*/
SELECT * FROM user_constraints;
-- CONSTRAINT_NAME
-- ������� ���̺� �÷������� ����X
SELECT * FROM user_tab_cols;
-- TABLE_NAME, COLUMN_NAME, DATA_TYPE

SELECT * FROM user_cons_columns;

-- CONSTRAINT_NAME, COLUMN_NAME, DATA_TYPE �� ���

--

SELECT  utc.TABLE_NAME, uc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
FROM   user_tab_cols utc, user_constraints uc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME)
 AND utc.TABLE_NAME='EMP';

-- ����, ��Į�󼭺����� ���
-- �ϴ� �ʿ��÷� �ִ� ������ �ߴµ�.. ���� ��� ������
SELECT  *
FROM   user_tab_cols utc, user_constraints uc, user_cons_columns ucc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME AND uc.COLUMN_NAME = ucc.COLUMN_NAME)
 AND ucc.TABLE_NAME='EMP';

SELECT  *
FROM   (SELECT TABLE_NAME
				FROM user_tab_cols
				GROUP BY TABLE_NAME) utc, user_constraints uc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME)
 AND utc.TABLE_NAME='EMP';



