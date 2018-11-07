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

CREATE OR REPLACE FUNCTION get_hometown(ssn CHAR)
RETURN CHAR
IS                                               

    h_code NUMBER;
    hometown CHAR(9);

BEGIN             
          
    IF CHECK_SSN(ssn) = 'success' THEN
        
        h_code := SUBSTR(ssn, 9, 2);
        
        IF h_code BETWEEN 0 AND 8 THEN
            hometown := '�����';
        ELSIF h_code BETWEEN 09 AND 12 THEN
            hometown := '�λ��';    
        ELSIF h_code BETWEEN 13 AND 15 THEN
            hometown := '��õ��';
        ELSIF h_code BETWEEN 16 AND 25 THEN
            hometown := '��⵵';    
        ELSIF h_code BETWEEN 26 AND 34 THEN
            hometown := '������';    
        ELSIF h_code BETWEEN 35 AND 47 THEN
            hometown := '��û��';    
        ELSIF h_code BETWEEN 48 AND 66 THEN
            hometown := '����';    
        ELSIF h_code BETWEEN 67 AND 92 THEN
            hometown := '���';    
        ELSIF h_code BETWEEN 93 AND 95 THEN
            hometown := '���ֵ�';    
        END IF;
        
        RETURN hometown;
    
    ELSE                
        hometown := '��ȸX';
        RETURN hometown;
    END IF;

END;
/
