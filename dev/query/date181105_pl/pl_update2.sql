-- �����ȣ, �����, ������ �Է¹޾� �����ȣ�� ��ġ�ϴ� ����� 
-- ������ ������� cp_emp2 ���̺��� �����ϼ���.
-- ��, ������ 3000�����϶� 1000�� ���� �������� �����Ѵ�.
SET serveroutput ON
SET verify OFF

ACCEPT empno PROMPT '�����ȣ : '
ACCEPT ename PROMPT '����� : '
ACCEPT sal PROMPT '���� : '

DECLARE
	i_empno cp_emp2.empno%TYPE := &empno;
	i_ename cp_emp2.ename%TYPE := '&ename';
	i_sal cp_emp2.sal%TYPE := &sal;
	cnt NUMBER;
BEGIN               
	
	IF i_sal <= 3000 THEN
		i_sal := i_sal + 1000;
	END IF;
  
	-- ������� �÷����� ������ ����Ŭ�� ������ �� ����(�ĺ��ȵǸ� �׻� ��)
	-- ������� �÷����� �ĺ����� �ʴ� UPDATE�� SET�� WHERE����
	-- ������� �÷����� ���е� �� �ֵ��� �̸��� �ٸ����Ͽ� �ۼ��ؾߵȴ�.
	UPDATE cp_emp2
	SET sal = i_sal, ename = i_ename 
	WHERE empno = i_empno;                
	           
	cnt := SQL%ROWCOUNT;           
	
	IF cnt = 1 THEN
		DBMS_OUTPUT.PUT_LINE(cnt||'���� ����Ǿ����ϴ�.');
		COMMIT;
	ELSE           
		DBMS_OUTPUT.PUT_LINE(cnt||'���� ���ų� �Ѱ��� �ƴϹǷ� �����۾��� ����մϴ�..');
		ROLLBACK;
	END IF;

END;
/