
SET serveroutput ON

DECLARE
-- 1. ���� ���� : ������ ��������(ũ��);
	name1 VARCHAR2(60);
	name2 VARCHAR2(60);
	temp VARCHAR2(60);

BEGIN
-- 2. �� �Ҵ� : ������ := ��;
	name1 := '������';
	name2 := '�ռּ�';
	temp := name1;
	name1 := name2;
	name2 := temp;

-- 3. ��� : ���, ��������, ���Ҵ�
	DBMS_OUTPUT.PUT_LINE('name1 : '||name1);
	DBMS_OUTPUT.PUT_LINE('name2 : '||name2);
END;
/
