
-- 순위 구하기
-- 전체 순위 구하기
-- RANK() OVER( ORDER BY 순위를구할컬럼명 정렬방식) - 중복번호 발생가능

-- 사원테이블에서 사원번호, 사원명, 연봉, 연봉순위
-- RANK() OVER()는 중복순위 발생할 수 있음
SELECT empno, ename, sal, RANK() OVER(ORDER BY sal DESC) rank
FROM emp;

-- 위 내용을 중복순위가 발생하지 않도록 처리하여 조회
SELECT empno, ename, sal, ROW_NUMBER() OVER(ORDER BY sal DESC) rank
FROM emp;

-- 조회된 레코드를 그룹별 순위 매기기 : PARTITION BY
-- 사원테이블에서 사원번호, 사원명, 연봉, 부서번호,  부서별연봉순위 조회
SELECT empno, ename, sal, deptno, RANK() OVER(PARTITION BY deptno ORDER BY sal DESC) deptrank
FROM emp;

-- 부서별연봉순위를 중복조회를 없이 조회
SELECT empno, ename, sal, deptno, ROW_NUMBER() OVER(PARTITION BY deptno ORDER BY sal DESC) deptrank
FROM emp;

