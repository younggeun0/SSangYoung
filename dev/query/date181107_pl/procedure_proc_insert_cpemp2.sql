-- cp_emp2 ���̺� �����ȣ, �����, �Ի���, ������ �߰��ϰ�
-- �߰��� ���� ���� �ܺη� ��ȯ�ϴ� Procedure

CREATE OR REPLACE PROCEDURE proc_insert_cpemp2(
	empno IN cp_emp2.empno%TYPE,
	ename IN cp_emp2.ename%TYPE,
	sal IN cp_emp2.sal%TYPE,
	cnt OUT NUMBER,
	msg OUT VARCHAR2
)                      
IS 


BEGIN

	INSERT INTO cp_emp2(empno, ename, hiredate, sal)
	VALUES(empno, ename, SYSDATE, sal); 

	cnt := SQL%ROWCOUNT;
	msg := '�߰�����';        
	
	COMMIT;
	
	EXCEPTION
	WHEN OTHERS THEN
		cnt := 0;
		msg := '�߰�����';
		
END;
/
