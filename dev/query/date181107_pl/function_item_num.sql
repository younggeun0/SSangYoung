-- �Ű����� ���� �Լ� : �������� ����Ͽ� 10�ڸ��� 
-- 1�� �����ϴ� ���������� ���ڿ��� ��ȯ�ϴ� �Լ�
-- �������� ���� : 'ITEM_00001'

CREATE OR REPLACE FUNCTION item_num
RETURN CHAR
IS
	temp_num CHAR(10);
	seq_num NUMBER;
	
BEGIN
    
--	SELECT seq_item.nextval
--	INTO seq_num
--	FROM dual;      
	              
	-- oracle 11g���� �Լ����� ������ ��� ��
	-- �������� �ٷ� ��뵵 �����ϴ�
	seq_num := seq_item.nextval;
	
	temp_num := 'ITEM_'||LPAD(seq_num,5,0);  
	-- temp_num := temp_num||���ڿ� �ϰԵǸ�
	-- temp_num�� CHAR(10)�� �ڿ� +@ �� �ٰ� �Ǿ� �����÷ο� �߻�
	
	RETURN temp_num;
	
END;
/
