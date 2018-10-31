
-- cmd창에서 작업
-- emp와 dept테이블만 백업
-- exp scott/tiger tables=dept, emp file=경로\파일명.dmp

-- 전체백업
-- exp scott/tiger full=y file=경로\파일명.dmp


-- 백업 후 테이블 삭제
DROP TABLE zipcode;
DROP TABLE cp_zipcode;

PURGE RECYCLEBIN;

-- zipcode, cp_zipcode 삭제 확인가능
SELECT tname FROM tab;

-- imp로 zipcode 테이블 가져오기
-- 윈도우에서 imp하면 임포트 후 에러 발생(작동은 잘 됨)
-- imp scott/tiger tables=zipcode file=경로

-- 다시 복구된 테이블 확인 가능
SELECT COUNT(*)
FROM zipcode;

-- emp 삭제
DROP TABLE emp;
PURGE RECYCLEBIN;

SELECT * FROM emp;

