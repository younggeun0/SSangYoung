-- ���ν����� �̿��� DELETE                         
-- �� �ƴ϶� confirm dialog ���� ����ó��
-- �����ȣ�� �Է¹޾� test_proc ���̺��� �����ϴ� PROCEDURE

CREATE OR REPLACE PROCEDURE delete_test_proc(
	i_empno NUMBER,
	msg OUT VARCHAR2,
	cnt OUT NUMBER
)                 
IS

	res_msg VARCHAR2(15);

BEGIN
    
 	DELETE FROM test_proc
 	WHERE empno = i_empno;
 	
 	cnt := SQL%ROWCOUNT; 
 	
 	IF cnt = 1 THEN
 		COMMIT;
	 	msg := i_empno||'�� ��� ���. �ູ�ϼ���~~';       
 	ELSE                               
 		msg := i_empno||'�� ����� �������� �ʽ��ϴ�.';	
 	END IF;
 	

END;
/
