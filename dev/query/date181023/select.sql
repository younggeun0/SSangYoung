/*
-- 특정 테이블에서 원하는 컬럼의 모든 레코드를 조회
-- Class4_info 테이블에서 이름, 번호, 나이 조회

SELECT  name, num, age
FROM    Class4_info;

-- 모든 컬럼을 조회할 땐 별(asterisk, *)을 사용
SELECT  *
FROM Class4_info;

-- 컬럼크기 변경
-- 0 : 데이터가 없다면 0을 채워 출력 
COLUMN num FORMAT 0000
COL eye FORMAT 0.000

-- 9 : 데이터가 존재하는 것만 출력
COL age FORMAT 999

-- 문자열은 한줄에 표기될 글자수를 설정합니다. - a글자수
COLUMN name FORMAT a7
COLUMN ssn FORMAT a6
COL email FORMAT a10

*/

SELECT * FROM Class4_info;




