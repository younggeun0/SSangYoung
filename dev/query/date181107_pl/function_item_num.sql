-- 매개변수 없는 함수 : 시퀀스를 사용하여 10자리의 
-- 1씩 증가하는 고정길이형 문자열을 반환하는 함수
-- 고정길이 형식 : 'ITEM_00001'

CREATE OR REPLACE FUNCTION item_num
RETURN CHAR
IS
	temp_num CHAR(10);
	seq_num NUMBER;
	
BEGIN
    
--	SELECT seq_item.nextval
--	INTO seq_num
--	FROM dual;      
	              
	-- oracle 11g부턴 함수에서 시퀀스 사용 시
	-- 쿼리없이 바로 사용도 가능하다
	seq_num := seq_item.nextval;
	
	temp_num := 'ITEM_'||LPAD(seq_num,5,0);  
	-- temp_num := temp_num||문자열 하게되면
	-- temp_num이 CHAR(10)인 뒤에 +@ 더 붙게 되어 오버플로우 발생
	
	RETURN temp_num;
	
END;
/
