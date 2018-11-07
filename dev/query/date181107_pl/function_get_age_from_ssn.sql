-- 입력된 주민번호에서 나이를 구하는 함수
-- 880101-1234567
-- 나이 : 현재년도 - 태어난해 + 1 (한국기준)
-- 8번째 자리수가 1,2면 19--  (한국인)
-- 8번째 자리수가 3,4면 20--  (한국인)
-- 8번째 자리수가 5,6면 19-- (외국인)
-- 8번째 자리수가 7,8면 20-- (외국인) 
-- 8번째 자리수가 0,9 18-- (한국인)  (생략..) 
-- 무효하면 0살을 반환

CREATE OR REPLACE FUNCTION get_age_from_ssn(ssn CHAR)
RETURN NUMBER
IS 
	age NUMBER := 0; 
	year_of_birth VARCHAR(4);
	yy CHAR(2);
	-- 판단기준으로 사용하는 flag 변수
	flag CHAR(1);
BEGIN             
    
    IF CHECK_SSN(ssn) = 'success' THEN
        
        -- 19일지 20일지 더 할지, 18일지 판단
        flag := SUBSTR(ssn, 8, 1);
        yy := SUBSTR(ssn,1,2);
                
    	IF flag IN (1,2,5,6) THEN
        	year_of_birth := '19'||yy;
		ELSIF flag IN (3,4,7,8) THEN
		    year_of_birth := '20'||yy;
		ELSIF flag IN (0, 9) THEN
			year_of_birth := '18'||yy;
		END IF;                            

		age := TO_CHAR(SYSDATE, 'yyyy') - year_of_birth + 1;
	ELSE
		age:= 0;	  
    END IF;

	RETURN age;

END;
/
