-- �������� ��ȸ�� �� ����ϴ� CURSOR
-- dept ���̺��� ��� ���ڵ带 ��ȸ�ϴ� CURSOR
SET serveroutput ON

DECLARE   
	-- ���� : CURSOR Ŀ���� IS (SELECT...);
	CURSOR cur_dept IS
	 SELECT deptno, dname, loc FROM dept;
	 
	-- ��ȸ����� ������ ������ ����
	deptno dept.deptno%TYPE;
	dname dept.dname%TYPE;
	loc dept.loc%TYPE;
	
	dept_data dept%ROWTYPE;
BEGIN       

  -- ����   
  DBMS_OUTPUT.PUT_LINE('Ŀ���� ��');
	OPEN cur_dept;
  
 	-- ����
  LOOP
  	-- INTO���� ���������� ����Ͽ� ó��
  	FETCH cur_dept INTO deptno, dname, loc; 
  	 
  	EXIT WHEN (cur_dept%NOTFOUND);	       
  	
		DBMS_OUTPUT.PUT_LINE(deptno||' '
											 ||dname||' '
											 ||loc);  
  END LOOP;  
  
  DBMS_OUTPUT.PUT_LINE('��ȸ�� ���ڵ� �� : '||cur_dept%ROWCOUNT); 
  
  IF cur_dept%ISOPEN THEN
  	-- Ŀ���� �����ִٸ� ���� Ŀ���� �ݰ�
  	DBMS_OUTPUT.PUT_LINE('Ŀ���� ���� ����');
  	CLOSE cur_dept; 
  	DBMS_OUTPUT.PUT_LINE('Ŀ���� ����');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Ŀ���� ���� ����');
  END IF;     
  
  -- ����
  DBMS_OUTPUT.PUT_LINE('Ŀ���� �ٽ� ��');
	OPEN cur_dept;
  
  LOOP
  	-- ����   
  	-- INTO���� ���ڵ� ������ ����Ͽ� ó��
  	FETCH cur_dept INTO dept_data;
  
  	EXIT WHEN (cur_dept%NOTFOUND);                                
		
		DBMS_OUTPUT.PUT_LINE(dept_data.deptno||' '
											 ||dept_data.dname||' '
											 ||dept_data.loc);  
  END LOOP;                            

  DBMS_OUTPUT.PUT_LINE('��ȸ�� ���ڵ� �� : '||cur_dept%ROWCOUNT); 

  CLOSE cur_dept;

  -- �ݱ�
  IF cur_dept%ISOPEN THEN
  	DBMS_OUTPUT.PUT_LINE('Ŀ���� ���� ����');
  	CLOSE cur_dept;    
    DBMS_OUTPUT.PUT_LINE('Ŀ���� ����');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Ŀ���� ���� ����');
  END IF;
END;
/