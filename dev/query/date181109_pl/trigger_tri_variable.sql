-- trigger1 ���̺� ���ڵ� �߰���
-- trigger2 ���̺� trigger1�� �߰��� �̸���
-- class4_info ���̺��� ��ȣ�� 99���� �л��� ���̷� 
-- trigger2 ���̺� ���ڵ� �߰�

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


