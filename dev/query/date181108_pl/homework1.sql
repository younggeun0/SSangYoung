/*
숙제
1. 아래의 Dictionary테이블을 사용하여
user_constraints, user_tab_cols, user_tab_columns
입력된테이블에 대한 제약사항명, 컬럼명, 데이터형
을 조회하는 쿼리문을 작성 .

2. 위의 작업을 수행하는 Procedure를 생성.


*/
SELECT * FROM user_constraints;  -- CONSTRAINT_NAME, 제약사항 테이블엔 컬럼정보가 존재X
, R_CONSTRAINT_NAME, CONSTRAINT_NAMESELECT * FROM user_tab_cols;     -- TABLE_NAME, COLUMN_NAME, DATA_TYPE
SELECT * FROM user_tab_columns;

--SELECT uc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
SELECT *
FROM   (SELECT TABLE_NAME
				FROM user_tab_cols
				GROUP BY TABLE_NAME) utc, user_constraints uc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME)
 AND uc.CONSTRAINT_NAME LIKE '%'
 AND utc.TABLE_NAME='EMP';

SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
FROM user_tab_cols
UNION
SELECT TABLE_NAME, CONSTRAINT_NAME
FROM user_constraints;

-- 유니온하고 그 결과에서 값을 뽑아내기                               
-- user_tab_cols
-- TABLE_NAME(VARCHAR2(30), COLUMN_NAME(VARCHAR2(30), DATA_TYPE(VARCHAR2(106)
                
-- user_constraints
-- TABLE_NAME(VARCHAR2(30), CONSTRAINT
/*

SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
FROM(
	SELECT TABLE_NAME, COLUMN_NAME, DATA_TYPE
	FROM user_tab_cols
	UNION
	SELECT TABLE_NAME, R_OWNER, R_CONSTRAINT_NAME
	FROM user_constraints
)
GROUP BY TABLE_NAME;

*/