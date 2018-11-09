SELECT * FROM user_triggers;

-- TRIGGER 예제용 테이블 생성
CREATE TABLE trigger1 (
  name VARCHAR2(30),
  age NUMBER(3),
  addr VARCHAR2(100)
);

CREATE TABLE trigger2 (
  name VARCHAR2(30),
  age NUMBER(3)
);

SELECT * FROM trigger1;
SELECT * FROM trigger2;

-- INSERT 시 INSERTING 조건 수행
INSERT INTO trigger1(name, age, addr)
VALUES ('이재찬',22,'서울시');

-- UPDATE 시 UPDATING 조건 수행
UPDATE trigger1
SET name='찬재이'
WHERE name='이재찬';

-- DELETE 시 DELETING 조건 수행
DELETE FROM trigger1
WHERE name='이재찬';

SELECT * FROM trigger1;
SELECT * FROM trigger2;

DROP TRIGGER event_compare;


SELECT * FROM class4_info;

-- TRIGGER내 변수사용 예제 사전작업
INSERT INTO class4_info(num,age)
VALUES(99,29);

COMMIT;

-- trigger1 테이블 레코드 추가시
-- trigger2 테이블에 trigger1에 추가된 이름과
-- class4_info 테이블의 번호가 99번인 학생의 나이로
-- trigger2 테이블에 레코드 추가

INSERT INTO trigger1(name,age,addr)
VALUES('영근오', 22, '서울');

SELECT * FROM trigger1;
SELECT * FROM trigger2;




-------------


SELECT * FROM cp_emp;
SELECT * FROM cp_emp3;

INSERT INTO cp_emp(empno, ename, sal)
VALUES(0001,'호호',1800);

INSERT INTO cp_emp(empno, ename, sal)
VALUES(0002,'호랑',3000);

DROP TRIGGER tri_emp;
