CREATE OR REPLACE
 -- ����(Random number)
-- ��ǻ�Ͱ� ������ ���� �����Ͽ� ��ȯ�ϴ� ��
-- DBMS_RANDOM ��Ű�� ���
-- DBMS_RANDOM.VALUE(����, ����) - ���ڸ� ��� �Լ�
-- DBMS_RANDOM.STRING('����', ��������) - ���ڿ��� ��� �Լ�
--  ���� : u - ������ �빮��, l - ������ �ҹ���,
--         a - ��ҹ��� ȥ��, x - �빮��, ���� ȥ��,
--         p - ��ҹ��� ���� Ư������ ȥ��

-- 1�������� 10 ������ ���� ��� (�Ҽ��߻�)
SELECT TRUNC(DBMS_RANDOM.VALUE(1, 10), 0) random_number
FROM dual;
                       
-- ���� ���ڿ� ���
SELECT DBMS_RANDOM.STRING('u',10) u,
			 DBMS_RANDOM.STRING('l',10) l,
			 DBMS_RANDOM.STRING('a',10) a,
			 DBMS_RANDOM.STRING('x',10) x,
			 DBMS_RANDOM.STRING('p',10) p
FROM DUAL;


/