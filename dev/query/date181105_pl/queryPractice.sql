/* 181102 ���� ����
1.  class4 �������� �л����� �������� ���ϴ�  PL/SQL�� ����
   �ϰ����Ѵ�.  ���߱������ ����� �Ʒ��� ������
   [���� : 1200��,  ����ö :1250��]
   10Ű�θ� �ʰ��ϸ� ��4Ű�θ��� 100���� ��� �� �ΰ��ȴ�.
  �� ������ �̿��Ͽ� �Ʒ� �л����� �����͸� ó���ϼ���
  ������.
  1, ������, ����� ������ ���ﵿ,      5Ű��, ����
  2, ����ö, ��õ�� ������ ������,      20Ű��, ����ö
  3, ������, ��õ�� ���� ����,     16Ű��, ����ö
  4, �ڿ���, ����� ���Ǳ� ��õ��,     10Ű��, ����ö
  5, ���ü�, ����� ���빮�� ���빮��, 8Ű��, ����

   ���
   ��ȣ, �̸�,  �ּ�, �Ÿ�, �������, ���


SET serveroutput ON

DECLARE

	TYPE stu_rec IS RECORD (
		num NUMBER,
		name VARCHAR2(15),
		addr VARCHAR2(100),
		dis NUMBER,
		method VARCHAR2(15),
		fee NUMBER(4),
		extra NUMBER(4)
	);

	TYPE stu_tab IS TABLE OF stu_rec
		INDEX BY BINARY_INTEGER;

	class4 stu_tab;

BEGIN

	class4(1).num := 1;
	class4(1).name := '������';
	class4(1).addr := '����� ������ ���ﵿ';
	class4(1).dis := 5;
	class4(1).method := '����';

	class4(2).num := 2;
	class4(2).name := '����ö';
	class4(2).addr := '��õ�� ������ ������';
	class4(2).dis := 20;
	class4(2).method := '����ö';

	class4(3).num := 3;
	class4(3).name := '������';
	class4(3).addr := '��õ�� ���� ����';
	class4(3).dis := 16;
	class4(3).method := '����ö';

	class4(4).num := 4;
	class4(4).name := '�ڿ���';
	class4(4).addr := '����� ���Ǳ� ��õ��';
	class4(4).dis := 10;
	class4(4).method := '����ö';

	class4(5).num := 5;
	class4(5).name := '���ü�';
	class4(5).addr := '����� ���빮�� ���빮��';
	class4(5).dis := 8;
	class4(5).method := '����';

	FOR i IN 1..class4.COUNT LOOP

		IF class4(i).method = '����' THEN
			class4(i).fee := 1200;
		ELSE
			class4(i).fee := 1250;
		END IF;

		IF class4(i).dis > 10 THEN

			class4(i).extra := TRUNC((class4(i).dis-10)/4,0)*100;

		END IF;

		DBMS_OUTPUT.PUT_LINE(class4(i).num||' '
												||class4(i).name||' '
												||class4(i).addr||' '
												||class4(i).dis||' '
												||class4(i).method||' '
												||class4(i).fee||' '
												||NVL(class4(i).extra, 0));

	END LOOP;


END;
/

2. �л����� ������ ó���ϴ� PL/SQL�ۼ�.
   ��ȣ, �̸�, ����Ŭ����,�ڹ�����,����,��� �� ������ ���ִ� record��
   ����� �Ʒ��� �����͸� �Է��� ��
   �ݺ����� ����Ͽ�  ����,����� ó���ϴ� PL/SQL �ۼ�
  1, ������, 80,81
  2, ����ö, 94,80
  3, ������, 97,96
  4, �ڿ���, 86,92
  5, ���ü�, 76,99

���
   ��ȣ, �̸�, ����Ŭ����,�ڹ�����,����,���
  .
  .
  .
  �ڹ��ְ����� [xx] ����Ŭ �ְ����� [xxx]

*/

SET serveroutput ON

DECLARE

	TYPE st_rec IS RECORD(
	  num NUMBER,
	  name VARCHAR2(15),
	  oracle_s NUMBER(3),
	  java_s NUMBER(3)
	);

	TYPE st_tab IS TABLE OF st_rec
		INDEX BY BINARY_INTEGER;

	class4 st_tab;  
	total_s NUMBER;
	
	oracle_max NUMBER := 0;
	java_max  NUMBER := 0;

BEGIN

	class4(1).num := 1;
	class4(1).name := '������';
	class4(1).oracle_s := 80;
	class4(1).java_s := 81;

	class4(2).num := 2;
	class4(2).name := '����ö';
	class4(2).oracle_s := 94;
	class4(2).java_s := 80;

	class4(3).num := 3;
	class4(3).name := '������';
	class4(3).oracle_s := 97;
	class4(3).java_s := 96;
	
	class4(4).num := 4;
	class4(4).name := '�ڿ���';
	class4(4).oracle_s := 86;
	class4(4).java_s := 92;
	
	class4(5).num := 5;
	class4(5).name := '���ü�';
	class4(5).oracle_s := 76;
	class4(5).java_s := 99;
	
	FOR i IN 1..class4.COUNT LOOP
	  
	
		total_s := class4(i).oracle_s + class4(i).java_s;
		
		DBMS_OUTPUT.PUT_LINE(class4(i).num||' '
											||class4(i).name||' '
											||class4(i).oracle_s||' '
											||class4(i).java_s||' '
											||total_s||' '
											||TRUNC(total_s/2,0));
			
		IF oracle_max < class4(i).oracle_s THEN
			oracle_max := class4(i).oracle_s;
		END IF;									           
		
		IF java_max < class4(i).java_s THEN
			java_max := class4(i).java_s;
		END IF;
	
	END LOOP;   
           
	DBMS_OUTPUT.PUT_LINE('�ڹ� �ְ����� : '||java_max
											||', ����Ŭ �ְ����� : '||oracle_max);


END;
/