-- ��ȯ�Լ�
-- ���ڿ��� �ƴ� ��(����, ��¥)�� ���ڿ��� ��ȯ : TO_CHAR(����, pattern)
-- ���� -> ������ �ڸ��� ,�� .�� ���

SELECT TO_CHAR(20181025, '0,000,000,000'),
	   TO_CHAR(20181025, '9,999,999,999')
FROM DUAL;

SELECT TO_CHAR(2018.1025, '999999.999')
FROM DUAL;

-- ������̺��� �����ȣ, �����, �Ի���, ������ ��ȸ
-- ��, ������ �����Ͱ� �ִ� �ͱ����� ,�� �־� ���

SELECT empno, ename, hiredate, TO_CHAR(sal, '999,999') sal
FROM emp;

-- Error! TO_CHAR�Լ��� ��ȯ�Ǵ� ����� ���ڿ��̹Ƿ� ��������� ���� ����
SELECT TO_CHAR(sal, '9,999')+100
FROM emp;

SELECT TO_CHAR(SYSDATE, 'y'),TO_CHAR(SYSDATE, 'yy'
	   TO_CHAR(SYSDATE, 'yyy')
FROM DUAL;




