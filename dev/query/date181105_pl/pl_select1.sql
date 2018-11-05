-- cp_emp2���� �����ȣ�� 7566�� �����
-- �����, �Ի���, ������ ��ȸ�Ͽ� ����ϴ� PL/SQL
SET serveroutput ON

DECLARE
	ename cp_emp2.ename%TYPE;
	input_date VARCHAR2(10);
	sal cp_emp2.sal%TYPE;
BEGIN

	SELECT ename, TO_CHAR(hiredate, 'yyyy-mm-dd'), sal
	INTO ename, input_date, sal
	FROM cp_emp2
	WHERE empno = 7566;

	DBMS_OUTPUT.PUT_LINE(ename||' / ' ||input_date||' / '
												||sal||' / '||SQL%ROWCOUNT);  

	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('�����߻�');

END;
/

