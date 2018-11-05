-- 여러행을 조회할 때 사용하는 CURSOR
-- dept 테이블의 모든 레코드를 조회하는 CURSOR
SET serveroutput ON

DECLARE   
	-- 선언 : CURSOR 커서명 IS (SELECT...);
	CURSOR cur_dept IS
	 SELECT deptno, dname, loc FROM dept;
	 
	-- 조회결과를 저장할 변수를 선언
	deptno dept.deptno%TYPE;
	dname dept.dname%TYPE;
	loc dept.loc%TYPE;
	
	dept_data dept%ROWTYPE;
BEGIN       

  -- 열기   
  DBMS_OUTPUT.PUT_LINE('커서를 염');
	OPEN cur_dept;
  
 	-- 인출
  LOOP
  	-- INTO절에 개별변수를 사용하여 처리
  	FETCH cur_dept INTO deptno, dname, loc; 
  	 
  	EXIT WHEN (cur_dept%NOTFOUND);	       
  	
		DBMS_OUTPUT.PUT_LINE(deptno||' '
											 ||dname||' '
											 ||loc);  
  END LOOP;  
  
  DBMS_OUTPUT.PUT_LINE('조회된 레코드 수 : '||cur_dept%ROWCOUNT); 
  
  IF cur_dept%ISOPEN THEN
  	-- 커서가 열려있다면 열린 커서를 닫고
  	DBMS_OUTPUT.PUT_LINE('커서가 열려 있음');
  	CLOSE cur_dept; 
  	DBMS_OUTPUT.PUT_LINE('커서를 닫음');
  ELSE
    DBMS_OUTPUT.PUT_LINE('커서가 닫혀 있음');
  END IF;     
  
  -- 열기
  DBMS_OUTPUT.PUT_LINE('커서를 다시 염');
	OPEN cur_dept;
  
  LOOP
  	-- 인출   
  	-- INTO절에 레코드 변수를 사용하여 처리
  	FETCH cur_dept INTO dept_data;
  
  	EXIT WHEN (cur_dept%NOTFOUND);                                
		
		DBMS_OUTPUT.PUT_LINE(dept_data.deptno||' '
											 ||dept_data.dname||' '
											 ||dept_data.loc);  
  END LOOP;                            

  DBMS_OUTPUT.PUT_LINE('조회된 레코드 수 : '||cur_dept%ROWCOUNT); 

  CLOSE cur_dept;

  -- 닫기
  IF cur_dept%ISOPEN THEN
  	DBMS_OUTPUT.PUT_LINE('커서가 열려 있음');
  	CLOSE cur_dept;    
    DBMS_OUTPUT.PUT_LINE('커서를 닫음');
  ELSE
    DBMS_OUTPUT.PUT_LINE('커서가 닫혀 있음');
  END IF;
END;
/