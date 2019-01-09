PROCEDURE insert_test_proc(
	empno NUMBER,
	ename VARCHAR2,
	sal NUMBER,
	job VARCHAR2,
	msg OUT VARCHAR2,
	row_cnt OUT NUMBER
)                       
IS
    -- in parameter는 값 변경이 안되기 때문에 변경되는 값을 담을 변수 선언
    temp_sal NUMBER := sal; 
    

BEGIN
	row_cnt := 0;

	IF empno BETWEEN 1 AND 9999 THEN 
				                
		IF temp_sal < 2500 THEN
			temp_sal := 2500;
		ELSIF temp_sal > 8000 THEN
			temp_sal := 8000;
		END IF;              
		
		IF job IN ('사원', '주임', '대리', '과장', '차장', '부장', '이사') THEN
			
			INSERT INTO test_proc(empno, ename, hiredate, sal, job)
			VALUES(empno, INITCAP(ename), SYSDATE, temp_sal, job);
			       
			row_cnt := SQL%ROWCOUNT;
			COMMIT;
			msg := empno||'번 사원 정보가 추가되었습니다.';
			
		ELSE
			msg := job||'은 입력가능한 직급이 아닙니다';		
		ENd IF;	
				
				
	ELSE
		msg := empno||'사원번호는 1에서 9999사이가 아닙니다.';
	END IF;  
	
	EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
		msg := empno||'번 사원번호는 이미 존재합니다.';	
	WHEN OTHERS THEN                                   
		IF sqlcode = -12899 THEN
			msg := ename||'명은 한글 3자, 영어 10자를 초과하였습니다.';
		END IF;

END;
