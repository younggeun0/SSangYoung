CREATE OR REPLACE PACKAGE ssn
AS
	-- �������, ����, �̸��� �Է¹޾� �ֹι�ȣ�� �����Ͽ�
	-- out parameter�� �����ϰ� class4_info ���̺� �߰��ϴ�
	-- ���ν��� �ۼ� 
  PROCEDURE create_ssn(birthdate VARCHAR2, gender VARCHAR2, 
  	name VARCHAR2, ssn OUT CHAR);
END;
/
