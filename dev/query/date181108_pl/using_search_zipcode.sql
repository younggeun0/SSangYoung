-- 동이름으로 우편번호 검색
VAR first_address VARCHAR2(100);
VAR search_num NUMBER;

EXEC search_zipcode('논현동',:first_address,:search_num);

PRINT first_address;
PRINT search_num;

SELECT *
FROM zipcode
WHERE dong LIKE '논현동%'
ORDER BY zipcode;
