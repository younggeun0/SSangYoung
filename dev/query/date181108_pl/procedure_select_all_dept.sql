-- ���ν����� �̿��� SELECT(��������ȸ)
-- ��ȸ�� ����� ��������� out parameter�� ���� �� ����
-- ���ε庯���� ���̺�� ���ڵ�Ÿ���� ��������
-- Ŀ���� ������� ������ ���ָ� �� => SYS_REFCURSOR�� ���

-- dept ���̺��� ��� �μ������� ��ȸ�Ͽ� 
-- out parameter�� �����ϴ�  ���ν����� �ۼ� 

CREATE OR REPLACE PROCEDURE select_all_dept(
	cur_dept OUT SYS_REFCURSOR
)
IS  
	
--	dept_data dept%ROWTYPE;

BEGIN

	OPEN cur_dept 
		FOR SELECT deptno, dname, loc 
			  FROM dept; 
		
-- SYS_REFCURSOR�� ����� ���� �ܺο��� ����� �� �ֵ���
-- Ŀ���� ������ ���ν��������� �������� �ʴ´�.			  
--	LOOP 
--		FETCH cur_dept INTO dept_data;
--		EXIT WHEN cur_dept%NOTFOUND;
--	END LOOP;    
--	CLOSE cur_dept;

END;
/
