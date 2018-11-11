CREATE OR REPLACE PACKAGE BODY lucky_pack
IS
------------------get_cz start----------------------------
	FUNCTION get_cz(birth_year NUMBER) RETURN VARCHAR2
	IS
		cz VARCHAR2(15);
		r NUMBER;	
	BEGIN        
		r := TRUNC(MOD(birth_year, 12),0);
		
		IF r = 11 THEN
			cz := '���';  
		ELSIF r = 10 THEN
			cz := '����';
		ELSIF r = 9 THEN
			cz := '���';
		ELSIF r = 8 THEN
			cz := '���';
		ELSIF r = 7 THEN
			cz := '�䳢��';
		ELSIF r = 6 THEN
			cz := 'ȣ���̶�';
		ELSIF r = 5 THEN
			cz := '�Ҷ�';
		ELSIF r = 4 THEN
			cz := '���';
		ELSIF r = 3 THEN
			cz := '������';
		ELSIF r = 2 THEN
			cz := '����';
		ELSIF r = 1 THEN
			cz := '�߶�';
		ELSIF r = 0 THEN
			cz := '�����̶�';
		END IF;
		
		RETURN cz;
	
	END get_cz;
------------------get_cz end--------------------------------
	
------------------get_avgcs start---------------------------
	PROCEDURE get_avgcs(i_deptno NUMBER, avgcs OUT NUMBER)
	IS
		hiredate DATE;
		sum_cs NUMBER := 0;
		emp_cnt NUMBER := 0;
	BEGIN                   
		FOR temp_data IN (SELECT hiredate
						  INTO hiredate
						  FROM emp
						  WHERE deptno = i_deptno)
		LOOP
			sum_cs := sum_cs + (TO_CHAR(SYSDATE, 'yyyy') - TO_CHAR(temp_data.hiredate,'yyyy'));
			emp_cnt := emp_cnt + 1;
		END LOOP;
		avgcs := TRUNC(sum_cs/emp_cnt, 0);	
	END;
------------------get_avgcs end-----------------------------
END;
/
