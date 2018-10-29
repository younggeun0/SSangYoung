
-- CHECK, NOT NULL, DEFAULT
-- CHECK : 컬럼의 값을 유효성 검증된 값으로 추가할 때 사용
-- NOT NULL : 값을 반드시 입력받아야 할 때 사용
-- DEFAULT : 컬럼이 생략되어 NULL이 입력될 때 대신 들어갈 기본 값으로 사용

-- 이름, 나이, 주소, 입력일을 저장하는 테이블을 생성
-- 단, 이름은 필수입력이고 나이는 20~30대만 입력가능하고
-- 입력일은 생략 시 현재날짜가 입력되도록 설정
CREATE TABLE other_constraints(
	name VARCHAR2(30byte) CONSTRAINT c_name NOT NULL,
	age NUMBER(2) CONSTRAINT c_age CHECK(age BETWEEN 20 AND 39),
	addr VARCHAR2(20byte) NULL,
	input_date DATE DEFAULT SYSDATE
);
--ALTER TABLE other_constraints MODIFY addr VARCHAR2(30);

-- usr_constraints에서는 제약사항(PK, FK, UK, CHECK, NOT NULL)만 확인가능
SELECT * FROM user_constraints;

-- DEFAULT는 user_tab_cols 딕셔너리에서 확인 가능
SELECT COLUMN_NAME, DATA_DEFAULT FROM user_tab_cols
WHERE table_name='OTHER_CONSTRAINTS';

-- 추가 성공
-- 최초 데이터
INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('이재찬',27,'서울시','2018-10-26');

-- 주소와 입력일 생략
INSERT INTO other_constraints(name, age)
VALUES('박영민', 57);

SELECT * FROM other_constraints;

-- 에러나는 경우
-- 이름이 생략되는 경우 NOT NULL조건 위배
INSERT INTO other_constraints(age, addr, input_date)
VALUES(27, '서울시', '2018-10-28');

INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('', 27, '서울시', '2018-10-28');

-- 나이가 20~30대가 아닌 경우
INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('이재찬', 15, '서울시', '2018-10-28');

INSERT INTO other_constraints(name, age, addr, input_date)
VALUES('이재찬', 40, '서울시', '2018-10-28');

-- NOT NULL은 테이블 단위 제약사항으로는 설정할 수 없음
CREATE TABLE temp(
	name VARCHAR2(10),
	CONSTRAINT c_name1 NOT NULL(name)
);