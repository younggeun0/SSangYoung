-- �����ȣ, �����, ������ ����ڿ��� �Է¹޾� cp_emp2���̺�
-- ������ 5000�̻��̸� cp_emp3���̺� �߰��ϰ� 5000�̸��̶��
-- cp_emp2 ���̺� �߰��ϴ� PL/SQL �ۼ�
-- ��, cp_emp3 ���̺� �߰��Ǵ� ����� �μ� ��ȣ�� 10���μ��� �߰�

SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '�����ȣ : '
ACCEPT ename PROMPT '����� : '
ACCEPT sal PROMPT '���� : '

DECLARE
	empno cp_emp2.empno%TYPE;
	ename cp_emp2.ename%TYPE;
	sal NUMBER := &sal;
BEGIN

	empno := &empno;
	ename := '&ename';

	IF sal >= 5000 THEN
		INSERT INTO cp_emp3(empno, ename, sal, deptno)
		VALUES(empno, ename, sal, 10);
		DBMS_OUTPUT.PUT_LINE('������ 5000�̻��̹Ƿ� cp_emp3 ���̺� �߰�');
	ELSE
		INSERT INTO cp_emp2(empno, ename, sal, hiredate)
		VALUES(empno, ename, sal, SYSDATE);
		DBMS_OUTPUT.PUT_LINE('������ 5000�̸��̹Ƿ� cp_emp2 ���̺� �߰�');
	END IF;

	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'�� �Է¼���');
	COMMIT;

	EXCEPTION
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('Exception!');

END;
/
