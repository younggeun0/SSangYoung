/* �ֹ� �ڵ带 "OR_000000001"�� ��ȯ�ϴ� �Լ�(function order_code.sql) */
CREATE OR REPLACE FUNCTION order_code
RETURN CHAR
IS

BEGIN
	RETURN 'OR_'||LPAD(seq_order.nextval,9,0);
END;
/
