-- ���̵�, �̸�, ��й�ȣ�� �Է¹޾� table_primary
-- ���̺� ���ڵ带 �����ϴ� PL/SQL �ۼ�

SET serveroutput ON
SET verify OFF

	ACCEPT name PROMPT '�̸� : '
	ACCEPT id PROMPT '���̵� : '
	ACCEPT pw PROMPT '��й�ȣ : '

DECLARE

	name table_primary.name%TYPE;
	id table_primary.id%TYPE := '&id';
	pw table_primary.pw%TYPE := '&pw';

BEGIN
	-- ���ڿ��� �Է¹޾� �Է¹��� ���ڿ��� ���̰� 
	-- ������ �� �ִ� ũ�Ⱑ �ƴ϶�� ���ܷδ� ó���� �� ����
	-- �ڵ�� ó���ؾ� ��
	
	IF LENGTH('&name') > 10 THEN
		DBMS_OUTPUT.PUT_LINE('�Է°����� ���ڼ��� �ʰ��Ͽ����ϴ�');	
	ELSE
		name := '&name';                         
		
		INSERT INTO table_primary(name, id, pw)
		VALUES(name, id, pw);
	
		DBMS_OUTPUT.PUT_LINE('�߰� �����߽��ϴ�.');
		COMMIT;
	END IF;

	
  EXCEPTION                                          
    -- ���Ἲ  �������� ���� ��(PK�� �ߺ��� �Է� ��)
  	WHEN DUP_VAL_ON_INDEX THEN
			DBMS_OUTPUT.PUT_LINE('�Է��Ͻ� '||id||'�� �̹� ������Դϴ�.');  
			-- ����ó�� ��ü�� �����ϴ� �޽��� : sqlerrm
			DBMS_OUTPUT.PUT_LINE( sqlerrm );
			-- ����ó�� ��ü�� �����ϴ� �����ڵ� : sqlcode   
			DBMS_OUTPUT.PUT_LINE( sqlcode );
                   
END;
/
