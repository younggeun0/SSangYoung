/*
1.차량 모델을 입력받아 car_model 테이블에서
	연식, 가격, 옵션, 입력일을 조회.

	출력
	XXXX 모델 검색 결과
	-------------------------------------------------------------
	연식    가격     입력일            옵션
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

ACCEPT i_model PROMPT '모델 : '

DECLARE
	CURSOR cur_car IS
	 SELECT model, car_year, TO_CHAR(hiredate,'mm-dd-yy'),
	 	    TO_CHAR(price,'9,999'), car_option
	 FROM car_model
	 WHERE model = '&i_model'
	 ORDER BY price;

	TYPE rec_car IS RECORD(
	  model car_model.model%TYPE,
	  car_year car_model.car_year%TYPE,
	  hiredate VARCHAR2(10),
	  price car_model.price%TYPE,
	  car_option car_model.car_option%TYPE
	);

	TYPE tab_car IS TABLE OF rec_car
	 INDEX BY BINARY_INTEGER;

	rec_data rec_car;
	arr_car tab_car;
	i NUMBER := 0;
BEGIN
	IF cur_car%ISOPEN THEN
		CLOSE cur_car;
	END IF;
	OPEN cur_car;

	LOOP
		FETCH cur_car INTO rec_data;

		EXIT WHEN cur_car%NOTFOUND;
		i := i + 1;
		arr_car(i) := rec_data;
	END LOOP;

	IF cur_car%ROWCOUNT = 0 THEN
		DBMS_OUTPUT.PUT_LINE('&i_model 해당 모델에 관한 데이터가 없습니다');
	ELSE
		DBMS_OUTPUT.PUT_LINE('&i_model 모델 검색 결과');
		DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
  	    DBMS_OUTPUT.PUT_LINE('연식 가격 입력일     옵션');
		DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');

		FOR i IN 1.. cur_car%ROWCOUNT LOOP
			DBMS_OUTPUT.PUT_LINE(arr_car(i).car_year||' '
				||arr_car(i).price||' '||arr_car(i).hiredate||' '
				||arr_car(i).car_option);
		END LOOP;

		DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
		DBMS_OUTPUT.PUT_LINE('검색대수 : '||cur_car%ROWCOUNT);

	END IF;
END;
/
