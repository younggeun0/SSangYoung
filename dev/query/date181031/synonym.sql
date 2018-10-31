
SELECT * FROM user_synonyms;
CREATE SYNONYM tmp FOR table_multi_primary;

SELECT *
FROM tmp;

INSERT INTO tmp(item, item_num, item_desc)
VALUES('철검','ITEM_0003', '목검 다음 검');

DELETE FROM tmp
WHERE ITEM='ITEM_0003';

UPDATE tmp
SET item='강철검', item_num='ITEM_0004', item_desc='철검 다음 검'
WHERE item='목검3';
       
-- SYNONYM 삭제
DROP SYNONYM tmp;
SELECT * FROM user_synonyms;
                 
SELECT * FROM table_multi_primary;               
