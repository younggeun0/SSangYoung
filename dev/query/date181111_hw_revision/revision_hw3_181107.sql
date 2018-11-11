/*              
3. 주민번호를 입력받아 출생지역을 반환하는 함수 작성
   출생지역은  880101-1xx1111 에서 xx 두자리 이고
   아래의 표와 같다.
    서울시 : 00~08
    부산시 : 09~12
    인천시 : 13~15
    경기도 : 16~25
    강원도 : 26~34
    충청도 : 35~47
    전라도 : 48~66
    경상도 : 67~92
    제주도 : 93~95         
*/

CREATE OR REPLACE FUNCTION get_ht(ssn CHAR)
RETURN CHAR
IS
	flag NUMBER;
	ht CHAR(9);
BEGIN          

	IF CHECK_SSN(ssn) = 'success' THEN
	
		flag := SUBSTR(ssn, 9, 2);
		
		IF flag BETWEEN 0 AND 8 THEN
			ht := '서울시';
		ELSIF flag BETWEEN 09 AND 12 THEN
            ht := '부산시';    
        ELSIF flag BETWEEN 13 AND 15 THEN
            ht := '인천시';
        ELSIF flag BETWEEN 16 AND 25 THEN
            ht := '경기도';    
        ELSIF flag BETWEEN 26 AND 34 THEN
            ht := '강원도';    
        ELSIF flag BETWEEN 35 AND 47 THEN
            ht := '충청도';    
        ELSIF flag BETWEEN 48 AND 66 THEN
            ht := '전라도';    
        ELSIF flag BETWEEN 67 AND 92 THEN
            ht := '경상도';    
        ELSIF flag BETWEEN 93 AND 95 THEN
            ht := '제주도';    
        END IF;	
	                
		RETURN ht;
	
	ELSE
		ht := '조회X';
		RETURN ht;
	END IF;

END;
/
