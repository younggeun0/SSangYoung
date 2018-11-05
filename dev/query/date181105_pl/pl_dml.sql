-- �����ȣ, �����, �μ���ȣ, ������ �Է¹޾� cp_emp3 ���̺� �߰��ϴ� PL/SQL
-- ��, ����� ������ �μ���ȣ�� ���� ���� �������� �߰��Ѵ�.
-- 10�� �μ� - emp ���̺��� �����ȣ�� 7566�� ����� ���� ����,
-- 20�� �μ� - emp ���̺��� �����ȣ�� 7698�� ����� ���� ����,
-- 30�� �μ� - emp ���̺��� �����ȣ�� 7782�� ����� ���� ����,
-- �� �� �μ���ȣ�� �ԷµǸ� 7788 ����� �������� �߰�
SET serveroutput ON
                                           
ACCEPT empno PROMPT '�����ȣ �Է� : '
ACCEPT ename PROMPT '����� �Է� : '
ACCEPT deptno PROMPT '�μ���ȣ �Է� : '
ACCEPT job PROMPT '���� �Է� : ' 

DECLARE                         
	i_empno cp_emp3.empno%TYPE := &empno;
	i_ename cp_emp3.ename%TYPE := '&ename';
	i_deptno cp_emp3.deptno%TYPE := &deptno;
	i_job cp_emp3.job%TYPE := '&job';	
	
	sal cp_emp3.sal%TYPE;
	select_empno cp_emp.empno%TYPE := 7788;                       
	
BEGIN        
  
	-- �ԷµǴ� �μ���ȣ���� ������ ������ ��ȸ�ϱ� ���� 
	-- �����ȣ�� ����
	IF i_deptno = 10 THEN
		select_empno := 7566;  
	ELSIF i_deptno = 20 THEN
		select_empno := 7698;  
	ELSIF i_deptno = 30 THEN
	  select_empno := 7782;    
	END IF;
	
	-- ������ �����ȣ���� ������ ��ȸ
	SELECT sal
	INTO sal
	FROM emp
	WHERE empno = select_empno;
	
	-- ��ȸ�� �������� �߰� �۾�
	INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
	VALUES(i_empno, i_ename, i_deptno, i_job, sal);    
	
	DBMS_OUTPUT.PUT_LINE(i_empno||'�� ��������� �߰��Ͽ����ϴ�.');
	DBMS_OUTPUT.PUT_LINE(SQL%ROWCOUNT||'�� �Է� ����');
	COMMIT;
	
	EXCEPTION
	WHEN OTHERS THEN
	DBMS_OUTPUT.PUT_LINE('�����߻�');

END;
/