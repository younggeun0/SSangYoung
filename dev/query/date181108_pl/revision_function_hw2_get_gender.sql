/*
2.  �ֹι�ȣ�� �Է¹޾� ����(���� - M, ���� - F)�� ��ȯ�ϴ� �Լ� �ۼ�
    ������ 000000-X000000, X�� ���ڸ� Ȧ��, ���ڸ� ¦��
*/

CREATE OR REPLACE FUNCTION hw2_get_gender(ssn CHAR)
RETURN CHAR
IS
	re_msg CHAR(1) := 'F';
	flag CHAR(1);
	
BEGIN
 
	flag := SUBSTR(ssn, 8, 1);
	
	IF MOD(flag, 2) != 0 THEN
	
		re_msg := 'M';       
	
	END IF;	     
	
	RETURN re_msg;

END;
/
