/*
4. ��������� �Է¹޾�, '�ý�','����','����ö' �� ��쿡��
  �Ʒ��� ���� ������� �Ѵ� ����� �����ϼ���.
   �ý� : 3800 -
   ���� : 1200
   ����ö :1250��
   ��� : ����ٿ� ����ϴ� ��������� 'XX'�̰� �⺻ ���: xx ���Դϴ�.
      �պ������ xx���̰�, �Ѵ� 20�� ���� ������ xx�� �Դϴ�.
    �ý�, ����, ����ö�� �ƴ϶��  '���߱����� �ƴմϴ�.' �� ����ϼ���.
*/

SET serveroutput ON
SET verify OFF

ACCEPT method PROMPT '������� : '

DECLARE
	method VARCHAR2(15);
	price NUMBER(5);
BEGIN             
	method := '&method';
	
	IF method NOT IN ('�ý�', '����', '����ö') THEN
		DBMS_OUTPUT.PUT_LINE('���߱����� �ƴմϴ�.');
	ELSE                                        
		IF method = '�ý�' THEN
			price := 3800;
		ELSIF method = '����' THEN
			price := 1200;
		ELSE
		  price := 1250;
		END IF;         
		DBMS_OUTPUT.PUT_LINE('����� ��������� '||method
			||'�̰� �⺻ ��� : '||price||' �� �Դϴ�. �պ������ '
			||price*2||'���̰� �Ѵ� 20�� ���� ������ '||price*20||
			'�� �Դϴ�.');
	
	END IF;


END;
/