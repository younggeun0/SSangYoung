/*
1.���� ���� �Է¹޾� car_model ���̺���
    ����, ����, �ɼ�, �Է����� ��ȸ.

    ���
    XXXX �� �˻� ���
    -------------------------------------------------------------
    ����    ����     �Է���            �ɼ�
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

ACCEPT i_model PROMPT '���� ���� �Է��ϼ��� : '

DECLARE
	
	CURSOR cur_car IS 
		SELECT car_year, price, TO_CHAR(hiredate,'mm-dd-yy q') hiredate, 
			     SUBSTR(car_option, 1, INSTR(car_option, ',')-1) car_option
		FROM car_model
		WHERE model = '&i_model'
		ORDER BY price;              
	
	TYPE rec_car IS RECORD (
		car_year car_model.car_year%TYPE,
		price car_model.price%TYPE,
		hiredate VARCHAR2(10),
		car_option VARCHAR2(60)
	);                       
	
	TYPE tab_car IS TABLE OF rec_car
		INDEX BY BINARY_INTEGER;
	
	rec_data rec_car;
	arr_car tab_car;
	
	idx NUMBER := 0;	
	
BEGIN

	IF cur_car%ISOPEN THEN
		CLOSE cur_car;
	END IF;
	
	OPEN cur_car;  
	
  LOOP
		FETCH cur_car INTO rec_data;
		EXIT WHEN (cur_car%NOTFOUND);
		
		idx := idx + 1;
		arr_car(idx) := rec_data;   
  END LOOP;          
  
  IF arr_car.COUNT = 0 THEN
  	DBMS_OUTPUT.PUT_LINE('&i_model �̶� ���� �����ϴ�..');
  ELSE
  	DBMS_OUTPUT.PUT_LINE('&i_model �� �˻� ���');
  	DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------');
  	DBMS_OUTPUT.PUT_LINE('����  ����  �Է���         �ɼ�');
  	DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------');
  	
  	FOR i IN 1 .. arr_car.COUNT LOOP
  		DBMS_OUTPUT.PUT_LINE(arr_car(i).car_year||' '
  											||TO_CHAR(arr_car(i).price, '999,999')||' '
  											||arr_car(i).hiredate||' '
  											||arr_car(i).car_option);
  	END LOOP;
  	
  	DBMS_OUTPUT.PUT_LINE('--------------------------------------------------------');
  END IF;                                                                            
  
  DBMS_OUTPUT.PUT_LINE('�˻���� ['||cur_car%ROWCOUNT||'] ��');

	CLOSE cur_car;
END;
/
