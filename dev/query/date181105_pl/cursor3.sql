-- 부서번호를 입력받아 해당부서에 근무하는 
-- 사원번호, 사원명, 연봉, 입사일을 조회하고, 
-- 조회한 후 총 사원 수와, 연봉합을 구하시오.

SET serveroutput ON
SET verify OFF

ACCEPT deptno PROMPT '부서번호 : '

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
	
	-- 테이블 생성 (데이터 처리와 보여주는 부분을 분리시키기 위해)
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
	
	-- 데이터 처리하는 부분	
	LOOP
		FETCH cur_emp INTO emp_data;
		
		EXIT WHEN cur_emp%NOTFOUND;
		
		i := i+1;
		arr_emp(i) := emp_data;
	END LOOP;                           
                               
	-- 화면 구성하는 부분
	IF i != 0 THEN
		DBMS_OUTPUT.PUT_LINE('사원번호 사원명  연봉   입사일');

		FOR idx IN 1 .. arr_emp.COUNT LOOP		
			DBMS_OUTPUT.PUT_LINE(arr_emp(idx).empno||
												' '||arr_emp(idx).ename||
												' '||arr_emp(idx).sal||
												' '||arr_emp(idx).hiredate);
												
			total_sal := total_sal + arr_emp(idx).sal;  
		END LOOP;                                   
		
		DBMS_OUTPUT.PUT(&deptno||'번 부서 사원수 : '||cur_emp%ROWCOUNT);	
		DBMS_OUTPUT.PUT_LINE(', 연봉합 : '||total_sal);		
	ELSE
	  DBMS_OUTPUT.PUT_LINE(&deptno||'번 부서는 사원이 없습니다.');
	END IF;                                         

	CLOSE cur_emp;
END;
/