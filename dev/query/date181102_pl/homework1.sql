/*
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
  
*/

SET serveroutput ON

DECLARE       

	TYPE stu_rec IS RECORD (
		num NUMBER,
		name VARCHAR(15),
		addr VARCHAR2(60),
		dis NUMBER,
		method VARCHAR2(10),
		fee NUMBER,
		extra_fee NUMBER 
	); 
	
	TYPE stu_tab IS TABLE OF stu_rec
	 INDEX BY BINARY_INTEGER;
	
	class4 stu_tab;  
	
	add_mount NUMBER;                
	
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

	DBMS_OUTPUT.PUT_LINE('��ȣ   �̸�   �ּ�            �Ÿ�  �������  �⺻��� �߰����');	          
	DBMS_OUTPUT.PUT_LINE('============================================================='); 
         
	FOR i IN 1 ..class4.COUNT LOOP
	
		IF class4(i).method = '����' THEN
			class4(i).fee := 1200;
		ELSE 
			class4(i).fee := 1250;
		END IF;
		                       
		IF class4(i).dis > 10 THEN
			class4(i).extra_fee := class4(i).fee + (TRUNC((class4(i).dis-10)/4,0))*100;
		END IF;
		
		DBMS_OUTPUT.PUT_LINE(class4(i).num
											||'  '||class4(i).name
											||'  '||class4(i).addr
											||'  '||class4(i).dis
											||'  '||class4(i).method
											||'  '||class4(i).fee
											||'  '||NVL(class4(i).extra_fee, class4(i).fee));
	
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('=============================================================');
END;
/