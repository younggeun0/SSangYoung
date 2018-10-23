
-- Transaction 취소하는 ROLLBACK

-- INSERT 2, UPDATE1, DELETE1 하는 Transaction 
-- ROLLBACK을 하면 num 21, 22 인 데이터들 다 날라감
-- SAVEPOINT를 설정하여 특정 지점까지 작업을 취소
-- Transaction이 여러개의 쿼리로 이루어진 경우 SAVEPOINT를 사용한다

SAVEPOINT insert_a;
INSERT INTO Class4_info (num, name, email)
VALUES (21, 'test1', 'test@test.com');

SAVEPOINT insert_b;
INSERT INTO Class4_info (num, name, email)
VALUES (22, 'test2', 'test@test.com');

SAVEPOINT update_c;
UPDATE Class4_info
SET    name='test3'
WHERE  num=22;

SAVEPOINT delete_d;
DELETE FROM Class4_info
WHERE num=22;

-- ROLLBACK TO delete_d;
-- ROLLBACK TO update_c;
-- ROLLBACK TO insert_b;
-- ROLLBACK TO insert_a;
-- 이렇게 되돌아갈 지점을 선택할 수 있다.

