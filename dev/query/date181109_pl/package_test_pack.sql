-- 패키지 헤더 : 패키지에 들어갈 함수나 프로시저의 목록을 정의 (업무 구현 X)

CREATE OR REPLACE PACKAGE test_pack 
AS
	FUNCTION get_msg(name VARCHAR2) RETURN VARCHAR2;
	PROCEDURE get_age(birth_year IN NUMBER, age OUT NUMBER);    
	
	PROCEDURE search_constraints(t_name VARCHAR2, tab_info OUT SYS_REFCURSOR);

END; 