-- TRIGGER1 테이블을 감시하는 TRIGGER 생성
CREATE OR REPLACE TRIGGER test_trigger
AFTER INSERT OR DELETE OR UPDATE ON trigger1
FOR EACH ROW
BEGIN
	DBMS_OUTPUT.PUT_LINE('감시중');
	DBMS_OUTPUT.PUT_LINE('이전값 : '||:old.name||' '||:old.age);
	DBMS_OUTPUT.PUT_LINE('새로운 값 : '||:new.name||' '||:new.age);
END;
