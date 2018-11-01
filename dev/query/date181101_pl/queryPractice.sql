
SELECT * FROM emp;

SELECT * FROM user_views;

SELECT * FROM all_users;
SELECT * FROM dba_users;

CREATE VIEW depAndEmp
AS (SELECT e.empno, e.ename, d.deptno, d.dname
	FROM emp e, dept d
	WHERE e.deptno = d.deptno);

SELECT * FROM depAndEmp;

DROP VIEW depAndEmp;

CREATE VIEW test_view1
AS (SELECT *
	FROM emp);

INSERT INTO test_view1(ename, empno)
VALUES ('young', 1234);

SELECT * FROM test_view1
WHERE ename='young';

DELETE FROM test_view1
WHERE ename='young';

DROP VIEW test_view1;

CREATE VIEW test_view1
AS (SELECT *
	FROM emp)
	WITH READ ONLY;

-- 읽기전용 뷰엔 DML 못 씀
INSERT INTO test_view1(ename, empno)
VALUES ('young', 1234);

DROP VIEW test_view1;

CREATE SYNONYM e FOR emp;

SELECT * FROM e;

INSERT INTO e(empno, ename)
VALUES(1234, 'young');

SELECT * FROM user_synonyms;

SELECT * FROM user_synonyms;

DELETE FROM emp WHERE ename='young';

CREATE UNIQUE INDEX idx_zip ON zipcode(seq);

SELECT /*+ INDEX(idx_zip) */*
FROM zipcode;

SELECT *
FROM zipcode;

DROP INDEX idx_zip;

CREATE INDEX idx_seq ON zipcode(seq);

ALTER INDEX idx_zipcode REBUILD;

SELECT * FROM user_indexes;

SELECT deptno, COUNT(*), SUM(sal), MAX(sal)
FROM emp
GROUP BY deptno
HAVING COUNT(*) > 4;

SELECT REPLACE('오늘은 토요일입니다.', '토요일', '목요일')FROM DUAL;

SELECT tname FROM tab;
