-- �����ȣ�� �Է¹޾� �����, ����, ����, �Ի���, �μ���ȣ�� ��ȸ
-- ��, ������ 2000�̸��̶�� ������ 2�踦 �����Ͽ� ����ϰ� 
-- �μ���ȣ�� 10���� 20�� �̶�� �Ի����� ��-��-���� ��������
-- �׷��� �ʴٸ� ��-��-�� �������� ����ϼ���. 

SET serveroutput ON
SET verify OFF                                  

ACCEPT empno PROMPT '�����ȣ : '             

DECLARE
	i_empno emp.empno%TYPE := &empno;
	ename emp.ename%TYPE;
	sal emp.sal%TYPE;
	job emp.job%TYPE;
	hiredate emp.hiredate%TYPE;
	deptno emp.deptno%TYPE;
	
	date_format VARCHAR2(30) := 'yyyy-mm-dd';
BEGIN

	SELECT ename, sal, job, hiredate, deptno
	INTO ename, sal, job, hiredate, deptno
	FROM  emp
	WHERE empno = i_empno;                                     
	         
	-- ������ 2000�̸��� ����� ���� ó��
	IF sal < 2000 THEN
		sal := sal * 2;
	END IF;
	
	-- �μ���ȣ�� ���� ��¥ ������� ���� (mm-dd-yyyy)
	IF deptno IN (10, 20) THEN
  	date_format := 'mm-dd-yyyy';
	END IF;
                                               
	DBMS_OUTPUT.PUT_LINE(i_empno||'�� �������');
	DBMS_OUTPUT.PUT_LINE('����� : '||ename||', ���� : '||
											job||', ���� : '||sal||', �μ���ȣ : '||
											deptno||', �Ի��� : '
											||TO_CHAR(hiredate, date_format));
										
										
	EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('�Է��Ͻ� ['||i_empno
												||']�� ����� �������� �ʽ��ϴ�..');

END;
/   