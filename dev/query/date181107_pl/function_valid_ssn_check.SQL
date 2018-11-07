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
	         
	total NUMBER := 0;
	valid_num NUMBER := 2;
	check_num NUMBER;         
	
BEGIN         

	FOR i IN 1..13 LOOP
		IF i != 7 THEN 
		    
			IF valid_num > 9 THEN 
				valid_num := 2;
			END IF;	    
			
			total := total + SUBSTR(ssn, i, 1) * (valid_num); 
			valid_num := valid_num + 1;		     
			                
		
		END IF;
	END LOOP;
	
	check_num := MOD(total, 11);
	check_num := 11 - check_num;
	check_num := MOD(check_num, 10);
	
	IF check_num = SUBSTR(ssn, 14, 1) THEN
		result_msg := '유효';	
	END IF;
 
	RETURN result_msg;
END;
/
