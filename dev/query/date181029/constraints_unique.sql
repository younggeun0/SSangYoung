
SELECT * FROM user_indexes;

-- column level constraint
-- unique : 값이 없을 수도 있고 있다면 유일해야 할 때
-- 이름, 이메일, 주소를 저장하는 테이블을 생성

CREATE TABLE column_unique(
	name    VARCHAR2(30),
	email	VARCHAR2(50) CONSTRAINT uk_email UNIQUE,
	address VARCHAR2(100)
);


SELECT * FROM user_constraints;
SELECT * FROM column_unique;

--ALTER TABLE column_unique MODIFY name VARCHAR2(30);
-- 추가 성공
-- 최초 입력 시
INSERT INTO column_unique(name, email, address)
VALUES('이재찬', 'lee@test.com', '경기도 수원시 영통구');
COMMIT;
-- 이메일이 없는 경우(null이 들어가는 경우)
INSERT INTO column_unique(name, email, address)
VALUES('이재찬', '', '경기도 수원시 영통구');

INSERT INTO column_unique(name, address)
VALUES('이재찬1','경기도 수원시 팔달구');

SELECT * FROM column_unique;

-- 추가 실패하는 경우
-- 같은 이메일이 입력되었을 때
INSERT INTO column_unique(name, email, address)
VALUES('박영민', 'lee@test.com', '부산시');

-- table level constraint
-- 번호, 이름, 전화번호, 카드번호를 저장하는 테이블 생성
-- 전화번호와 카드번호는 없을 수도 있고 있다면 유일해할 것
CREATE TABLE table_unique(
	num NUMBER(5),
	name VARCHAR2(30),
	tel VARCHAR2(13),
	card_num VARCHAR2(4),
	CONSTRAINT uk_tel UNIQUE(tel),
	CONSTRAINT uk_card_num UNIQUE(card_num)
);

SELECT * FROM table_unique;

SELECT * FROM user_constraints;
SELECT * FROM user_indexes;

-- 추가 성공
-- 최초입력
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(1, '김정운', '010-8798-8999', '1234');

-- 전화번호와 카드번호가 다른 경우
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(2,'이재현','010-1111-2222','1235');

-- null입력되는 경우
INSERT INTO table_unique(num, name)
VALUES(3,'이재현운');

INSERT INTO table_unique(num, name, tel, card_num)
VALUES(3,'이재현운', '', '');

SELECT * FROM table_unique;

-- 전화번호든 카드번호든 둘 중 하나라도 같다면 에러
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(4, '정택성', '010-1111-3333', '1235');

-- 전화번호든 카드번호든 둘 중 하나라도 같다면 에러
INSERT INTO table_unique(num, name, tel, card_num)
VALUES(4, '정택성', '010-1111-3333', '9999');                 * 
SELECT * FROM table_unique;

