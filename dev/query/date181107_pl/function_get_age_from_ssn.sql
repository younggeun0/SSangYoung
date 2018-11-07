-- �Էµ� �ֹι�ȣ���� ���̸� ���ϴ� �Լ�
-- 880101-1234567
-- ���� : ����⵵ - �¾�� + 1 (�ѱ�����)
-- 8��° �ڸ����� 1,2�� 19--  (�ѱ���)
-- 8��° �ڸ����� 3,4�� 20--  (�ѱ���)
-- 8��° �ڸ����� 5,6�� 19-- (�ܱ���)
-- 8��° �ڸ����� 7,8�� 20-- (�ܱ���) 
-- 8��° �ڸ����� 0,9 18-- (�ѱ���)  (����..) 
-- ��ȿ�ϸ� 0���� ��ȯ

CREATE OR REPLACE FUNCTION get_age_from_ssn(ssn CHAR)
RETURN NUMBER
IS 
	age NUMBER := 0; 
	year_of_birth VARCHAR(4);
	yy CHAR(2);
	-- �Ǵܱ������� ����ϴ� flag ����
	flag CHAR(1);
BEGIN             
    
    IF CHECK_SSN(ssn) = 'success' THEN
        
        -- 19���� 20���� �� ����, 18���� �Ǵ�
        flag := SUBSTR(ssn, 8, 1);
        yy := SUBSTR(ssn,1,2);
                
    	IF flag IN (1,2,5,6) THEN
        	year_of_birth := '19'||yy;
		ELSIF flag IN (3,4,7,8) THEN
		    year_of_birth := '20'||yy;
		ELSIF flag IN (0, 9) THEN
			year_of_birth := '18'||yy;
		END IF;                            

		age := TO_CHAR(SYSDATE, 'yyyy') - year_of_birth + 1;
	ELSE
		age:= 0;	  
    END IF;

	RETURN age;

END;
/
