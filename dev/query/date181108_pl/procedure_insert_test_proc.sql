-- 사원번호, 사원명, 연봉, 직급를 입력받아 test_proc테이블에
-- 추가하는 PROCEDURE를 작성하세요.      
-- 제약들                   
--   * 사원번호는 1~9999 사이의 값만 입력되어야 한다.
--   * 연봉 2500~8000 사이만 입력되어야한다.
--     2500 이하라면 2500으로 8000 이상이라면 8000으로 설정하여 추가
--   * 직급은 사원, 주임, 대리, 과장, 차장, 부장, 이사가 입력되었을 때만
--     추가한다.
--   * 사원명은 영어인 경우 첫자를 대문자로 변경하여 추가                                         
--   * 중복된 사원 번호가 입력되면 예외로 처리한다. 

CREATE OR REPLACE PROCEDURE insert_test_proc(
	empno NUMBER,
	ename VARCHAR2,
	sal NUMBER,
	job VARCHAR2,
	msg OUT VARCHAR2,
	row_cnt OUT NUMBER
)                       
IS
    -- in parameter는 값 변경이 안되기 때문에 값이 변경되는 경우
    -- 새로운 변수를 생성해야 한다
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
/
