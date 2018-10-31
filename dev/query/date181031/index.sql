
-- �ε��� ��ȸ
SELECT * FROM user_indexes;

-- zipcode ���̺� ����
CREATE TABLE cp_zipcode
AS (SELECT *
	FROM zipcode);

-- �����ϰ� ����Ȱ� Ȯ��
SELECT COUNT(*)
FROM   cp_zipcode;
SELECT COUNT(*)
FROM   cp_zipcode;

-- cp_zipcode���̺��� seq�÷�(����ũ�� ���� ���� �÷�)�� UNIQUE INDEX ����
CREATE UNIQUE INDEX idx_zipcode ON cp_zipcode(seq);

DROP INDEX idx_zipcode;

SELECT * FROM user_indexes
WHERE index_name='IDX_ZIPCODE';


-- �ε����� ������� �ʴ� ��ȸ(FULL-SCAN)
SELECT zipcode, sido, gugun, bunji, seq
FROM zipcode
WHERE zipcode='402-866';


-- �ε����� ����� ��ȸ
SELECT /*+ORDERED INDEX(idx_zipcode2)*/zipcode, sido, gugun, bunji, seq
FROM cp_zipcode
WHERE zipcode='402-866';


-- �����ȣ�� �ߺ������� ��Ư�� ����('000-000')�� ������
-- ����Ŭ EE������ ��밡��..
CREATE BITMAP INDEX bit_zipcode ON cp_zipcode(zipcode);

-- NON UNIQUE INDEX
CREATE INDEX idx_zipcode2 ON cp_zipcode(zipcode);

SELECT * FROM user_indexes
WHERE index_name='IDX_ZIPCODE2';



-- �ε����� �������̺��� ����Ǹ� ��������� �������� �ʴ´�.
-- ���̺�� �ε����� ���ߴ� ����
ALTER INDEX idx_zipcode2 REBUILD;


