
-- UPDATE Subquery
-- 다른테이블의 값을 참조하여 현재 테이블의 값을 변경할 때 사용
-- 다중행보단 단일행 Subquery를 권장함

-- cp_emp3테이블에서 사원번호가 '1111'인 사원의 연봉을
-- emp테이블의 사원번호가 '7788'인 사원의 연봉으로 변경

SELECT * FROM cp_emp3;
SELECT * FROM emp;

UPDATE cp_emp3
SET sal=(SELECT sal
		 FROM emp
		 WHERE empno=7788)
WHERE empno=1111;

-- 다중행이 값에 들어갈 수 없어 Error
UPDATE cp_emp3
SET sal=(SELECT sal FROM emp)
WHERE empno=1111;


-- 다중값이 들어 갈 수 없어 ERROR
UPDATE cp_emp3
SET sal=(SELECT sal,deptno
 		 FROM emp
 		 WHERE empno=7788)
WHERE empno=1111;

-- 복수행 서브쿼리는 IN을 사용하여 WHERE절에 사용가능
INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(2222, '테스트', 30, 'salesman', 2000);

COMMIT;

SELECT * FROM cp_emp3;

-- cp_emp3테이블에서 부서번호가 30인 emp테이블의
-- 사원번호와 같은 사원의 연봉을 1000으로 변경

SELECT empno
FROM   emp
WHERE  deptno=30;

UPDATE cp_emp3
SET    sal=1000
WHERE  empno IN (SELECT empno
				 FROM   emp
 				 WHERE  deptno=30);

SELECT * FROM cp_emp3;

-- DELETE Subquery
-- 다른테이블의 값을 참조하여 현재 테이블 레코드 삭제
-- 단수행 서브쿼리

UPDATE cp_emp3
SET	   ename='블랑카'
WHERE  empno=7698;
COMMIT;

SELECT * FROM cp_emp3;
SELECT * FROM cp_emp;
SELECT * FROM emp;
-- cp_emp3테이블에서 사원정보를 삭제할 것
-- 삭제조건 : emp테이블의 사원명이 'BLAKE'인 사원의
--         사원번호와 같은 사원을 cp_emp3테이블에서 삭제

DELETE FROM cp_emp3
WHERE empno=(SELECT empno
			 FROM emp
			 WHERE ename='BLAKE');

SELECT * FROM cp_emp3;


-- 복수행 서브쿼리
-- cp_emp3테이블에서 emp테이블의 부서번호가
-- 30번인 모든 사원들의 사원번호와 같은 사원을 삭제

DELETE FROM cp_emp3
WHERE empno IN (SELECT empno
			    FROM   emp
			    WHERE  deptno=30);

SELECT * FROM cp_emp3;
