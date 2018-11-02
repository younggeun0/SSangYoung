/*
-- RECORD�� ������������ ����� TABLE
 
-- class4 �л����� ��ȣ, �̸�, ����Ŭ ������ ó���ϴ� PL/SQL 
SET serveroutput ON                  

DECLARE                                                     
  
	-- �л� ������ ������ ���ڵ� ����
	TYPE stu_rec IS RECORD (
		num	NUMBER,
		name VARCHAR2(30),
		oracle_score NUMBER(3)
	);                               
	
	-- �л����� ������ ������ ���̺� ����
	TYPE stu_tab IS TABLE OF
	 stu_rec
	 INDEX BY BINARY_INTEGER;
	                    
	-- �л����� ������ ó���� ���̺�Ÿ���� ����� ���� ����
	class4_tab stu_tab;
-- �̷��� ���̺� ������ Ȱ���ϸ� �ٸ� �� �л����� ������ ������ ���̺����� ���� ����
--	class3_tab stu_tab;
--	class2_tab stu_tab;
BEGIN    
  
	-- table ������ �� �Ҵ�
	class4_tab(1).num := 1111;
	class4_tab(1).name := '������';
	class4_tab(1).oracle_score := 99;
	
	class4_tab(2).num := 2222;
	class4_tab(2).name := 'ȫ�浿';
	class4_tab(2).oracle_score := 77;
	
	class4_tab(3).num := 1112;
	class4_tab(3).name := '�Ѹ�';
	class4_tab(3).oracle_score := 55;
	
	class4_tab(4).num := 1113;
	class4_tab(4).name := '��ġ';
	class4_tab(4).oracle_score := 44;
	
	FOR i IN 1..class4_tab.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE('�й� : '||class4_tab(i).num
													||', �̸� : '||class4_tab(i).name
													||', ����Ŭ ���� : '||class4_tab(i).oracle_score);
	END LOOP;

END;
/ 

*/
SET serveroutput ON

DECLARE

	TYPE stu_rec IS RECORD(
	  num NUMBER,
	  name VARCHAR2(15),
	  oracle_score NUMBER(3)
	);                      
	
	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;
	 
	 class4_tab stu_tab; 
	 
	 total NUMBER := 0;

BEGIN                 

	class4_tab(1).num := 1;
	class4_tab(1).name := 'young';
	class4_tab(1).oracle_score := 100;
	
	class4_tab(2).num := 2;
	class4_tab(2).name := 'sol';
	class4_tab(2).oracle_score := 30;
	
	class4_tab(3).num := 3;
	class4_tab(3).name := 'su';
	class4_tab(3).oracle_score := 66;
	
	class4_tab(4).num := 4;
	class4_tab(4).name := 'jung';
	class4_tab(4).oracle_score := 33;
	
	DBMS_OUTPUT.PUT_LINE('���� �ο��� '||class4_tab.COUNT||'�� �Դϴ�..');
	
	DBMS_OUTPUT.PUT_LINE('��ȣ   �̸�     ����Ŭ����');
	DBMS_OUTPUT.PUT_LINE('===========================================');
	FOR i IN 1..class4_tab.COUNT LOOP
		DBMS_OUTPUT.PUT_LINE(class4_tab(i).num||'      '||class4_tab(i).name
												||'         '||class4_tab(i).oracle_score);
		total := total + class4_tab(i).oracle_score;
	END LOOP;
	
	DBMS_OUTPUT.PUT_LINE('===========================================');
	DBMS_OUTPUT.PUT_LINE('    ���� : '||total||', ��� : '||total/class4_tab.COUNT);

END;
/

