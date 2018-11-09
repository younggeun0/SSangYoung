-- lucky_pack 패키지 사용

-- lucky_num 함수 사용
SELECT lucky_pack.lucky_num
FROM dual;

-- lucky_name 프로시저 사용
VAR name VARCHAR2(30);

EXEC lucky_pack.lucky_name(:name);

PRINT name;

SELECT * FROM user_procedures;


---------------------------------
-- get_ssn 프로시저 사용
VAR ssn CHAR(14);

EXEC lucky_pack.get_ssn('901206', '남자', :ssn);

PRINT ssn;
