/*
SET serveroutput ON

DECLARE

	TYPE num_tab IS TABLE OF NUMBER INDEX BY BINARY_INTEGER; 
    
    nt num_tab;
	
BEGIN                                                       

	nt(1) := 10;
	nt(2) := 20;
	nt(3) := 30;	
	
	FOR i IN 1..nt.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(nt(i));
	END LOOP;

END;
/


--  테이블 : 인덱스를 가지며, 순차적으로 값을 저장하고 사용하는 데이터형
SET serveroutput ON

DECLARE
	
	-- 1. 테이블 데이터형 선언(테이블의 방의 데이터형이 무엇인지)
	TYPE num_tab IS TABLE OF NUMBER INDEX BY BINARY_INTEGER;        
	
	-- 2. 선언한 테이블데이터형으로 테이블 변수 생성
	age_arr num_tab;  
	total NUMBER := 0;                                                        
	
BEGIN    

	-- 3. 값 넣기 : 인덱스 사용
	DBMS_OUTPUT.PUT_LINE('table변수 방의 갯수 '||age_arr.COUNT); 
	
	age_arr(1) := 22;
	age_arr(2) := 33;
	age_arr(3) := 29;
	age_arr(4) := 27;
	
	DBMS_OUTPUT.PUT_LINE('table변수 방의 갯수 '||age_arr.COUNT);
	     
	-- 4. 
	FOR i IN 1.. age_arr.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(age_arr(i));
		total := total + age_arr(i);
	END LOOP;                       
	
	DBMS_OUTPUT.PUT_LINE('평균 나이 : '||TRUNC(total/age_arr.COUNT, 0));

END;
/


SET serveroutput ON

DECLARE

	TYPE VARCHAR2_tab IS TABLE OF 
	 VARCHAR2(60) 
	 INDEX BY BINARY_INTEGER;
	name_arr VARCHAR2_tab; 
	i NUMBER := 1;
	
BEGIN

	name_arr(1) := '오오오';
	name_arr(2) := '김민수';
	name_arr(3) := '홍길동';  
	name_arr(4) := '나나나';
	name_arr(5) := '홀롤로';
	
	DBMS_OUTPUT.PUT_LINE('방의 개수 : '||name_arr.COUNT);
	
	
	WHILE i <= name_arr.COUNT LOOP
	    
	    IF name_arr(i) = '홍길동' THEN
	    	DBMS_OUTPUT.PUT_LINE('홍길동은 두번 출력');
	    END IF; 
	    
		DBMS_OUTPUT.PUT_LINE(name_arr(i));
		i := i + 1;                         
	
	END LOOP;	


END;
/
 
SET serveroutput ON

DECLARE
	TYPE date_tab IS TABLE OF date INDEX BY BINARY_INTEGER;
	yob date_tab;
	
BEGIN
    
	yob(1) := '2018-01-22';
	yob(2) := '2013-03-12';
	yob(3) := '2014-01-22';
	
	FOR i IN 1 ..yob.COUNT LOOP
		
		DBMS_OUTPUT.PUT_LINE(yob(i));
	
	END LOOP;

END;
/

    
*/




































