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

SELECT TO_CHAR(SYSDATE, 'y'),TO_CHAR(SYSDATE, 'yy'
	   TO_CHAR(SYSDATE, 'yyy')
FROM DUAL;




