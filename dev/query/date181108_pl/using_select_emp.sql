-- 부서번호 입력하여 부서별 사원정보 조회
VAR cur_emp REFCURSOR;

-- 부서번호 : 10~19 : 10, 20~29 : 20, 그외 : 30
EXEC select_emp(29,:cur_emp);


PRINT cur_emp;
