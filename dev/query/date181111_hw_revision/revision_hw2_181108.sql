/*
����
1. �Ʒ��� Dictionary���̺��� ����Ͽ�
user_constraints, user_tab_cols, user_tab_columns
�Էµ����̺� ���� ������׸�, �÷���, ��������
�� ��ȸ�ϴ� �������� �ۼ� .
*/

CREATE OR REPLACE PROCEDURE select_constraints(
	t_name VARCHAR2,
	cur_cons OUT SYS_REFCURSOR
)
IS                           
BEGIN                        

	OPEN cur_cons FOR	
		SELECT ucc.constraint_name, utc.column_name, utc.data_type
		FROM user_tab_cols utc, user_constraints uc, user_cons_columns ucc
		WHERE (uc.table_name = utc.table_name AND uc.constraint_name = ucc.constraint_name)
		 AND utc.column_name = ucc.column_name
		 AND utc.table_name='EMP';


END;
/

