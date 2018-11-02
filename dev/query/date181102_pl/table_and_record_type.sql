/*
-- RECORD를 데이터형으로 사용한 TABLE
 
-- class4 학생들의 번호, 이름, 오라클 점수를 처리하는 PL/SQL 
SET serveroutput ON                  

DECLARE                                                     
  
	-- 학생 정보를 저장할 레코드 선언
	TYPE stu_rec IS RECORD (
		num	NUMBER,
		name VARCHAR2(30),
		oracle_score NUMBER(3)
	);                               
	
	-- 학생들의 정보를 저장할 테이블 선언
	TYPE stu_tab IS TABLE OF
	 stu_rec
	 INDEX BY BINARY_INTEGER;
	                    
	-- 학생들의 정보를 처리할 테이블타입을 사용한 변수 선언
	class4_tab stu_tab;
-- 이렇게 테이블 변수를 활용하면 다른 반 학생들의 정보를 저장할 테이블변수를 생성 가능
--	class3_tab stu_tab;
--	class2_tab stu_tab;
BEGIN    
  
	-- table 변수에 값 할당
	class4_tab(1).num := 1111;
	class4_tab(1).name := '오영근';
	class4_tab(1).oracle_score := 99;
	
	class4_tab(2).num := 2222;
	class4_tab(2).name := '홍길동';
	class4_tab(2).oracle_score := 77;
	
	class4_tab(3).num := 1112;
	class4_tab(3).name := '둘리';
	class4_tab(3).oracle_score := 55;
	
	class4_tab(4).num := 1113;
	class4_tab(4).name := '또치';
	class4_tab(4).oracle_score := 44;
	
	FOR i IN 1..class4_tab.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE('학번 : '||class4_tab(i).num
													||', 이름 : '||class4_tab(i).name
													||', 오라클 점수 : '||class4_tab(i).oracle_score);
	END LOOP;

END;
/ 

*/
SET serveroutput ON

DECLARE

	TYPE stu_rec IS RECORD(
	  num NUMBER,
	  name VARCHAR2(15),
	  oracle_score NUMBER(3)
	);                      
	
	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;
	 
	 class4_tab stu_tab; 
	 
	 total NUMBER := 0;

BEGIN                 

	class4_tab(1).num := 1;
	class4_tab(1).name := 'young';
	class4_tab(1).oracle_score := 100;
	
	class4_tab(2).num := 2;
	class4_tab(2).name := 'sol';
	class4_tab(2).oracle_score := 30;
	
	class4_tab(3).num := 3;
	class4_tab(3).name := 'su';
	class4_tab(3).oracle_score := 66;
	
	class4_tab(4).num := 4;
	class4_tab(4).name := 'jung';
	class4_tab(4).oracle_score := 33;
	
	DBMS_OUTPUT.PUT_LINE('응시 인원은 '||class4_tab.COUNT||'명 입니다..');
	
	DBMS_OUTPUT.PUT_LINE('번호   이름     오라클점수');
	DBMS_OUTPUT.PUT_LINE('===========================================');
	FOR i IN 1..class4_tab.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(class4_tab(i).num||'      '||class4_tab(i).name
												||'         '||class4_tab(i).oracle_score);
		total := total + class4_tab(i).oracle_score;
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('===========================================');
	DBMS_OUTPUT.PUT_LINE('    총점 : '||total||', 평균 : '||total/class4_tab.COUNT);

END;
/

