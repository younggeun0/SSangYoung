/*
    ���� ���� �Է¹޾� car_model ���̺���
    ������, ������, ����, ����, �ɼ�, �Է����� ��ȸ.
    
    ���
    XXXX �� �˻� ���
    -------------------------------------------------------------
    ������ ������  ����    ����     �Է���            �ɼ�
  -------------------------------------------------------------
                  2010    1,990    ��-��-�� �б�     ó��,������ ��ȸ
  															(���� 2�ڸ��� ��ȸ)

    -------------------------------------------------------------
    �˻� ��� [x] ��

    ������ �������� �����Ͽ� ��ȸ
    (Ŀ��, ���ڵ�� ���̺��� ��� ���)

*/
SET serveroutput ON
SET verify OFF    

	ACCEPT model PROMPT '���� ���� �Է��ϼ��� : '

DECLARE                                          

	-- ��ȸ�� ���� �����Ϸ� ����ϱ� ���� ���ڵ� Ÿ�� ����
	TYPE rec_car IS RECORD (
		country car_country.country%TYPE,
		maker car_country.maker%TYPE,
		car_year car_model.car_year%TYPE,
		price car_model.price%TYPE,
		car_option car_model.car_option%TYPE,
		hiredate VARCHAR2(10)	
	);      
	
	-- ����� ���ڵ�� ���̺��� ����
	TYPE tab_car IS TABLE OF rec_car
	 INDEX BY BINARY_INTEGER;
	                  
	-- ó�� , ������ ����ϱ����� �ɼ��� �����ϴ� ����
	car_option car_model.car_option%TYPE;
	-- ��ü �˻����� �����ϱ� ���� ����
	search_cnt NUMBER := 0; 
	 
	arr_car tab_car;
	
	idx NUMBER := 0; 

BEGIN
  
	-- �˻��� ����� ���̺� ���� (����� ������ ����)
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
	
	-- ������ �����͸� ����Ͽ� ��� ������ ����� ���
	IF search_cnt != 0 THEN
		DBMS_OUTPUT.PUT_LINE('------------------------------------------------------'); 
		DBMS_OUTPUT.PUT_LINE('������ ������ ���� ����  �Է���     �ɼ�');
		DBMS_OUTPUT.PUT_LINE('------------------------------------------------------'); 
		
		FOR i IN 1 .. arr_car.COUNT LOOP
			car_option := arr_car(i).car_option; 
			                         
			-- INSTR�Լ��� �ش� ���ڸ� �� ã���� 0�� ����(,�� ���� �ɼǵ� ����ϰ��� ��)
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
	  DBMS_OUTPUT.PUT_LINE('�˻� ��� ['||search_cnt||'] ��');
  ELSE
  	DBMS_OUTPUT.PUT_LINE('&model �ش� �𵨿� ���� ����� �����ϴ�..');
  END IF;         
END;
/
