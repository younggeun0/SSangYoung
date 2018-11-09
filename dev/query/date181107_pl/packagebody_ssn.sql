CREATE OR REPLACE PACKAGE BODY ssn
IS 
	--------- create_ssn 프로시저 시작 -------------------------
	-- 생년월일, 성별, 이름을 입력받아 주민번호를 생성하여
	-- out parameter에 설정하고 class4_info 테이블에 추가하는
	-- 프로시저 작성 
  PROCEDURE create_ssn(
  	birthdate VARCHAR2, gender VARCHAR2, 
  	name VARCHAR2, ssn OUT CHAR
  )
	IS                         
		-- 주민번호를 저장할 테이블 		
  	TYPE tab_ssn IS TABLE OF NUMBER(1)
  		INDEX BY BINARY_INTEGER; 
  	
  	arr_ssn tab_ssn;              
    gender_num NUMBER := 2; 
    temp_num NUMBER := 0;
    flag_num NUMBER := 2;
    
    -- ssn을 바로 INSERT값으로 넣어주면 
    -- CHAR 기본값 2000바이트를 INSERT - error발생!
    ssn_value VARCHAR2(14);
    
  BEGIN             
  
  	-- 입력받은 생년월일을 arr_ssn에 추가
  	FOR i IN 1..LENGTH(birthdate) LOOP
  		arr_ssn(i) := SUBSTR(birthdate, i, 1);
  	END LOOP;                               
  	
  	-- 성별 채우기 1900년대생, 2000년대생(생략) 
  	IF gender='남자' THEN
  		gender_num := 1;
  	END IF;        
  	
  	arr_ssn(7) := gender_num;
  	
  	-- 나머지 번째 방 값을 채운다
  	FOR i IN 8..12 LOOP
  		arr_ssn(i) := TRUNC(DBMS_RANDOM.VALUE(0,10));  	
  	END LOOP;                                    

    -- 생성된 주민번호를 가지고 끝자리를 채우기 위한 연산  	
  	FOR i IN 1..arr_ssn.COUNT LOOP             
  		temp_num := temp_num + arr_ssn(i)*flag_num;
  		flag_num := flag_num + 1;
  		IF flag_num = 10 THEN
  			flag_num := 2;
  		END IF;                         
  	END LOOP; 
  	-- 채워진 값으로 끝자리를 설정
  	arr_ssn(13) := mod(11-mod(temp_num, 11),10);  
  	
  	ssn_value := birthdate||'-'||gender_num||arr_ssn(8)
  			       	||arr_ssn(9)||arr_ssn(10)||arr_ssn(11)||arr_ssn(12)
  			       	||arr_ssn(13);
  				
  	-- 생성된 주민번호를 class4_info에 추가
  	-- 쿼리가 있으면 프로시저가 적합
  	INSERT INTO class4_info(name, ssn)
  	VALUES (name,ssn_value); 
  	
  	ssn := ssn_value; -- 프로시저 실행 결과를 보기 위해
  	
  	COMMIT;  	
  	
  END create_ssn;
  --------- create_ssn 프로시저 종료 -----------------------
END;
/
