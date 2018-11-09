-- DBMS_RANDOM 패키지 사용한 패키지 만들기
CREATE OR REPLACE PACKAGE BODY lucky_pack
IS
	 -- 행운의 수(1~45) 중 하나를 얻는 함수
	 ---------- lucky_num 시작 -------------------         
   FUNCTION lucky_num RETURN NUMBER
   IS
   BEGIN
		RETURN TRUNC(DBMS_RANDOM.VALUE(1,46));
   END lucky_num;  
	 ---------- lucky_num 끝 ---------------------   
                               
	 
   -- 귀인얻기 프로시저
	 ---------- lucky_name 시작 -----------------
   PROCEDURE lucky_name(name OUT VARCHAR2)
   IS
   	TYPE tab_name IS TABLE OF VARCHAR2(30)
   		INDEX BY BINARY_INTEGER;
   	arr_name tab_name;      
   	temp_num NUMBER;
   BEGIN       
		arr_name(1) := '공선의';
		arr_name(2) := '이봉현';   
		arr_name(3) := '백인제';
		arr_name(4) := '김정윤';
		arr_name(5) := '박소영';
		arr_name(6) := '최혜원';
		arr_name(7) := '이재찬';		
		
		-- 난수는 1~7사이에 발생해야 함
		temp_num := TRUNC(DBMS_RANDOM.VALUE(1,arr_name.count+1));
		
   	name := arr_name(temp_num);
   END lucky_name;                
   ---------- lucky_name 끝 -------------------  
   
   
   -- 생년월일 , 성별을 입력받아 주민번호를 생성하여
   -- out parameter에 설정하는 프로시저를 작성
   
   ---------- get_ssn 시작 ---------------------- 
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
	   	-- 00, 01로 시작하면 2000이후생
	   	-- 남자면 3
	   	-- 여자면 4   	                                             
	   	IF check_year IN (00, 01) THEN 
	   		IF gender = '남자' THEN
	   			confirmed_ssn := birthdate||'-3';
	   		ELSE
	   			confirmed_ssn := birthdate||'-4';
	   		END IF;
	   		
	   	-- 만약 00 01로 시작하지 않는다면 2000이전생
		  -- 남자면 1
		  -- 여자면 2
	   	ELSE 
	   	  IF gender = '남자' THEN
	   			confirmed_ssn := birthdate||'-1';
	   		ELSE
	   			confirmed_ssn := birthdate||'-2';
	   		END IF;
	   	END IF;              
	   	
	   	temp_ssn := confirmed_ssn;
			
      -- 5자리 추가 수 받기
			FOR i IN 1..5 LOOP
	    	temp_ssn := temp_ssn||TRUNC(DBMS_RANDOM.VALUE(1,10));
			END LOOP;            
			
			-- 마지막 체크값을 계산 후 추가	
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
                                 
	    -- 최종 ssn 합쳐서 할당
	    ssn := temp_ssn||temp_val;   
	   
   ELSE 
   	ssn := '에러';	 
   END IF;   
   
   END get_ssn;
   ---------- get_ssn 끝 ------------------------

/*	
1.lucky_pack 패키지에 태어난해를 입력받으면 띠를 반환하는 
  함수를 추가하세요.
  띠 - 태어난해를 12로 나눈 나머지가 
      11이면 양띠, 10- 말, 9-뱀,8-용,7-토끼,6-호랑이,5-소,4-쥐,3-돼지,
      2-개,1-닭,0-원숭이	
*/	
-------------------get_chinese_zodiac 시작------------------------  
	FUNCTION get_chinese_zodiac(birth_year NUMBER) RETURN VARCHAR2
	IS
		c_z VARCHAR2(15);
		r NUMBER; -- 나머지	
	BEGIN              
		r := TRUNC(MOD(birth_year,12),0);
	
		IF r = 11 THEN
			c_z := '양띠';  
		ELSIF r = 10 THEN
			c_z := '말띠';
		ELSIF r = 9 THEN
			c_z := '뱀띠';
		ELSIF r = 8 THEN
			c_z := '용띠';
		ELSIF r = 7 THEN
			c_z := '토끼띠';
		ELSIF r = 6 THEN
			c_z := '호랑이띠';
		ELSIF r = 5 THEN
			c_z := '소띠';
		ELSIF r = 4 THEN
			c_z := '쥐띠';
		ELSIF r = 3 THEN
			c_z := '돼지띠';
		ELSIF r = 2 THEN
			c_z := '개띠';
		ELSIF r = 1 THEN
			c_z := '닭띠';
		ELSIF r = 0 THEN
			c_z := '원숭이띠';
		END IF;
	  
		RETURN c_z;
	
	END get_chinese_zodiac;                          
-------------------get_chinese_zodiac 끝------------------------
/*
2. lucky_pack 패키지에 부서번호를 받아 emp 테이블에서 부서별
   사원의 평균 근속년수를 out_parameter에 설정하는 procedure를
   추가하세요.
*/   

-------------------get_cs 시작-----------------------             
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
	-------------------get_cs 끝 ------------------------                                
END;
/
