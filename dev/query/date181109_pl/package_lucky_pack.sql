CREATE OR REPLACE PACKAGE lucky_pack
AS           
	-- 행운의 수(1~45) 중 하나를 얻는 함수         
   FUNCTION lucky_num RETURN NUMBER;  
   
   -- 귀인얻기 프로시저
   PROCEDURE lucky_name(name OUT VARCHAR2); 
   
   -- 생년월일 , 성별을 입력받아 주민번호를 생성하여
   -- out parameter에 설정하는 프로시저를 작성
   PROCEDURE get_ssn(birthdate CHAR, gender VARCHAR2, ssn OUT CHAR);
   
END;
/
