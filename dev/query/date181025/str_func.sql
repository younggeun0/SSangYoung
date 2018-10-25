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
	   INSTR('한글도잘찾아요','')
FROM DUAL;


