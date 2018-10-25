
-- 수학함수
-- SIN, COS, TAN 구하는 함수
SELECT SIN(0), COS(0), TAN(0)
FROM DUAL;

-- 절대값 : ABS(값)
-- 음수를 양수로 변환해주는 함수
SELECT ABS(25), ABS(-25)
FROM DUAL;

-- 반올림 : ROUND(값, 반올림할자릿수)
SELECT ROUND(555.555, -2), ROUND(555.555, -1),
	   ROUND(555.555, 0), ROUND(555.555, 1),
	   ROUND(555.555, 2), ROUND(555.555, 3)
FROM DUAL;

-- 절삭 : TRUNC(값, 절삭할자릿수)
-- -1은 원단위 절삭
SELECT TRUNC(777.777, 2), TRUNC(777.777, -1)
FROM DUAL;

-- 올림 : CEIL(값)
SELECT CEIL(10.6), CEIL(10.0), CEIL(10.3)
FROM DUAL;

-- 내림 : FLOOR(값)
SELECT FLOOR(10.6), FLOOR(10.0), FLOOR(10.3)
FROM DUAL;

-- 사원테이블에서 사원번호, 사원명, 입사일, 연봉, 세금을 조회
-- 단, 세금은 연봉의 3.3%로 계산하고 원단위 절삭할 것
SELECT empno, ename, hiredate, sal, sal*1.033, TRUNC(sal*1.033, -1) tax
FROM emp;
       