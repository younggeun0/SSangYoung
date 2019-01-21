CREATE OR REPLACE PROCEDURE lunch_order_select(
	i_order_name IN VARCHAR2,
	i_phone IN VARCHAR2,
	cur_order_list OUT SYS_REFCURSOR 
)
IS                                           

BEGIN                                        

	OPEN cur_order_list FOR
		SELECT l.lunch_name, 
			TO_CHAR(o.order_date, 'yyyy-mm-dd day hh24:mi:ss') order_date,
			 o.quan
		FROM ordering o, lunch l
		WHERE l.lunch_code = o.lunch_code
		 AND o.order_name=i_order_name AND o.phone=i_phone
		ORDER BY o.order_date DESC;

END;
/
