/*
    차량 모델을 입력받아 car_model 테이블에서
    제조국, 제조사, 연식, 가격, 옵션, 입력일을 조회.
    
    출력
    XXXX 모델 검색 결과
    -------------------------------------------------------------
    제조국 제조사  연식    가격     입력일            옵션
  -------------------------------------------------------------
                  2010    1,990    월-일-년 분기     처음,까지만 조회
  															(년은 2자리만 조회)

    -------------------------------------------------------------
    검색 대수 [x] 대

    가격의 오름차순 정렬하여 조회
    (커서, 레코드와 테이블을 모두 사용)

*/
SET serveroutput ON
SET verify OFF    

	ACCEPT model PROMPT '차량 모델을 입력하세요 : '

DECLARE                                          

	-- 조회된 행을 저장하로 사용하기 위한 레코드 타입 선언
	TYPE rec_car IS RECORD (
		country car_country.country%TYPE,
		maker car_country.maker%TYPE,
		car_year car_model.car_year%TYPE,
		price car_model.price%TYPE,
		car_option car_model.car_option%TYPE,
		hiredate VARCHAR2(10)	
	);      
	
	-- 선언된 레코드로 테이블을 생성
	TYPE tab_car IS TABLE OF rec_car
	 INDEX BY BINARY_INTEGER;
	                  
	-- 처음 , 까지만 출력하기위해 옵션을 저장하는 변수
	car_option car_model.car_option%TYPE;
	-- 전체 검색수를 저장하기 위한 변수
	search_cnt NUMBER := 0; 
	 
	arr_car tab_car;
	
	idx NUMBER := 0; 

BEGIN
  
	-- 검색된 결과를 테이블에 저장 (사용할 데이터 생성)
	FOR rec_temp IN (SELECT cc.country, cc.maker, cmo.car_year, 
													cmo.price, 
													cmo.car_option, 
												  TO_CHAR(cmo.hiredate, 'mm-dd-yy q') hiredate
									 FROM car_model cmo, car_maker cma, car_country cc
									 WHERE (cma.maker = cc.maker AND cmo.model = cma.model)
									 	AND cmo.model = '&model'
									 ORDER BY cmo.price) 
	LOOP
		idx := idx + 1;          
		arr_car(idx) := rec_temp;
	END LOOP;     
	  
	search_cnt := idx;
	
	-- 생성된 데이터를 사용하여 출력 형식을 만들어 출력
	IF search_cnt != 0 THEN
		DBMS_OUTPUT.PUT_LINE('------------------------------------------------------'); 
		DBMS_OUTPUT.PUT_LINE('제조국 제조사 연식 가격  입력일     옵션');
		DBMS_OUTPUT.PUT_LINE('------------------------------------------------------'); 
		
		FOR i IN 1 .. arr_car.COUNT LOOP
			car_option := arr_car(i).car_option; 
			                         
			-- INSTR함수는 해당 문자를 못 찾으면 0이 나옴(,가 없는 옵션도 출력하고자 함)
			IF INSTR(car_option, ',') > 0 THEN
				car_option := SUBSTR(car_option, 1, INSTR(car_option, ',')-1);  
			END IF;                                   
		
			DBMS_OUTPUT.PUT_LINE(arr_car(i).country||'   '
													||arr_car(i).maker||'   '
													||arr_car(i).car_year||' '
													||TO_CHAR(arr_car(i).price, '9,999')||' '
													||arr_car(i).hiredate||' '
													||car_option);
		
		END LOOP;
		
		DBMS_OUTPUT.PUT_LINE('------------------------------------------------------');
	  DBMS_OUTPUT.PUT_LINE('검색 대수 ['||search_cnt||'] 대');
  ELSE
  	DBMS_OUTPUT.PUT_LINE('&model 해당 모델에 대한 결과가 없습니다..');
  END IF;         
END;
/
