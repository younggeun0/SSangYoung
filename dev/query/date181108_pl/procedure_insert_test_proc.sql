-- �����ȣ, �����, ����, ���޸� �Է¹޾� test_proc���̺�
-- �߰��ϴ� PROCEDURE�� �ۼ��ϼ���.      
-- �����                   
--   * �����ȣ�� 1~9999 ������ ���� �ԷµǾ�� �Ѵ�.
--   * ���� 2500~8000 ���̸� �ԷµǾ���Ѵ�.
--     2500 ���϶�� 2500���� 8000 �̻��̶�� 8000���� �����Ͽ� �߰�
--   * ������ ���, ����, �븮, ����, ����, ����, �̻簡 �ԷµǾ��� ����
--     �߰��Ѵ�.
--   * ������� ������ ��� ù�ڸ� �빮�ڷ� �����Ͽ� �߰�                                         
--   * �ߺ��� ��� ��ȣ�� �ԷµǸ� ���ܷ� ó���Ѵ�. 

CREATE OR REPLACE PROCEDURE insert_test_proc(
	empno NUMBER,
	ename VARCHAR2,
	sal NUMBER,
	job VARCHAR2,
	msg OUT VARCHAR2,
	row_cnt OUT NUMBER
)                       
IS
    -- in parameter�� �� ������ �ȵǱ� ������ ���� ����Ǵ� ���
    -- ���ο� ������ �����ؾ� �Ѵ�
    temp_sal NUMBER := sal; 
    

BEGIN
	row_cnt := 0;

	IF empno BETWEEN 1 AND 9999 THEN 
				                
		IF temp_sal < 2500 THEN
			temp_sal := 2500;
		ELSIF temp_sal > 8000 THEN
			temp_sal := 8000;
		END IF;              
		
		IF job IN ('���', '����', '�븮', '����', '����', '����', '�̻�') THEN
			
			INSERT INTO test_proc(empno, ename, hiredate, sal, job)
			VALUES(empno, INITCAP(ename), SYSDATE, temp_sal, job);
			       
			row_cnt := SQL%ROWCOUNT;
			COMMIT;
			msg := empno||'�� ��� ������ �߰��Ǿ����ϴ�.';
			
		ELSE
			msg := job||'�� �Է°����� ������ �ƴմϴ�';		
		ENd IF;	
				
				
	ELSE
		msg := empno||'�����ȣ�� 1���� 9999���̰� �ƴմϴ�.';
	END IF;  
	
	EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
		msg := empno||'�� �����ȣ�� �̹� �����մϴ�.';	
	WHEN OTHERS THEN                                   
		IF sqlcode = -12899 THEN
			msg := ename||'���� �ѱ� 3��, ���� 10�ڸ� �ʰ��Ͽ����ϴ�.';
		END IF;

END;
/
