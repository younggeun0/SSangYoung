
-- 1. 바인드변수 선언
VAR cnt NUMBER;
VAR msg VARCHAR2(12);

-- 2. 실행
EXEC proc_insert_cpemp2(1111, '오복동', 4000, :cnt, :msg);

-- 3. 바인드 변수 출력
PRINT cnt;
PRINT msg;

SELECT * FROM cp_emp2;

