
-- 제약사항을 확인 : user_constraints
-- 제약사항명은 테이블명처럼 유일해야 함
SELECT * FROM user_constraints;

-- column level constraint
-- 번호, 이름, 전화번호, 주민번호, 이메일 저장하는 테이블을 생성
-- 주민번호는 null을 허용하지 않으면서 유일해야함(PK)
CREATE TABLE column_primary(
	num NUMBER,
	name VARCHAR2(15),
	phone VARCHAR2(13),
	ssn CHAR(14) PRIMARY KEY,
	email VARCHAR2(50)
);

SELECT * FROM user_constraints;

INSERT INTO column_primary(num, name, ssn)
VALUES(1, 'test', '880101-1234567');

INSERT INTO dept(deptno, dname, loc)
VALUES (10, 't', 't');

DROP TABLE column_primary;
PURGE RECYCLEBIN;

CREATE TABLE column_primary(
	num NUMBER,
	name VARCHAR2(15),
	phone VARCHAR2(13),
	ssn CHAR(14) CONSTRAINT pk_column_primary PRIMARY KEY,
	email VARCHAR2(50)
);

SELECT * FROM user_constraints;

-- 컬럼하나로 PK가 구성되는 경우
-- 추가 성공
-- 최초 레코드 삽입
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (1, '이재찬','010-1234-5678','880101-1234567','lee@test.com');
COMMIT;

-- 주민번호가 다른 경우
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (2,'이재현','010-2222-6532','890101-1234567','jae@test.com');


-- 추가 실패
-- 같은 주민번호가 입력되는 경우 에러
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (3,'정택성','010-7281-3332','890101-1234567','jung@test.com');

-- NULL이 입력되는 경우
-- 숫자, 날짜는 컬럼이 생략되면 NULL이 입력되고
-- 문자열(고정길이, 가변길이)는 컬럼이 생략되는 경우와 ''(empty)로 데이터가 추가되는 경우에 null이 입력된다
-- 컬럼이 생략되어 insert되는 경우
INSERT INTO column_primary(num, name, phone, email)
VALUES (4, '오영근', '010-2332-2222', 'oh@test.com');

-- 컬럼은 정의되어 있으나 ''인 경우
INSERT INTO column_primary(num, name, phone, ssn, email)
VALUES (4, '오영근', '010-2332-2222', '','oh@test.com');

SELECT * FROM column_primary;

-- table level constraint
-- 이름, 아이디, 비밀번호 저장하는 테이블 생성
-- 아이디는 null을 허용하지 않으면서 값은 유일해야한다
CREATE TABLE table_primary(
	name VARCHAR2(30),
	id VARCHAR2(20),
	pw VARCHAR2(30),
	CONSTRAINT pk_table_primary PRIMARY KEY(id)
);

SELECT * FROM user_constraints;

-- 추가 성공
INSERT INTO table_primary(name, id, pw)
VALUES('김희철', 'kim', '1234');

COMMIT;

INSERT INTO table_primary(name, id, pw)
VALUES('김호호','test','1234');

SELECT * FROM table_primary;

-- 추가 실패
INSERT INTO table_primary(name, pw)
VALUES('김후호','1234');

INSERT INTO table_primary(name, id, pw)
VALUES('김희철', '', '1234');


-- 여러개의 컬럼이 PK로 구성되는 경우
-- table level constraint(테이블 단위 제약사항)으로만 설정 가능

-- 가장 큰사원번호 번호보다 1증가한 값으로 emp_00007899의 형식을 가진 값을 조회
SELECT CONCAT('emp_', LPAD(MAX(empno)+1, 8, 0)) output
FROM   emp;

-- 아이템명, 아이템 번호, 설명
-- 아이템번호는 레코드가 추가될 때 순차적으로 증가하며
-- 'ITEM_0001'의 형식을 가진다.
-- 아이템번호와 아이템명은 같은 수 없다
-- 시퀀스를 사용하던가 서브쿼리를 사용해 만들 수 있음.
CREATE TABLE table_multi_primary(
    item VARCHAR2(60),
    item_num CHAR(9),
    item_desc VARCHAR2(4000),
    CONSTRAINT pk_table_multi_primary PRIMARY KEY(item_num, item)
);


-- 레코드가 없을 때
-- table_multi_primary테이블에서
-- item을 'ITEM_0001'의 형식으로 조회
SELECT CONCAT('ITEM_',LPAD(NVL(MAX(item_num), 0)+1, 4, 0)) output
FROM   table_multi_primary;

-- 여러개의 컬럼이 하나의 PK로 구성되는 경우
-- 추가 성공 : 최초데이터 입력
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT 'ITEM_'||LPAD(NVL(MAX(item_num),0), 4, 0)
         FROM   table_multi_primary),'물폭탄','일정거리 쾅2');

-- 두 컬럼의 값이 모두 다른 경우 성공
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT CONCAT('ITEM_', LPAD(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1))+1,4,0))
FROM table_multi_primary),'물폭탄2', '일정거리 쾅2');

-- 두 컬럼 중 하나의 컬럼만 다른 경우도 성공
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT CONCAT('ITEM_', LPAD(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1))+1,4,0))
FROM table_multi_primary),'물폭탄2', '일정거리 쾅3');

SELECT * FROM table_multi_primary;

-- 에러가 발생하는 경우
-- 두 컬럼이 모두 같은 값을 가진다면 Error!
INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ('ITEM_0002','물폭탄2', '설명이 다른 물폭탄2 하지만 PK 두개가 같아서 에러가 날꺼야');

-- 둘 중 하나라도 null이 추가될 때 Error!
INSERT INTO table_multi_primary(item_num, item_desc)
VALUES('ITEM_0003', '앞선 특정 라이더를 조준하여 미사일 발사');

COMMIT;
/*
DELETE FROM dept
WHERE       deptno=30;

SELECT * FROM dept;
-- FK, 부모테이블은 자식레코드가 발견되면 삭제할 수 없다
ROLLBACK;
*/
DELETE FROM table_multi_primary;

SELECT * FROM table_multi_primary;
SELECT  'ITEM_'||LPAD(NVL(MAX(item_num), 0), 4, 0) output
FROM	table_multi_primary;

INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT 'ITEM_'||LPAD(NVL(MAX(item_num),0)+1, 4, 0)
         FROM   table_multi_primary),'목검','바람의나라 기본검');

INSERT INTO table_multi_primary(item_num, item, item_desc)
VALUES ((SELECT 'ITEM_'||LPAD(NVL(MAX(SUBSTR(item_num, INSTR(item_num,'_')+1)),0)+1, 4, 0)
		 FROM   table_multi_primary),'목검4','바람의나라 기본검3');

SELECT * FROM table_multi_primary;












