-- �̸����� ��ȿ�� ������ 6�� �̻��̸鼭 '@'�� '.'�� ����־�� �Ѵ�.
-- ������ ������ο� ���� '��ȿ', '��ȿ' ��ȯ
CREATE OR REPLACE FUNCTION valid_email(email VARCHAR2) 
RETURN CHAR
IS
    result_msg CHAR(6) := '��ȿ';
BEGIN
    
    IF LENGTH(email) >= 6 AND INSTR(email, '@') != 0 
      AND INSTR(email, '.')<>0 THEN
    		result_msg := '��ȿ';
    END IF;

    RETURN result_msg;

END;
/
