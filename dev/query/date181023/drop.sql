/*
-- 필요없는 테이블은 삭제할 때 DROP 사용
-- 삭제된 테이블은 Oracle 10g부터 휴지통으로 이동한다.

-- 휴지통 보기
SHOW RECYCLEBIN;
SELECT tname FROM tab;

DROP TABLE Class4_info;
-- 휴지통 비우기
PURGE RECYCLEBIN;

CREATE TABLE test (num number);
DROP TABLE test;
SHOW RECYCLEBIN;

-- 휴지통 테이블 복구
FLASHBACK TABLE test TO BEFORE DROP;

*/

