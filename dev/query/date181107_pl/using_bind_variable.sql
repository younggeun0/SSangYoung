-- BIND ���� ���
-- 1. BIND ���� ���� : VAR[VARIABLE] ������ ��������(ũ��)
VAR name VARCHAR2(30);
-- VARIABLE name VARCHAR2(30); -- VAR�� VARIABLE �� �� ����
VARIABLE age NUMBER;

VAR;

SET serveroutput ON
-- 2. BIND���� �� �Ҵ� :������

DECLARE
  name VARCHAR2(30);
BEGIN

	name := '�׽�Ʈ';

  -- 3. ���ε庯���� �� �Ҵ�
  -- ':'������ �ۿ� �ִ� ����
	:name :=	name||'�� �ȳ�';
  :age := 20;

  DBMS_OUTPUT.PUT_LINE(name||' '||:name||' '||:age);

END;
/
	-- 4.���ε庯���� �� ���
	PRINT name age
