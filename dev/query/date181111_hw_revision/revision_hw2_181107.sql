/*              

2.  �ֹι�ȣ�� �Է¹޾� ����(���� - M, ���� - F)�� ��ȯ�ϴ� �Լ� �ۼ� 
	������ 000000-X000000, X�� ���ڸ� Ȧ��, ���ڸ� ¦��
	
*/

CREATE OR REPLACE FUNCTION get_gender(ssn CHAR)
RETURN CHAR
IS
	flag CHAR(1);
	re_msg CHAR(1) := 'M';
BEGIN  
	-- CHECK_SSN�� ������ ������ ssn validation �Լ� 
	IF CHECK_SSN(ssn) = 'success' THEN
		flag := SUBSTR(ssn, 8, 1);
		
		IF MOD(flag, 2) = 0 THEN
			re_msg := 'F';
		END IF;
		
		RETURN re_msg;
	ELSE
		res_msg := 'X';
		RETURN re_msg;
	END IF;
END;
/
