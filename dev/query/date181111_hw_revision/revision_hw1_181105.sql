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

ACCEPT i_model PROMPT '�� : '

DECLARE
	CURSOR cur_car IS
	 SELECT model, car_year, TO_CHAR(hiredate,'mm-dd-yy'),
	 	    TO_CHAR(price,'9,999'), car_option
	 FROM car_model
	 WHERE model = '&i_model'
	 ORDER BY price;

	TYPE rec_car IS RECORD(
	  model car_model.model%TYPE,
	  car_year car_model.car_year%TYPE,
	  hiredate VARCHAR2(10),
	  price car_model.price%TYPE,
	  car_option car_model.car_option%TYPE
	);

	TYPE tab_car IS TABLE OF rec_car
	 INDEX BY BINARY_INTEGER;

	rec_data rec_car;
	arr_car tab_car;
	i NUMBER := 0;
BEGIN
	IF cur_car%ISOPEN THEN
		CLOSE cur_car;
	END IF;
	OPEN cur_car;

	LOOP
		FETCH cur_car INTO rec_data;

		EXIT WHEN cur_car%NOTFOUND;
		i := i + 1;
		arr_car(i) := rec_data;
	END LOOP;

	IF cur_car%ROWCOUNT = 0 THEN
		DBMS_OUTPUT.PUT_LINE('&i_model �ش� �𵨿� ���� �����Ͱ� �����ϴ�');
	ELSE
		DBMS_OUTPUT.PUT_LINE('&i_model �� �˻� ���');
		DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
  	    DBMS_OUTPUT.PUT_LINE('���� ���� �Է���     �ɼ�');
		DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');

		FOR i IN 1.. cur_car%ROWCOUNT LOOP
			DBMS_OUTPUT.PUT_LINE(arr_car(i).car_year||' '
				||arr_car(i).price||' '||arr_car(i).hiredate||' '
				||arr_car(i).car_option);
		END LOOP;

		DBMS_OUTPUT.PUT_LINE('---------------------------------------------------');
		DBMS_OUTPUT.PUT_LINE('�˻���� : '||cur_car%ROWCOUNT);

	END IF;
END;
/
