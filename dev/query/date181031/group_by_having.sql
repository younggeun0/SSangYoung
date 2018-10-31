
-- HAVING : 그룹으로 묶일 조건을 줄 때 사용
-- 사원수가 4명 이상인 부서의 부서번호, 사원수, 연봉합, 최고연봉을 조회

SELECT   deptno, COUNT(empno), SUM(sal), MAX(sal)
FROM     emp
GROUP BY deptno
HAVING   COUNT(deptno) >= 4;


-- REPLACE : 값을 치환할 때 사용

SELECT  REPLACE('정택성, 이재현, 이재찬, 김희철', '이재찬', '인천시의 자랑 이재찬') output
FROM	DUAL;
