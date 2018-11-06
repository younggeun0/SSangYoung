-- SYS_REFCURSOR �� ���
-- Ŀ���� ������� �ܺη� ������ �� �ַ� ���

-- ������̺��� �Ŵ�����ȣ�� �Է¹޾� �ų����� �����ϴ�
-- ����� �����ȣ, �����, �Ի���, �μ���ȣ, ������ ��ȸ
-- �Էµ� �Ŵ�����ȣ�� emp���̺� �����ϴ� �Ŵ��� ��ȣ�϶���
-- �˻��� �����Ѵ�. (7839, 7782, 7698, 7902, 7566, 7788)

SET serveroutput ON
SET verify OFF

	ACCEPT mgr PROMPT '�Ŵ�����ȣ : '

DECLARE
	i_mgr NUMBER;
	
	-- 1. SYS_REFCURSOR ���� : Ŀ���� SYS_REFCURSOR;
	cur_mgr SYS_REFCURSOR;
	
	-- ��ȸ����� ������ ���ڵ��� ����
	TYPE rec_emp IS RECORD (
	  empno emp.empno%TYPE,
	  ename emp.ename%TYPE,
	  hiredate emp.hiredate%TYPE,
	  deptno emp.deptno%TYPE,
	  sal emp.sal%TYPE
	);	
	
	emp_rec rec_emp;
	
BEGIN

	-- �Էµ� �Ŵ��� ��ȣ�� �����ϴ��� �˻�
	-- Ŀ�� ������ �޾ƿ��� ���� ���ڵ� ����! .�� ����ؼ� �÷����� �����Ѵ�.**
	FOR temp_rec IN (SELECT DISTINCT mgr
							     FROM emp
							     WHERE mgr = &mgr)
	LOOP
		i_mgr := temp_rec.mgr;
	END LOOP;


	IF i_mgr IS NOT NULL THEN
		
		-- 2. Ŀ�� ���� : ��ȸ ������ �ۼ�
		OPEN cur_mgr FOR SELECT empno, ename, hiredate, deptno, sal
		                 FROM emp
		                 WHERE mgr = i_mgr; 
		                 
		LOOP   
		  -- 3. ����
			FETCH cur_mgr INTO emp_rec;		
			EXIT WHEN cur_mgr%NOTFOUND; 
			
			DBMS_OUTPUT.PUT_LINE(emp_rec.empno||' '
			                    ||emp_rec.ename||' '
			                    ||TO_CHAR(emp_rec.hiredate,'yyyy-mm-dd')||' '
			                    ||emp_rec.deptno||' '
			                    ||emp_rec.sal);
		
		END LOOP;
	
		IF cur_mgr%ISOPEN THEN
			-- 4. �ݱ�
			CLOSE cur_mgr;
			DBMS_OUTPUT.PUT_LINE('Ŀ���� �ݽ��ϴ�..');
		END IF;		
		
	ELSE
		DBMS_OUTPUT.PUT_LINe('&mgr �� ���� �Ŵ�����ȣ�Դϴ�.');
  END IF;


		
END;
/