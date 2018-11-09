VAR ssn CHAR(14);

EXEC ssn.create_ssn('880204', '여자', '노진경', :ssn);

PRINT ssn;


SELECT * FROM class4_info;

-- 유효한지 이전에 만든 함수를 이용해 확인가능
SELECT name, ssn, valid_ssn_check(ssn)
FROM class4_info;
