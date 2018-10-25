
-- �����Լ�
-- SIN, COS, TAN ���ϴ� �Լ�
SELECT SIN(0), COS(0), TAN(0)
FROM DUAL;

-- ���밪 : ABS(��)
-- ������ ����� ��ȯ���ִ� �Լ�
SELECT ABS(25), ABS(-25)
FROM DUAL;

-- �ݿø� : ROUND(��, �ݿø����ڸ���)
SELECT ROUND(555.555, -2), ROUND(555.555, -1),
	   ROUND(555.555, 0), ROUND(555.555, 1),
	   ROUND(555.555, 2), ROUND(555.555, 3)
FROM DUAL;

-- ���� : TRUNC(��, �������ڸ���)
-- -1�� ������ ����
SELECT TRUNC(777.777, 2), TRUNC(777.777, -1)
FROM DUAL;

-- �ø� : CEIL(��)
SELECT CEIL(10.6), CEIL(10.0), CEIL(10.3)
FROM DUAL;

-- ���� : FLOOR(��)
SELECT FLOOR(10.6), FLOOR(10.0), FLOOR(10.3)
FROM DUAL;

-- ������̺��� �����ȣ, �����, �Ի���, ����, ������ ��ȸ
-- ��, ������ ������ 3.3%�� ����ϰ� ������ ������ ��
SELECT empno, ename, hiredate, sal, sal*1.033, TRUNC(sal*1.033, -1) tax
FROM emp;
       