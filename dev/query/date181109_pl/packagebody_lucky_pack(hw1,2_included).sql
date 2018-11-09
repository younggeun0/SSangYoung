-- DBMS_RANDOM ��Ű�� ����� ��Ű�� �����
CREATE OR REPLACE PACKAGE BODY lucky_pack
IS
	 -- ����� ��(1~45) �� �ϳ��� ��� �Լ�
	 ---------- lucky_num ���� -------------------         
   FUNCTION lucky_num RETURN NUMBER
   IS
   BEGIN
		RETURN TRUNC(DBMS_RANDOM.VALUE(1,46));
   END lucky_num;  
	 ---------- lucky_num �� ---------------------   
                               
	 
   -- ���ξ�� ���ν���
	 ---------- lucky_name ���� -----------------
   PROCEDURE lucky_name(name OUT VARCHAR2)
   IS
   	TYPE tab_name IS TABLE OF VARCHAR2(30)
   		INDEX BY BINARY_INTEGER;
   	arr_name tab_name;      
   	temp_num NUMBER;
   BEGIN       
		arr_name(1) := '������';
		arr_name(2) := '�̺���';   
		arr_name(3) := '������';
		arr_name(4) := '������';
		arr_name(5) := '�ڼҿ�';
		arr_name(6) := '������';
		arr_name(7) := '������';		
		
		-- ������ 1~7���̿� �߻��ؾ� ��
		temp_num := TRUNC(DBMS_RANDOM.VALUE(1,arr_name.count+1));
		
   	name := arr_name(temp_num);
   END lucky_name;                
   ---------- lucky_name �� -------------------  
   
   
   -- ������� , ������ �Է¹޾� �ֹι�ȣ�� �����Ͽ�
   -- out parameter�� �����ϴ� ���ν����� �ۼ�
   
   ---------- get_ssn ���� ---------------------- 
   PROCEDURE get_ssn(birthdate CHAR, gender VARCHAR2, ssn OUT CHAR)
   IS        
   		temp_ssn VARCHAR2(100) := ssn;
			check_year CHAR(2) := SUBSTR(birthdate,1,2);   
			confirmed_ssn CHAR(8); 
			lastnum CHAR(1); 
			valid_num NUMBER := 2; 
			temp_val NUMBER := 0;
   BEGIN    
   
   IF SUBSTR(birthdate, 3, 2) BETWEEN 1 AND 12 AND 
      SUBSTR(birthdate, 5, 2) BETWEEN 1 AND 31 THEN 
	   	-- 00, 01�� �����ϸ� 2000���Ļ�
	   	-- ���ڸ� 3
	   	-- ���ڸ� 4   	                                             
	   	IF check_year IN (00, 01) THEN 
	   		IF gender = '����' THEN
	   			confirmed_ssn := birthdate||'-3';
	   		ELSE
	   			confirmed_ssn := birthdate||'-4';
	   		END IF;
	   		
	   	-- ���� 00 01�� �������� �ʴ´ٸ� 2000������
		  -- ���ڸ� 1
		  -- ���ڸ� 2
	   	ELSE 
	   	  IF gender = '����' THEN
	   			confirmed_ssn := birthdate||'-1';
	   		ELSE
	   			confirmed_ssn := birthdate||'-2';
	   		END IF;
	   	END IF;              
	   	
	   	temp_ssn := confirmed_ssn;
			
      -- 5�ڸ� �߰� �� �ޱ�
			FOR i IN 1..5 LOOP
	    	temp_ssn := temp_ssn||TRUNC(DBMS_RANDOM.VALUE(1,10));
			END LOOP;            
			
			-- ������ üũ���� ��� �� �߰�	
	    FOR i IN 1..13 LOOP   
	        IF i != 7 THEN
	            temp_val := temp_val + SUBSTR(temp_ssn, i, 1) * (valid_num);
	            valid_num := valid_num + 1;       
	            
	            IF valid_num > 9 THEN
	                valid_num := 2;
	            END IF;                   
	        END IF;
	    END LOOP;
	    temp_val := mod(11-mod(temp_val,11),10);
                                 
	    -- ���� ssn ���ļ� �Ҵ�
	    ssn := temp_ssn||temp_val;   
	   
   ELSE 
   	ssn := '����';	 
   END IF;   
   
   END get_ssn;
   ---------- get_ssn �� ------------------------

/*	
1.lucky_pack ��Ű���� �¾�ظ� �Է¹����� �츦 ��ȯ�ϴ� 
  �Լ��� �߰��ϼ���.
  �� - �¾�ظ� 12�� ���� �������� 
      11�̸� ���, 10- ��, 9-��,8-��,7-�䳢,6-ȣ����,5-��,4-��,3-����,
      2-��,1-��,0-������	
*/	
-------------------get_chinese_zodiac ����------------------------  
	FUNCTION get_chinese_zodiac(birth_year NUMBER) RETURN VARCHAR2
	IS
		c_z VARCHAR2(15);
		r NUMBER; -- ������	
	BEGIN              
		r := TRUNC(MOD(birth_year,12),0);
	
		IF r = 11 THEN
			c_z := '���';  
		ELSIF r = 10 THEN
			c_z := '����';
		ELSIF r = 9 THEN
			c_z := '���';
		ELSIF r = 8 THEN
			c_z := '���';
		ELSIF r = 7 THEN
			c_z := '�䳢��';
		ELSIF r = 6 THEN
			c_z := 'ȣ���̶�';
		ELSIF r = 5 THEN
			c_z := '�Ҷ�';
		ELSIF r = 4 THEN
			c_z := '���';
		ELSIF r = 3 THEN
			c_z := '������';
		ELSIF r = 2 THEN
			c_z := '����';
		ELSIF r = 1 THEN
			c_z := '�߶�';
		ELSIF r = 0 THEN
			c_z := '�����̶�';
		END IF;
	  
		RETURN c_z;
	
	END get_chinese_zodiac;                          
-------------------get_chinese_zodiac ��------------------------
/*
2. lucky_pack ��Ű���� �μ���ȣ�� �޾� emp ���̺��� �μ���
   ����� ��� �ټӳ���� out_parameter�� �����ϴ� procedure��
   �߰��ϼ���.
*/   

-------------------get_cs ����-----------------------             
	PROCEDURE get_cs(i_deptno NUMBER, avg_cs OUT NUMBER)
	IS
		hiredate DATE;
		sum_cs NUMBER := 0;
		emp_cnt NUMBER := 0;
	BEGIN
	  
		FOR temp_data IN (SELECT hiredate
											INTO hiredate
											FROM emp
											WHERE deptno = i_deptno)
		LOOP
		         
			sum_cs :=	sum_cs + (TO_CHAR(SYSDATE,'yyyy') - TO_CHAR(temp_data.hiredate,'yyyy'));
		  emp_cnt := emp_cnt + 1;
		END LOOP;
		
	  avg_cs := TRUNC(sum_cs/emp_cnt,0);
	END;
	-------------------get_cs �� ------------------------                                
END;
/
