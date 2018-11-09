/*
숙제
1. 아래의 Dictionary테이블을 사용하여
user_constraints, user_tab_cols, user_tab_columns
입력된테이블에 대한 제약사항명, 컬럼명, 데이터형
을 조회하는 쿼리문을 작성 .

2. 위의 작업을 수행하는 Procedure를 생성.
*/

-- CONSTRAINT_NAME
SELECT * FROM user_constraints;

-- TABLE_NAME, COLUMN_NAME, DATA_TYPE
SELECT * FROM user_tab_cols;

-- CONSTRAINT_NAME, COLUMN_NAME
SELECT * FROM user_cons_columns;


SELECT ucc.CONSTRAINT_NAME, utc.COLUMN_NAME, utc.DATA_TYPE
FROM   user_tab_cols utc, user_constraints uc, user_cons_columns ucc
WHERE  (uc.TABLE_NAME = utc.TABLE_NAME AND uc.CONSTRAINT_NAME = ucc.CONSTRAINT_NAME)
 AND utc.COLUMN_NAME = ucc.COLUMN_NAME
 AND utc.TABLE_NAME='TABLE_UNIQUE';




-- hw2 . 프로시저 호출

VAR cur_cons REFCURSOR;

EXEC select_constraints('EMP',:cur_cons);      

PRINT cur_cons;

