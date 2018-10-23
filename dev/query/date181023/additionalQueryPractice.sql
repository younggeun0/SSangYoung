
SELECT ename, hiredate, sal
FROM emp
WHERE hiredate > '81/01/01'
OR sal >= 1300;

SELECT empno, ename, sal, comm
FROM emp
WHERE sal > 1000
AND (comm < 1000 OR comm IS NULL);

SELECT empno, ename, sal, comm
FROM emp
WHERE sal > 1000
AND comm < 1000 OR comm IS NULL;

SELECT empno, ename, sal
FROM emp
WHERE empno = &empno;

SELECT empno, ename
FROM &table
WHERE sal = 3000;

SELECT ename, sal, hiredate
FROM emp
ORDER BY ename;

SELECT deptno, sal, ename
FROM emp
ORDER BY deptno ASC, sal DESC;

SELECT ename, sal, hiredate
FROM emp
WHERE sal > 1000
ORDER BY 2, 1;

SELECT tname FROM tab;

drop table student;

CREATE TABLE student(
	studno NUMBER(4),
	name VARCHAR2(15),
	deptno1 NUMBER(3)
);

INSERT INTO student
VALUES(9411, 'James Seo', 101);

INSERT INTO student
VALUES(9511, 'Billy Crystal', 101);

INSERT INTO student
VALUES(9611, 'Richard Dreyfus', 101);

INSERT INTO student
VALUES(9711, 'Danny Devito', 101);

SELECT * FROM student;


CREATE TABLE professor(
  profno NUMBER(4),
  name VARCHAR2(15),
  deptno NUMBER(3)
);

INSERT INTO professor
VALUES(1001, 'Audie Murphy', 101);

INSERT INTO professor
VALUES(1002, 'Angela Bassett', 101);

INSERT INTO professor
VALUES(1003, 'Jessica Lange', 101);

SELECT * FROM professor;

SELECT studno, name, deptno1, 1
FROM student
WHERE deptno1=101
UNION ALL
SELECT profno, name, deptno, 2
FROM professor
WHERE deptno=101;

DROP TABLE student;
DROP TABLE professor;

SELECT empno, ename, sal
FROM emp
MINUS
SELECT empno, ename, sal
FROM emp
WHERE sal > 2500;
