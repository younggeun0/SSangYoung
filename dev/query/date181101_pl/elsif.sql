
SET serveroutput ON
SET verify OFF
             
ACCEPT howl PROMPT '�����Ҹ� : '

DECLARE
 var VARCHAR2(6);
BEGIN           
	var := '&howl';
	
	IF var = '����' THEN
		var := '����';
	ELSIF var = '�߿�' THEN
		var := '�߿�';
	ELSIF var = '�۸�' THEN
		var := '�۸�';
	ELSIF var = '����' THEN
		var := '����';
	ELSE
		var := '����';
	END IF;                     
	
	DBMS_OUTPUT.PUT_LINE(var);
END;
/