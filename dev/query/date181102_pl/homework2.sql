/*
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
	TYPE stu_rec IS RECORD (
		num NUMBER,
		name VARCHAR2(15),
		oracle_score NUMBER(3),
		java_score NUMBER(3),
		total NUMBER(3),
		avg_score NUMBER(3,1)
	);                   
	
	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;
	
	class4 stu_tab;
	
	java_top_score NUMBER(3) := 0;
	oracle_top_score NUMBER(3) := 0;

BEGIN  

	class4(1).num := 1;
	class4(1).name := '������';
	class4(1).oracle_score := 80;
	class4(1).java_score := 81;
	
	class4(2).num := 2;
	class4(2).name := '����ö';
	class4(2).oracle_score := 94;
	class4(2).java_score := 80;
	
	class4(3).num := 3;
	class4(3).name := '������';
	class4(3).oracle_score := 97;
	class4(3).java_score := 96;     
	
	class4(4).num := 4;
	class4(4).name := '�ڿ���';
	class4(4).oracle_score := 86;
	class4(4).java_score := 92;
	
	class4(5).num := 5;
	class4(5).name := '���ü�';
	class4(5).oracle_score := 76;
	class4(5).java_score := 99;
                            
	FOR i IN 1 .. class4.COUNT LOOP
	
		class4(i).total := class4(i).oracle_score + class4(i).java_score;
		class4(i).avg_score := class4(i).total/2;
		
		DBMS_OUTPUT.PUT_LINE(class4(i).num||' '
												||class4(i).name||' '
												||class4(i).oracle_score||' '   
												||class4(i).java_score||' '
												||class4(i).total||' '
												||class4(i).avg_score);   
												
		IF class4(i).java_score > java_top_score THEN 
			java_top_score := class4(i).java_score;
		END IF;									                 
		
		If class4(i).oracle_score > oracle_top_score THEN
			oracle_top_score := class4(i).oracle_score;
		END IF;
	END LOOP;                                    
	
	DBMS_OUTPUT.PUT_LINE('java top : '||java_top_score
											||', oracle top : '||oracle_top_score);
END;
/