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

CREATE OR REPLACE FUNCTION get_hometown(ssn CHAR)
RETURN CHAR
IS                                               

    h_code NUMBER;
    hometown CHAR(9);

BEGIN             
          
    IF CHECK_SSN(ssn) = 'success' THEN
        
        h_code := SUBSTR(ssn, 9, 2);
        
        IF h_code BETWEEN 0 AND 8 THEN
            hometown := '서울시';
        ELSIF h_code BETWEEN 09 AND 12 THEN
            hometown := '부산시';    
        ELSIF h_code BETWEEN 13 AND 15 THEN
            hometown := '인천시';
        ELSIF h_code BETWEEN 16 AND 25 THEN
            hometown := '경기도';    
        ELSIF h_code BETWEEN 26 AND 34 THEN
            hometown := '강원도';    
        ELSIF h_code BETWEEN 35 AND 47 THEN
            hometown := '충청도';    
        ELSIF h_code BETWEEN 48 AND 66 THEN
            hometown := '전라도';    
        ELSIF h_code BETWEEN 67 AND 92 THEN
            hometown := '경상도';    
        ELSIF h_code BETWEEN 93 AND 95 THEN
            hometown := '제주도';    
        END IF;
        
        RETURN hometown;
    
    ELSE                
        hometown := '조회X';
        RETURN hometown;
    END IF;

END;
/
