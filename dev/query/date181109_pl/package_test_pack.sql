-- ��Ű�� ��� : ��Ű���� �� �Լ��� ���ν����� ����� ���� (���� ���� X)

CREATE OR REPLACE PACKAGE test_pack 
AS
	FUNCTION get_msg(name VARCHAR2) RETURN VARCHAR2;
	PROCEDURE get_age(birth_year IN NUMBER, age OUT NUMBER);    
	
	PROCEDURE search_constraints(t_name VARCHAR2, tab_info OUT SYS_REFCURSOR);

END; 