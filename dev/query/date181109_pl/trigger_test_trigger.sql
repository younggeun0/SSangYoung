-- TRIGGER1 ���̺��� �����ϴ� TRIGGER ����
CREATE OR REPLACE TRIGGER test_trigger
AFTER INSERT OR DELETE OR UPDATE ON trigger1
FOR EACH ROW
BEGIN
	DBMS_OUTPUT.PUT_LINE('������');
	DBMS_OUTPUT.PUT_LINE('������ : '||:old.name||' '||:old.age);
	DBMS_OUTPUT.PUT_LINE('���ο� �� : '||:new.name||' '||:new.age);
END;
