-- �μ� ��ȣ�� �Է¹޾� �ش� �μ��� ���� 
-- �����ȣ, �����, �Ի���, ������ ��ȸ
-- �Ի����� ��-��-�� �б��� ����   
-- �μ���ȣ�� 10,20,30�� �ƴ϶�� 
-- 10�� �μ��� ��ȸ�Ͽ� ����� ��

SET serveroutput ON 
SET verify OFF

ACCEPT deptno PROMPT '�μ���ȣ : '

DECLARE         
-- �Է°��� ���� IF���� ����� ���༳��(�� ����)�� 
-- DECLARE-BEGIN���̿��� �� �� ����
	i_deptno NUMBER(2) := &deptno;
BEGIN                     

	IF &deptno NOT IN (10, 20, 30) THEN
	  i_deptno := 10; 
	END IF; 
	
	FOR emp_data IN (SELECT empno, ename, 
													TO_CHAR(hiredate,'yyyy-mm-dd q') hiredate, sal
									 FROM   emp
									 WHERE  deptno = i_deptno) 
	LOOP								 
		DBMS_OUTPUT.PUT_LINE(emp_data.empno||' '
												||emp_data.ename||' '
												||emp_data.hiredate||' '
												||emp_data.sal);	
	END LOOP;            
	
END;
/         