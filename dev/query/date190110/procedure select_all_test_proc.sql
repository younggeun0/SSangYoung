/*
	test_proc ���̺��� ��� ��� ������ ��ȸ�Ͽ� out parameter�� 
	�����ϴ� Procedure
*/
CREATE OR REPLACE PROCEDURE select_all_test_proc(
	cur_emp OUT SYS_REFCURSOR,
	date_pattern IN VARCHAR2	
)
IS

BEGIN                             	

	OPEN cur_emp FOR 
	SELECT empno, ename, TO_CHAR(hiredate, date_pattern) hiredate, sal, job
	FROM test_proc;                                               

END;
/

