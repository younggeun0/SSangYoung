-- cp_emp���̺� ���ڵ尡 �߰��Ǹ�
-- cp_emp3 ���̺� �����ȣ, �����, �μ���ȣ, ����('���'), ������
-- �߰��ϴ� TRIGGER�� �ۼ�
-- ��, �μ���ȣ�� emp���̺��� �����ȣ�� 7788�� ����� ������ deptno�� �߰�
-- ������ 2000���ϰ� �߰��Ǹ� cp_emp3�� ������ 500�� ���� �߰��ϴ� Ʈ���� �ۼ�

CREATE OR REPLACE TRIGGER tri_emp 
AFTER INSERT ON cp_emp
FOR EACH ROW 
DECLARE
	deptno NUMBER;
BEGIN

	SELECT deptno
	INTO deptno
	FROM emp
	WHERE emp.empno=7788;                  
	
	IF :new.sal <= 2000 THEN
		INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
		VALUES(:new.empno, :new.ename, deptno, '���', :new.sal+500);
	ELSE
		INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
		VALUES(:new.empno, :new.ename, deptno, '���', :new.sal);
	END IF;
END; 

