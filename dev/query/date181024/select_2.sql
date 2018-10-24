
-- 문자열 연산자 LIKE를 사용할 테이블 생성
-- NUMBER에 크기를 지정안하면 22개를 넣을 수 있음
CREATE TABLE test_like(
	num NUMBER,
	name VARCHAR2(30),
	loc VARCHAR2(300),
	highschool VARCHAR2(60)
);

-- DROP TABLE test_like;

INSERT INTO test_like(num, name, loc, highschool)
VALUES (1, '김정윤', '서울시 강남구 역삼동', '오지고');

INSERT INTO test_like
VALUES (2, '김정운', '서울시 구로구 개봉동', '지리고');

INSERT INTO test_like
VALUEs (3, '박영민', '경기도 수원시', '레릿고');

INSERT INTO test_like
VALUES (4, '김희철', '서울시 서초구 서초동', '먹고');

INSERT INTO test_like
VALUES (5, '김저정은', '평양시 평양동', '씹고');

INSERT INTO test_like
VALUES (6, '하정운', '경기도 수원시 매탄동', '맛보고');

SELECT * FROM test_like;

-- COMMIT 하기전엔 Session에만 존재(메모리), COMMIT을 해줘야 File영역에 씌여지고
-- 다른 Client Process도 접근해서 사용이 가능해진다.
COMMIT;

-- LIKE 연산자 %, _ 와일드카드 기호와 같이 사용
-- %는 모든 문자열, _는 한 문자
-- test_like 테이블에서 '서울시'에 사는 사람의 번호, 이름, 출신고등학교명을 조회
SELECT	num, name, highschool
FROM    test_like
WHERE 	loc LIKE '서울시%';

-- LIKE를 쓰고 와일드카드(%,_)를 사용하지 않으면 '='와 동일하다
SELECT 	num, loc, highschool
FROM	test_like
WHERE	name LIKE '김정윤';

-- 이름이 '운'으로 끝나는 사람의 번호, 이름, 주소를 조회
SELECT	num, name, loc
FROM	test_like
WHERE	name LIKE '%운';

-- 이름에 '정'이 포함되어 있는 학생의 번호, 이름, 주소, 고등학교를 조회
SELECT  num, name, loc, highschool
FROM	test_like
WHERE	name like '%정%';

-- 이름이 3글자이며 가운데 글자가 '정'인 사람의 번호와 이름을 조회
SELECT	num, name
FROM	test_like
WHERE	name LIKE '_정_';

-- 
