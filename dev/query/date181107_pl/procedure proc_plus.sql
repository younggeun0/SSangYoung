-- �� ���� �Է¹޾� ���ϱ� ������ ����� out parameter�� �����ϴ� ���ν���                            
CREATE OR REPLACE PROCEDURE proc_plus (num1 NUMBER,
 num2 IN NUMBER, num3 OUT NUMBER)
IS  
	-- parameter��� ���� ������ ���� �� ���� 
	-- �������� ���Ҷ��� ���ν������ �ٸ��� �����Ѵ�.
 
BEGIN   
	-- out parameter���� ���Ҵ��� ������ in parameter�� ���Ҵ� �ȵ�
	-- num1 := 100; �ϸ� error!
	
	num3 := num1 + num2;
END;
/
