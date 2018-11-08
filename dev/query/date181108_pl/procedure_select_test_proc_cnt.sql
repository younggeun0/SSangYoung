-- 프로시저를 이용한 SELECT
-- 직무(사원, 주임, 대리, 과장, 차장, 부장, 이사, 상무, 
-- 전무, 대표이사)일 때 입력받아 해당 직무의 
-- 사원수와 연봉합(커서사용)을 out parameter에 설정하는 프로시저

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
 	
  IF i_job IN ('사원', '주임', '대리', '과장', 
  			'차장', '부장', '이사', '상무', '전무', '대표이사') THEN   
  
  	-- 커서를 사용해서 여러 조회결과 처리
--  	FOR rec_emp IN (SELECT sal
--  									FROM test_proc
--  									WHERE job = i_job)
--  	LOOP
--  	  -- 조회가 실행될 때마다 사원수 증가
--  		cnt_emp := cnt_emp + 1;
--  		sum_sal := sum_sal + rec_emp.sal;
--  	
--  	END LOOP;				    	
  	-- 커서 사용 안한 COUNT(), SUM() 사용 구현해보기  
  	SELECT COUNT(empno), SUM(sal)
  	INTO sum_sal, cnt_emp
  	FROM test_proc
  	WHERE job=i_job;
   
    IF cnt_emp != 0 THEN
  		msg := i_job||' 으로 조회된 결과 있음';		
    ELSE
			msg := i_job||' 직급의 사원은 존재하지 않습니다.'; 
			-- cnt_emp = 0이면 결과가 NULL이 나오기 때문에 할당
		 	cnt_emp := 0;	    
    END IF;                                       
                                 
  ELSE
  	msg := i_job||'은 없는 직무입니다.';
			
  END IF;
  
 	

END;
/
