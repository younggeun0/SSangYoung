
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

-- 이름이 4글자인 학생의 번호, 이름, 고등학교명 조회
SELECT	num, name, highschool
FROM	test_like
WHERE	name LIKE '____';


-- 지번주소를 저장하는 테이블 생성
CREATE TABLE zipcode(
	zipcode CHAR(7),
	sido CHAR(6),
	gugun VARCHAR2(25),
	dong VARCHAR2(60),
	bunji VARCHAR2(25),
	seq NUMBER(5)
);

-- 3만개만 들어갔음
SELECT * FROM zipcode;

-- dong의 크기가 작았기 때문에 다 안들어갔어서 dong의 열 크기 수정
ALTER TABLE zipcode MODIFY dong VARCHAR2(80);

TRUNCATE TABLE zipcode;

-- 해당 테이블의 레코드 수를 반환하는 COUNT()함수
SELECT COUNT(*)
FROM zipcode;

-- 다시 sqlldr를 사용해서 대량입력하면 5만개의 주소가 무사히 들어옴
SELECT COUNT(*)
FROM zipcode;


-- 우리집의 지번 주소를 조회
-- 동이름입력 받았다 가정

-- 3건만 조회됨
SELECT	zipcode, sido, gugun, dong, bunji, seq
FROM	zipcode
WHERE   dong='상도동';

-- LIKE로 뒤에만 보면 6건이 조회됨
SELECT 	*
FROM	zipcode
WHERE	dong LIKE '상도동%';

-- LIKE 와일드카드를 양옆에 붙이면 더 많이 조회됨
-- 상도2동도 검색되는 이유는 아파트명에 '상도동'이 포함되었기 때문
SELECT 	*
FROM	zipcode
WHERE	dong LIKE '%상도동%';

-- %를 앞에 뒤에 또는 앞뒤에 붙일건지 잘 결정해야 됨

-- 사원테이블에서 사원명에 'L'이 두개 들어있는 사원의
-- 사원번호, 사원명, 입사일 조회
SELECT	empno, ename, hiredate
FROM	emp
WHERE	ename LIKE '%L%L%';

-- 'L'을 'A'로 변경해서 조회
SELECT  empno, ename, hiredate
FROM	emp
WHERE	ename LIKE '%A%A%';


-- 사원 테이블에서 부서 번호를 조회
SELECT	deptno
FROM	emp;

-- 중복 배제

-- 사원 테이블에서 매니저번호를 조회
SELECT	mgr
FROM	emp;

-- 단, 중복되는 매니저번호는 출력하지 않음
-- DISTINCT - 집계함수를 사용하여 그룹별 집계를 보여줄 수 없음
SELECT DISTINCT	mgr
FROM			emp;

-- 다른 값이 나오는 컬럼과 같이 사용할 경우, 모든 컬럼의 값이 동일해야 중복 배제가 됨
SELECT DISTINCT	mgr, ename
FROM			emp;

-- DISTINCT와 GROUP BY의 결과는 모두 중복배제로 같다
SELECT		mgr
FROM		emp
GROUP BY	mgr;


-- DISTINCT 조회하는 컬럼명 앞에 기술, 조회결과 생성할 때 같은 값이 존재하는지 판단하여
-- 같은 값이 존재하면 출력하지 않음
SELECT DISTINCT	deptno
FROM	emp;

-- 모든 컬럼과 같이 조회하면 모든 컬럼의 값이 같은 경우만 중복값을 출력하지 않는다
SELECT DISTINCT deptno, /*ename*/
FROM	emp;


-- GROUP BY 조회 결과를 그룹으로 묶어 출력
-- 조회되는 컬럼은 반드시 그룹으로 묶인 컬럼이거나, 집게함수를 사용한 컬럼만 조회 가능
-- 다른 컬럼을 조회하면 에러 발생
-- HAVING 절로 그룹으로 묶일
SELECT		deptno
FROM		emp
GROUP BY	deptno;

SELECT		deptno
FROM		emp
GROUP BY	deptno
HAVING		deptno=10;

-- GROUP BY : 그룹으로 묶여지지 않은 컬럼과 같이 사용되면 error.
SELECT		mgr, /*ename*/
FROM		emp
GROUP BY	mgr, ename;
                                  