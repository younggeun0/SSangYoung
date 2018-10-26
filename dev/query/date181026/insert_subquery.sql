-- INSERT Subquery
-- 단수행
-- cp_emp3에 아래와 같은 레코드를 추가하세요
-- 사원번호 : 1111, 사원명 : 김희철, 부서번호 : 10
-- 직무 : 사원, 연봉 : emp테이블의 사원번호가 7566인 사원의
-- 연봉과 같은 연봉

INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1111, '김희철', 10, '사원',(SELECT sal
	    						FROM emp
	   							WHERE empno=7566));

SELECT * FROM cp_emp3;


-- 단수행 Subquery가 들어가야하는 곳에서 복수행 Subquery가 사용되면 에러가 발생
 INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1111, '김희철', 10, '사원',(SELECT sal FROM emp));

-- 컬럼하나에 값을 넣어야 하는 곳에 컬럼 여러개 조회되면
-- 추가하는 값의 갯수가 맞지 않으므로 에러발생
 INSERT INTO cp_emp3(empno, ename, deptno, job, sal)
VALUES(1111, '김희철', 10, '사원',(SELECT sal, deptno FROM emp));


-- 복수행(다중행) 서브쿼리
-- emp테이블에서 부서번호가 30번인 부서의
-- 사원번호, 사원명, 부서번호, 직무, 연봉을 조회하여
-- cp_emp3테이블에 한꺼번에 추가

INSERT INTO cp_emp3
(SELECT empno, ename, deptno, job, sal
 FROM emp
 WHERE deptno=30);

SELECT * FROM cp_emp3;


CREATE TABLE test(
	job VARCHAR2(9),
	sal number(7,2),
	hiredate VARCHAR2(7),
	input_date DATE
);

-- 테이블 수정
-- ALTER TABLE test ADD input_date DATE;
-- ALTER TABLE test MODIFY hiredate VARCHAR2(8);

-- 사원테이블에서 1981-02에 입사한 사원의 직무, 연봉,
-- 입사년-월, 입력일을 test테이블에 입력
INSERT INTO test(job, sal, hiredate, input_date)
(SELECT job, sal, TO_CHAR(hiredate, 'yyyy-mm'), SYSDATE
 FROM emp
 WHERE TO_CHAR(hiredate, 'yyyy-mm')='1981-02');

SELECT * FROM test;
             
/* 올바르진 않은 예제..
	INSERT INTO test
	(SELECT job, sum(sal), TO_CHAR(hiredate, 'yyyy-mm') hiredate, SYSDATE
	 FROM emp
	 WHERE TO_CHAR(hiredate, 'yyyy-mm')='1981-02'
	 GROUP BY job, hiredate);
 */
 
