-- PACKAGE BODY 정의 : 업무 구현

CREATE OR REPLACE PACKAGE BODY test_pack 
IS
	-------------FUNCTION get_msg 시작 ------------------ 
	FUNCTION get_msg(name VARCHAR2) RETURN VARCHAR2    
	IS       
	BEGIN
	
		RETURN TO_CHAR(SYSDATE,'day')||'입니다. '||name||'님 안녕하세요';
	
	END get_msg;                                   
	----------- FUNCTION get_msg 끝 --------------------
	
	----------- PROCEDURE get_age 시작 ----------------- 
	PROCEDURE get_age(birth_year IN NUMBER, age OUT NUMBER)
	IS 
	BEGIN
	
		age := TO_CHAR(SYSDATE, 'yyyy') - birth_year + 1;
	
	END get_age; 
	----------- PROCEDURE get_age 끝 ------------------
	
	
	----------- search_constraints 시작 --------------- 
	PROCEDURE search_constraints(
		t_name VARCHAR2, 
		tab_info OUT SYS_REFCURSOR
	)
	IS
	BEGIN
		OPEN tab_info FOR 
			SELECT ucc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
			FROM   user_tab_cols utc, user_constraints uc, user_cons_columns ucc
			WHERE  (uc.TABLE_NAME = utc.TABLE_NAME AND uc.CONSTRAINT_NAME = ucc.CONSTRAINT_NAME)
			 AND utc.COLUMN_NAME = ucc.COLUMN_NAME
			 AND utc.TABLE_NAME=UPPER(t_name);
	END;                                                   
	----------- search_constraints 끝 -----------------
END test_pack;
/
