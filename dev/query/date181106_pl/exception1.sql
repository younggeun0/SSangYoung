-- 아이디, 이름, 비밀번호를 입력받아 table_primary
-- 테이블에 레코드를 삽입하는 PL/SQL 작성

SET serveroutput ON
SET verify OFF

	ACCEPT name PROMPT '이름 : '
	ACCEPT id PROMPT '아이디 : '
	ACCEPT pw PROMPT '비밀번호 : '

DECLARE

	name table_primary.name%TYPE;
	id table_primary.id%TYPE := '&id';
	pw table_primary.pw%TYPE := '&pw';

BEGIN
	-- 문자열을 입력받아 입력받은 문자열의 길이가 
	-- 저장할 수 있는 크기가 아니라면 예외로는 처리할 수 없고
	-- 코드로 처리해야 됨
	
	IF LENGTH('&name') > 10 THEN
		DBMS_OUTPUT.PUT_LINE('입력가능한 글자수를 초과하였습니다');	
	ELSE
		name := '&name';                         
		
		INSERT INTO table_primary(name, id, pw)
		VALUES(name, id, pw);
	
		DBMS_OUTPUT.PUT_LINE('추가 성공했습니다.');
		COMMIT;
	END IF;

	
  EXCEPTION                                          
    -- 무결성  제약조건 위배 시(PK에 중복값 입력 시)
  	WHEN DUP_VAL_ON_INDEX THEN
			DBMS_OUTPUT.PUT_LINE('입력하신 '||id||'는 이미 사용중입니다.');  
			-- 예외처리 객체가 제공하는 메시지 : sqlerrm
			DBMS_OUTPUT.PUT_LINE( sqlerrm );
			-- 예외처리 객체가 제공하는 에러코드 : sqlcode   
			DBMS_OUTPUT.PUT_LINE( sqlcode );
                   
END;
/
