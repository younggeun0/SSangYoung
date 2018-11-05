-- �μ���ȣ�� �Է¹޾� �ش�μ��� �ٹ��ϴ� 
-- �����ȣ, �����, ����, �Ի����� ��ȸ�ϰ�, 
-- ��ȸ�� �� �� ��� ����, �������� ���Ͻÿ�.

SET serveroutput ON
SET verify OFF

ACCEPT deptno PROMPT '�μ���ȣ : '

DECLARE
	CURSOR cur_emp IS 
	 SELECT empno, ename, sal, 
	 	      TO_CHAR(hiredate, 'yyyy-mm-dd') hiredate
	 FROM   emp
	 WHERE  deptno = &deptno; 
	 
	TYPE rec_emp IS RECORD (
		empno	emp.empno%TYPE,
		ename emp.ename%TYPE,
		sal emp.sal%TYPE,
		hiredate VARCHAR2(10)
	);
	
	-- ���̺� ���� (������ ó���� �����ִ� �κ��� �и���Ű�� ����)
	TYPE tab_emp IS TABLE OF rec_emp
		INDEX BY BINARY_INTEGER; 
  
  emp_data rec_emp;                             
  arr_emp tab_emp; 
  
	total_sal NUMBER := 0; 
	i NUMBER := 0;
	
BEGIN
	
	IF cur_emp%ISOPEN THEN
		CLOSE cur_emp;
	END IF;
	
	OPEN cur_emp;
	
	-- ������ ó���ϴ� �κ�	
	LOOP
		FETCH cur_emp INTO emp_data;
		
		EXIT WHEN cur_emp%NOTFOUND;
		
		i := i+1;
		arr_emp(i) := emp_data;
	END LOOP;                           
                               
	-- ȭ�� �����ϴ� �κ�
	IF i != 0 THEN
		DBMS_OUTPUT.PUT_LINE('�����ȣ �����  ����   �Ի���');

		FOR idx IN 1 .. arr_emp.COUNT LOOP		
			DBMS_OUTPUT.PUT_LINE(arr_emp(idx).empno||
												' '||arr_emp(idx).ename||
												' '||arr_emp(idx).sal||
												' '||arr_emp(idx).hiredate);
												
			total_sal := total_sal + arr_emp(idx).sal;  
		END LOOP;                                   
		
		DBMS_OUTPUT.PUT(&deptno||'�� �μ� ����� : '||cur_emp%ROWCOUNT);	
		DBMS_OUTPUT.PUT_LINE(', ������ : '||total_sal);		
	ELSE
	  DBMS_OUTPUT.PUT_LINE(&deptno||'�� �μ��� ����� �����ϴ�.');
	END IF;                                         

	CLOSE cur_emp;
END;
/