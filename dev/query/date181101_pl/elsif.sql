
SET serveroutput ON
SET verify OFF
             
ACCEPT howl PROMPT '匡澜家府 : '

DECLARE
 var VARCHAR2(6);
BEGIN           
	var := '&howl';
	
	IF var = '捞叁' THEN
		var := '捞叁';
	ELSIF var = '具克' THEN
		var := '具克';
	ELSIF var = '港港' THEN
		var := '港港';
	ELSIF var = '绢蕊' THEN
		var := '绢蕊';
	ELSE
		var := '栏雷';
	END IF;                     
	
	DBMS_OUTPUT.PUT_LINE(var);
END;
/