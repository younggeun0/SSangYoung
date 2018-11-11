/*              
3. �ֹι�ȣ�� �Է¹޾� ��������� ��ȯ�ϴ� �Լ� �ۼ�
   ���������  880101-1xx1111 ���� xx ���ڸ� �̰�
   �Ʒ��� ǥ�� ����.
    ����� : 00~08
    �λ�� : 09~12
    ��õ�� : 13~15
    ��⵵ : 16~25
    ������ : 26~34
    ��û�� : 35~47
    ���� : 48~66
    ��� : 67~92
    ���ֵ� : 93~95         
*/

CREATE OR REPLACE FUNCTION get_ht(ssn CHAR)
RETURN CHAR
IS
	flag NUMBER;
	ht CHAR(9);
BEGIN          

	IF CHECK_SSN(ssn) = 'success' THEN
	
		flag := SUBSTR(ssn, 9, 2);
		
		IF flag BETWEEN 0 AND 8 THEN
			ht := '�����';
		ELSIF flag BETWEEN 09 AND 12 THEN
            ht := '�λ��';    
        ELSIF flag BETWEEN 13 AND 15 THEN
            ht := '��õ��';
        ELSIF flag BETWEEN 16 AND 25 THEN
            ht := '��⵵';    
        ELSIF flag BETWEEN 26 AND 34 THEN
            ht := '������';    
        ELSIF flag BETWEEN 35 AND 47 THEN
            ht := '��û��';    
        ELSIF flag BETWEEN 48 AND 66 THEN
            ht := '����';    
        ELSIF flag BETWEEN 67 AND 92 THEN
            ht := '���';    
        ELSIF flag BETWEEN 93 AND 95 THEN
            ht := '���ֵ�';    
        END IF;	
	                
		RETURN ht;
	
	ELSE
		ht := '��ȸX';
		RETURN ht;
	END IF;

END;
/
