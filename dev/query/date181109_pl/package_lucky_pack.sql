CREATE OR REPLACE PACKAGE lucky_pack
AS           
	-- ����� ��(1~45) �� �ϳ��� ��� �Լ�         
   FUNCTION lucky_num RETURN NUMBER;  
   
   -- ���ξ�� ���ν���
   PROCEDURE lucky_name(name OUT VARCHAR2); 
   
   -- ������� , ������ �Է¹޾� �ֹι�ȣ�� �����Ͽ�
   -- out parameter�� �����ϴ� ���ν����� �ۼ�
   PROCEDURE get_ssn(birthdate CHAR, gender VARCHAR2, ssn OUT CHAR);
   
END;
/
