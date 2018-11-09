CREATE OR REPLACE PACKAGE BODY ssn
IS 
	--------- create_ssn ���ν��� ���� -------------------------
	-- �������, ����, �̸��� �Է¹޾� �ֹι�ȣ�� �����Ͽ�
	-- out parameter�� �����ϰ� class4_info ���̺� �߰��ϴ�
	-- ���ν��� �ۼ� 
  PROCEDURE create_ssn(
  	birthdate VARCHAR2, gender VARCHAR2, 
  	name VARCHAR2, ssn OUT CHAR
  )
	IS                         
		-- �ֹι�ȣ�� ������ ���̺� 		
  	TYPE tab_ssn IS TABLE OF NUMBER(1)
  		INDEX BY BINARY_INTEGER; 
  	
  	arr_ssn tab_ssn;              
    gender_num NUMBER := 2; 
    temp_num NUMBER := 0;
    flag_num NUMBER := 2;
    
    -- ssn�� �ٷ� INSERT������ �־��ָ� 
    -- CHAR �⺻�� 2000����Ʈ�� INSERT - error�߻�!
    ssn_value VARCHAR2(14);
    
  BEGIN             
  
  	-- �Է¹��� ��������� arr_ssn�� �߰�
  	FOR i IN 1..LENGTH(birthdate) LOOP
  		arr_ssn(i) := SUBSTR(birthdate, i, 1);
  	END LOOP;                               
  	
  	-- ���� ä��� 1900����, 2000����(����) 
  	IF gender='����' THEN
  		gender_num := 1;
  	END IF;        
  	
  	arr_ssn(7) := gender_num;
  	
  	-- ������ ��° �� ���� ä���
  	FOR i IN 8..12 LOOP
  		arr_ssn(i) := TRUNC(DBMS_RANDOM.VALUE(0,10));  	
  	END LOOP;                                    

    -- ������ �ֹι�ȣ�� ������ ���ڸ��� ä��� ���� ����  	
  	FOR i IN 1..arr_ssn.COUNT LOOP             
  		temp_num := temp_num + arr_ssn(i)*flag_num;
  		flag_num := flag_num + 1;
  		IF flag_num = 10 THEN
  			flag_num := 2;
  		END IF;                         
  	END LOOP; 
  	-- ä���� ������ ���ڸ��� ����
  	arr_ssn(13) := mod(11-mod(temp_num, 11),10);  
  	
  	ssn_value := birthdate||'-'||gender_num||arr_ssn(8)
  			       	||arr_ssn(9)||arr_ssn(10)||arr_ssn(11)||arr_ssn(12)
  			       	||arr_ssn(13);
  				
  	-- ������ �ֹι�ȣ�� class4_info�� �߰�
  	-- ������ ������ ���ν����� ����
  	INSERT INTO class4_info(name, ssn)
  	VALUES (name,ssn_value); 
  	
  	ssn := ssn_value; -- ���ν��� ���� ����� ���� ����
  	
  	COMMIT;  	
  	
  END create_ssn;
  --------- create_ssn ���ν��� ���� -----------------------
END;
/
