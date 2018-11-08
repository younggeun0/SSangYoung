-- ���ν����� �̿��� SELECT
-- ����(���, ����, �븮, ����, ����, ����, �̻�, ��, 
-- ����, ��ǥ�̻�)�� �� �Է¹޾� �ش� ������ 
-- ������� ������(Ŀ�����)�� out parameter�� �����ϴ� ���ν���

CREATE OR REPLACE PROCEDURE select_test_proc_cnt(
	i_job VARCHAR2,
	cnt_emp OUT NUMBER,
	sum_sal OUT NUMBER,
	msg OUT VARCHAR2
)                     
IS
	temp_sal NUMBER := 0;
	
BEGIN
	sum_sal := 0;
 	cnt_emp := 0;	  
 	
  IF i_job IN ('���', '����', '�븮', '����', 
  			'����', '����', '�̻�', '��', '����', '��ǥ�̻�') THEN   
  
  	-- Ŀ���� ����ؼ� ���� ��ȸ��� ó��
--  	FOR rec_emp IN (SELECT sal
--  									FROM test_proc
--  									WHERE job = i_job)
--  	LOOP
--  	  -- ��ȸ�� ����� ������ ����� ����
--  		cnt_emp := cnt_emp + 1;
--  		sum_sal := sum_sal + rec_emp.sal;
--  	
--  	END LOOP;				    	
  	-- Ŀ�� ��� ���� COUNT(), SUM() ��� �����غ���  
  	SELECT COUNT(empno), SUM(sal)
  	INTO sum_sal, cnt_emp
  	FROM test_proc
  	WHERE job=i_job;
   
    IF cnt_emp != 0 THEN
  		msg := i_job||' ���� ��ȸ�� ��� ����';		
    ELSE
			msg := i_job||' ������ ����� �������� �ʽ��ϴ�.'; 
			-- cnt_emp = 0�̸� ����� NULL�� ������ ������ �Ҵ�
		 	cnt_emp := 0;	    
    END IF;                                       
                                 
  ELSE
  	msg := i_job||'�� ���� �����Դϴ�.';
			
  END IF;
  
 	

END;
/
