-- PL/SQL���� UPDATE ���
SET serveroutput ON

DECLARE
	cnt NUMBER;
BEGIN

	UPDATE cp_emp2
	SET sal = 3500
	WHERE empno = 5443;

	-- �Ͻ���(������) Ŀ�� SQL�� ����Ͽ� ������ ���� ���� ��´�
	cnt := SQL%ROWCOUNT;
	-- ����� ����� 1���϶��� Transcation�� �Ϸ��ϰ� �׷��� �ʴٸ�
	-- �۾��� ���.

	IF cnt = 1 THEN
  	DBMS_OUTPUT.PUT_LINE(cnt||'���� ����Ǿ����ϴ�');
		COMMIT;
	ELSE 
		DBMS_OUTPUT.PUT_LINE('��ȸ�� ����� �������̰ų� �����Ƿ� �����۾��� ����մϴ�..');
		ROLLBACK;
	END IF;



END;
/
