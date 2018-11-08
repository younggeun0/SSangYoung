-- 여러행 조회할 땐 SYS_REFCURSOR 사용
-- 1. 바인드변수(커서) 선언
VAR cur_dept REFCURSOR;

-- 2. 프로시저 실행
EXEC select_all_dept(:cur_dept);

-- 3. 결과 출력
PRINT cur_dept;

-- 프로시저 내부에서 FETCH 후 프로시저 실행 - error!
EXEC select_all_dept(:cur_dept);
