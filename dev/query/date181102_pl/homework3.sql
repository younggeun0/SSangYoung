/*
3. 아래의 데이터를 처리하는  PL/SQL작성
    "이름, 주민번호, 나이, 성별"을 저장할 수 있는 테이블을
    생성하고 아래의 데이터를 채운다.
   김정운, 880101-1234567
   김희철, 890101-1234567
   이재찬, 011231-3234567
   박영민, 920101-2234567
   정택성, 020420-4234567
   위의 데이터를 사용하여 
   이름,주민번호,나이,성별을 보여주는  PL/SQL을 작성하세요. 
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

	users(1).name := '김정운';
	users(1).ssn := '880101-1234567';
	
	users(2).name := '김희철';
	users(2).ssn := '890101-1234567';
	
	users(3).name := '이재찬';
	users(3).ssn := '011231-3234567';
	
	users(4).name := '박영민';
	users(4).ssn := '920101-2234567';
	
	users(5).name := '정택성';
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


