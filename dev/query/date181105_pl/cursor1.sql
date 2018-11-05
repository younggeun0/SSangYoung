SET serveroutput ON

DECLARE
	-- 1. ����
	CURSOR cur_dept IS
	  SELECT deptno, dname, loc
	  FROM dept;
           
	dept_data dept%ROWTYPE;	  
BEGIN      
  -- 2. ����
	OPEN cur_dept;
	
	LOOP
		-- 3. ����(Ŀ���� �����̸� ���ڵ��� �÷����� ���)
  	FETCH cur_dept INTO dept_data;
  	
  	EXIT WHEN(cur_dept%NOTFOUND);
  	
  	DBMS_OUTPUT.PUT_LINE(dept_data.deptno||' '||dept_data.dname
  											||' '||dept_data.loc);
	END LOOP;
	-- 4. �ݱ�
  CLOSE cur_dept;
END;
/	  