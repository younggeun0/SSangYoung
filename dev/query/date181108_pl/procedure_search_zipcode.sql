-- ���̸��� �Է¹޾� zipcode���̺��� �ּ� �˻��ϴ� PROCEDURE
-- �����ȣ�� �������� �������� �� ���� ���� ��ȸ�Ǵ� 
-- �����ȣ, �õ�, ����, ��, ������ ��� out parameter�� �Ҵ��ϰ� 
-- ��ȸ�� �����ȣ�� �Ǽ��� out parameter�� �Ҵ��� ��            

CREATE OR REPLACE PROCEDURE search_zipcode(
	i_dong VARCHAR2,   
	
	address OUT VARCHAR2,
	search_cnt OUT NUMBER
)
IS                
  -- 1. Ŀ�� ����
	CURSOR cur_zipcode IS
		SELECT   zipcode, sido, gugun, 
					   dong, NVL(bunji, '��������') bunji
		FROM     zipcode
		WHERE    dong LIKE i_dong||'%'
		ORDER BY zipcode;      
	  
	TYPE rec_zip IS RECORD(   
		-- �������� ���̺��.�÷���� ��� ���ٸ� �ν� ���ϴ� ���׹߻� ����
		-- zipcode zipcode.zipcode%TYPE,
		zip CHAR(7),                     
		-- ���� ����� ������ ���̺��� ���ٸ� ���̺��� �������� ���� �� ����
		-- zipcode CHAR(7)�� ���� �� �ؿ� ���̺��.�Ӽ����� ����.�Ӽ������� �νİ���.
		sido zipcode.sido%TYPE,
		gugun zipcode.gugun%TYPE,
		dong zipcode.dong%TYPE,
		bunji zipcode.dong%TYPE			
	);                       
	
	-- ������ �����͸� ������ ���ڵ� ����
	zip_data rec_zip;                    
	
	-- ���� ù ���ڵ带 ������ RECORD ����
	first_data rec_zip;                     
	
	-- ���� ù ���ڵ带 �˱����� �ε��� ����
	cnt NUMBER := 0;

BEGIN
             
  -- 2. Ŀ�� ����
  IF cur_zipcode%ISOPEN THEN
		CLOSE cur_zipcode;  
  END IF;             
  
  OPEN cur_zipcode;
  
  -- 3. ����
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
		address := i_dong||'�� �������� �ʽ��ϴ�.';	 
	END IF;                    	
	                 
	-- 4. Ŀ�� �ݱ�
	CLOSE cur_zipcode

	EXCEPTION
	WHEN invalid_cursor THEN
		address := 'Ŀ���� �߸��� ������ ����';
	WHEN others THEN
		address := sqlerrm;

END;
/

