-- �����ȣ, �����, ������ ����ڿ��� �Է¹޾� cp_emp2���̺�
-- �߰��ϴ� PL/SQL �ۼ�
-- ��, ������ 9000�̻� �ԷµǸ� 9000���� �����Ͽ� �߰�
-- �Ի����� �߰��Ǵ� ������ ��¥�� �߰�

SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '�����ȣ : '
ACCEPT ename PROMPT '����� : '
ACCEPT sal PROMPT '���� : '

DECLARE
	empno cp_emp2.empno%TYPE;
	ename cp_emp2.ename%TYPE;
	sal number:= &sal;

BEGIN

  empno := &empno;
  ename := '&ename';

	-- PL/SQL�� ���� ������ �Ŀ� SQL���� �����Ѵ�
	IF sal > 9000 THEN
		sal := 9000;
	END IF;

  INSERT INTO cp_emp2(empno, ename, sal, hiredate)
  VALUES(empno, ename, sal, SYSDATE);
                                    
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'�� �Է� ����');
	COMMIT;      
	DBMS_OUTPUT.PUT_LINE(empno||'�� ����� ������ '|| 
		sal||'�� �Է��Ͽ����ϴ�.');

	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('�����߻�');

END;
/