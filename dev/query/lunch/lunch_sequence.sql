DROP SEQUENCE seq_lunch;
DROP SEQUENCE seq_order;

------------------- DDL for sequence seq_lunch ---------------------------------
CREATE SEQUENCE seq_lunch
	START WITH 1
	MAXVALUE 9999999999
	INCREMENT BY 1
	NOCYCLE
	CACHE 20;

------------------- DDL for sequence seq_order------------------------------
CREATE SEQUENCE seq_order
	START WITH 1
	MAXVALUE 999999999999
	INCREMENT BY 1
	NOCYCLE
	CACHE 25;
