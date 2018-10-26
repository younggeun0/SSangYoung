

-- SELECT
-- 단수행 서브쿼리
-- Scalar Subquery, SELECT 조회하는 컬럼에 서브쿼리를 쓰는 것
-- emp테이블에서 사원번호, 사원명, 부서번호, 부서명 조회
-- 부서명은 dept테이블에 존재
-- 같은 이름의 컬럼이 존재하면 어떤 테이블의 존재하는 컬럼인지 구분하여 사용해야 함
-- (테이블명.컬럼명)
SELECT empno, ename, deptno, (SELECT dname
							  FROM   dept
							  WHERE  dept.deptno=emp.deptno)
FROM   emp;

SELECT * FROM cp_emp3;

INSERT INTO cp_emp3
(SELECT empno, ename, deptno, job, sal
 FROM emp
 WHERE deptno IN (10, 30));

-- 사원테이블에서 사원번호가 '7698'인 사원의 부서번호와
-- 같은 부서를 cp_emp3테이블에서 조회
-- 조회 컬럼은 사원번호, 사원명, 부서번호, 직무를 조회

SELECT deptno
FROM emp
WHERE empno=7698;

SELECT empno, ename, deptno, job
FROM	cp_emp3
WHERE  deptno=(SELECT deptno
		       FROM emp
		       WHERE empno=7698);


-- 컬럼값의 다중행 서브쿼리를 쓸 때는 IN, ANY, ALL, EXISTS

-- 사원테이블에서 사원번호가 '7698', '7782'인 사원의 부서번호와
-- 같은 부서를 cp_emp3테이블에서 조회
-- 조회 컬럼은 사원번호, 사원명, 부서번호, 직무를 조회
SELECT	empno, ename, deptno, job
FROM	cp_emp3
WHERE	deptno IN(SELECT deptno
			      FROM   emp
			 	  WHERE  empno IN (7698, 7782));

-- 외부값 입력받기
-- 쿼리문에 &변수명 - 입력창이 동작 : 입력창에 입력한 값이 쿼리대입
-- &변수명이 쿼리문에 그대로 대입되므로 문자열을 입력할 경우 ''로 묶어 사용해야 함
SELECT *
FROM emp
WHERE deptno=&d_no;

SELECT *
FROM emp
WHERE ename=&ename;
-- KING을 입력하면 Error, ename=KING 이렇게 들어가므로 ''로 묶어야 조회됨

-- EXISTS : 서브쿼리에 값이 존재한다면 바깥쿼리를 수행
-- 사원 테이블에서 입력되는 부서번호가 존재한다면
-- 사원번호, 사원명, 입사일, 부서번호를 조회

SELECT  empno, ename, hiredate, deptno
FROM	emp
WHERE 	EXISTS (SELECT deptno
				FROM   emp
				WHERE  deptno=&no);

-- ALL : AND - 서브쿼리에 조회된 값 중 가장 작은값으로 비교연산 수행(<)

SELECT * FROM emp WHERE deptno=10;

-- 가장 sal인 1300보다 작은 결과를 조회함
SELECT empno, ename, sal, deptno
FROM   emp
WHERE  sal < ALL (SELECT sal
			      FROM emp
			      WHERE deptno=10);

-- 입력된 부서에서 가장 연봉이 작은 사원보다, 연봉이 작은 사원을 조회
SELECT empno, ename, sal, deptno
FROM   emp
WHERE  sal >= ALL (SELECT sal
  				  FROM   emp
  				  WHERE  deptno = &no);


-- ANY : OR - 서브쿼리에 조회된 값 중 가장 큰 값으로 비교연산 수행(<)
SELECT empno, ename, sal, deptno
FROM   emp
WHERE  sal < ANY(SELECT sal
				 FROM   emp
  				 WHERE  deptno = 10);


-- ROWNUM
-- 조회된 결과에 순차적인 번호를 붙이는 가상컬럼

-- 번호, 사원번호, 사원명, 입사일을 조회
-- 단, 번호는 조회결과에 1번부터 순차적으로 나와야 함
SELECT ROWNUM, empno, ename, hiredate
FROM   emp
WHERE  deptno IN (10, 20);

-- ORDER BY와 같이 사용되면 번호가 섞임(먼저 수행하기 때문)
SELECT   ROWNUM, empno, ename
FROM     emp
ORDER BY ename;

-- ROWNUM을 WHER절에서 사용하면 1번부터는 조회가 되나
-- 1번이 아닌 번호는 조회되지 않는다
-- 사원테이블에서 사원번호, 사원명, 입사일, 연봉을 조회
-- 단, 출력은 조회 순서  1~5까지만 출력
SELECT ROWNUM, empno, ename, hiredate, sal
FROM   emp
WHERE  ROWNUM BETWEEN 1 AND 5;

-- 1번이 아닌 번호로 시작을 하면 조회가 안됨
SELECT ROWNUM, empno, ename, hiredate, sal
FROM   emp
WHERE  ROWNUM BETWEEN 2 AND 5;

-- 복수행 서브쿼리
-- 조회결과(INLINE VIEW)를 가지고 재조회를 함
/*
	SELECT 컬럼명, ...
	FROM (SELECT ... )
*/

SELECT ROWNUM, empno, ename, sal, hiredate
FROM (SELECT   ROWNUM,empno, ename, sal, hiredate
	  FROM     emp
	  ORDER BY sal);

-- 사원테이블에서 가장 마지막에 입사한 사원부터 5명을 조회
-- 조회컬럼은 사원번호, 사원명, 입사일을 조회
SELECT ROWNUM, empno, ename, hiredate
FROM   (SELECT   empno, ename, hiredate
	    FROM	 emp
	    ORDER BY hiredate DESC)
WHERE  ROWNUM BETWEEN 1 AND 5;

-- 사원테이블에서 가장 마지막에 입사한 이전 사원(1987-04-19)부터 5명 조회
-- 조회 컬럼은 사원번호, 사원명, 입사일을 조회
SELECT ROWNUM, rn, empno, ename
FROM   (SELECT   ROWNUM rn, empno, ename, hiredate
	    FROM	 (SELECT   empno, ename, hiredate
	    		  FROM	   emp
	    		  ORDER BY hiredate DESC))
WHERE  rn BETWEEN 2 AND 6;


SELECT * FROM user_constraints;
