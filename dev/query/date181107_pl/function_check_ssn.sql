-- �ԷµǴ� �ֹι�ȣ�� ��ȿ�� ����
-- ���ڼ��� 14�ڸ�, 7��° �ڸ��� '-'�� �����ϴ���
-- ���� ��� �� success, ���� �� fail�� ��ȯ

CREATE OR REPLACE FUNCTION check_ssn(ssn CHAR)
RETURN VARCHAR2
IS         
	result_msg VARCHAR2(7) := 'fail';	
                           
BEGIN                      

	IF LENGTH(TRIM(ssn)) = 14 AND INSTR(ssn, '-') = 7 THEN
		result_msg := 'success';
	END IF;
           
	RETURN result_msg; 

END;   
/
