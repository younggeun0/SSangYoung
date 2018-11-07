
-- 생성된 프로시저 확인
SELECT * FROM user_procedures
WHERE OBJECT_TYPE LIKE 'P%';

VAR num NUMBER

EXEC proc_plus(11,11,:num);

PRINT num;
