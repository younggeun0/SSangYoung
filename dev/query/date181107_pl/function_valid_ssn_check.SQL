-- '880101-1234567' 
-- 각 자리에 지정한 수를 곱함
--  234567 892345 
-- 마지막 주민번호 한자리가 검증 값
-- 각 자리별 결과를 다 더한 후 11로 나눈 나머지를 구함
-- 그 결과를 11에서 뺀다
-- 그 결과를 10으로 나눈 나머지를 구함
-- 최종 결과값이 주민번호 최종끝자리와 같으면 유효
-- 같지 않으면 무효

CREATE OR REPLACE FUNCTION valid_ssn_check(ssn CHAR)
RETURN CHAR
IS
    result_msg CHAR(6) := '무효';
             
    temp_val NUMBER := 0; -- 연산결과를 저장할 변수

    -- ssn 각 자리수와 곱해질 validation number
    valid_num NUMBER := 2;  

    flag_num CHAR(1); -- 주민번호 끝자리                 
  
    
BEGIN        

	IF CHECK_SSN(ssn) = 'success' THEN     
	
	    flag_num := SUBSTR(ssn, 14, 1); 
	
	    FOR i IN 1..13 LOOP
	        IF i != 7 THEN
	            
	            temp_val := temp_val + SUBSTR(ssn, i, 1) * (valid_num);
	            valid_num := valid_num + 1;       
	            
	            IF valid_num > 9 THEN
	                valid_num := 2;
	            END IF;        
	                            
	        END IF;
	    END LOOP;
	
	    
	    temp_val := mod(11-mod(temp_val,11),10);
	                                    
	    IF temp_val = flag_num THEN
	        result_msg := '유효';    
	    END IF;	       
	
	END IF; 

    RETURN result_msg;
END;
/
