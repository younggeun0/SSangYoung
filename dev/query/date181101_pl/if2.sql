
-- ��ǰ��� �����, ������ �Է¹޾�
-- ������� 'Ư��'�̶�� 
-- ��ǰ ������  30% ���ε� �������� ���
-- "XX��� ���� XXX��ǰ�� ������ XX���Դϴ�." 
-- Ư���� ��쿡�� �Ʒ��� �޽��� ���
-- "��ǰ���� XX�� ���ΰ� XX��" 


SET serveroutput ON
SET verify OFF
   
ACCEPT i_item_name PROMPT '��ǰ�� :'
ACCEPT i_customer_grade PROMPT '����� :'  
ACCEPT i_item_price PROMPT '���� :'

DECLARE
	item_name VARCHAR2(30);
	customer_grade VARCHAR2(12);
	item_price NUMBER;
BEGIN       
	item_name := '&i_item_name';
	customer_grade := '&i_customer_grade';
	item_price := &i_item_price;          
	                            
	DBMS_OUTPUT.PUT_LINE(customer_grade||'��� ���� '||item_name||' ��ǰ�� ������ '||
						 TO_CHAR(item_price,'999,999,999,999')||'���Դϴ�.');
	
	IF customer_grade='Ư��' THEN
		DBMS_OUTPUT.PUT_LINE('��ǰ���� '||TO_CHAR(item_price,'999,999,999,999')
							 ||'��, ���ΰ� '||TO_CHAR(item_price*0.7,'999,999,999,999')||'��');  
	END IF;

END;
/
               
