
-- cmdâ���� �۾�
-- emp�� dept���̺� ���
-- exp scott/tiger tables=dept, emp file=���\���ϸ�.dmp

-- ��ü���
-- exp scott/tiger full=y file=���\���ϸ�.dmp


-- ��� �� ���̺� ����
DROP TABLE zipcode;
DROP TABLE cp_zipcode;

PURGE RECYCLEBIN;

-- zipcode, cp_zipcode ���� Ȯ�ΰ���
SELECT tname FROM tab;

-- imp�� zipcode ���̺� ��������
-- �����쿡�� imp�ϸ� ����Ʈ �� ���� �߻�(�۵��� �� ��)
-- imp scott/tiger tables=zipcode file=���

-- �ٽ� ������ ���̺� Ȯ�� ����
SELECT COUNT(*)
FROM zipcode;

-- emp ����
DROP TABLE emp;
PURGE RECYCLEBIN;

SELECT * FROM emp;

