CREATE OR REPLACE PACKAGE ssn
AS
	-- 생년월일, 성별, 이름을 입력받아 주민번호를 생성하여
	-- out parameter에 설정하고 class4_info 테이블에 추가하는
	-- 프로시저 작성 
  PROCEDURE create_ssn(birthdate VARCHAR2, gender VARCHAR2, 
  	name VARCHAR2, ssn OUT CHAR);
END;
/
