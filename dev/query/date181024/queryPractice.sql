/*
SELECT tname FROM tab;

CREATE TABLE p_info(
  num NUMBER(5),
  name VARCHAR2(15),
  gender CHAR(1),
  address VARCHAR2(360),
  score NUMBER(3),
  i_date DATE
);

INSERT INTO p_info
VALUES(1, '김준호', 'm', '서울시 강남구 역삼동', 64, SYSDATE);

INSERT INTO p_info(num, name, gender, address, score, i_date)
VALUES(2, '김준현', 'm', '서울시 구로구 개봉동', 87, SYSDATE);

INSERT INTO p_info
VALUES(3, '오나미', 'f', '서울시 영등포구 여의도동', 97, SYSDATE);

INSERT INTO p_info
VALUES(4, '황재성', 'm', '서울시 동작구 상도동', 100, SYSDATE);

INSERT INTO p_info
VALUES(5, '유재석', 'm', '경기도 수원시 영통구', 100, SYSDATE);

SELECT * FROM p_info;

UPDATE 	p_info
SET		name='테스트'
WHERE	num=3 AND score=97;

UPDATE	p_info
SET		gender='m'
WHERE	num=3 AND score=97;

SELECT * FROM p_info;

COMMIT;

UPDATE	p_info
SET		gender='f'
WHERE	name='유재석';

SELECT * FROM p_info;

ROLLBACK;

SELECT * FROM p_info;

DELETE FROM p_info
WHERE num=1 AND name='김준현';

TRUNCATE TABLE p_info;

SELECT * FROM p_info;

DROP TABLE p_info;

SELECT tname FROM tab;

PURGE RECYCLEBIN;

SELECT tname FROM tab;

COMMIT;
*/














