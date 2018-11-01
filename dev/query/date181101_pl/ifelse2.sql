-- 고객등급, 상품명, 가격을 입력받아 처리하는 PL/SQL작성
-- 출력은 고객 등급이 '특별' 또는 '일반'인 경우에만 프로그램이 실행되어 연산 수행
-- 특별고객은 상품할인은 상품가에 50%, 일반고객은 상품가에 30%로 계산하여 출력
SET serveroutput ON
SET verify OFF

ACCEPT i_customer_grade PROMPT '고객 등급 :'
ACCEPT i_item PROMPT '상품명 :'
ACCEPT i_price PROMPT '가격 :'

DECLARE
	customer_grade VARCHAR2(10);
	item VARCHAR2(30);
	price NUMBER;  
	salePrice NUMBER;
BEGIN            
	customer_grade := '&i_customer_grade';
	item := '&i_item';
	price := &i_price;
	
	IF customer_grade IN ('특별', '일반') THEN
		IF customer_grade='특별' THEN  
			salePrice := price*0.5;
		ELSE                  
			salePrice := price*0.7;                                                           
		END IF;   
		
		DBMS_OUTPUT.PUT_LINE('고객님의 등급은 '||customer_grade
							||'고 할인된'||item||'의 가격은 '||salePrice||'입니다.');
	END IF;

END;
/                                                    
