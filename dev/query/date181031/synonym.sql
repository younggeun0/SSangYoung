
SELECT * FROM user_synonyms;
CREATE SYNONYM tmp FOR table_multi_primary;

SELECT *
FROM tmp;

INSERT INTO tmp(item, item_num, item_desc)
VALUES('ö��','ITEM_0003', '��� ���� ��');

DELETE FROM tmp
WHERE ITEM='ITEM_0003';

UPDATE tmp
SET item='��ö��', item_num='ITEM_0004', item_desc='ö�� ���� ��'
WHERE item='���3';
       
-- SYNONYM ����
DROP SYNONYM tmp;
SELECT * FROM user_synonyms;
                 
SELECT * FROM table_multi_primary;               
