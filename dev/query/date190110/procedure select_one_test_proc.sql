/*
  �����ȣ�� �Է¹޾� �����, ����, ����, �Ի����� ��ȯ�ϴ� Procedure
*/                                                                   

CREATE OR REPLACE PROCEDURE select_one_test_proc(
	i_empno IN NUMBER,
	cur_emp OUT SYS_REFCURSOR,
	err_msg OUT VARCHAR2
)
IS
BEGIN         
	
	err_msg := '����';
	OPEN cur_emp FOR             
		SELECT ename, sal, job, TO_CHAR(hiredate, 'yy-mm-dd day') hiredate
		FROM test_proc
		WHERE empno = i_empno;

	EXCEPTION 
	WHEN OTHERS THEN
		err_msg := '���� �߻�'||sqlerrm;

END;
/
