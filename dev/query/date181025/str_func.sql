-- 문자열 함수
-- 길이 : LENGTH(문자열)

SELECT 'oracle길이는 '||LENGTH('oracle')||'자' temp_col
FROM DUAL;

SELECT LENGTH('테스트') temp_col
FROM DUAL;

-- 사원테이블에서 사원명, 사원명의 글자수를 조회
SELECT ename, LENGTH(ename) lengthofname
FROM emp;

-- 사원테이블에서 사원명이 4자인 사람의 사원명을 조회
SELECT ename
FROM emp
WHERE ename LIKE '____';

-- LENGTH 함수를 사용하면 관계연산자 사용, 더 유연하게 조회 가능
SELECT ename
FROM emp
WHERE LENGTH(ename)=4;

-- 4자 이상인 사원
SELECT ename
FROM emp
WHERE LENGTH(ename)>4;

-- 대문자 : UPPER(문자열)
-- 영어만 적용됨
SELECT UPPER('hello world!') temp_col, UPPER('한글english') temp_col2
FROM DUAL;

-- 소문자 : LOWER(문자열)
SELECT LOWER('HELLO WORLD') temp_col
FROM DUAL;

-- 사원테이블에서 사원명이 'scott'인 사원의 사원번호, 사원명,
-- 입사일, 연봉을 조회

SELECT empno, ename, hiredate, sal
FROM emp
WHERE LOWER(ename)='scott';

SELECT empno, ename, hiredate, sal
FROM emp
WHERE ename=upper('scott');

-- 사원테이블에서 사원명을 모두 소문자로 조회
SELECT LOWER(ename)
FROM emp;

-- INITCAP()은 영어 문자열의 첫 글자를 대문자로 나머지 글자를 소문자로 변환해 반환
-- 사원테이블에서 사원명의 첫 글자만 대문자로 바꿔 조회
SELECT INITCAP(ename)
FROM emp;

-- 인덱스 얻기 : INSTR(문자열, 찾을문자열)
-- 해당 문자열을 못 찾으면 0을 반환
SELECT INSTR('AbcdeF', 'A'), INSTR('AbcdeF', 'F'),
	   INSTR('AbcdeF', 'c'), INSTR('AbcdeF', 'a')
FROM DUAL;

SELECT INSTR('한글도잘찾아요','잘'),
	   INSTR('한글도잘찾아요','찾')
FROM DUAL;

SELECT * FROM class4_info;

INSERT INTO class4_info(num, name, email)
VALUES(6, '테스트','test@kr');

INSERT INTO class4_info(num, name, email)
VALUES(7, '테스트1','test.kr');

COMMIT;

-- class4_info테이블에서 번호, 이름, 이메일, 이메일의 유효성을 조회
-- 이메일의 유효성은 INSTR로 @과 .의 여부로 확인가능
SELECT num, name, email, INSTR(email, '@'), INSTR(email, '.')
FROM class4_info;

-- 문자열 자르기 : SUBSTR(문자열, 시작인덱스, 자를글자수)
-- 자를 글자수가 없다면 시작인덱스부터 끝인덱스까지 자름
-- 'Abcdefg'문자열에서 'def'를 자르고 싶다면
SELECT SUBSTR('Abcdefg', 4,3), SUBSTR('Abcdefg', 2,5),
	   SUBSTR('Abcdefg', 1)
FROM DUAL;

-- class4_info 테이블에서 번호, 이름, email 컬럼의 '메일 주소'만 조회
-- 메일주소@도메인주소
SELECT num, name, email, SUBSTR(email, 1, INSTR(email, '@')-1)
FROM class4_info
WHERE INSTR(email, '@')!=0 AND INSTR(email, '.')!=0;

-- 도메인주소만 조회
SELECT email, SUBSTR(email, INSTR(email, '@')+1)
FROM class4_info
WHERE INSTR(email, '@')!=0 AND INSTR(email, '.')!=0;

-- 앞뒤공백제거 : TRIM(문자열)
SELECT '['||TRIM('   ABC   ')||']'
FROM DUAL;

-- 앞공백제거 : LTRIM(문자열)
SELECT '['||LTRIM('   ABC   ')||']'
FROM DUAL;

-- 뒷공백제거 : RTRIM(문자열)
SELECT '['||RTRIM('   ABC   ')||']'
FROM DUAL;

SELECT TRIM('a' FROM 'aaaaaaOracleaaaaaa')
FROM DUAL;

SELECT TRIM('-' FROM '-----Oracle------')
FROM DUAL;

-- 첫글자를 대문자로 : INITCAP(문자열)

SELECT INITCAP('oracle') FROM DUAL;
SELECT INITCAP('java jsp jQuery') FROM DUAL;
SELECT INITCAP('SCOTT') FROM DUAL;

SELECT INITCAP(ename)
FROM emp;

-- 문자열 붙이기 : CONCAT(문자열, 붙일문자열)
SELECT CONCAT('ABC', 'DEF') FROM DUAL;
SELECT 'ABC'||'DEF' FROM DUAL;

SELECT CONCAT(CONCAT('ABC', 'DEF'), 'GHI')
FROM DUAL;

-- 붙일 문자열이 많아질 수록 ||붙임연사자 사용이 훨씬 좋다
SELECT 'ABC'||'DEF'||'GHI'
FROM DUAL;


-- 문자열 채우기
-- 왼쪽으로 채우기 : LPAD(문자열, 총자릿수, 채울문자열)
SELECT LPAD('ABCDE', 7,'$'), LPAD('ABCDEFG', 10, 0)
FROM DUAL;

-- 오라클은 자동형변환이 잘 되어있음
SELECT LPAD('ABCDE', 10, 0)
FROM DUAL;

-- 오른쪽으로 채우기 : RPAD(문자열, 총자릿수, 채울문자열)
SELECT RPAD('ABCDEF', 10,'가'), RPAD('ABC', 10, '#')
FROM DUAL;
