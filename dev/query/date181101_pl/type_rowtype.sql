
SET serveroutput ON

DECLARE
-- ���̺��� �÷��� �����Ͽ� ������ ���� �� �ִ�
	e_name emp.ename%TYPE;

-- ���̺��� ��� �÷��� �����Ͽ� ���� ����(RECORD TYPE)
	row_type cp_emp%ROWTYPE;     
	r cp_emp%ROWTYPE;

BEGIN
	e_name := '������';

-- RECORD TYPE ���� ��� : ������.�÷���
    row_type.empno := 1234;
    row_type.ename := 'young';
    row_type.hiredate := '1990-12-06';
    row_type.sal := 5000;
	DBMS_OUTPUT.PUT_LINE(e_name||'��');

	DBMS_OUTPUT.PUT_LINE(row_type.empno||'��, '
		||row_type.ename||'�� ������ '||TO_CHAR(row_type.hiredate,'yyyy')||'�� '
		||row_type.sal||'������ ������ �޴´�.');
		
	r.empno := 1111;
	r.ename := '���ü�';
	r.hiredate := SYSDATE;
	r.sal := 2800;
	
	DBMS_OUTPUT.PUT_LINE('�����ȣ : '||r.empno
	||', ����� : '||r.ename||', �Ի��� : '
	||TO_CHAR(r.hiredate, 'yyyy"��" mm"��" dd"��"')||
	', ���� : '||r.sal);	

END;
/

