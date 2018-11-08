/*
숙제
1. 아래의 Dictionary테이블을 사용하여
user_constraints, user_tab_cols, user_tab_columns
입력된테이블에 대한 제약사항명, 컬럼명, 데이터형
을 조회하는 쿼리문을 작성 .

2. 위의 작업을 수행하는 Procedure를 생성.
*/
SELECT * FROM user_constraints;
-- CONSTRAINT_NAME
-- 제약사항 테이블엔 컬럼정보가 존재X
SELECT * FROM user_tab_cols;
-- TABLE_NAME, COLUMN_NAME, DATA_TYPE

SELECT * FROM user_cons_columns;

-- CONSTRAINT_NAME, COLUMN_NAME, DATA_TYPE 을 출력

--

SELECT  utc.TABLE_NAME, uc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
FROM   user_tab_cols utc, user_constraints uc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME)
 AND utc.TABLE_NAME='EMP';

-- 조인, 스칼라서브쿼리 사용
-- 일단 필요컬럼 있는 조인은 했는데.. 이제 어떻게 줄이지
SELECT  *
FROM   user_tab_cols utc, user_constraints uc, user_cons_columns ucc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME AND uc.COLUMN_NAME = ucc.COLUMN_NAME)
 AND ucc.TABLE_NAME='EMP';

SELECT  *
FROM   (SELECT TABLE_NAME
				FROM user_tab_cols
				GROUP BY TABLE_NAME) utc, user_constraints uc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME)
 AND utc.TABLE_NAME='EMP';



