CREATE OR REPLACE PROCEDURE select_constraints(
 	t_name VARCHAR2,
 	cur_cons OUT SYS_REFCURSOR
)
IS
BEGIN

	OPEN cur_cons FOR 
		SELECT  ucc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
		FROM user_tab_cols utc, user_constraints uc, user_cons_columns ucc
		WHERE (uc.TABLE_NAME = utc.TABLE_NAME AND uc.CONSTRAINT_NAME = ucc.CONSTRAINT_NAME)
		 AND utc.COLUMN_NAME = ucc.COLUMN_NAME
		 AND utc.TABLE_NAMe = t_name;

END;
/
