CREATE OR REPLACE
 -- 난수(Random number)
-- 컴퓨터가 임의의 수를 생성하여 반환하는 것
-- DBMS_RANDOM 패키지 사용
-- DBMS_RANDOM.VALUE(시작, 범위) - 숫자를 얻는 함수
-- DBMS_RANDOM.STRING('형식', 난수갯수) - 문자열을 얻는 함수
--  형식 : u - 영문자 대문자, l - 영문자 소문자,
--         a - 대소문자 혼합, x - 대문자, 숫자 혼합,
--         p - 대소문자 숫자 특수문자 혼합

-- 1에서부터 10 사이의 난수 얻기 (소수발생)
SELECT TRUNC(DBMS_RANDOM.VALUE(1, 10), 0) random_number
FROM dual;
                       
-- 랜덤 문자열 얻기
SELECT DBMS_RANDOM.STRING('u',10) u,
			 DBMS_RANDOM.STRING('l',10) l,
			 DBMS_RANDOM.STRING('a',10) a,
			 DBMS_RANDOM.STRING('x',10) x,
			 DBMS_RANDOM.STRING('p',10) p
FROM DUAL;


/