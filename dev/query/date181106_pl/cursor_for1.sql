-- �����ȣ, �����, �Ի���, ������ ��ȸ
-- �Ի����� ��-��-�� �б��� ����
SET serveroutput ON

DECLARE
	-- 1.����
	CURSOR cur_emp IS 
	 SELECT empno, ename, 
	 				TO_CHAR(hiredate,'yyyy-mm-dd q') hiredate, sal
	 FROM   emp;
BEGIN                     
--	OPEN cur_emp; Ŀ���� �ι� ���� �� ���� ������ �����߻�
-- FOR�� ���۵Ǹ� Ŀ�� ������ �ڵ����� FETCH, CLOSE���� ����

  -- 2. FOR�� ����� ����(FETCH�� ������� �ʴ´�.)
	FOR emp_data IN cur_emp LOOP
		DBMS_OUTPUT.PUT_LINE(emp_data.empno||' '
												||emp_data.ename||' '
												||emp_data.hiredate||' '
												||emp_data.sal);	
	END LOOP;                                               
	
--	CLOSE cur_emp;
--  FOR�� ���������� ���� Ŀ���� ������ ������ �����߻�
END;
/           


  