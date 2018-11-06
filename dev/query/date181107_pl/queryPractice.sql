/*
숙제1.
제조사를 두개 입력받아 제조사에 해당하는 모든 차량의
제조국, 제조사,모델명,년식,가격,옵션을 조회 하세요.
출력은 가격의 오름차순으로 조회하였을 때 조회된 결과에
   3~6번째 레코드만  출력하세요.

현대, 기아를 입력하였을 때
출력 예
-----------------------------------------------------------------
번호 제조국  제조사  모델명  년식  가격   입력일
-----------------------------------------------------------------
1     국산     현대    아반테  2001  3,500 mm-dd-yyyy


-----------------------------------------------------------------
검색 결과 현대 [x]대, 기아 [x]대

현대 x대와 기아 x대는 검색 결과에 나온 대수만 카운트 합니다.
*/

SET serveroutput ON
SET verify OFF
 
ACCEPT maker1 PROMPT '제조사1 : '
ACCEPT maker2 PROMPT '제조사2 : '

DECLARE                  
  
	TYPE rec_car IS RECORD (
	  country car_country.country%TYPE,
	  maker car_maker.maker%TYPE,
	  model car_model.model%TYPE,
	  car_year car_model.car_year%TYPE,
	  price car_model.price%TYPE,
	  hiredate car_model.hiredate%TYPE	
	);                                    
	
	TYPE tab_car IS TABLE OF rec_car
	 INDEX BY BINARY_INTEGER;
	 
	arr_car tab_car;      
	idx NUMBER := 0;

	cnt_maker1 NUMBER := 0;
	cnt_maker2 NUMBER := 0;

BEGIN         

  -- 1. 처리(데이터 가져오기)
	FOR temp_rec IN 
		(SELECT country, maker, model, car_year, price, hiredate
		 FROM   (SELECT ROWNUM r, country, maker, model, car_year, price, hiredate
			       FROM (SELECT cc.country, cma.maker, cmo.model, cmo.car_year, cmo.price, cmo.hiredate
			             FROM   car_country cc, car_maker cma, car_model cmo
			             WHERE  (cma.maker = cc.maker AND cmo.model = cma.model) 
			              AND   (cma.maker = '&maker1' OR cma.maker = '&maker2')
		               ORDER BY price ASC))
		 WHERE r BETWEEN 3 AND 6	
		)
	LOOP  
	
		idx := idx + 1;
		arr_car(idx) := temp_rec;	
	
	END LOOP;
	
	
	-- 2. 데이터 보이기     
	IF arr_car.COUNT != 0 THEN
		
		DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
		DBMS_OUTPUT.PUT_LINE('번호 제조국 제조사 모델명 연식 가격 입력일');
		DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
		
		FOR i IN 1..arr_car.COUNT LOOP
		         
			DBMS_OUTPUT.PUT_LINE(' '||i||' '
												||arr_car(i).country||' '
												||arr_car(i).maker||' ' 
												||arr_car(i).model||' '
												||arr_car(i).car_year||' '
												||TO_CHAR(arr_car(i).price, '9,999')||' '
												||TO_CHAR(arr_car(i).hiredate,'mm-dd-yyyy'));
												
			IF arr_car(i).maker = '&maker1' THEN
				cnt_maker1 := cnt_maker1 + 1;
			END IF;
			
			IF arr_car(i).maker = '&maker2' THEN
				cnt_maker2 := cnt_maker2 + 1;		
			END IF;		
		END LOOP;
		
		DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');		
		DBMS_OUTPUT.PUT_LINE('검색 결과 &maker1 ['||cnt_maker1||']대, &maker2 ['||cnt_maker2||']대');     
	
	ELSE
	  DBMS_OUTPUT.PUT_LINE('&maker1 또는 &maker2 에 해당하는 제조사 정보는 없습니다.');
	END IF;

END;
/