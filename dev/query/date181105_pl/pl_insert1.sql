-- PL/SQL���� DML ���

SET serveroutput ON

DECLARE

BEGIN

	INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
	VALUES(3333, '���缮', 10, '������ְ�', 8000);

  -- ������ ���� �� ��� : �Ͻ���(������) Ŀ���� ���
  -- SQL(�Ͻ��� Ŀ��)
  -- INSERT�� �߰� ���� �ƴϸ� ���ܰ� �߻��ϹǷ�
  -- ���� �Ͻ��� Ŀ���� ����Ͽ� �߰��� ���� ���� ���� �ʿ����

	COMMIT;
  
  DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'�� �߰�');
  
  EXCEPTION
  WHEN OTHERS THEN
  	DBMS_OUTPUT.PUT_LINE('�����߻�');

END;
/