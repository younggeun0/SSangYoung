
-- 인덱스 조회
SELECT * FROM user_indexes;

-- zipcode 테이블 복사
CREATE TABLE cp_zipcode
AS (SELECT *
	FROM zipcode);

-- 동일하게 복사된걸 확인
SELECT COUNT(*)
FROM   cp_zipcode;
SELECT COUNT(*)
FROM   cp_zipcode;

-- cp_zipcode테이블의 seq컬럼(유니크한 값을 갖는 컬럼)에 UNIQUE INDEX 설정
CREATE UNIQUE INDEX idx_zipcode ON cp_zipcode(seq);

DROP INDEX idx_zipcode;

SELECT * FROM user_indexes
WHERE index_name='IDX_ZIPCODE';


-- 인덱스를 사용하지 않는 조회(FULL-SCAN)
SELECT zipcode, sido, gugun, bunji, seq
FROM zipcode
WHERE zipcode='402-866';


-- 인덱스를 사용한 조회
SELECT /*+ORDERED INDEX(idx_zipcode2)*/zipcode, sido, gugun, bunji, seq
FROM cp_zipcode
WHERE zipcode='402-866';


-- 우편번호는 중복되지만 독특한 형태('000-000')를 가진다
-- 오라클 EE버전만 사용가능..
CREATE BITMAP INDEX bit_zipcode ON cp_zipcode(zipcode);

-- NON UNIQUE INDEX
CREATE INDEX idx_zipcode2 ON cp_zipcode(zipcode);

SELECT * FROM user_indexes
WHERE index_name='IDX_ZIPCODE2';



-- 인덱스는 실제테이블이 변경되면 변경사항을 적용하지 않는다.
-- 테이블과 인덱스를 맞추는 쿼리
ALTER INDEX idx_zipcode2 REBUILD;


