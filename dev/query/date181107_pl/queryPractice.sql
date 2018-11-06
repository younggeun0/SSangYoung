/*
����1.
�����縦 �ΰ� �Է¹޾� �����翡 �ش��ϴ� ��� ������
������, ������,�𵨸�,���,����,�ɼ��� ��ȸ �ϼ���.
����� ������ ������������ ��ȸ�Ͽ��� �� ��ȸ�� �����
   3~6��° ���ڵ常  ����ϼ���.

����, ��Ƹ� �Է��Ͽ��� ��
��� ��
-----------------------------------------------------------------
��ȣ ������  ������  �𵨸�  ���  ����   �Է���
-----------------------------------------------------------------
1     ����     ����    �ƹ���  2001  3,500 mm-dd-yyyy


-----------------------------------------------------------------
�˻� ��� ���� [x]��, ��� [x]��

���� x��� ��� x��� �˻� ����� ���� ����� ī��Ʈ �մϴ�.
*/

SET serveroutput ON
SET verify OFF
 
ACCEPT maker1 PROMPT '������1 : '
ACCEPT maker2 PROMPT '������2 : '

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

  -- 1. ó��(������ ��������)
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
	
	
	-- 2. ������ ���̱�     
	IF arr_car.COUNT != 0 THEN
		
		DBMS_OUTPUT.PUT_LINE('-----------------------------------------------------------');
		DBMS_OUTPUT.PUT_LINE('��ȣ ������ ������ �𵨸� ���� ���� �Է���');
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
		DBMS_OUTPUT.PUT_LINE('�˻� ��� &maker1 ['||cnt_maker1||']��, &maker2 ['||cnt_maker2||']��');     
	
	ELSE
	  DBMS_OUTPUT.PUT_LINE('&maker1 �Ǵ� &maker2 �� �ش��ϴ� ������ ������ �����ϴ�.');
	END IF;

END;
/