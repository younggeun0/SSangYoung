
SELECT * FROM user_procedures;

DROP FUNCTION plus;

-- 입력되는 주민번호의 유효성 검증
SELECT check_ssn('901201-1234567') ssn1,
	     check_ssn('333333-123') ssn2,
	     check_ssn('90020241234567') ssn3
FROM dual;

SELECT * FROM class4_info;

UPDATE class4_info
SET name='김정운', ssn='7702031-234567'
WHERE num = 5;

UPDATE class4_info
SET ssn = '880101-123456'
WHERE num = 6;

COMMIT;

-- class4_info 테이블에서 번호, 이름, 주민번호,
-- 주민번호의 형식 체크하여 모든 레코드를 조회

SELECT num, name, ssn, check_ssn(ssn) check_res
FROM class4_info;

-- 주민번호가 유효할 때 나이를 구하는 함수 사용
SELECT get_age_from_ssn('010101-4234567') age,
			 get_age_from_ssn('780101-1234566') age,
			 get_age_from_ssn('990101-0234566') age,
			 get_age_from_ssn('030202-3123456') age
FROM dual;

INSERT INTO class4_info(num, name, ssn)
VALUES(8,'JAMES','890307-5234567');

INSERT INTO class4_info(num,name,ssn)
VALUES(9,'혜리','030102-4234567');

INSERT INTO class4_info(num, name, ssn)
VALUES(10, '오영군', '990107-9234567');

-- 번호, 이름, 주민번호, 나이, 조회
-- 나이는 주민번호가 유효했을 때는 나이를 보여주고
-- 유효하지 않다면 0을 보여줌
SELECT num, name, ssn, get_age_from_ssn(ssn) age
FROM class4_info
WHERE num IN (8,9,10);

SELECT * FROM class4_info;

-- 이메일 유효성 검증
SELECT valid_email('@.'),
		   valid_email('a@b.c'),
			 valid_email('hello.com'),
			 valid_email('hello@world'),
			 valid_email('@@@@....'),
			 valid_email('hello@world.com')
FROM dual;

-- class4_info 테이블에서
-- 번호, 이름, 이메일, 이메일의 유효성을 조회하는
SELECT num, name, email, valid_email(email)
FROM class4_info;


-- 1에서부터 9999999까지 1씩 증가시키는 시퀀스 생성
CREATE SEQUENCE seq_item
 INCREMENT BY 1
 START WITH 1
 MAXVALUE 9999999
 CACHE 10
 NOCYCLE;

SELECT * FROM user_sequences;

SELECT seq_item.nextval
FROM dual;

SELECT seq_item.currval
FROM dual;

CREATE TABLE test_func(
  num CHAR(10),
  name VARCHAR2(30),
  input_date DATE DEFAULT SYSDATE,
  CONSTRAINT pk_test_func PRIMARY KEY(num)
);

-- 함수를 호출하여 지정된 형식의 번호를 얻기
INSERT INTO test_func(num, name)
VALUES(item_num, 'young');

INSERT INTO test_func(num, name)
VALUES(item_num, 'sol');

INSERT INTO test_func(num, name)
VALUES(item_num, 'kim');

INSERT INTO test_func(num, name)
VALUES(item_num, 'Lee');

-- 함수 호출 시 ()는 없어도 잘 호출됨, 있어도 됨
INSERT INTO test_func(num, name)
VALUES(item_num(), 'Park');

SELECT * FROM test_func;

-- 주민번호 유효성 검증 함수 사용
SELECT valid_ssn_check('121212-1234567')
FROM dual;

INSERT INTO class4_info(num, name, ssn)
VALUES(15, 'someone', '121212-1234567');

SELECT num, name, ssn, valid_ssn_check(ssn)
FROM class4_info;                 





























