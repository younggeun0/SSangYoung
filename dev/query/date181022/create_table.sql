-- 181022 Oracle DBMS 학습시작

-- 한줄 주석
/*
    여러줄 주석

-- table명 출력 
SELECT tname FROM tab;

-- 해당 테이블 구조 파악 가능
DESC emp;

-- 테이블 생성
CREATE TABLE new_table(
    no NUMBER(3),
    name VARCHAR2(10),
    birth DATE
);

-- DEFAULT값 갖는 테이블 생성
CREATE TABLE new_table2(
    no NUMBER(3,1) DEFAULT 0,
    name VARCHAR2(10) DEFAULT 'No Name',
    hiredate DATE DEFAULT SYSDATE);

-- 새로운 데이터 입력
INSERT INTO new_table2 (no) VALUES(1);
INSERT INTO new_table2 (name) VALUES('YOUNG');

SELECT * FROM new_table2;

CREATE TABLE Dept2(
    dcode NUMBER(5),
    dname VARCHAR2(100),
    pdept NUMBER(5),
    area VARCHAR2(100)
);

INSERT INTO Dept2(dcode, dname, pdept, area)
VALUES (9000, 'temp_1', 1006, 'temp area');

INSERT INTO Dept2
VALUES (9001, 'temp_2', 1006, 'temp area');

SELECT * FROM Dept2;

CREATE TABLE professor(
    profno NUMBEr(5) DEFAULT 100,
    name VARCHAR2(20) DEFAULT 'No Name',
    id VARCHAR2(20) DEFAULT 'No Id',
    position VARCHAR2(20) DEFAULT 'No Position',
    pay NUMBER(10) DEFAULT 10,
    hiredate DATE DEFAULT SYSDATE
);

SELECT * FROM professor;

INSERT INTO professor(profno, name, id, position, pay, hiredate)
VALUES (5001, 'James', 'LoveMe', 'a Full Professor', 500, '2018-10-22');

SELECT * FROM professor;

CREATE TABLE t_minus(
    no1 NUMBER,
    no2 NUMBER(3),
    no3 NUMBER(3,2)
);

INSERT INTO t_minus VALUES(1, 1, 1);
INSERT INTO t_minus VALUES(1.1, 1.1, 1.1);
INSERT INTO t_minus VALUES(-1.1, -1.1, -1.1);

SELECT * FROM t_minus;

DROP TABLE t_minus;

UPDATE professor
SET pay = 1000
WHERE position = 'a Full Professor';

SELECT * FROM professor;

SELECT * FROM emp;

SELECT *
FROM emp;

SELECT empno, ename FROM emp;

COL empno FOR 9999
COL ename FOR a8
SET LINE 200
SET PAGES 50

SELECT * FROM emp;

SELECT name, 'good morning~~!' "Good Morning" FROM professor;

SELECT name, '''s salary is.. ' "'s salary is..'", pay FROM professor;

SELECT DISTINCT deptno FROM emp;

SELECT job, ename
FROM emp
ORDER BY 1, 2;

-- DISTINCT 키워드는 모든 컬럼에 적용됨!
SELECT DISTINCT job, ename
FROM emp
ORDER BY 1, 2;

-- 연결 연산자 사용 시 연결한 컬럼은 오라클에서 1개의 컬럼으로 인식
SELECT ename ||' ''s job is '||job AS "NAME AND JOB" FROM emp;

--연습문제 풀이1
CREATE TABLE student (
    id VARCHAR2(10) DEFAULT NULL,
    weight NUMBER(3) DEFAULT 0 
);

INSERT INTO student VALUES('hello1', 60);
INSERT INTO student VALUES('hello2', 70);
INSERT INTO student VALUES('hello3', 80);

SELECT id || '''s weight is ' || weight "ID AND WEIGHT" FROM student;

--연습문제 풀이2
DESC emp;
SELECT ename || '(' || job || '), ' || ename || ''' ' || job || '''' AS "NAME AND JOB" FROM emp;

--연습문제 풀이3
DESC emp;
SELECT ename||'''s sal is $'||sal AS "Name and Sal" FROM emp;

DROP TABLE new_table;
DROP TABLe new_table2;
DROP TABLE Dept2;
DROP TABLE professor;
*/