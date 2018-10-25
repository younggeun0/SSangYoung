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

-- ��¥�� ���ڿ��� ��ȯ : TO_CHAR(��¥, pattern)
SELECT TO_CHAR(SYSDATE, 'y'), TO_CHAR(SYSDATE, 'yy'),
	   TO_CHAR(SYSDATE, 'yyy'), TO_CHAR(SYSDATE, 'yyyy'),
	   TO_CHAR(SYSDATE, 'yyyyy')
FROM DUAL;

-- ���� ���� mm, ddó�� �ΰ� �� �ΰ� �̻� ��� �Ѵ�
-- ���� ������� ���·� ������ ����
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd'), TO_CHAR(SYSDATE, 'mm-dd-yyyy')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24)')
FROM DUAL;

-- ��¥���� �ð����·� �Է��� �Ǹ� �ð������� ����, ��¥ ������ ����
-- SYSDATE�� �ð����� ���´�
SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24):mi:ss')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'yyyy-mm-dd am hh(hh24):mi:ss day dy q')
FROM DUAL;


-- perttern�� Ư�����ڰ� �ƴ� ���ڿ� ����Ҷ����� "�� ���´�
SELECT TO_CHAR(SYSDATE, 'yyyy"��" mm"��" dd"��"')
FROM DUAL;


-- perttern�� �ʹ� ��� ����ϸ� Error �߻�!
-- �������� �ἱ ���� �ȳ�




