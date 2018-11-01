
-- 상품명과 고객등급, 가격을 입력받아
-- 고객등급이 '특별'이라면 
-- 상품 가격의  30% 할인된 가격으로 출력
-- "XX등급 고객님 XXX상품의 정가는 XX원입니다." 
-- 특별인 경우에는 아래의 메시지 출력
-- "상품가격 XX원 할인가 XX원" 


SET serveroutput ON
SET verify OFF
   
ACCEPT i_item_name PROMPT '상품명 :'
ACCEPT i_customer_grade PROMPT '고객등급 :'  
ACCEPT i_item_price PROMPT '가격 :'

DECLARE
	item_name VARCHAR2(30);
	customer_grade VARCHAR2(12);
	item_price NUMBER;
BEGIN       
	item_name := '&i_item_name';
	customer_grade := '&i_customer_grade';
	item_price := &i_item_price;          
	                            
	DBMS_OUTPUT.PUT_LINE(customer_grade||'등급 고객님 '||item_name||' 상품의 정가는 '||
						 TO_CHAR(item_price,'999,999,999,999')||'원입니다.');
	
	IF customer_grade='특급' THEN
		DBMS_OUTPUT.PUT_LINE('상품가격 '||TO_CHAR(item_price,'999,999,999,999')
							 ||'원, 할인가 '||TO_CHAR(item_price*0.7,'999,999,999,999')||'원');  
	END IF;

END;
/
               
