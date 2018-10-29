/*
 1. 아래에 조건에 맞는 테이블을 생성하고 적절한 제약사항을 부여한 후
	모든 제약조건에 성공하는 경우와 각각의 경우에 따라 실패하는 모든
	쿼리문을 작성하세요.

	부서번호, 사원명, 연봉, 이메일, 전화번호, 성별, 주소, 입사일, 사원번호를
	저장하는 테이블을 생성

	제약사항
	- 부서번호는 숫자 두자리이며 dept테이블의 deptno만 입력할 수 있다
	- 사원명은 가변길이형이고 한글로 10글자까지 입력 가능하며 반드시 입력해야한다.
	- 연봉은 숫자이고 억단위의 입력이 가능, 입력가능 연봉은 2400~8000까지 입력가능
	- 이메일과 전화번호는 없을 수도 있지만 있다면 유일함
	- 성별은 남자 또는 여자만 입력가능
	- 주소는 없을 수도 있다
	- 입사일은 날짜형식이며 추가할 때 입사일이 null이라면 현재날짜가 입력됨
	- 사원번호는 숫자 4자리이며 null을 허용하지 않고 데이터를 중복데이터를 저장할 수 없음

	모든 에러상황과 성공상황에 대한 쿼리 작성 후 FOREIGN KEY에 해당하는 제약사항을
	비활성화 시킨 후 삭제를 해보세요.
*/

CREATE TABLE personal_info(
	deptno   NUMBER(2) CONSTRAINT fk_personal_info_deptno REFERENCES dept(deptno),
	ename    VARCHAR2(30) NOT NULL,
	sal      NUMBER(9) CONSTRAINT c_sal CHECK (sal BETWEEN 24000000 AND 80000000),
	email    VARCHAR2(20) CONSTRAINT uk_personal_info_email UNIQUE,
	tel      VARCHAR2(13) CONSTRAINT uk_personal_info_tel UNIQUE,
	gender   CHAR(6) CONSTRAINT c_gender CHECK (gender IN ('남자', '여자')),
	address  VARCHAR2(30) NULL,
	hiredate DATE DEFAULT SYSDATE,
	empno    NUMBER(4) CONSTRAINT pk_personal_info PRIMARY KEY
);
SELECT * FROM personal_info;
ALTER TABLE personal_info MODIFY sal NUMBER(9) CONSTRAINT c_sal CHECK (sal BETWEEN 24000000 AND 80000000);
ALTER TABLE personal_info DROP CONSTRAINT c_sal;

SELECT * FROM user_constraints
WHERE  table_name='PERSONAL_INFO';

-- PK 제약사항 추가 성공
INSERT INTO personal_info(ename, empno)
VALUES ('오영근',1);

-- PK 제약사항 실패, 중복된 empno인 경우
INSERT INTO personal_info(ename, empno)
VALUES ('오영근', 1);

-- PK 제약사항 실패, empno값이 NULL인 경우
INSERT INTO personal_info(ename)
VALUES ('오영근');

-- FK 제약사항 추가 성공, deptno인 경우
INSERT INTO personal_info(ename, empno, deptno)
VALUES('김영근', 2, 10);
INSERT INTO personal_info(ename, empno, deptno)
VALUES('이영근', 3, 40);

-- FK 제약사항 추가 성공, deptno가 null인 경우
INSERT INTO personal_info(ename, empno, deptno)
VALUES('고영근', 4, '');
INSERT INTO personal_info(ename, empno)
VALUES('강영근', 5);

-- FK 제약사항 실패
INSERT INTO personal_info(ename, empno, deptno)
VALUES('조영근', 6, 100);

-- UNIQUE 제약사항 추가 성공, email과 tel은 UNIQUE
INSERT INTO personal_info(ename, empno, email, tel)
VALUES('장영근', 7, 'hello@world.com', '010-2222-3333');

-- UNIQUE 제약사항 실패, email중복된 값 삽입 시
INSERT INTO personal_info(ename, empno, email)
VALUES('손영근', 8, 'hello@world.com');

-- UNIQUE 제약사항 실패, tel중복된 값 삽입 시
INSERT INTO personal_info(ename, empno, tel)
VALUES('손영근', 8, '010-2222-3333');

-- CHECK 제약사항 추가 성공, sal과 gender
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('킴영근', 9, 28000000, '남자');
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('솔솔솔', 10, 75000000, '여자');

-- CHECK 제약사항 실패, c_sal CHECK조건 위배
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('죠영근', 11, 2400000, '남자');

-- CHECK 제약사항 실패, c_gender CHECK조건 위배
INSERT INTO personal_info(ename, empno, sal, gender)
VALUES('솔솔소', 12, 30000000, '사람');

-- NOT NULL 제약사항 추가 성공
INSERT INTO personal_info(ename, empno)
VALUES('영영근', 13);

-- NOT NULL 제약사항 실패, NULL삽입
INSERT INTO personal_info(empno)
VALUES(14);
INSERT INTO personal_info(ename, empno)
VALUES('', 14);

-- DEFAULT는 제약사항이 아니니 성공, 실패 존재안함
INSERT INTO personal_info(ename, empno)
VALUES('김민수', 15);

-- SYSDATE가 그간 만든 모든 레코드에 DEFAULT값으로 입력됨
SELECT * FROM personal_info;

-- FK 제약사항 DISABLE
ALTER TABLE personal_info DISABLE CONSTRAINT fk_personal_info_deptno;

SELECT * FROM user_constraints
WHERE  table_name='PERSONAL_INFO';

-- FK 제약사항이 적용 안됨, dept테이블 deptno외의 값을 갖는 데이터 입력가능
INSERT INTO personal_info(ename, empno, deptno)
VALUES('김미수', 16, 55);

-- FK 제약사항 ENABLE할 수 없음, empno 16인 레코드가 FK에 위배됨
ALTER TABLE personal_info ENABLE CONSTRAINT fk_personal_info_deptno;

-- 다시 empno 16번 레코드 삭제
DELETE FROM personal_info
WHERE empno=16;

-- 위 ENABLE 적용하면 에러없이 FK 제약조건 활성화
ALTER TABLE personal_info ENABLE CONSTRAINT fk_personal_info_deptno;

SELECT *
FROM user_constraints
WHERE table_name='PERSONAL_INFO';