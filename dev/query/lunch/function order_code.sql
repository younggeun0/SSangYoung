/* 주문 코드를 "OR_000000001"를 반환하는 함수(function order_code.sql) */
CREATE OR REPLACE FUNCTION order_code
RETURN CHAR
IS

BEGIN
	RETURN 'OR_'||LPAD(seq_order.nextval,9,0);
END;
/
