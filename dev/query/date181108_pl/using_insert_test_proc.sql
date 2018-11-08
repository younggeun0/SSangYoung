-- 프로시저 CRUD 연습용 테이블 생성
CREATE TABLE test_proc
AS (SELECT empno, ename, hiredate,sal,job
    FROM emp
    WHERE 1=0);

-- pk 설정
ALTER TABLE test_proc ADD CONSTRAINT pk_test_proc PRIMARY KEY(empno);

-- pk 설정 확인
SELECT * FROM user_constraints
WHERE TABLE_NAME='TEST_PROC';




-- insert_test_proc 프로시저 out parameter를 받을 바인드 변수 선언
VAR msg VARCHAR2(300);
VAR cnt NUMBER;

-- 직접 실행
EXEC insert_test_proc(1111,'테스트',3000,'주임',:msg,:cnt);

-- 바인드 변수 출력, 결과 확인
PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 제약사항 확인

-- 1.사원번호 1~9999까지만 입력가능
-- 사원번호 0
EXEC insert_test_proc(0,'테스트',3000,'주임',:msg,:cnt);

PRINT msg;
PRINT cnt;

-- 사원번호 10000
EXEC insert_test_proc(10000,'테스트',3000,'주임',:msg,:cnt);

PRINT msg;
PRINT cnt;

-- 2.연봉은 2500에서 8000사이만 입력가능
-- 연봉이 2000(2500이하)
EXEC insert_test_proc(1112,'테스트',2000,'주임',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 연봉이 9000(8000이상)
EXEC insert_test_proc(1113,'테스트',9000,'주임',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 3.사원, 주임, 대리, 과장, 차장, 부장, 이사인 경우만 입력가능
EXEC insert_test_proc(1114,'테스트',1400,'알바',:msg,:cnt);

PRINT msg;
PRINT cnt;

-- 4.사원명이 영어일 경우 첫 글자는 대문자여야 함
EXEC insert_test_proc(1114,'kim',3300,'차장',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;

-- 5.사원명이 길게 입력되는 경우 -> EXCEPTION
EXEC insert_test_proc(1115,'선우용녀',5000,'과장',:msg,:cnt);

PRINT msg;
PRINT cnt;

SELECT * FROM test_proc;              


