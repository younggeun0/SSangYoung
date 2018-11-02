/*
1.  class4 강의장의 학생들의 교통요금을 구하는  PL/SQL을 제작
   하고자한다.  대중교통수단 요금은 아래와 같으며 
   [버스 : 1200원,  지하철 :1250원]
   10키로를 초과하면 매4키로마다 100원의 요금 더 부과된다.  
  이 정보를 이용하여 아래 학생들의 데이터를 처리하세요
  데이터. 
  1, 김정운, 서울시 강남구 역삼동,      5키로, 버스
  2, 김희철, 인천시 남동구 구월동,      20키로, 지하철
  3, 이재찬, 인천시 부평구 부평동,     16키로, 지하철
  4, 박영민, 서울시 관악구 봉천동,     10키로, 지하철
  5, 정택성, 서울시 동대문구 동대문동, 8키로, 버스

   출력
   번호, 이름,  주소, 거리, 교통수단, 요금   
  
*/

SET serveroutput ON

DECLARE       

	TYPE stu_rec IS RECORD (
		num NUMBER,
		name VARCHAR(15),
		addr VARCHAR2(60),
		dis NUMBER,
		method VARCHAR2(10),
		fee NUMBER,
		extra_fee NUMBER 
	); 
	
	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;
	
	class4 stu_tab;  
	
	add_mount NUMBER;                
	
BEGIN  
	class4(1).num := 1;
	class4(1).name := '김정운';
	class4(1).addr := '서울시 강남구 역삼동';
	class4(1).dis := 5;
	class4(1).method := '버스';
	
	class4(2).num := 2;
	class4(2).name := '김희철';
	class4(2).addr := '인천시 남동구 구월동';
	class4(2).dis := 20;
	class4(2).method := '지하철';
	                    
	class4(3).num := 3;
	class4(3).name := '이재찬';
	class4(3).addr := '인천신 부평구 부평동';
	class4(3).dis := 16;
	class4(3).method := '지하철';
	                          
	class4(4).num := 4;
	class4(4).name := '박영민';
	class4(4).addr := '서울시 관악구 봉천동';
	class4(4).dis := 10;
	class4(4).method := '지하철';
	                         
	class4(5).num := 5;
	class4(5).name := '정택성';
	class4(5).addr := '서울시 동대문구 동대문동';
	class4(5).dis := 8;
	class4(5).method := '버스';

	DBMS_OUTPUT.PUT_LINE('번호   이름   주소            거리  교통수단  기본요금 추가요금');	          
	DBMS_OUTPUT.PUT_LINE('============================================================='); 
         
	FOR i IN 1 ..class4.COUNT LOOP
	
		IF class4(i).method = '버스' THEN
			class4(i).fee := 1200;
		ELSE 
			class4(i).fee := 1250;
		END IF;
		                       
		IF class4(i).dis > 10 THEN
			class4(i).extra_fee := class4(i).fee + (TRUNC((class4(i).dis-10)/4,0))*100;
		END IF;
		
		DBMS_OUTPUT.PUT_LINE(class4(i).num
											||'  '||class4(i).name
											||'  '||class4(i).addr
											||'  '||class4(i).dis
											||'  '||class4(i).method
											||'  '||class4(i).fee
											||'  '||NVL(class4(i).extra_fee, class4(i).fee));
	
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('=============================================================');
END;
/