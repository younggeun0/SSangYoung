-- NULL ��ȯ
-- ���ڵ带 �߰��� ��(INSERT) �ش� �÷��� ������� ������ NULL �Էµ�
-- CHAR/VARCHAR2 : �÷��� ������� �ʰų� ���� ''�� ��� NULL �Էµ�
-- NUMBER/DATE : �÷��� ������� ���� ��� NULL �Էµ�
SELECT *
FROM emp;

-- ������̺��� �����, ����, ���ʽ� ��ȸ
-- ��, ���ʽ��� ���� ������� 100���� ���
SELECT ename, sal, NVL(comm, '100')
FROM emp;

-- �����ȣ���̺��� �Է��� ���� �����ȣ, �õ�, ����, ��, ���� ��ȸ
-- ��, ������ ���ٸ� '��������'�� ���
SELECT zipcode, sido, gugun, dong, NVL(bunji, '��������') bunji
FROM zipcode
WHERE dong LIKE '����%';

-- class4_info ���̺��� ��ȣ, �̸�, �Է��� ��ȸ
-- ��, �Է����� ���ٸ� ���糯¥ ���
SELECT num, name, NVL(input_date, SYSDATE)
FROM class4_info;
