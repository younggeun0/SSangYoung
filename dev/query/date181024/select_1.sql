-- 컬럼을 붙여 문자열로 조회 : || 연산자를 사용
-- EMP 테이블에서 사원번호, 사원명, 직무를 조회
-- 출력형식은 : 사원명(사원번호)님은 직무입니다.

SELECT *
FROM emp;

-- ','로 컬럼이 나눠져 조회됨
SELECT	ename, empno, job
FROM	emp;

-- 컬럼이 하나로 합쳐져서 알아보기가 힘듦
SELECT 	ename || empno || job
FROM 	emp;

SELECT	ename||' ('||empno||')님은 '||job||'입니다.' output
FROM	emp;

-- alias를 쌍따옴표로 묶어서 부여하면 대소문자가 가려짐, 조회 시 불편하므로 비권장
SELECT ename AS "Ename"
FROM   emp;

-- alias는 바로 아래 WHERE절에서 사용할 수 없다
SELECT  empno, ename, sal
FROM	emp
WHERE	sal < 3000;

-- 아래 쿼리 실행 시 '부적합한 식별자' 에러 발생
SELECT	empno, ename, sal s
FROM	emp
WHERE	s < 3000;

-- 산술연산자 : +, -, *, /
-- 사원테이블에서 사원번호, 사원명, 연봉, 세금을 조회
-- 단, 세금은 연봉에 3.3% 계산하여 출력
SELECT  empno, ename, sal, sal * 0.033 tax
FROM	emp;

-- 사원번호는 현재 번호에 10을 더한 값으로 출력
SELECT 	empno, empno + 10 new_empno
FROM 	emp;

-- 컬럼값끼리 연산도 가능
SELECT  empno - mgr
FROM	emp;

-- null은 연산되면 결과가 null이 나옴
-- 사원테이블에서 사원번호, 연봉, 보너스, 총 수령액을 조회
-- 단, 총 수령액은 연봉과 보너스를 합산한 금액으로 조회

-- SAL + COMM 연산 시 COMM이 없는 사람들은 null과 합산하는 연산을 할 것
SELECT * FROM emp;

-- NULL인 컬럼과 값 있는 컬럼 연산 시 NULL이 나옴
-- NULL인 컬럼에 연산을 하기 위해서 NVL 함수를 사용
SELECT	empno, sal, comm, sal+NVL(comm, 0) total
FROM    emp;

-- 나눈 나머지 : mod(컬럼명, 나눌값) 함수 사용
SELECT  sal, mod(sal, 3)
FROM	emp;

-- dual 테이블은 모든 계정에서 사용할 수 있는 가상테이블
-- 입력되는 값으로 컬럼을 생성하여 조회처리
SELECT '오영근', mod(1, 3) FROM DUAL;

SELECT  '오영근' name
FROM	dual;

SELECT	mod(10,2), mod(11,2), mod(3,2), mod(5,2)
FROM	dual;

-- 생년/12 나머지 구하기
SELECT  mod(1990,12)
FROM	dual;
-- 0~11
-- 11:양, 10:말, 9:뱀, 8:용, 7:토끼, 6:호랑이,
-- 5:소띠, 4:쥐, 3:돼지, 2:개, 1:닭, 0:원숭이


-- 조회하는 컬럼에 관계연산자를 사용하면 error
SELECT  sal > 3000
FROM	emp;

SELECT 	sal
FROM	emp
WHERE 	sal > 3000;



-- 관계연산자 : WHERE절, HAVING절에서 사용
-- >, <, >=, <=, =, !=(<>)
-- 사원테이블에서 연봉이 3000보다 작거나 같은  사원의 사원번호,
-- 사원명, 매니저번호, 연봉, 입사일, 부서번호 조회
SELECT  empno, ename, mgr, sal, hiredate, deptno
FROM	emp
WHERE	sal <= 3000;

-- 사원 테이블에서 연봉이 3000이상인 사원의 사원번호,
-- 사원명, 매니저번호, 연봉, 입사일, 부서번호 조회
SELECT	empno, ename, mgr,sal, hiredate, deptno
FROM	emp
WHERE	sal >= 3000;


-- 사원 테이블에서 부서번호가 '30'번인 사원들의
-- 사원번호, 사원명, 직무, 입사일, 부서번호를 조회
SELECT  empno, ename, job, hiredate, deptno
FROM	emp
WHERE	deptno=30;


-- 사원 테이블에서 부서번호가 20번이 아닌 사원들의
-- 사원번호, 부서번호, 사원명, 직무를 조회
SELECT	empno, deptno, ename, job
FROM	emp
WHERE 	deptno<>20;
--WHERE	deptno!=20;

-- 사원 테이블에서 보너스가 없는 사원의 사원번호, 사원명, 연봉, 보너스 조회
-- null은 관계 연산자로 비교할 수 없다.
-- IS NULL, IS NOT NULL로 조회
SELECT	empno, ename, sal, comm
FROM	emp
WHERE	comm IS NULL;

-- 보너스가 있는 사원들
SELECT 	empno, ename, sal, comm
FROM	emp
WHERE	comm IS NOT NULL AND comm!=0;

-- 논리 연산자 : AND, OR, NOT
-- AND (모든 비교조건이 맞는 레코드를 조회)
-- OR (비교조건에 해당하는 모든 레코드를 조회)
-- 사원테이블에서 사원번호가 7369 이면서 직무가 clerk인 사원의
-- 사원번호, 사원명, 직무, 입사일, 연봉을 조회
SELECT	empno, ename, job, hiredate,sal
FROM	emp
WHERE	empno=7369 AND job='CLERK';

-- 사원테이블에서 연봉이 1500이상 3000이하인 사원들의
-- 사원번호, 사원명, 직무, 입사일, 연봉 조회
SELECT	empno, ename, job, hiredate, sal
FROM 	emp
WHERE	sal >= 1500 AND sal <= 3000;

-- 범위를 검색조건으로 사용할 때에는 BETWEEN을 사용할 수 있다.
-- 문법) 컬럼명 BETWEEN 작은값 AND 큰값
SELECT 	empno, ename, job, hiredate, sal
FROM	emp
WHERE	sal BETWEEN 1500 AND 3000;

-- 사원 테이블에서 7902, 7839, 7566 매니저의 관리를 받는 사원의
-- 사원번호, 사원명, 매니저번호, 연봉, 입사일 조회
SELECT  empno, ename, mgr, sal, hiredate
FROM	emp
WHERE	mgr=7902 OR mgr=7839 OR mgr=7566;

-- OR는 쉽게 길어지므로 IN()으로 바꿔 쓸 수 있다.
-- 사용법) 컬럼명 IN (값, 값, ...)
SELECT	empno, ename, mgr, sal, hiredate
FROM	emp
WHERE	mgr NOT IN (7902, 7839, 7566);

-- IN()은 포함하는 결과 조회, NOT IN()은 포함하지 않는 결과 조회






