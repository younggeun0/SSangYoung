-- �����ȣ�� �Է¹޾� cp_emp2���̺��� �����ȣ�� 
-- ��ġ�ϴ� ����� �����ϴ� PL/SQL �ۼ�.

SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '�����ȣ : '

DECLARE
  i_empno cp_emp2.empno%TYPE := &empno;
	cnt NUMBER;
BEGIN                                    
         
	-- DELETE WHERE�������� �÷���� �������� ���ٸ� 
	-- ��� ������ �Ǵ��Ͽ� ��� ���ڵ带 ����
	-- ������� �÷���� ���е� �� �ֵ��� �̸��� �����ؾ��Ѵ�.
	DELETE FROM cp_emp2 
	WHERE empno = i_empno;
	
	cnt := SQL%ROWCOUNT;
	
	IF cnt = 1 THEN
		DBMS_OUTPUT.PUT_LINE(cnt||'���� �����Ǿ����ϴ�');
  	COMMIT;
  ELSE
		DBMS_OUTPUT.PUT_LINE('�������� ���ڵ�� ������ �� �����ϴ�.');
    ROLLBACK;
  END IF;
		
END;
/