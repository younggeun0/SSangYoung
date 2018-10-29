-- 외래키 : 다른테이블(부모)의 컬럼값으로만 값을 추가해야 할 때 사용
-- null과 중복값을 허용함
-- 컬럼단위 제약사항 : foreign key 키워드 사용안함(테이블 단위 제약사항 때 기입)


-- table_primary 테이블의 id값을 참조하여 데이터를 추가하는 foreign key 설정
-- 자식테이블의 컬럼명은 같은 필요는 없고, 데이터형과 크기만 맞춰주면 됨
SELECT * FROM table_primary;

CREATE TABLE column_foreign(
	f_id VARCHAR2(20) CONSTRAINT fk_f_id REFERENCES table_primary(id),
	phone VARCHAR2(13),
	address VARCHAR2(400)
);

SELECT * FROM column_foreign;

-- 추가 성공
-- 부모테이블에 존재하는 값으로 추가
INSERT INTO column_foreign(f_id, phone, address)
VALUES('kim', '010-1113-2311', 'SM');

INSERT INTO column_foreign(f_id, phone, address)
VALUES('test', '010-3313-2311', '서울시 강남구 한독빌딩');


-- 같은 아이디로 값을 추가할 수 있다. (중복허용)
INSERT INTO column_foreign(f_id, phone, address)
VALUES('kim', '010-1113-2311', 'JYP');

SELECT * FROM column_foreign;

-- null 허용
INSERT INTO column_foreign(phone, address)
VALUES('010-3939-9999', '미스틱');

-- 부모테이블에 없는 값을 추가하면 error
INSERT INTO column_foreign(f_id, phone, address)
VALUES('kim1', '010-3939-9999', '미스틱');

-- 부모테이블은 참조하는 자식레코드가 존재한다면 삭제되지 않는다
INSERT INTO table_primary(name, id, pw)
VALUES('강호동','kang','1234');

COMMIT;
SELECT * FROM table_primary;

-- kim이나 test는 참조하는 레코드가 존재하므로 삭제 불가
DELETE FROM table_primary
WHERE id='kim';
DELETE FROM table_primary
WHERE id='test';

-- kang은 참조하는 레코드가 존재하지 않으므로 삭제됨
DELETE FROM table_primary
WHERE id='kang';

ROLLBACK;

-- ON DELETE CASCADE를 설정하지 않았을 때에는
-- 참조하는 자식레코드를 모두 삭제하고 부모레코드를 삭제한다
DELETE FROM column_foreign
WHERE f_id='kim' OR f_id='test';

DELETE FROM table_primary
WHERE id='kim' OR id='test';

SELECT * FROM table_primary;

COMMIT;

-- 테이블 단위 제약사항
CREATE TABLE table_foreign(
	id VARCHAR2(20),
	java_score NUMBER(3),
	oracle_score NUMBER(3),
	CONSTRAINT fk_table_foreign_id FOREIGN KEY(id) REFERENCES table_primary(id)
);

SELECT * FROM user_constraints;

-- 부모테이블의 존재하는 값으로 추가
-- 중복, null 허용
INSERT INTO table_foreign(id, java_score, oracle_score)
VALUES('kim', 97, 78);

COMMIT;

SELECT * FROM table_foreign;

-- 참조하는 자식 레코드가 존재한다면 부모테이블에서 바로 삭제 불가
DELETE FROM table_primary
WHERE id='kim';

INSERT INTO table_primary(name, id, pw)
VALUES('송중기','song','1234');
INSERT INTO table_primary(name, id, pw)
VALUES('공유','gong','1234');

SELECT * FROM table_primary;
COMMIT;

-- 부모레코드를 삭제하면 참조하는 모든 자식레코드를 삭제하고
-- 부모 레코드를 삭제하는 ON DELETE CASCADE 사용

CREATE TABLE test_cascade(
	id VARCHAR2(20),
	address VARCHAR2(100),
	CONSTRAINT fk_test_id FOREIGN KEY(id)
	  REFERENCES table_primary(id)
	  ON DELETE CASCADE
);

INSERT INTO test_cascade(id, address)
VALUES('song','강남구 역삼동');

INSERT INTO test_cascade(id, address)
VALUES('gong','강남구 역삼동');

INSERT INTO test_cascade(id, address)
VALUES('kang','강남구 역삼동');
COMMIT;

SELECT * FROM test_cascade;

-- ON DELETE CASCADE가 설정되면
-- 부모 레코드가 삭제되면 자식 레코드도 함께 삭제됨

DELETE FROM table_primary
WHERE id='gong';

SELECT * FROM table_primary;
SELECT * FROM test_cascade;
SELECT * FROM table_foreign;


-- ON DELETE CASCADE가 사용되지 않은 테이블에서 참조하는 레코드는
-- 삭제되지 않는다
