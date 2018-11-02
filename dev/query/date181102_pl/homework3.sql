/*
3. �Ʒ��� �����͸� ó���ϴ�  PL/SQL�ۼ�
    "�̸�, �ֹι�ȣ, ����, ����"�� ������ �� �ִ� ���̺���
    �����ϰ� �Ʒ��� �����͸� ä���.
   ������, 880101-1234567
   ����ö, 890101-1234567
   ������, 011231-3234567
   �ڿ���, 920101-2234567
   ���ü�, 020420-4234567
   ���� �����͸� ����Ͽ� 
   �̸�,�ֹι�ȣ,����,������ �����ִ�  PL/SQL�� �ۼ��ϼ���. 
*/	             
     
SET serveroutput ON
                   
DECLARE            

	TYPE p_rec IS RECORD(
	  name VARCHAR2(15),
	  ssn CHAR(14),
	  age NUMBER(3),
	  gender CHAR(1)
	);              
	
	TYPE p_tab IS TABLE OF p_rec
	 INDEX BY BINARY_INTEGER;
	 
	users p_tab; 
	
	yob NUMBER(4); 
	gender CHAR(1);

BEGIN         

	users(1).name := '������';
	users(1).ssn := '880101-1234567';
	
	users(2).name := '����ö';
	users(2).ssn := '890101-1234567';
	
	users(3).name := '������';
	users(3).ssn := '011231-3234567';
	
	users(4).name := '�ڿ���';
	users(4).ssn := '920101-2234567';
	
	users(5).name := '���ü�';
	users(5).ssn := '020420-4234567';
	
	FOR i IN 1..users.COUNT LOOP
	
		IF SUBSTR(users(i).ssn,8,1) IN (1, 3) THEN 
			gender := 'M';
		ELSE 
		  gender := 'F';
		END IF;                  

		IF SUBSTR(users(i).ssn,1,1) IN (0, 1) THEN				
			yob := CONCAT(20,SUBSTR(users(i).ssn,1,2));
		ELSE 	
	  	yob := CONCAT(19,SUBSTR(users(i).ssn,1,2));
		END IF;
		
		users(i).gender := gender;
		users(i).age := TO_CHAR(SYSDATE, 'yyyy') - yob;
		
		DBMS_OUTPUT.PUT_LINE(users(i).name||' '
												||users(i).ssn||' '
												||users(i).age||' '
												||users(i).gender); 
	END LOOP;
END;
/


