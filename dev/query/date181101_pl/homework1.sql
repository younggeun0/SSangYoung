/*
����.

1. �������� �Է¹޾� �������� Ư¡�� ��� �ϴ� PL/SQL�ۼ�.
   -�������� ��ҹ��� ��� �� ���� �ؾ��Ѵ�.
   -'A' : �������̴�. ���ɽ�����, �����ϴ�
   -'B' : �ڱ��߽����̴�. �����̳� ��Ģ, �ӹ��� ���� �Ⱦ��Ѵ�.
   -'AB' : �ո����̴�. �ո����� �ݵ����� ��ȣ�ϰԵȴ�. 
   -'O' :  �Ѱᰰ�� ��°� �������� �ִ�. �����ǽ��� ���ϴ� 
*/                                                          

  
SET serveroutput ON
SET verify OFF

ACCEPT blood_type PROMPT '�������� �Է����ּ��� : '

DECLARE
	btype VARCHAR2(2);
	output VARCHAR2(100);
BEGIN
	btype := '&blood_type';
	btype := UPPER(btype);
	
	IF btype NOT IN ('A', 'B', 'AB', 'O') THEN
		output := '�������� �ƴմϴ�..';
	ELSE
	    IF btype = 'A' THEN
	    	output := '�������̴�. ���ɽ�����, �����ϴ�';
	    ELSIF btype = 'B' THEN
	    	output := '�ڱ��߽����̴�. �����̳� ��Ģ, �ӹ��� ���� �Ⱦ��Ѵ�';
	    ELSIF btype = 'AB' THEN
	    	output := '�ո����̴�. �ո����� �ݵ����� ��ȣ�ϰԵȴ�.';
	    ELSE
	    	output :=  '�Ѱᰰ�� ��°� �������� �ִ�. �����ǽ��� ���ϴ� '; 
	    END IF;
	END IF;	

	DBMS_OUTPUT.PUT_LINE(output);	

END;
/
