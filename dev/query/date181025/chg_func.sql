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
SELECT TO_CHAR(SYSDATE, 'yyyy " �� " mm " �� " dd " �� " hh24 " �� " mi " �� " ss " �� "')
FROM DUAL;

-- �̷���� �߶� ||�� ���̴� ����� ���
SELECT TO_CHAR(SYSDATE, 'yyyy " �� " mm " �� " dd " �� "') ||
       TO_CHAR(' hh24 " �� " mi " �� " ss " �� "')
FROM DUAL;

-- ������̺��� �����ȣ, �����, �Ի����� ��ȸ
-- ��, �Ի����� ��-��-�� ������ �������� ����� ��
SELECT empno, ename, hiredate, TO_CHAR(hiredate, 'yyyy-mm-dd day hh:mi:ss')
FROM emp;

-- ������̺��� �Ի�⵵�� '1981'���� �������
-- �����ȣ, �����, �Ի���, ������ ��ȸ

SELECT empno �����ȣ, ename �����, sal ����, TO_CHAR(hiredate, 'mm"�� "dd"��"') �Ի���
FROM emp
WHERE TO_CHAR(hiredate, 'yyyy')=1981;

-- ���� ��¥�� �ƴ� ��¥�� �߰��� ��
-- ��¥ ������ ���ڿ��� �߰��ϸ� ��
INSERT INTO class4_info(num, name, input_date)
VALUES(8, '�缼��', '2018-10-21');

INSERT INTO class4_info(num, name, input_date)
VALUES(9, '�缼��', TO_DATE('2018-10-22', 'yyyy-mm-dd'));

SELECT * FROM class4_info
WHERE name LIKE '��%';

SELECT TO_CHAR(input_date, 'yyyy-mm')
FROM class4_info;

-- TO_CHAR�� ��¥�� ���ڸ� �Է¹޾ƾ���.(�Լ��� ��(����)�� ���������� �����Ѵ�.)
SELECT TO_CHAR('2018-10-25', 'mm')
FROM DUAL;

SELECT TO_CHAR(TO_DATE('2018-10-25', 'yyyy-mm-dd'), 'mm')
FROM DUAL;

-- ���� ��ȯ : TO_NUMBER(���������ǹ��ڿ�)

SELECT '25'-'10'
FROM DUAL;

SELECT TO_NUMBER('25') - TO_NUMBER('10')
FROM DUAL;

-- ���ڿ��� ���������� ���� ��쿡�� TO_NUMBER ��� ����
-- ���ڰ� �ƴ� �ٸ� ������ TO_NUMBER�� ���ڷ� �ٲ� �� ����
SELECT TO_NUMBER('������')
FROM DUAL;

-- �����Լ� DECODE(��, �񱳰�, ��°�, �񱳰�, ��°�, ... , �񱳰��̾���������Ұ�)

-- ������̺��� �����ȣ, �����, ����, �μ����� ��ȸ
-- ��, �μ����� �Ʒ��� �μ���ȣ�� �ش��ϴ� �μ������� ���
-- 10-���ߺ�, 20-����������, 30-ǰ��������, �� �ܴ� Ź���η� ���
SELECT empno, ename, sal, deptno,
       DECODE(deptno, 10, '���ߺ�', 20, '����������', 30, 'ǰ��������', 'Ź����') dname
FROM   emp;

-- �� �ܿ� �ش��ϴ� ������� �������� 30-ǰ�������� ����
SELECT empno, ename, sal, deptno,
       DECODE(deptno, 10, '���ߺ�', 20, '����������', 'Ź����') dname
FROM   emp;

-- �����ȣ, �����, ����, �μ���ȣ, �μ�Ƽ��  ��ȸ
-- ��, �μ�Ƽ��� �μ����� �Ʒ��� ���� ��������
-- 10 - ������ 20%, 20 - ������ 50%, 30 - ������ 30%, �� �� - ������ 10%

SELECT empno, ename, sal, deptno,
	   DECODE(deptno, 10, sal*0.2, 20, sal*0.5, 30, sal*0.3, sal*0.1) incentive,

FROM emp;


-- CASE
-- ������̺��� �����ȣ, �����, ����, �μ����� ��ȸ
-- ��, �μ����� �Ʒ��� �μ���ȣ�� �ش��ϴ� �μ������� ���
-- 10-���ߺ�, 20-����������, 30-ǰ��������, �� �ܴ� Ź���η� ���
SELECT empno, ename, sal, deptno,
	CASE deptno WHEN 10 THEN '���ߺ�'
				WHEN 20 THEN '����������'
				WHEN 30 THEN 'ǰ��������'
				ELSE 'Ź����'
	END dname
FROM emp;

-- �� ������ ������ ���ǿ��� CASE�� �̿� �� ���ɾ�(����+���ʽ�+�μ�)�� ��ȸ
SELECT empno, ename, sal, NVL(comm,0) bonus, deptno,
	   CASE deptno WHEN 10 THEN sal+NVL(comm,0)+sal*0.2
	   			   WHEN 20 THEN sal+NVL(comm,0)+sal*0.5
	   			   WHEN 30 THEN sal+NVL(comm,0)+sal*0.3
	   			   ELSE sal+NVL(comm,0)+sal*0.1
	   END total
FROM emp;

-- ������̺��� �����ȣ, �����, ������ ��ȸ
-- ��, ������ ù ���ڿ� ���� ������ ���� ���� ���
-- 'C'-�Ҹ�ǰ, 'S'-������� �ִ� ���
-- 'M'-������, 'A'-���캸�� ���, 'P'-�θ��

SELECT empno, ename, job,
	   DECODE(SUBSTR(job,1,1),
			'C', '�Ҹ�ǰ',
			'S', '�� ����� �ִ� ���',
			'M', '������',
			'A', '���캸�� ���',
			'P', '�θ��') title
FROM emp;


SELECT empno, ename, job,
       CASE SUBSTR(job,1,1) WHEN 'C' THEN '�Ҹ�ǰ'
       						WHEN 'S' THEN '�� ����� �ִ� ���'
       						WHEN 'M' THEN '������'
       						WHEN 'A' THEN '���캸�� ���'
       						WHEN 'P' THEN '�θ��'
		END title
FROM emp;



SELECT empno, ename, job
FROM emp
WHERE job LIKE 'C%';


SELECT * FROM emp;
