/* ���ö� �ڵ带 "L_00000001"�� ��ȯ�ϴ� �Լ� */
CREATE OR REPLACE FUNCTION lunch_code
RETURN CHAR
IS

BEGIN
	RETURN concat('L_', LPAD(seq_lunch.nextval,8,0));
END;
/
