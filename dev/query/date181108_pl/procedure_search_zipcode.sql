-- 동이름을 입력받아 zipcode테이블의 주소 검색하는 PROCEDURE
-- 우편번호의 오름차순 정렬했을 때 가장 먼저 조회되는 
-- 우편번호, 시도, 구군, 동, 번지를 묶어서 out parameter에 할당하고 
-- 조회된 우편번호의 건수를 out parameter에 할당할 것            

CREATE OR REPLACE PROCEDURE search_zipcode(
	i_dong VARCHAR2,   
	
	address OUT VARCHAR2,
	search_cnt OUT NUMBER
)
IS                
  -- 1. 커서 선언
	CURSOR cur_zipcode IS
		SELECT   zipcode, sido, gugun, 
					   dong, NVL(bunji, '번지없음') bunji
		FROM     zipcode
		WHERE    dong LIKE i_dong||'%'
		ORDER BY zipcode;      
	  
	TYPE rec_zip IS RECORD(   
		-- 변수명이 테이블명.컬럼명과 모두 같다면 인식 못하는 버그발생 가능
		-- zipcode zipcode.zipcode%TYPE,
		zip CHAR(7),                     
		-- 위에 선언된 변수가 테이블명과 같다면 테이블을 참조하지 못할 수 있음
		-- zipcode CHAR(7)로 선언 시 밑에 테이블명.속성명이 변수.속성명으로 인식가능.
		sido zipcode.sido%TYPE,
		gugun zipcode.gugun%TYPE,
		dong zipcode.dong%TYPE,
		bunji zipcode.dong%TYPE			
	);                       
	
	-- 인출한 데이터를 저장할 레코드 변수
	zip_data rec_zip;                    
	
	-- 가장 첫 레코드를 저장한 RECORD 변수
	first_data rec_zip;                     
	
	-- 가장 첫 레코드를 알기위한 인덱스 변수
	cnt NUMBER := 0;

BEGIN
             
  -- 2. 커서 열기
  IF cur_zipcode%ISOPEN THEN
		CLOSE cur_zipcode;  
  END IF;             
  
  OPEN cur_zipcode;
  
  -- 3. 인출
  LOOP
		FETCH cur_zipcode INTO zip_data;
		EXIT WHEN cur_zipcode%NOTFOUND;
		
		cnt := cnt + 1;
		
		IF cnt = 1 THEN
			first_data := zip_data;
		END IF;
  END LOOP;
  
  search_cnt := cur_zipcode%ROWCOUNT;
	
	IF search_cnt != 0 THEN
	  address := first_data.zip||' '||first_data.sido||' '||
	  		first_data.gugun||' '||first_data.dong||' '||first_data.bunji;
	ELSE
		address := i_dong||'은 존재하지 않습니다.';	 
	END IF;                    	
	                 
	-- 4. 커서 닫기
	CLOSE cur_zipcode

	EXCEPTION
	WHEN invalid_cursor THEN
		address := '커서가 잘못된 연산을 수행';
	WHEN others THEN
		address := sqlerrm;

END;
/

