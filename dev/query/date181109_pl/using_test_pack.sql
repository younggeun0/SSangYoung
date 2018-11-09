SELECT * FROM user_procedures;

-- 패키지에 포함된 함수 호출
SELECT	test_pack.get_msg('이재찬')
FROM	dual;

-- 프로시저 호출
VAR age NUMBER;

EXEC test_pack.get_age(1993, :age);

PRINT age;


------------------

-- 1107 hw2 프로시저 호출
VAR tab_info REFCURSOR;

EXEC test_pack.search_constraints('car_maker', :tab_info);

PRINT tab_info;
