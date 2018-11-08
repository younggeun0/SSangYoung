/*
����
1. �Ʒ��� Dictionary���̺��� ����Ͽ�
user_constraints, user_tab_cols, user_tab_columns
�Էµ����̺� ���� ������׸�, �÷���, ��������
�� ��ȸ�ϴ� �������� �ۼ� .

2. ���� �۾��� �����ϴ� Procedure�� ����.


*/
SELECT * FROM user_constraints;  -- CONSTRAINT_NAME, ������� ���̺� �÷������� ����X
, R_CONSTRAINT_NAME, CONSTRAINT_NAMESELECT * FROM user_tab_cols;     -- TABLE_NAME, COLUMN_NAME, DATA_TYPE
SELECT * FROM user_tab_columns;

--SELECT uc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
SELECT *
FROM   (SELECT TABLE_NAME
				FROM user_tab_cols
				GROUP BY TABLE_NAME) utc, user_constraints uc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME)
 AND uc.CONSTRAINT_NAME LIKE '%'
 AND utc.TABLE_NAME='EMP';

SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
FROM user_tab_cols
UNION
SELECT TABLE_NAME, CONSTRAINT_NAME
FROM user_constraints;

-- ���Ͽ��ϰ� �� ������� ���� �̾Ƴ���                               
-- user_tab_cols
-- TABLE_NAME(VARCHAR2(30), COLUMN_NAME(VARCHAR2(30), DATA_TYPE(VARCHAR2(106)
                
-- user_constraints
-- TABLE_NAME(VARCHAR2(30), CONSTRAINT
/*

SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
FROM(
	SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
	FROM user_tab_cols
	UNION
	SELECT TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME
	FROM user_constraints
)
GROUP BY TABLE_NAME;

*/