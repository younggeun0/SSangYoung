-- trigger1 테이블 레코드 추가시
-- trigger2 테이블에 trigger1에 추가된 이름과
-- class4_info 테이블의 번호가 99번인 학생의 나이로 
-- trigger2 테이블에 레코드 추가

CREATE OR REPLACE TRIGGER tri_variable
AFTER INSERT ON trigger1
FOR EACH ROW
DECLARE
	st_age NUMBER;
BEGIN

	SELECT age
	INTO st_age
	FROM class4_info
	WHERE num=99;
	
	INSERT INTO trigger2(name,age)
	VALUES(:new.name, st_age);

END;
/


