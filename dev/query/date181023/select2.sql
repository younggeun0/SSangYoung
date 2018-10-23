
-- 컬럼명에 alias 부여하기
SELECT num 번호, name 이름
FROM Class4_info;

-- 같은 컬럼을 다른 컬럼명으로 여러개로 쓸 수 있
SELECT num, name, input_date AS i_date, input_date AS i_date2
FROM CLASS4_INFO;
