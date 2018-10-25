-- 변환함수
-- 문자열이 아닌 값(숫자, 날짜)을 문자열로 변환 : TO_CHAR(숫자, pattern)
-- 숫자 -> 지정한 자리에 ,나 .을 출력

SELECT TO_CHAR(20181025, '0,000,000,000'),
	   TO_CHAR(20181025, '9,999,999,999')
FROM DUAL;

SELECT TO_CHAR(2018.1025, '999999.999')
FROM DUAL;

-- 사원테이블에서 사원번호, 사원명, 입사일, 연봉을 조회
-- 단, 연봉은 데이터가 있는 것까지만 ,를 넣어 출력

SELECT empno, ename, hiredate, TO_CHAR(sal, '999,999') sal
FROM emp;

-- Error! TO_CHAR함수로 반환되는 결과는 문자열이므로 산술연산이 되지 않음
SELECT TO_CHAR(sal, '9,999')+100
FROM emp;

-- 날짜를 문자열로 변환 : TO_CHAR(날짜, pattern)
SELECT TO_CHAR(SYSDATE, 'y'), TO_CHAR(SYSDATE, 'yy'),
	   TO_CHAR(SYSDATE, 'yyy'), TO_CHAR(SYSDATE, 'yyyy'),
	   TO_CHAR(SYSDATE, 'yyyyy')
FROM DUAL;

-- 월과 일은 mm, dd처럼 두개 꼭 두개 이상 써야 한다
-- 내가 보고싶은 형태로 패턴을 만듦
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd'), TO_CHAR(SYSDATE, 'mm-dd-yyyy')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24)')
FROM DUAL;

-- 날짜형이 시간형태로 입력이 되면 시간정보는 없음, 날짜 정보만 있음
-- SYSDATE만 시간정보 갖는다
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24):mi:ss')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24):mi:ss day dy q')
FROM DUAL;


-- perttern이 특수문자가 아닌 문자열 사용할때에는 "로 묶는다
SELECT TO_CHAR(SYSDATE, 'yyyy"년" mm"월" dd"일"')
FROM DUAL;


-- perttern을 너무 길게 사용하면 Error 발생!
-- 어지간히 써선 에러 안남




