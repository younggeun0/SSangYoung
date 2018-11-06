-- SELECT�� ���� ���� ��ȸ�ϰų� �� ���� ��ȸ�� �� ����ó��
-- �����ȣ�� �Է¹޾� cp_emp3���̺����� �ش� �����
-- �����, �μ���ȣ, ����, ���� ��ȸ�ϴ� PL/SQL

SET serveroutput ON
SET verify OFF

	ACCEPT empno PROMPT '�����ȣ : '

DECLARE
	i_empno number := &empno;
  
	TYPE rec_emp IS RECORD(
		ename cp_emp3.ename%TYPE,
		deptno cp_emp3.deptno%TYPE,
		job cp_emp3.job%TYPE,
		sal cp_emp3.sal%TYPE
	);
	
	emp_rec rec_emp;
BEGIN             

	SELECT ename, deptno, job, sal 
	INTO emp_rec
	FROM cp_emp3
	WHERE empno = i_empno;
	
	DBMS_OUTPUT.PUT_LINE(emp_rec.ename||' '
												||emp_rec.deptno||' '
												||emp_rec.job||' '
												||emp_rec.sal);

                                                
    EXCEPTION
--        WHEN TOO_MANY_ROWS THEN
--            DBMS_OUTPUT.PUT_LINE(i_empno||'�� ����� �� �� �̻� �����մϴ�.');
--        WHEN NO_DATA_FOUND THEN
--            DBMS_OUTPUT.PUT_LINE(i_empno||'�� ����� �������� �ʽ��ϴ�.'); 
--        WHEN OTHERS THEN
--          -- ��� ���ܸ� �� ó���� �� �ִ�.
--          -- �ֻ��� �����̱� ������ EXCEPTION���� ���� ���� �����ϰԵǸ�
--          -- ���� ����ó�� ��ü�� ���ܸ� ó���ϱ� ���� OTHERS�� ó���ϰ� ��
--            DBMS_OUTPUT.PUT_LINE('�ν����� ���� ����');                                            
          												
--    OTHERS�ȿ��� �񱳱������� sqlcode�� �̿��� ����ó���� �����ϴ�
		WHEN OTHERS THEN                                                     
			IF sqlcode = 100 THEN
				DBMS_OUTPUT.PUT_LINE('ã�� �����Ͱ� �����ϴ�..');
			END IF;  
			
			IF sqlcode = -1422 THEN
				DBMS_OUTPUT.PUT_LINE('�����ȣ�� �������� ����� ��ȸ�˴ϴ�.');
			END IF;
		
							
									
END;
/              
