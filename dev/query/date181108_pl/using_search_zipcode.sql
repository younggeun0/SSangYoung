-- ���̸����� �����ȣ �˻�
VAR first_address VARCHAR2(100);
VAR search_num NUMBER;

EXEC search_zipcode('������',:first_address,:search_num);

PRINT first_address;
PRINT search_num;

SELECT *
FROM zipcode
WHERE dong LIKE '������%'
ORDER BY zipcode;
