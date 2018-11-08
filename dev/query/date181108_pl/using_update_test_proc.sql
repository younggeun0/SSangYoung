SELECT * FROM user_procedures;

SELECT * FROM test_proc;

-- 바인드 변수(외부 변수) 선언
VAR msg VARCHAR2(100);
VAR row_cnt NUMBER;

-- 프로시저 실행
EXEC update_test_proc(1112,'주임',3000,:msg,:row_cnt);

-- 처리결과(바인드 변수) 출력
PRINT msg;
PRINT row_cnt;


-- 제약사항 확인
--  직급은 사원, 주임, 대리, 과장, 차장, 부장, 이사,
--    상무, 전무, 대표이사가 입력 되었을 때만 변경
EXEC update_test_proc(1112,'선임',3100,:msg,:row_cnt);

PRINT msg;
PRINT row_cnt;

--  연봉이 현재 연봉보다 작다면 현재 연봉보다 5% 인상액으로 변경
EXEC update_test_proc(1111,'주임',2300,:msg,:row_cnt);

PRINT msg;
PRINT row_cnt;                      

