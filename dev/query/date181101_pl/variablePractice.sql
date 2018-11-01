SET serveroutput ON

DECLARE
	age NUMBER := 29;
	currentyear NUMBER := 2018;	  
	height NUMBER(3); 
	name VARCHAR2(15);
BEGIN                 
	SELECT ename INTO name 
	FROM emp 
	WHERE sal = 5000;
	height := 175;       
	DBMS_OUTPUT.PUT_LINE('name : '||name);
	DBMS_OUTPUT.PUT_LINE('height: '||height);
    DBMS_OUTPUT.PUT_LINE('year of birth :'||TO_CHAR(currentyear-age+1));
END;
/