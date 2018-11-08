
SELECT * FROM test_proc;

-- 직급에 따른 사원 수, 연봉합 조회예정

-- 바인드변수 선언
VAR cnt_emp NUMBER;
VAR sum_sal NUMBER;
VAR msg VARCHAR2(100);

-- 프로시저 실행
EXEC select_test_proc_cnt('주임',:cnt_emp, :sum_sal, :msg);

-- 프로시저 결과 출력
PRINT msg;
PRINT cnt_emp;
PRINT sum_sal;



-- 직급이 없는 경우
EXEC select_test_proc_cnt('알바생',:cnt_emp, :sum_sal, :msg);

PRINT msg;
PRINT cnt_emp;
PRINT sum_sal;

-- 직급은 있으나 사원이 없는 경우
EXEC select_test_proc_cnt('대표이사',:cnt_emp, :sum_sal, :msg); 

PRINT msg;
PRINT cnt_emp;
PRINT sum_sal;
