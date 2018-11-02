/*
SET serveroutput ON
      
DECLARE
	TYPE rec IS RECORD (
		name VARCHAR2(10),
		addr VARCHAR2(10),
		age NUMBER
	);             
 	
 	data rec;
 	
BEGIN
    
	data.name := '오영근';
	data.addr := '서울';
	data.age := 29;
	
	DBMS_OUTPUT.PUT_LINE(data.name||' '||data.addr||' '||data.age);


END;
/ 

 
-- RECORD : 사용하고 싶은 데이터형을 묶어 하나의 데이터형으로 사용하는 것
SET serveroutput ON

DECLARE
    
    -- 1. 레코드 선언 : 레코드에 포함될 변수를 설정하는 것
	TYPE score_record IS RECORD (
		num NUMBER(4),
		name VARCHAR2(30),
		oracle_score NUMBER(3),
		java_score NUMBER(3)	
	);                       
	
	-- 2. 레코드로 변수 생성
	student score_record;

BEGIN                     

  -- 3. 값 할당
	student.num := 0001;
	student.name := 'young';
	student.oracle_score := 88;
	student.java_score := 60;
	
	-- 4. 값 사용
	DBMS_OUTPUT.PUT_LINE('번호 : '||student.num||', 이름 : '
										||student.name||', 오라클점수 : '
										||student.oracle_score||', 자바점수 : '
										||student.java_score||', 총점 : '
										||(student.oracle_score+student.java_score));
      

END;
/
    

-- 사원번호, 사원명, 입사일을 저장할 수 있는 레코드 만들기
SET serveroutput ON

DECLARE

	TYPE emp_rec IS RECORD (
		empno emp.empno%TYPE,
		ename emp.ename%TYPE,
		hiredate emp.hiredate%TYPE,
		sal emp.sal%TYPE
	);                          
	
	emp1 emp_rec;
	emp2 emp_rec;

BEGIN              

	emp1.empno := 0001;
	emp1.ename := 'young';
	emp1.hiredate := '2018-01-01'; 
  emp1.sal := 5000;
	
	emp2.empno := 0002;
	emp2.ename := 'sol';
	emp2.hiredate := '2018-02-02';
	emp2.sal := 6000;    
                                    
	DBMS_OUTPUT.PUT_LINE(emp1.empno||' '||emp1.ename||' '||emp1.hiredate||' '||emp1.sal);               
	DBMS_OUTPUT.PUT_LINE(emp2.empno||' '||emp2.ename||' '||emp2.hiredate||' '||emp2.sal);
	
END;
/       

*/     


SET serveroutput ON

DECLARE

	TYPE emp_rec IS RECORD (
		empno emp.empno%TYPE,
		ename emp.ename%TYPE,
		hiredate emp.hiredate%TYPE,
		sal emp.sal%TYPE
	);         
	
	TYPE emp_tab IS TABLE OF 
	 emp_rec
	 INDEX BY BINARY_INTEGER;                 
	
	employee emp_tab;

BEGIN              
         
  employee(1).empno := 0001;       
	employee(1).ename := 'young';
	employee(1).hiredate := '2018-01-01';
	employee(1).sal := 5000;  
	
	employee(2).empno := 0002;
	employee(2).ename := 'song';
	employee(2).hiredate := '2018-02-01';
	employee(2).sal := 6000;          
	
	FOR i IN 1..employee.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(employee(i).empno||' '
												||employee(i).ename||' '
												||employee(i).hiredate||' '
												||employee(i).sal);
	END LOOP;
	               
	DBMS_OUTPUT.PUT_LINE('입사한 개월차 : '
						||MONTHS_BETWEEN(employee(2).hiredate, employee(1).hiredate));
	DBMS_OUTPUT.PUT_LINE('연봉차 : '||ABS(employee(1).sal - employee(2).sal)); 

END;
/       
  
