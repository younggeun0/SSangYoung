-- SYS_REFCURSOR�� �̿��� ���ν������ ������ ��ȸ
-- �μ���ȣ�� �Է¹޾� emp���̺��� �μ��� ��������� ��ȸ�Ͽ� 
-- out parameter�� �����ϴ� ���ν��� �ۼ�
-- * �����ȣ, �����, ����, �μ���ȣ, �μ���, ��ġ�� ��ȸ
-- * �Է°��� 10~19�� �ԷµǸ� 10���μ� ��ȸ
--            20~29�� �ԷµǸ� 20���μ� ��ȸ
--            �׿ܴ� 30�� �μ��� ��ȸ

CREATE OR REPLACE PROCEDURE select_emp(
 	deptno NUMBER,
	cur_join OUT SYS_REFCURSOR 
)
IS
	temp_deptno NUMBER := deptno;
BEGIN

	-- �ԷµǴ� �μ���ȣ�� 10�Ǵ� 20���� ����                                   
	temp_deptno := TRUNC(temp_deptno/10, 0)*10;

	IF temp_deptno NOT IN (10, 20) THEN
		temp_deptno := 30;
	END IF;      
	
	OPEN cur_join 
			FOR SELECT e.empno, e.ename, e.sal, d.deptno, d.dname, d.loc
				  FROM emp e, dept d
				  WHERE (e.deptno = d.deptno)
				  	AND d.deptno = temp_deptno; 
END;
/
