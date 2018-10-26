

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
FROM emp;









