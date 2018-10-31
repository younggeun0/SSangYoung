-- 계정 생성 : 관리자 계정만 생성가능
-- CREATE USER 계정명 IDENTIFIED BY 비밀번호;

CREATE USER test IDENTIFIED BY 1234;

-- 접속 권한 : CONNECT
GRANT CONNECT TO test;

SELECT '1'
FROM dual;

-- 테이블 생성 X
CREATE TABLE my_table(num NUMBER);

-- 테이블이 없어서 SELECT로 가져올 수 있는게 없음..
-- DUAL은 사용가능

SELECT SYSDATE
FROM   DUAL;

-- 자원사용 권한 : RESOURCE
GRANT RESOURCE TO test;

-- 재접속해야 권한적용됨

-- RESOURCE 권한으로 테이블 생성 가능
CREATE TABLE my_table(num NUMBER);

INSERT INTO my_table VALUES(1);
COMMIT;

SELECT * FROM my_table;


-- 관리자 권한 : DBA
GRANT DBA TO test;


-- 관리자 권한 부여 후
-- 서버 재시작은 불가능
shutdown abort;

-- 관리자 권한 부여 후 일반계정이 관리자 업무를 수행
-- 계정생성, 계정 권한 부여함


-- SCOTT
CREATE VIEW test_view
AS (SELECT num
	FROM my_table);

-- user_views 에서 뷰들을 볼 수 있음
SELECT * FROM user_views;

DROP VIEW test_view;

-- 권한 회수
-- REVOKE 권한, ...  FROM 계정명;
REVOKE DBA FROM test;

-- 권한 회수 후 계정생성, VIEW 생성 등 모두 권한불충분 에러 발생
CREATE USER test1 IDENTIFIED BY 2222;

-- 계정 삭제
-- 계정이 접속되어 있다면 삭제되지 않는다
-- 삭제하는 계정이 만든 객체들이 존재한다면 삭제가 안됨
-- CASCADE 옵션으로 모두 삭제시켜야 삭제가 된다


-- system 계정 로그인 후
--
SELECT tname FROM tab;

-- 계정 조회(all_users, dba_users)
SELECT * FROM all_users;

SELECT * FROM dba_users;
                          