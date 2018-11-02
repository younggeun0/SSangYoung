/*
2. 학생들의 정보를 처리하는 PL/SQL작성.
   번호, 이름, 오라클점수,자바점수,총점,평균 을 저장할 수있는 record를
   만들고 아래의 데이터를 입력한 후
   반복문을 사용하여  총점,평균을 처리하는 PL/SQL 작성
  1, 김정운, 80,81
  2, 김희철, 94,80
  3, 이재찬, 97,96
  4, 박영민, 86,92
  5, 정택성, 76,99

 출력
   번호, 이름, 오라클점수,자바점수,총점,평균
  .
  .
  .
  자바최고점수 [xx] 오라클 최고점수 [xxx]

*/
SET serveroutput ON

DECLARE
	TYPE stu_rec IS RECORD (
		num NUMBER,
		name VARCHAR2(15),
		oracle_score NUMBER(3),
		java_score NUMBER(3),
		total NUMBER(3),
		avg_score NUMBER(3,1)
	);                   
	
	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;
	
	class4 stu_tab;
	
	java_top_score NUMBER(3) := 0;
	oracle_top_score NUMBER(3) := 0;

BEGIN  

	class4(1).num := 1;
	class4(1).name := '김정운';
	class4(1).oracle_score := 80;
	class4(1).java_score := 81;
	
	class4(2).num := 2;
	class4(2).name := '김희철';
	class4(2).oracle_score := 94;
	class4(2).java_score := 80;
	
	class4(3).num := 3;
	class4(3).name := '이재찬';
	class4(3).oracle_score := 97;
	class4(3).java_score := 96;     
	
	class4(4).num := 4;
	class4(4).name := '박영민';
	class4(4).oracle_score := 86;
	class4(4).java_score := 92;
	
	class4(5).num := 5;
	class4(5).name := '정택성';
	class4(5).oracle_score := 76;
	class4(5).java_score := 99;
                            
	FOR i IN 1 .. class4.COUNT LOOP
	
		class4(i).total := class4(i).oracle_score + class4(i).java_score;
		class4(i).avg_score := class4(i).total/2;
		
		DBMS_OUTPUT.PUT_LINE(class4(i).num||' '
												||class4(i).name||' '
												||class4(i).oracle_score||' '   
												||class4(i).java_score||' '
												||class4(i).total||' '
												||class4(i).avg_score);   
												
		IF class4(i).java_score > java_top_score THEN 
			java_top_score := class4(i).java_score;
		END IF;									                 
		
		If class4(i).oracle_score > oracle_top_score THEN
			oracle_top_score := class4(i).oracle_score;
		END IF;
	END LOOP;                                    
	
	DBMS_OUTPUT.PUT_LINE('java top : '||java_top_score
											||', oracle top : '||oracle_top_score);
END;
/