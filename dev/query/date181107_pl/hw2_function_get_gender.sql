/*              

2.  �ֹι�ȣ�� �Է¹޾� ����(���� - M, ���� - F)�� ��ȯ�ϴ� �Լ� �ۼ� 
	������ 000000-X000000, X�� ���ڸ� Ȧ��, ���ڸ� ¦��
	
*/

CREATE OR REPLACE FUNCTION get_gender(ssn CHAR)
RETURN CHAR
IS
    
	flag CHAR(1);
	res_msg CHAR(1) := 'M';

BEGIN                    

	IF CHECK_SSN(ssn) = 'success' THEN
		    
		flag := SUBSTR(ssn,8,1);
		
		IF MOD(flag,2) = 0 THEN
			res_msg := 'F';   
		END IF;
	
		RETURN res_msg; 
	ELSE              
		res_msg := 'X';
		
		RETURN res_msg;
	END IF;

END;
/
