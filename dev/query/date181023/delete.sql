/*
-- 테이블의 모든 레코드를 삭제하거나 조건에 맞는 특정 레코드를 삭제할 때 사용하는 쿼리

-- 모든 레코드를 삭제할 때 
DELETE FROM Class4_info;
-- 특정 레코드만 삭제할 때
-- 학생 번호가 11인 레코드 삭제 
DELETE FROM Class4_info
WHERE       num=11;

ROLLBACK;

-- TRUNCATE는 테이블의 레코드를 절삭한다
TRUNCATE TABLE Class4_info;
*/
