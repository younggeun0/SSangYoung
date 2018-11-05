SET serveroutput ON

DECLARE
	-- 1. 선언
	CURSOR cur_dept IS
	  SELECT deptno, dname, loc
	  FROM dept;
           
	dept_data dept%ROWTYPE;	  
BEGIN      
  -- 2. 열기
	OPEN cur_dept;
	
	LOOP
		-- 3. 인출(커서가 움직이며 레코드의 컬럼값을 얻기)
  	FETCH cur_dept INTO dept_data;
  	
  	EXIT WHEN(cur_dept%NOTFOUND);
  	
  	DBMS_OUTPUT.PUT_LINE(dept_data.deptno||' '||dept_data.dname
  											||' '||dept_data.loc);
	END LOOP;
	-- 4. 닫기
  CLOSE cur_dept;
END;
/	  