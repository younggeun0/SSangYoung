-- Triggering Event 비교
CREATE OR REPLACE TRIGGER event_compare
AFTER INSERT OR UPDATE OR DELETE ON trigger1
FOR EACH ROW
BEGIN
	IF INSERTING THEN                                   
	
		-- trigger2 테이블에 이름, 나이+1 을 추가         
		INSERT INTO trigger2(name, age)
		VALUES(:new.name, :new.age + 1);	
		
		-- TRIGGER에서는 transaction 명령을 사용할 수 없음
		-- COMMIT; error!
		    
	ELSIF UPDATING THEN
		
		-- trigger1 테이블에서 변경작업이 발생하면 
		-- trigger2 테이블에 이전이름과 나이를 추가
		INSERT INTO trigger2(name, age)
		VALUES(:old.name, :old.age);
	
	ELSIF DELETING THEN		       
	  -- trigger1 테이블에서 삭제작업이 발생하면
	  -- trigger2 테이블에서 같은 이름의 모든 레코드 삭제
	  DELETE FROM trigger2
	  WHERE name=:old.name;
	END IF;
END;                                             
