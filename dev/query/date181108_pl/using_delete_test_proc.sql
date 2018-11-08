
SELECT * FROM test_proc;
 
-- 바인드 변수 선언
VAR msg VARCHAR2(100);
VAR cnt NUMBER;

-- 프로시저 실행 
-- 삭제 : 존재하는 사원번호로 삭제
EXEC delete_test_proc(2222, :msg, :cnt);
               
-- 처리 결과 출력
PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 존재하지 않는 사원번호로 삭제
EXEC delete_test_proc(3333, :msg, :cnt);

PRINT msg;
PRINT cnt;
