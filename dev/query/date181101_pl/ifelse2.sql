-- �����, ��ǰ��, ������ �Է¹޾� ó���ϴ� PL/SQL�ۼ�
-- ����� �� ����� 'Ư��' �Ǵ� '�Ϲ�'�� ��쿡�� ���α׷��� ����Ǿ� ���� ����
-- Ư������ ��ǰ������ ��ǰ���� 50%, �Ϲݰ��� ��ǰ���� 30%�� ����Ͽ� ���
SET serveroutput ON
SET verify OFF

ACCEPT i_customer_grade PROMPT '�� ��� :'
ACCEPT i_item PROMPT '��ǰ�� :'
ACCEPT i_price PROMPT '���� :'

DECLARE
	customer_grade VARCHAR2(10);
	item VARCHAR2(30);
	price NUMBER;  
	salePrice NUMBER;
BEGIN            
	customer_grade := '&i_customer_grade';
	item := '&i_item';
	price := &i_price;
	
	IF customer_grade IN ('Ư��', '�Ϲ�') THEN
		IF customer_grade='Ư��' THEN  
			salePrice := price*0.5;
		ELSE                  
			salePrice := price*0.7;                                                           
		END IF;   
		
		DBMS_OUTPUT.PUT_LINE('������ ����� '||customer_grade
							||'�� ���ε�'||item||'�� ������ '||salePrice||'�Դϴ�.');
	END IF;

END;
/                                                    
