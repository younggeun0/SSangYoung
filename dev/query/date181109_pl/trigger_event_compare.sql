-- Triggering Event ��
CREATE OR REPLACE TRIGGER event_compare
AFTER INSERT OR UPDATE OR DELETE ON trigger1
FOR EACH ROW
BEGIN
	IF INSERTING THEN                                   
	
		-- trigger2 ���̺� �̸�, ����+1 �� �߰�         
		INSERT INTO trigger2(name, age)
		VALUES(:new.name, :new.age + 1);	
		
		-- TRIGGER������ transaction ����� ����� �� ����
		-- COMMIT; error!
		    
	ELSIF UPDATING THEN
		
		-- trigger1 ���̺��� �����۾��� �߻��ϸ� 
		-- trigger2 ���̺� �����̸��� ���̸� �߰�
		INSERT INTO trigger2(name, age)
		VALUES(:old.name, :old.age);
	
	ELSIF DELETING THEN		       
	  -- trigger1 ���̺��� �����۾��� �߻��ϸ�
	  -- trigger2 ���̺��� ���� �̸��� ��� ���ڵ� ����
	  DELETE FROM trigger2
	  WHERE name=:old.name;
	END IF;
END;                                             
