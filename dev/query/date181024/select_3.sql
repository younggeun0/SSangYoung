
-- ORDER BY를 사용한 정렬

SELECT * FROM emp;

-- 사원 테이블에서 사원번호, 사원명, 연봉, 입사일을 조회
-- 단, 연봉은 오름차순으로 정렬하여 출력할 것
SELECT		empno, ename, sal, hiredate
FROM		emp
ORDER BY	sal DESC;

-- 연봉이 같다면 입사일은 내림차순으로 정렬하여 출력할 것
SELECT		empno, ename, sal, hiredate
FROM		emp
ORDER BY	sal DESC, hiredate DESC;

-- 사원 테이블에서 매니저번호, 사원번호, 사원명, 연봉을 조회
-- 단, 매니저번호의 내림차순으로 정렬하되, 매니저번호가 같다면
-- 사원명의 오름차순으로 정렬
SELECT		mgr, empno, ename, sal
FROM		emp
ORDER BY	mgr DESC, ename;


-- 문자열에 저장된 숫자에 대한 정렬
CREATE TABLE test_orderby (
	num VARCHAR2(10)
);

INSERT INTO test_orderby(num)VALUES('1000');
INSERT INTO test_orderby(num)VALUES('1');
INSERT INTO test_orderby(num)VALUES('204');
INSERT INTO test_orderby(num)VALUES('21');
INSERT INTO test_orderby(num)VALUES('191');
INSERT INTO test_orderby(num)VALUES('300');
INSERT INTO test_orderby(num)VALUES('20001');

SELECT * FROM test_orderby;

-- 번호 오름차순 정렬
-- 문자열의 정렬은 자릿수의 정렬
SELECT * FROM test_orderby ORDER BY num;

COMMIT;









