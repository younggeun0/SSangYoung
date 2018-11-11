/*
숙제
1. 아래의 Dictionary테이블을 사용하여
user_constraints, user_tab_cols, user_tab_columns
입력된테이블에 대한 제약사항명, 컬럼명, 데이터형
을 조회하는 쿼리문을 작성 .
*/


SELECT ucc.constraint_name, utc.column_name, utc.data_type
FROM user_tab_cols utc, user_constraints uc, user_cons_columns ucc
WHERE (uc.table_name = utc.table_name AND uc.constraint_name = ucc.constraint_name)
 AND utc.column_name = ucc.column_name
 AND utc.table_name='EMP';

        
-- hw2 프로시저 실행
VAR t_name VARCHAR2(15);
VAR cur REFCURSOR;

EXEC select_constraints('EMP', :cur);

PRINT cur;
