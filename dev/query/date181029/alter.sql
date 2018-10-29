
-- ALTER

-- 계정 잠그기 : 관리자만 가능
ALTER USER scott ACCOUNT LOCK;

-- 계정 : system, 비번 : 설치시 입력한 비번

-- 계정 열기
ALTER USER scott ACCOUNT UNLOCK;

-- 비번 변경
ALTER USER scott IDENTIFIED BY 1111;
ALTER USER scott IDENTIFIED BY tiger;

-- 테이블 생성
CREATE TABLE test_atler(
	num NUMBER,
	neam VARCHAR2(30),
	addr NUMBER
);

-- 테이블명 변경
ALTER TABLE test_atler RENAME TO test_alter;

-- 컬럼명 변경
ALTER TABLE test_alter RENAME COLUMN neam TO name;

SELECT * FROM test_alter;

-- 컬럼의 데이터형 변경 : 레코드가 없으므로 데이터형까지 변경 가능
-- addr의 NUMBER를 VARCHAR2(100), NOT NULL제약사항으로 변경
ALTER TABLE test_alter MODIFY addr VARCHAR2(100) NOT NULL;

INSERT INTO test_alter(num, name, addr)
VALUES(1, '테스트', '서울시 강남구');

COMMIT;
-- 데이터형을 변경할 때는 레코드가 비어있어야 함
ALTER TABLE test_alter MODIFY addr NUMBER;

-- 레코드가 존재할때는 동일 데이터형에서 크기만 변경 가능(축소X)
ALTER TABLE test_alter MODIFY addr VARCHAR(200);

-- 컬럼 추가 :추가되는 컬럼은 가장 마지막에 추가됨
-- 레코드가 존재하지 않으면 모든 제약사항을 부여할 수 있음
-- 레코드가 존재하면 상황에 따라 부여 못하는 제약사항이 생길 수 있음
ALTER TABLE test_alter ADD id VARCHAR2(15);

-- 컬럼 삭제
ALTER TABLE test_alter DROP COLUMN addr;

SELECT * FROM test_alter;

-- 제약사항 추가
ALTER TABLE test_alter ADD CONSTRAINT pk_test_alter
 PRIMARY KEY(id);

UPDATE test_alter
SET    id='test'
WHERE  id IS NULL;

SELECT * FROM test_alter;

SELECT * FROM user_constraints
WHERE table_name='TEST_ALTER';

-- 제약사항 비활성화 : 제약조건이 동작하지 않음
ALTER TABLE test_alter DISABLE constraint pk_test_alter;

INSERT INTO test_alter(num, name, id)
VALUES(2, '이재찬', 'test');

SELECT * FROM test_alter;

-- 제약사항 활성화 : 레코드의 구성에 따라 다름
--
ALTER TABLE test_alter ENABLE constraint pk_test_alter;

DELETE FROM test_alter WHERE num=2;

-- 제약사항 삭제
ALTER TABLE test_alter DROP CONSTRAINT pk_test_alter;


